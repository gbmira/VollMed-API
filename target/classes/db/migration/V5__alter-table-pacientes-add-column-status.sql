alter table pacientes add status char(1);
update pacientes set status = 'A';