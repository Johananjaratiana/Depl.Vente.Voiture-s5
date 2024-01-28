CREATE SEQUENCE "public".annonce_favoris_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".annonce_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".couleur_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".energie_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".etat_annonce_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".marque_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".modele_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".pdp_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".photo_annonce_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".profil_utilisateur_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".taille_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".token_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".transmission_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_annonce_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".type_moteur_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".usage_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".users_id_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".couleur ( 
	id                   integer DEFAULT nextval('couleur_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	rgb                  varchar  NOT NULL  ,
	status               integer  NOT NULL  ,
	CONSTRAINT pk_couleur PRIMARY KEY ( id )
 );

CREATE  TABLE "public".energie ( 
	id                   integer DEFAULT nextval('energie_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_energie PRIMARY KEY ( id )
 );

CREATE  TABLE "public".marque ( 
	id                   integer DEFAULT nextval('marque_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_marque PRIMARY KEY ( id )
 );

CREATE  TABLE "public".modele ( 
	id                   integer DEFAULT nextval('modele_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_modele PRIMARY KEY ( id )
 );

CREATE  TABLE "public".profil_utilisateur ( 
	id                   integer DEFAULT nextval('profil_utilisateur_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	CONSTRAINT profil_utilisateur_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE "public".taille ( 
	id                   integer DEFAULT nextval('taille_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_taille PRIMARY KEY ( id )
 );

CREATE  TABLE "public".transmission ( 
	id                   integer DEFAULT nextval('transmission_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_transmission PRIMARY KEY ( id )
 );

CREATE  TABLE "public".type_annonce ( 
	id                   integer DEFAULT nextval('type_annonce_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	commission           double precision  NOT NULL  ,
	niveau               integer  NOT NULL  ,
	CONSTRAINT pk_type_annonce PRIMARY KEY ( id )
 );

CREATE  TABLE "public".type_moteur ( 
	id                   integer DEFAULT nextval('type_moteur_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_type_moteur PRIMARY KEY ( id )
 );

CREATE  TABLE "public"."usage" ( 
	id                   integer DEFAULT nextval('usage_id_seq'::regclass) NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_tbl PRIMARY KEY ( id )
 );

CREATE  TABLE "public".users ( 
	id                   integer DEFAULT nextval('users_id_seq'::regclass) NOT NULL  ,
	idprofile            integer  NOT NULL  ,
	nom                  varchar(50)  NOT NULL  ,
	mdp                  varchar(50)  NOT NULL  ,
	prenom               varchar  NOT NULL  ,
	dtn                  date  NOT NULL  ,
	addresse             varchar(100)  NOT NULL  ,
	email                varchar  NOT NULL  ,
	telephone            varchar  NOT NULL  ,
	CONSTRAINT users_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_users_profil_utilisateur FOREIGN KEY ( idprofile ) REFERENCES "public".profil_utilisateur( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".annonce ( 
	id                   integer DEFAULT nextval('annonce_id_seq'::regclass) NOT NULL  ,
	id_marque            integer  NOT NULL  ,
	id_modele            integer  NOT NULL  ,
	"version"            varchar  NOT NULL  ,
	nb_place             integer  NOT NULL  ,
	description          varchar  NOT NULL  ,
	prix_vente           double precision  NOT NULL  ,
	consommation         double precision  NOT NULL  ,
	nb_vitesse           integer  NOT NULL  ,
	id_type_moteur       integer  NOT NULL  ,
	puissance            integer  NOT NULL  ,
	id_type_annonce      integer  NOT NULL  ,
	date_annonce         date  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	id_users             integer  NOT NULL  ,
	id_energie           integer  NOT NULL  ,
	id_transmission      integer  NOT NULL  ,
	id_usage             integer  NOT NULL  ,
	id_taille            integer  NOT NULL  ,
	km_effectue          double precision  NOT NULL  ,
	id_couleur           integer  NOT NULL  ,
	numero               varchar  NOT NULL  ,
	CONSTRAINT pk_annonce PRIMARY KEY ( id ),
	CONSTRAINT fk_annonce_couleur FOREIGN KEY ( id_couleur ) REFERENCES "public".couleur( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_energie FOREIGN KEY ( id_energie ) REFERENCES "public".energie( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_marque FOREIGN KEY ( id_marque ) REFERENCES "public".marque( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_modele FOREIGN KEY ( id_modele ) REFERENCES "public".modele( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_taille FOREIGN KEY ( id_taille ) REFERENCES "public".taille( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_transmission FOREIGN KEY ( id_transmission ) REFERENCES "public".transmission( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_type_annonce FOREIGN KEY ( id_type_annonce ) REFERENCES "public".type_annonce( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_type_moteur FOREIGN KEY ( id_type_moteur ) REFERENCES "public".type_moteur( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_usage FOREIGN KEY ( id_usage ) REFERENCES "public"."usage"( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_users FOREIGN KEY ( id_users ) REFERENCES "public".users( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".annonce_favoris ( 
	id                   integer DEFAULT nextval('annonce_favoris_id_seq'::regclass) NOT NULL  ,
	id_users             integer  NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	status               integer DEFAULT 0 NOT NULL  ,
	CONSTRAINT pk_annonce_favoris PRIMARY KEY ( id ),
	CONSTRAINT fk_annonce_favoris_annonce FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id ) ON DELETE CASCADE ON UPDATE CASCADE ,
	CONSTRAINT fk_annonce_favoris_users FOREIGN KEY ( id_users ) REFERENCES "public".users( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".etat_annonce ( 
	id                   integer DEFAULT nextval('etat_annonce_id_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	carrosserie          integer  NOT NULL  ,
	siege                integer  NOT NULL  ,
	tableau_bord         integer  NOT NULL  ,
	moteur               integer  NOT NULL  ,
	freinage             integer  NOT NULL  ,
	transmission         integer  NOT NULL  ,
	pneu                 integer  NOT NULL  ,
	electronique         integer  NOT NULL  ,
	suspension           integer  NOT NULL  ,
	CONSTRAINT pk_etat_annonce PRIMARY KEY ( id ),
	CONSTRAINT fk_etat_annonce_annonce FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE INDEX idx_etat_annonce ON "public".etat_annonce  ( id_annonce );

CREATE  TABLE "public".pdp ( 
	id                   integer DEFAULT nextval('pdp_id_seq'::regclass) NOT NULL  ,
	id_users             integer  NOT NULL  ,
	image                varchar  NOT NULL  ,
	CONSTRAINT pk_pdp PRIMARY KEY ( id ),
	CONSTRAINT unq_pdp UNIQUE ( id_users ) ,
	CONSTRAINT fk_pdp_users FOREIGN KEY ( id_users ) REFERENCES "public".users( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".photo_annonce ( 
	id                   integer DEFAULT nextval('photo_annonce_id_seq'::regclass) NOT NULL  ,
	id_annonce           integer  NOT NULL  ,
	image                varchar  NOT NULL  ,
	CONSTRAINT pk_photo_annonce PRIMARY KEY ( id ),
	CONSTRAINT fk_photo_annonce_annonce FOREIGN KEY ( id_annonce ) REFERENCES "public".annonce( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".token ( 
	id                   integer DEFAULT nextval('token_id_seq'::regclass) NOT NULL  ,
	idusers              integer  NOT NULL  ,
	token                varchar(255)  NOT NULL  ,
	dtexp                date DEFAULT (CURRENT_DATE + '1 mon'::interval) NOT NULL  ,
	isvalidate           boolean DEFAULT true NOT NULL  ,
	CONSTRAINT token_pkey PRIMARY KEY ( id ),
	CONSTRAINT fk_token_users FOREIGN KEY ( idusers ) REFERENCES "public".users( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

CREATE  TABLE "public".user_notification ( 
	id                   serial  NOT NULL  ,
	id_users             integer  NOT NULL  ,
	token                varchar(255)  NOT NULL  ,
	CONSTRAINT pk_users_notification PRIMARY KEY ( id ),
	CONSTRAINT fk_users_notification_users FOREIGN KEY ( id_users ) REFERENCES "public".users( id ) ON DELETE CASCADE ON UPDATE CASCADE 
 );

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

CREATE VIEW "public".v_annonce_complet_current_month AS  SELECT vac.id,
    vac.id_marque,
    vac.id_modele,
    vac.version,
    vac.nb_place,
    vac.description,
    vac.prix_vente,
    vac.consommation,
    vac.nb_vitesse,
    vac.id_type_moteur,
    vac.puissance,
    vac.id_type_annonce,
    vac.date_annonce,
    vac.status,
    vac.id_users,
    vac.id_energie,
    vac.id_transmission,
    vac.id_usage,
    vac.id_taille,
    vac.km_effectue,
    vac.id_couleur,
    vac.numero,
    vac.nom_marque,
    vac.nom_modele,
    vac.nom_type_moteur,
    vac.nom_type_annonce,
    vac.commission_type_annonce,
    vac.niveau_type_annonce,
    vac.nom_users,
    vac.prenom_users,
    vac.email_users,
    vac.telephone_users,
    vac.nom_energie,
    vac.nom_transmission,
    vac.nom_usage,
    vac.nom_taille,
    vac.etat_carrosserie,
    vac.etat_siege,
    vac.etat_tableau_bord,
    vac.etat_moteur,
    vac.etat_freinage,
    vac.etat_transmission,
    vac.etat_pneu,
    vac.etat_electronique,
    vac.etat_suspension,
    vac.nom_couleur,
    vac.rgb_couleur
   FROM v_annonce_complet vac
  WHERE ((vac.status = 20) AND (EXTRACT(month FROM vac.date_annonce) = EXTRACT(month FROM CURRENT_DATE)));

CREATE VIEW "public".v_annonce_complet_ordered_by_type_annonce AS  SELECT v_annonce_complet.id,
    v_annonce_complet.id_marque,
    v_annonce_complet.id_modele,
    v_annonce_complet.version,
    v_annonce_complet.nb_place,
    v_annonce_complet.description,
    v_annonce_complet.prix_vente,
    v_annonce_complet.consommation,
    v_annonce_complet.nb_vitesse,
    v_annonce_complet.id_type_moteur,
    v_annonce_complet.puissance,
    v_annonce_complet.id_type_annonce,
    v_annonce_complet.date_annonce,
    v_annonce_complet.status,
    v_annonce_complet.id_users,
    v_annonce_complet.id_energie,
    v_annonce_complet.id_transmission,
    v_annonce_complet.id_usage,
    v_annonce_complet.id_taille,
    v_annonce_complet.km_effectue,
    v_annonce_complet.id_couleur,
    v_annonce_complet.numero,
    v_annonce_complet.nom_marque,
    v_annonce_complet.nom_modele,
    v_annonce_complet.nom_type_moteur,
    v_annonce_complet.nom_type_annonce,
    v_annonce_complet.commission_type_annonce,
    v_annonce_complet.niveau_type_annonce,
    v_annonce_complet.nom_users,
    v_annonce_complet.prenom_users,
    v_annonce_complet.email_users,
    v_annonce_complet.telephone_users,
    v_annonce_complet.nom_energie,
    v_annonce_complet.nom_transmission,
    v_annonce_complet.nom_usage,
    v_annonce_complet.nom_taille,
    v_annonce_complet.etat_carrosserie,
    v_annonce_complet.etat_siege,
    v_annonce_complet.etat_tableau_bord,
    v_annonce_complet.etat_moteur,
    v_annonce_complet.etat_freinage,
    v_annonce_complet.etat_transmission,
    v_annonce_complet.etat_pneu,
    v_annonce_complet.etat_electronique,
    v_annonce_complet.etat_suspension,
    v_annonce_complet.nom_couleur,
    v_annonce_complet.rgb_couleur
   FROM v_annonce_complet
  ORDER BY v_annonce_complet.niveau_type_annonce DESC, v_annonce_complet.id DESC;

CREATE VIEW "public".v_annonce_en_attente_validation AS  SELECT a.id,
    (((m.nom)::text || ' '::text) || (mo.nom)::text) AS voiture,
    a.description,
    (((u.nom)::text || ' '::text) || (u.prenom)::text) AS utilisateur,
    a.prix_vente
   FROM (((annonce a
     JOIN users u ON ((a.id_users = u.id)))
     JOIN marque m ON ((a.id_marque = m.id)))
     JOIN modele mo ON ((a.id_modele = mo.id)))
  WHERE (a.status = 0);

CREATE VIEW "public".v_annonce_vendu_current_month AS  SELECT v_annonce_complet.id,
    v_annonce_complet.id_marque,
    v_annonce_complet.id_modele,
    v_annonce_complet.version,
    v_annonce_complet.nb_place,
    v_annonce_complet.description,
    v_annonce_complet.prix_vente,
    v_annonce_complet.consommation,
    v_annonce_complet.nb_vitesse,
    v_annonce_complet.id_type_moteur,
    v_annonce_complet.puissance,
    v_annonce_complet.id_type_annonce,
    v_annonce_complet.date_annonce,
    v_annonce_complet.status,
    v_annonce_complet.id_users,
    v_annonce_complet.id_energie,
    v_annonce_complet.id_transmission,
    v_annonce_complet.id_usage,
    v_annonce_complet.id_taille,
    v_annonce_complet.km_effectue,
    v_annonce_complet.id_couleur,
    v_annonce_complet.numero,
    v_annonce_complet.nom_marque,
    v_annonce_complet.nom_modele,
    v_annonce_complet.nom_type_moteur,
    v_annonce_complet.nom_type_annonce,
    v_annonce_complet.commission_type_annonce,
    v_annonce_complet.niveau_type_annonce,
    v_annonce_complet.nom_users,
    v_annonce_complet.prenom_users,
    v_annonce_complet.email_users,
    v_annonce_complet.telephone_users,
    v_annonce_complet.nom_energie,
    v_annonce_complet.nom_transmission,
    v_annonce_complet.nom_usage,
    v_annonce_complet.nom_taille,
    v_annonce_complet.etat_carrosserie,
    v_annonce_complet.etat_siege,
    v_annonce_complet.etat_tableau_bord,
    v_annonce_complet.etat_moteur,
    v_annonce_complet.etat_freinage,
    v_annonce_complet.etat_transmission,
    v_annonce_complet.etat_pneu,
    v_annonce_complet.etat_electronique,
    v_annonce_complet.etat_suspension,
    v_annonce_complet.nom_couleur,
    v_annonce_complet.rgb_couleur,
    v_annonce_complet.image,
    (v_annonce_complet.prix_vente * v_annonce_complet.commission_type_annonce) AS commission_obtenue
   FROM v_annonce_complet
  WHERE ((v_annonce_complet.status = 20) AND (EXTRACT(month FROM v_annonce_complet.date_annonce) = EXTRACT(month FROM CURRENT_DATE)))
  ORDER BY v_annonce_complet.date_annonce DESC;

CREATE VIEW "public".v_users_with_total_commission AS  SELECT a.id_users,
    sum((a.prix_vente * ta.commission)) AS commission
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  WHERE (a.status = 20)
  GROUP BY a.id_users;

CREATE VIEW "public".v_best_user AS  SELECT u.id,
    u.idprofile,
    u.nom,
    u.mdp,
    u.prenom,
    u.dtn,
    u.addresse,
    u.email,
    u.telephone,
    tcu.commission
   FROM (v_users_with_total_commission tcu
     JOIN users u ON ((u.id = tcu.id_users)))
  ORDER BY tcu.commission DESC;

CREATE VIEW "public".v_count_annonce_current_month AS  SELECT count(*) AS nb_annonce
   FROM annonce a
  WHERE (EXTRACT(month FROM a.date_annonce) = EXTRACT(month FROM CURRENT_DATE));

CREATE VIEW "public".v_count_annonce_current_year AS  SELECT count(*) AS nb_annonce
   FROM annonce a
  WHERE (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE));

CREATE VIEW "public".v_count_annonce_valide_current_month AS  SELECT count(*) AS nb_annonce_valide
   FROM annonce a
  WHERE ((a.status = 10) AND (EXTRACT(month FROM a.date_annonce) = EXTRACT(month FROM CURRENT_DATE)));

CREATE VIEW "public".v_count_annonce_valide_current_year AS  SELECT count(*) AS nb_annonce_valide
   FROM annonce a
  WHERE ((a.status = 10) AND (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE)));

CREATE VIEW "public".v_count_annonce_vendu_current_month AS  SELECT count(*) AS nb_annonce_vendu
   FROM annonce a
  WHERE ((a.status = 20) AND (EXTRACT(month FROM a.date_annonce) = EXTRACT(month FROM CURRENT_DATE)));

CREATE VIEW "public".v_count_annonce_vendu_current_year AS  SELECT count(*) AS nb_annonce_vendu
   FROM annonce a
  WHERE ((a.status = 20) AND (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE)));

CREATE VIEW "public".v_latest_annonce_vendu AS  SELECT v_annonce_complet.id,
    v_annonce_complet.id_marque,
    v_annonce_complet.id_modele,
    v_annonce_complet.version,
    v_annonce_complet.nb_place,
    v_annonce_complet.description,
    v_annonce_complet.prix_vente,
    v_annonce_complet.consommation,
    v_annonce_complet.nb_vitesse,
    v_annonce_complet.id_type_moteur,
    v_annonce_complet.puissance,
    v_annonce_complet.id_type_annonce,
    v_annonce_complet.date_annonce,
    v_annonce_complet.status,
    v_annonce_complet.id_users,
    v_annonce_complet.id_energie,
    v_annonce_complet.id_transmission,
    v_annonce_complet.id_usage,
    v_annonce_complet.id_taille,
    v_annonce_complet.km_effectue,
    v_annonce_complet.id_couleur,
    v_annonce_complet.numero,
    v_annonce_complet.nom_marque,
    v_annonce_complet.nom_modele,
    v_annonce_complet.nom_type_moteur,
    v_annonce_complet.nom_type_annonce,
    v_annonce_complet.commission_type_annonce,
    v_annonce_complet.niveau_type_annonce,
    v_annonce_complet.nom_users,
    v_annonce_complet.prenom_users,
    v_annonce_complet.email_users,
    v_annonce_complet.telephone_users,
    v_annonce_complet.nom_energie,
    v_annonce_complet.nom_transmission,
    v_annonce_complet.nom_usage,
    v_annonce_complet.nom_taille,
    v_annonce_complet.etat_carrosserie,
    v_annonce_complet.etat_siege,
    v_annonce_complet.etat_tableau_bord,
    v_annonce_complet.etat_moteur,
    v_annonce_complet.etat_freinage,
    v_annonce_complet.etat_transmission,
    v_annonce_complet.etat_pneu,
    v_annonce_complet.etat_electronique,
    v_annonce_complet.etat_suspension,
    v_annonce_complet.nom_couleur,
    v_annonce_complet.rgb_couleur,
    v_annonce_complet.image,
    (v_annonce_complet.prix_vente * v_annonce_complet.commission_type_annonce) AS commission_obtenue
   FROM v_annonce_complet
  WHERE (v_annonce_complet.status = 20)
  ORDER BY v_annonce_complet.date_annonce DESC;

CREATE VIEW "public".v_nombre_important AS  SELECT '-1'::integer AS id,
    ( SELECT count(*) AS count
           FROM users) AS nb_users,
    ( SELECT count(*) AS count
           FROM annonce) AS nb_annonces,
    ( SELECT count(*) AS count
           FROM annonce
          WHERE (annonce.status = 0)) AS nb_annonce_en_attente,
    ( SELECT count(*) AS count
           FROM annonce
          WHERE (annonce.status = '-10'::integer)) AS nb_annonce_rejete,
    ( SELECT count(*) AS count
           FROM annonce
          WHERE (annonce.status = 10)) AS nb_annonce_valide,
    ( SELECT count(*) AS count
           FROM annonce
          WHERE (annonce.status = 20)) AS nb_annonce_vendu,
    ( SELECT sum((annonce.prix_vente * ta.commission)) AS sum
           FROM (annonce
             JOIN type_annonce ta ON ((ta.id = annonce.id_type_annonce)))
          WHERE (annonce.status = 20)) AS total_commission;

CREATE VIEW "public".v_stat_annonce_vendu_par_marque AS  SELECT a.id_marque AS id,
    a.id_marque,
    m.nom AS nom_marque,
    count(a.id) AS nb_annonce_vendu
   FROM (annonce a
     JOIN marque m ON ((m.id = a.id_marque)))
  WHERE (a.status = 20)
  GROUP BY a.id_marque, m.nom;

CREATE VIEW "public".v_stat_by_month AS  SELECT (EXTRACT(month FROM a.date_annonce))::integer AS id,
    ( SELECT v_count_annonce_current_month.nb_annonce
           FROM v_count_annonce_current_month) AS nb_annonce,
    ( SELECT v_count_annonce_vendu_current_month.nb_annonce_vendu
           FROM v_count_annonce_vendu_current_month) AS nb_annonce_vendu,
    COALESCE(sum(a.prix_vente), (0)::double precision) AS prix_mois_actuelle,
    COALESCE(sum((a.prix_vente * ta.commission)), (0)::double precision) AS commission_mois_actuelle,
    EXTRACT(month FROM CURRENT_DATE) AS month,
    EXTRACT(year FROM CURRENT_DATE) AS year
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  WHERE ((a.status = 20) AND (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE)))
  GROUP BY (EXTRACT(month FROM a.date_annonce));

CREATE VIEW "public".v_stat_by_year AS  SELECT EXTRACT(year FROM a.date_annonce) AS id,
    ( SELECT v_count_annonce_current_year.nb_annonce
           FROM v_count_annonce_current_year) AS nb_annonce,
    ( SELECT v_count_annonce_vendu_current_year.nb_annonce_vendu
           FROM v_count_annonce_vendu_current_year) AS nb_annonce_vendu,
    COALESCE(sum(a.prix_vente), (0)::double precision) AS prix_mois_actuelle,
    COALESCE(sum((a.prix_vente * ta.commission)), (0)::double precision) AS commission_mois_actuelle
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  WHERE (a.status = 20)
  GROUP BY (EXTRACT(year FROM a.date_annonce));

CREATE VIEW "public".v_stat_current_month AS  SELECT '-1'::integer AS id,
    ( SELECT v_count_annonce_current_month.nb_annonce
           FROM v_count_annonce_current_month) AS nb_annonce,
    ( SELECT v_count_annonce_vendu_current_month.nb_annonce_vendu
           FROM v_count_annonce_vendu_current_month) AS nb_annonce_vendu,
    COALESCE(sum(a.prix_vente), (0)::double precision) AS prix_mois_actuelle,
    COALESCE(sum((a.prix_vente * ta.commission)), (0)::double precision) AS commission_mois_actuelle,
    EXTRACT(month FROM CURRENT_DATE) AS month,
    EXTRACT(year FROM CURRENT_DATE) AS year
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  WHERE ((a.status = 20) AND (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE)) AND (EXTRACT(month FROM a.date_annonce) = EXTRACT(month FROM CURRENT_DATE)));

CREATE VIEW "public".v_stat_current_year AS  SELECT '-1'::integer AS id,
    ( SELECT v_count_annonce_current_year.nb_annonce
           FROM v_count_annonce_current_year) AS nb_annonce,
    ( SELECT v_count_annonce_vendu_current_year.nb_annonce_vendu
           FROM v_count_annonce_vendu_current_year) AS nb_annonce_vendu,
    COALESCE(sum(a.prix_vente), (0)::double precision) AS prix_mois_actuelle,
    COALESCE(sum((a.prix_vente * ta.commission)), (0)::double precision) AS commission_mois_actuelle,
    EXTRACT(year FROM CURRENT_DATE) AS year
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  WHERE ((a.status = 20) AND (EXTRACT(year FROM a.date_annonce) = EXTRACT(year FROM CURRENT_DATE)));

CREATE VIEW "public".v_user_complet AS  SELECT u.id,
    u.idprofile,
    u.nom,
    u.mdp,
    u.prenom,
    u.dtn,
    u.addresse,
    u.email,
    u.telephone,
    pu.nom AS nom_pofil_utilisateur,
    pdp.image
   FROM ((users u
     LEFT JOIN pdp ON ((pdp.id_users = u.id)))
     JOIN profil_utilisateur pu ON ((pu.id = u.idprofile)));


CREATE VIEW "public".v_users_commission AS  SELECT a.id_users,
    sum((a.prix_vente * ta.commission)) AS commission
   FROM (annonce a
     JOIN type_annonce ta ON ((ta.id = a.id_type_annonce)))
  GROUP BY a.id_users;
  
CREATE VIEW "public".v_user_ordered_by_commission AS  SELECT u.id,
    u.idprofile,
    u.nom,
    u.mdp,
    u.prenom,
    u.dtn,
    u.addresse,
    u.email,
    u.telephone,
    uc.commission
   FROM (users u
     LEFT JOIN v_users_commission uc ON ((uc.id_users = u.id)))
  ORDER BY uc.commission DESC;


INSERT INTO "public".couleur( id, nom, rgb, status ) VALUES ( 1, 'Blanc', '#fff', 0);
INSERT INTO "public".couleur( id, nom, rgb, status ) VALUES ( 2, 'Noir', '#000', 0);
INSERT INTO "public".couleur( id, nom, rgb, status ) VALUES ( 3, 'Rouge', 'red', 0);
INSERT INTO "public".couleur( id, nom, rgb, status ) VALUES ( 4, 'Vert', 'Green', 0);
INSERT INTO "public".energie( id, nom, status ) VALUES ( 1, 'Essence', 0);
INSERT INTO "public".energie( id, nom, status ) VALUES ( 2, 'Diesel', 0);
INSERT INTO "public".energie( id, nom, status ) VALUES ( 3, 'Électrique', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 1, 'Toyota', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 2, 'Suzuki', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 3, 'Nissan', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 4, 'Volkswagen', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 5, 'Honda', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 6, 'Hyundai', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 7, 'BMW', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 8, 'Mercedes-Benz', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 9, 'Ford', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 10, 'Audi', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 11, 'Renault', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 12, 'Chevrolet', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 13, 'Peugeot', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 14, 'Kia', 0);
INSERT INTO "public".marque( id, nom, status ) VALUES ( 15, 'Fiat', 0);
INSERT INTO "public".modele( id, nom, status ) VALUES ( 1, 'Arteon', 0);
INSERT INTO "public".modele( id, nom, status ) VALUES ( 2, 'Celestiq', 0);
INSERT INTO "public".modele( id, nom, status ) VALUES ( 3, 'CR-V', 0);
INSERT INTO "public".modele( id, nom, status ) VALUES ( 4, 'Panamera', 0);
INSERT INTO "public".profil_utilisateur( id, nom ) VALUES ( 3, 'admin');
INSERT INTO "public".profil_utilisateur( id, nom ) VALUES ( 4, 'user');
INSERT INTO "public".taille( id, nom, status ) VALUES ( 1, 'Sous-compacte', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 2, 'Compacte', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 3, 'Intermédiaire', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 4, 'Full-Size', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 5, 'Fourgonnette', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 6, 'Camion', 0);
INSERT INTO "public".taille( id, nom, status ) VALUES ( 7, 'Berlin', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 2, 'Boîte de vitesses manuelle', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 3, 'Boîte de vitesses automatique', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 4, 'Boîte de vitesses séquentielle', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 5, 'Boîte de vitesses robotisée', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 6, 'Boîte de vitesses à variations continues', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 7, 'Boîte de vitesses à embrayage hydraulique', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 8, 'Boîte de vitesses de type H', 0);
INSERT INTO "public".transmission( id, nom, status ) VALUES ( 9, 'Boîte de vitesses à variations continues', 0);
INSERT INTO "public".type_annonce( id, nom, status, commission, niveau ) VALUES ( 1, 'Annonces Sponsorisées', 0, 0.01, 10);
INSERT INTO "public".type_annonce( id, nom, status, commission, niveau ) VALUES ( 2, 'Annonces Premium', 0, 0.02, 20);
INSERT INTO "public".type_annonce( id, nom, status, commission, niveau ) VALUES ( 3, 'Annonces Featured', 0, 0.03, 30);
INSERT INTO "public".type_annonce( id, nom, status, commission, niveau ) VALUES ( 4, 'Annonces VIP', 0, 0.04, 40);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 1, 'Moteur à explosion', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 2, 'Moteur à combustion', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 3, 'Moteur électrique', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 4, 'Moteur en étoile', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 5, 'Moteur à plat', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 6, 'Moteur en ligne', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 7, 'Moteur en V', 0);
INSERT INTO "public".type_moteur( id, nom, status ) VALUES ( 8, 'Moteur en W', 0);
INSERT INTO "public"."usage"( id, nom, status ) VALUES ( 1, 'Quotidienne', 0);
INSERT INTO "public"."usage"( id, nom, status ) VALUES ( 2, 'Transport de marchandises', 0);
INSERT INTO "public"."usage"( id, nom, status ) VALUES ( 3, 'Loisir et tourisme', 0);
INSERT INTO "public".users( id, idprofile, nom, mdp, prenom, dtn, addresse, email, telephone ) VALUES ( 9, 3, 'ANDRIANAIVOSOA', 'johan', 'Johan Anjaratiana', '2003-08-26', 'III AB 50 Andrononobe', 'johan@gmail.com', '+261 89 692 62');
INSERT INTO "public".users( id, idprofile, nom, mdp, prenom, dtn, addresse, email, telephone ) VALUES ( 13, 4, 'MAMIARILAZA', 'to', 'To', '2007-01-12', 'TD 001 Tsididy', 'to@gmail.com', '+261 34 14 517 43');
INSERT INTO "public".annonce( id, id_marque, id_modele, "version", nb_place, description, prix_vente, consommation, nb_vitesse, id_type_moteur, puissance, id_type_annonce, date_annonce, status, id_users, id_energie, id_transmission, id_usage, id_taille, km_effectue, id_couleur, numero ) VALUES ( 5, 1, 2, '1.0', 18, 'No desc', 200000.0, 8.0, 5, 2, 1500, 1, '2024-01-14', 20, 9, 2, 2, 1, 3, 100.0, 3, '1234 TAB');
INSERT INTO "public".annonce( id, id_marque, id_modele, "version", nb_place, description, prix_vente, consommation, nb_vitesse, id_type_moteur, puissance, id_type_annonce, date_annonce, status, id_users, id_energie, id_transmission, id_usage, id_taille, km_effectue, id_couleur, numero ) VALUES ( 6, 2, 3, '1.0', 18, 'No desc', 250000.0, 5.0, 4, 2, 1500, 3, '2024-10-04', 20, 13, 2, 2, 1, 3, 100.0, 1, '1234 TAB');
INSERT INTO "public".annonce( id, id_marque, id_modele, "version", nb_place, description, prix_vente, consommation, nb_vitesse, id_type_moteur, puissance, id_type_annonce, date_annonce, status, id_users, id_energie, id_transmission, id_usage, id_taille, km_effectue, id_couleur, numero ) VALUES ( 4, 1, 1, '1.0', 18, 'No desc', 150000.0, 10.0, 5, 2, 1500, 2, '2024-01-12', 20, 9, 2, 2, 1, 3, 100.0, 2, '1234 TAB');
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 4, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MDU1OTk5LCJleHAiOjE3MDUwNTk1OTl9.Qy389nxZ_Ur9x2J83m8G-5fZh6pTeCFgham5XQbvQHw7_-FCuBlrAD54kTZayAZwQdqWyXzXMnVABtKtMzKjTg', '2024-01-12', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 5, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MDU2MTc4LCJleHAiOjE3MDUwNTk3Nzh9.Q-srh8WjdA9_kYae54lVm0gfbeh2bRtg-TUFgJQZlapQ9fVGAIvEE8eY8JzwyBoFMXVesDZPHvSIQLXMdxKmGA', '2024-01-12', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 6, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MjI2NjQ5LCJleHAiOjE3MDUyMzAyNDl9.cWXATlKTE6Ay0lCpu5ZEXQu2YX--aGGqDML_R89iexv26_9S2UH-xKE3qe4_OAdLerUD7KnRQkboZpXZ9M0CXQ', '2024-01-14', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 7, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MjI2NjczLCJleHAiOjE3MDUyMzAyNzN9.vNNPyEDTybLklLbChfSp99shR9VcjgsKE6sfFyXvstzIoqA0Fx0Tmw6pZhBsq0wp0UeloZRtfSSSGrqX2IRhxg', '2024-01-14', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 8, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MjI2Njg4LCJleHAiOjE3MDUyMzAyODh9.QxXFYxI7r_I65TkiuQHg3eYdZKHYpnL1JaR6bwQQVg5cZy0-8TUjmZFdonKYo_sGqRziblX-uvw0EXxSNhoHiQ', '2024-01-14', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 9, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1MzgxNDMwLCJleHAiOjE3MDU0Njc4MzB9.z3k0yHJHh6zYKACPMb2bylRWBLvd558VObaht-h5Ym9JciDSlDtbXA1R5L9R4iR6jZ3_20MehvzuYdRBbavA7Q', '2024-01-17', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 10, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA1NjUxNTgwLCJleHAiOjE3MDU3Mzc5ODB9.Tw_LGtPGebFgatE2_-5bp5klWfZe_RDHFye9HQFaQ-9_8hxmldncCFNe2_bbPKODrcSVaGubNwt0zRFakMLZmA', '2024-01-20', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 11, 13, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsImlhdCI6MTcwNTY1NDYzNSwiZXhwIjoxNzA1NzQxMDM1fQ.DOEBSNMtkl6qcTkGJ05EZjtC-XnsSMCQj_YMegN8GT8l-Pp9HAGbr_ohksIv2mJbn27Cm3AEjFRb4MUDDPq5Kw', '2024-01-20', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 12, 13, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMyIsImlhdCI6MTcwNTc2Mjk4MiwiZXhwIjoxNzA1ODQ5MzgyfQ.pFrGtzFonMdYPqG5ucWWSX6dIW6NtqbqSaMh7d57eLCFqogknpxWYBChRjhyUAKqvoVNib2QGaRRJY2wLxlEKQ', '2024-01-21', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 13, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA2MDk1MjMzLCJleHAiOjE3MDYxODE2MzN9.DHiW6tgnZTjzNq6OukNkIO_6cSNu-b781bN1xJdqjrtKyNCz0gZ4vEzsZvriW6w5aU54MWQN1D7qOfVvkrKXwA', '2024-01-25', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 14, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA2Mjk2MjUzLCJleHAiOjE3MDYzODI2NTN9.1-J0G_fWbbvGGdhIMYeNeJdtfwEdCQdHTvs1RDZN4vmSIXki2MmSHUtXRhsMgHOZjAqFgx9_h1uF9-Eu3fkGVQ', '2024-01-27', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 15, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA2Mjk2NDc1LCJleHAiOjE3MDYzODI4NzV9.232upmUaOlmCZv1pYA81yMDDh-lUeGTqg8ecVG2HWJQltCYX6UJMmdrrNnb0JSrUekizurntU1RllqrU20GCaA', '2024-01-27', true);
INSERT INTO "public".token( id, idusers, token, dtexp, isvalidate ) VALUES ( 16, 9, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5IiwiaWF0IjoxNzA2Mjk2NTk3LCJleHAiOjE3MDYzODI5OTd9.HfXUgseeblThAqWHox0UWNr1sO90I1EqgBzNr2BjM3rh7rseTnD5d251aAQ72xK6wJcqFOGWhM3CCMFn7H2wHA', '2024-01-27', true);