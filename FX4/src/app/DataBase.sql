create database autotest;
use autotest;
select * from auto;
use tabelefx;
select * from log;
drop table log;
CREATE TABLE log (
    id INT unique auto_increment primary key,
    login varchar (20) unique not null,
    pass varchar (20) not null,
    role varchar (15) not null);
    
    insert into log (login,pass,role) values 
    ('admin','a','admin'),
	('maja','b','admin'),
	('user','a','user'),
	('basia','b','user');
    
    select*from employee;
    drop table employee;
    
    create table employee(
id_e int auto_increment unique primary key,
id_log_e int unique,
FirstName varchar(25),
LastName varchar(25),
service1 varchar(5),
service2 varchar(5),
foreign key (id_log_e) references log (id)
);

insert into employee (FirstName, LastName, service1, service2) values ("Admin", "Admin", "0", "0"), ("Maja", "Kowalska", "0", "0"),("User", "User", "0", "0"),("Basia", "Nowak", "0", "0") ;
drop table summary;
create table summary(
id_summary int  auto_increment unique primary key,
id_em int,
Month int,
hrs_service1 varchar(5),
hrs_service2 varchar(5),
ttl_service1 float (15),
ttl_service2 float(15),
ttl_gross float (20),
ttl_net float (20),
ttl_sum float (20), 
foreign key (id_em) references employee(id_e)
);
create view employee_accounts as select * from log inner join employee where ();
select * from employee_accounts;
drop view employee_accounts;

create view employee_earnings as select id_log_e, FirstName, LastName 
from employee inner join summary;

select * from employee_earnings;
drop view employee_earnings;

