INSERT INTO energie
	( id, nom, status) VALUES 
    ( DEFAULT, 'Essence', 0 ),
    ( DEFAULT, 'Diesel', 0 ),
    ( DEFAULT, 'Électrique', 0 );

INSERT INTO usage
	( id, nom, status) VALUES 
    ( DEFAULT, 'Quotidienne' , 0 ),
    ( DEFAULT, 'Transport de marchandises' , 0 ),
    ( DEFAULT, 'Loisir et tourisme' , 0 );

INSERT INTO taille
	( id, nom, status) VALUES 
    ( DEFAULT, 'Sous-compacte', 0 ),
    ( DEFAULT, 'Compacte', 0 ),
    ( DEFAULT, 'Intermédiaire', 0 ),
    ( DEFAULT, 'Full-Size', 0 ),
    ( DEFAULT, 'Fourgonnette', 0 ),
    ( DEFAULT, 'Camion', 0 ),
    ( DEFAULT, 'Berlin', 0 );

INSERT INTO type_moteur
	( id, nom, status) VALUES 
    ( DEFAULT, 'Moteur à explosion', 0 ),
    ( DEFAULT, 'Moteur à combustion', 0 ),
    ( DEFAULT, 'Moteur électrique', 0 ),
    ( DEFAULT, 'Moteur en étoile', 0 ),
    ( DEFAULT, 'Moteur à plat', 0 ),
    ( DEFAULT, 'Moteur en ligne', 0 ),
    ( DEFAULT, 'Moteur en V', 0 ),
    ( DEFAULT, 'Moteur en W', 0 );

INSERT INTO type_annonce
	( id, nom, status, commission) VALUES 
    ( DEFAULT, 'Annonces Sponsorisées', 0 , 0.02),
    ( DEFAULT, 'Annonces Premium', 0 , 0.03 ),
    ( DEFAULT, 'Annonces Featured', 0 , 0.04 ),
    ( DEFAULT, 'Annonces VIP', 0, 0.05 );

---------------------------------------------------------------------
Marque : 
    (1, Toyota    ) 
    (2, Suzuki    ) 
    (3, Nissan    ) 
Modele : 
    (1, Arteon  ) 
    (2, Celestiq) 
    (3, CR-V    )
Type_moteur : 
    (1, Moteur à explosion )
    (2, Moteur à combustion)
    (3, Moteur électrique  )
Type_annonce : 
    (1, Annonces Sponsorisées, 0.01)
    (2, Annonces Premium     , 0.02)
    (3, Annonces Featured    , 0.03)
Users : 
    (9, Johan), 
    (13, To)
Taille : 
    (1, Sous-compacte)
    (2, Compacte     )
    (3, Intermédiaire)
Energie :
    (1, Essence   )
    (2, Diesel    )
    (3, Électrique)
Transmission :
    (2, Boîte de vitesses manuelle    )
    (3, Boîte de vitesses automatique )
    (4, Boîte de vitesses séquentielle)
Usage : 
    (1, Quotidienne              )
    (2, Transport de marchandises)
    (3, Loisir et tourisme       )


Insertion de 3 annonces pour tester les views
---------------------------------------------
INSERT INTO "public".annonce
	(
    id_marque, id_modele, "version", 
    couleur, nb_place, description, 
    prix_vente, consommation, nb_vitesse, 
    id_type_moteur, puissance, id_type_annonce, 
    date_annonce, status, id_users,
    id_energie, id_transmission, id_usage, 
    id_taille, km_effectue
    ) VALUES 
    (
    1, 1, '1.0', 
    'Rouge', 18, 'No desc', 
    150000, 10, 5, 
    2, 1500, 2, 
    '2024-01-12', 0, 9, 
    2, 2, 1, 
    3, 100 ),
    (
    1, 2, '1.0', 
    'Vert', 18, 'No desc', 
    200000, 8, 5, 
    2, 1500, 1, 
    '2024-01-14', 0, 9, 
    2, 2, 1, 
    3, 100 ),
    (
    2, 3, '1.0', 
    'Bleu', 18, 'No desc', 
    250000, 5, 4,
    2, 1500, 3, 
    '2024-10-04', 0, 13, 
    2, 2, 1, 
    3, 100 );


------------------------- IN REQUEST 
SELECT string_agg(id_annonce::text, ',') AS id_annonces
    FROM annonce_favoris
    WHERE id_users =  6;


