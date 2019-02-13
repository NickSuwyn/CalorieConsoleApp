CREATE DATABASE IF NOT EXISTS calorie_db;

USE calorie_db;

DROP TABLE IF EXISTS foods;

CREATE TABLE foods (
	id int(11) not null auto_increment,
	name varchar(75) not null,
	calories int(11) not null,
	category varchar(30) not null,
	PRIMARY KEY (id)
);