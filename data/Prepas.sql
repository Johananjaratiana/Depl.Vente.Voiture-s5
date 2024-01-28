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


CREATE VIEW "public".v_annonce_complet AS  SELECT a.id,
    a.id_marque,
    a.id_modele,
    a.version,
    a.nb_place,
    a.description,
    a.prix_vente,
    a.consommation,
    a.nb_vitesse,
    a.id_type_moteur,
    a.puissance,
    a.id_type_annonce,
    a.date_annonce,
    a.status,
    a.id_users,
    a.id_energie,
    a.id_transmission,
    a.id_usage,
    a.id_taille,
    a.km_effectue,
    a.id_couleur,
    a.numero,
    ma.nom AS nom_marque,
    mo.nom AS nom_modele,
    tm.nom AS nom_type_moteur,
    ta.nom AS nom_type_annonce,
    ta.commission AS commission_type_annonce,
    ta.niveau AS niveau_type_annonce,
    u.nom AS nom_users,
    u.prenom AS prenom_users,
    u.email AS email_users,
    u.telephone AS telephone_users,
    e.nom AS nom_energie,
    t.nom AS nom_transmission,
    us.nom AS nom_usage,
    tai.nom AS nom_taille,
    COALESCE(ea.carrosserie, 0) AS etat_carrosserie,
    COALESCE(ea.siege, 0) AS etat_siege,
    COALESCE(ea.tableau_bord, 0) AS etat_tableau_bord,
    COALESCE(ea.moteur, 0) AS etat_moteur,
    COALESCE(ea.freinage, 0) AS etat_freinage,
    COALESCE(ea.transmission, 0) AS etat_transmission,
    COALESCE(ea.pneu, 0) AS etat_pneu,
    COALESCE(ea.electronique, 0) AS etat_electronique,
    COALESCE(ea.suspension, 0) AS etat_suspension,
    c.nom AS nom_couleur,
    c.rgb AS rgb_couleur,
    ( SELECT pa.image
           FROM photo_annonce pa
          WHERE (pa.id_annonce = a.id)
          ORDER BY pa.id
         LIMIT 1) AS image
   FROM (((((((((((annonce a
     JOIN marque ma ON ((ma.id = a.id_marque)))
     JOIN modele mo ON ((mo.id = a.id_modele)))
     JOIN type_moteur tm ON ((tm.id = a.id_type_moteur)))
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
     JOIN users u ON ((u.id = a.id_users)))
     JOIN energie e ON ((e.id = a.id_energie)))
     JOIN transmission t ON ((t.id = a.id_transmission)))
     JOIN usage us ON ((us.id = a.id_usage)))
     JOIN taille tai ON ((tai.id = a.id_taille)))
     LEFT JOIN etat_annonce ea ON ((a.id = ea.id_annonce)))
     JOIN couleur c ON ((c.id = a.id_couleur)));

CREATE VIEW "public".v_annonce_vendu_current_month AS  
SELECT v_annonce_complet.*,
    (v_annonce_complet.prix_vente * v_annonce_complet.commission_type_annonce) AS commission_obtenue
   FROM v_annonce_complet
  WHERE (v_annonce_complet.status = 20)
  AND (EXTRACT(month FROM date_annonce) = EXTRACT(month FROM CURRENT_DATE))
  ORDER BY v_annonce_complet.date_annonce DESC;


