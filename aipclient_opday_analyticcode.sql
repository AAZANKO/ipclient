create table if not exists opday.analyticcode
(
	id bigserial,
	analytic_type bigint,
	analytic_code bigint,
	name varchar(250),
	short_name varchar(250),
	comment varchar(250),
	isopen integer,
	version serial
);

INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (1, 1, 'Директор', 'Директор', 'админ', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (1, 2, 'Менеджер', 'Менеджер', 'юзер', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (1, 3, 'Аудитор', 'Аудитор', 'список', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (2, 1, 'фабрика', 'произадство конфетных изделий', '', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (3, 1, 'Директор', 'Генеральный директор', '', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (3, 2, 'Бухгалтер', 'Главный бухгалтер', '', 1);
INSERT INTO opday.analyticcode (analytic_type, analytic_code, short_name, name, comment, isopen) VALUES (1, 4, 'Бухгалтер', 'Бухгалтер', '', 1);