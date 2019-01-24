create table if not exists opday.contacts
(
	id bigserial not null
		constraint contacts_pk
			primary key,
	director_firstname varchar(250),
	director_lastnameint varchar(250),
	director_middlenaintme varchar(250),
	director_phone varchar(50),
	director_fax_phone varchar(50),
	director_mobil_phone varchar(50),
	director_email varchar(100),
	buchgalter_firstname varchar(250),
	buchgalter_lastname varchar(250),
	buchgalter_middlename varchar(250),
	buchgalter_phone varchar(50),
	buchgalter_fax_phone varchar(50),
	buchgalter_mobil_phone varchar(50),
	buchgalter_email varchar(100),
	reception_phone varchar(50),
	reception_email varchar(100),
	reception_fax_phone varchar(50),
	comment varchar(500),
	officer_id serial,
	client_id serial not null,
	date_open timestamp,
	version bigint not null,
	clientn_number varchar(250)
);

alter table opday.contacts owner to postgres;