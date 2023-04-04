drop table if exists product;
create table product(
    id int AUTO_INCREMENT primary key,
    nombre varchar(255),
    precio float
);