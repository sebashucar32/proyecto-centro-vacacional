create table agencia_viajes.poliza (
	id_poliza serial4 not null,
	valor_poliza integer not null,
	valor_asegurado integer not null,
	contrato varchar(255) null,
	constraint poliza_pk primary key(id_poliza)
);

create table agencia_viajes.paseos (
	id_paseo serial4 not null,
	nombre_ciudad varchar(100) null,
	sede varchar(100) null,
	imagen varchar(255) null,
	id_poliza serial4 not null,
	constraint paseo_pk primary key(id_paseo),
	constraint paseo_fk_poliza foreign key(id_poliza) references agencia_viajes.poliza(id_poliza)
);

create table agencia_viajes.tours (
	id_tour serial4 not null,
	nombre_tour varchar(100) null,
	comidas integer not null,
	hora_inicio time,
	hora_fin time,
	fecha timestamp,
	id_paseo integer not null,
	constraint tour_pk primary key(id_tour),
	constraint tour_fk_paseo foreign key(id_paseo) references agencia_viajes.paseos(id_paseo)
);

create table agencia_viajes.transporte (
	id_transporte serial4 not null,
	fecha_ida timestamp,
	fecha_vuelta timestamp,
	tipo_transporte varchar(255) null,
	id_paseo integer not null,
	constraint transporte_pk primary key(id_transporte),
	constraint transporte_fk_paseo foreign key(id_paseo) references agencia_viajes.paseos(id_paseo)
);


insert into agencia_viajes.poliza(valor_poliza, valor_asegurado, contrato) values(20000, 1800000, 'Esta poliza aplica para todos los tours del paseo');
insert into agencia_viajes.poliza(valor_poliza, valor_asegurado, contrato) values(10000, 1200000, 'Esta poliza aplica solo para 2 de 4 tours');

insert into agencia_viajes.paseos(nombre_ciudad, sede, imagen, id_poliza) values('Santa Marta', 'Tayrona', 'playacristal.jpg', 1);
insert into agencia_viajes.paseos(nombre_ciudad, sede, imagen, id_poliza) values('Cartagena', 'San Bernardo', 'sanber.jpg', 2);
insert into agencia_viajes.paseos(nombre_ciudad, sede, imagen, id_poliza) values('San andres', 'Yoni kit', 'yonikit.jpg', 1);
insert into agencia_viajes.paseos(nombre_ciudad, sede, imagen, id_poliza) values('Cartagena', 'Baru', 'baru.jpg', 1);

insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Playa Cristal', 2, '08:00', '16:00', '15/02/2025', 1);
insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Cabo San Juan', 2, '07:00', '15:00', '15/02/2025', 1);
insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Playa 1', 1, '08:00', '14:00', '15/02/2025', 2);
insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Playa Delfin', 3, '08:00', '19:00', '15/02/2025', 2);
insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Playa Yoni', 1, '08:00', '14:00', '15/02/2025', 3);
insert into agencia_viajes.tours(nombre_tour, comidas, hora_inicio, hora_fin, fecha, id_paseo)
values('Visita zona cangrejos', 1, '14:00', '16:00', '15/02/2025', 3);

insert into agencia_viajes.transporte(fecha_ida, fecha_vuelta, tipo_transporte, id_paseo)
values('11/02/2025', '15/02/2025', 'avion', 1);
insert into agencia_viajes.transporte(fecha_ida, fecha_vuelta, tipo_transporte, id_paseo)
values('12/02/2025', '16/02/2025', 'avion', 2);
insert into agencia_viajes.transporte(fecha_ida, fecha_vuelta, tipo_transporte, id_paseo)
values('20/02/2025', '27/02/2025', 'avion', 3);
insert into agencia_viajes.transporte(fecha_ida, fecha_vuelta, tipo_transporte, id_paseo)
values('13/02/2025', '17/02/2025', 'automovil', 4);

select * from agencia_viajes.paseos;
select * from agencia_viajes.poliza;
select * from agencia_viajes.tours;
select * from agencia_viajes.transporte;