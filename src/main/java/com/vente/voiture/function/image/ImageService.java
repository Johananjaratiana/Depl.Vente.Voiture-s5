package com.vente.voiture.function.image;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class ImageService {
    
    private static final String bucketName = "cloud-image-vente-voiture.appspot.com";

    private String uploadFile(String base64Image, String fileName) throws IOException {
        
        BlobId blobId = BlobId.of(bucketName, fileName); // Remplacez par le nom de votre bucket
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();

        // Chargez les informations d'identification depuis un fichier JSON
        Credentials credentials = GoogleCredentials.fromStream(
                ImageService.class.getClassLoader().getResourceAsStream("firebase-private-key.json"));

        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Base64.getDecoder().decode(base64Image));

        // Remplacez <bucket-name> par le nom de votre bucket
        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    public String upload(String base64Image) {
        try {
            String fileName = UUID.randomUUID().toString() + ".png"; // Extension par défaut (à adapter)
            
            String URL = this.uploadFile(base64Image, fileName);

            return URL;
        } catch (Exception e) {
            e.printStackTrace();
            return "L'image n'a pas pu être téléchargée, une erreur s'est produite.";
        }
    }
}
