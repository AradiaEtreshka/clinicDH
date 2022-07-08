create table IF NOT EXISTS residence (id int auto_increment primary key,street varchar(255),number varchar (255),state varchar (255),province varchar (255));
create table IF NOT EXISTS patients (id int auto_increment primary key,name varchar(255),lastName varchar (255),dni varchar (255),admission TIMESTAMP WITHOUT TIME ZONE,residence_id int);
create table IF NOT EXISTS dentists (id int auto_increment primary key,name varchar(255),lastName varchar (255),registration_number int);
create table IF NOT EXISTS turns (id int auto_increment primary key, turn TIMESTAMP WITHOUT TIME ZONE, patient_id int, dentist_id int )

