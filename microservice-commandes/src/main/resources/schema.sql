drop table if exists commandes;
create table commandes
(
    id           int auto_increment primary key,
    description  varchar(255) not null,
    quantite     int          not null,
    date timestamp    not null,
    montant        float        not null
);