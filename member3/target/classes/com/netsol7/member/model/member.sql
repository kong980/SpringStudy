CREATE TABLE member(
	id number not null,
	email varchar2(50) not null PRIMARY KEY,
	name varchar2(20) not null,
	password varchar2(10) not null,
	registerDate Date not null
);

CREATE SEQUENCE seq_id;