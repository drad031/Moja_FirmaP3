drop database if exists moja_firma;
create database moja_firma DEFAULT CHARACTER SET utf8;
use moja_firma;

create table osoba(
sifra int not null primary key auto_increment,
ime varchar(50) not null,
prezime varchar(50) not null,
uloga varchar(50),
korisnicko_ime varchar(50) not null,
lozinka char (32)not null,
naziv varchar(50), #u slučaju da je rad obavio vanjskisuradnik tj. pravna osoba
oib char(11) not null,
telefon varchar(50) not null,
mob varchar(50) not null,
email varchar(50) not null,
adresa varchar(50)not null,
iban varchar(50) not null,
datumrodenja datetime,
aktivan boolean,
primjedba varchar(500)
)engine=innodb;

#pretpostavljam da će slike ići u javu u files, ne ovdje, ali za sad ih imam ovdje 
create table proizvod(
sifra int not null primary key auto_increment,
osoba int not null,
slika BLOB,
nazivpr varchar(50) not null,
dimenzija varchar(50) not null,
kolicina char(5) not null,
grupaproizvoda varchar(50) not null,
datumproizvodnje datetime,
rokizrade datetime,
sirovinskisastav varchar(50) not null,
cijena decimal(18,2)
)engine=innodb;
#na jFrame trebam iskombinirati oznakuproizvoda(grupaproizvoda+oznaka(crteza))

create table rad(
sifra int not null primary key auto_increment,
proizvod int not null,
osoba int not null,
naziv varchar(50) not null,
cijenarada decimal(18,10),
kolicina decimal(18,10),
uposlenik boolean,
vanjskisuradnik boolean
)engine=innodb;


create table clan(
proizvod int not null,
materijal int not null
)engine=innodb;


create table materijal(
sifra int not null primary key auto_increment,
slika BLOB,
naziv varchar(50) not null,
dobavljac varchar(50) not null,
cijenamat decimal(18,10),
kolicina decimal(18,10), 
datumkupnje datetime
)engine=innodb;

create unique index i1 on osoba(korisnicko_ime);

alter table clan add foreign key (proizvod) references proizvod(sifra);
alter table clan add foreign key (materijal) references materijal(sifra);
alter table rad add foreign key (proizvod) references proizvod(sifra);
alter table rad add foreign key (osoba) references osoba(sifra);
alter table proizvod add foreign key (osoba) references osoba(sifra);




insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','administrator','drad',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Madovanović','administrator','drad1',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Sadovanović','administrator','drad2',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Dadovanović','administrator','drad3',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Čadovanović','administrator','drad4',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','uposlenik','drad5',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Qadovanović','uposlenik','drad6',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Mara','Radovanović','uposlenik','drad7',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','vanjski_suradnik','drad8',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Kata','Radovanović','vanjski_suradnik','drad9',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Jula','Radovanović','vanjski_suradnik','dradd',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','naručitelj','dradd1',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Lara','Radovanović','naručitelj','dradd2',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Sara','Radovanović','naručitelj','dradd3',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','autor','dradd4',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Mira','Radovanović','autor','drado5',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Lana','Radovanović','autor','drado6',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');


insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina11.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina22.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina33.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina44.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina55.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina66.png','Tkanina','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme11.png','Dugme','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme22.png','Dugme','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme33.png','Dugme','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme44.png','Dugme','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac11.png','Konac','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac22.png','Konaca','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac33.png','Konac','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac44.png','Konac','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,naziv,dobavljac,cijenamat,kolicina,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac55.png','Konac','dob',136.55,5.00,'2014-10-10');

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Košulja','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Košulja','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Košulja','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Hlače','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Hlače','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Hlače','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Haljina','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Haljina','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Haljina','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Sako','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Sako','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Sako','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Slika','42x50',5,'Kuća','2014-10-28','2014-10-28',null,40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Slika','42x60',5,'Kuća','2014-10-28','2014-10-28',null,40.99);

insert into proizvod(slika,nazivpr,dimenzija,kolicina,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('F:\Moja_FirmaP\slike\Tkanina11.png','Slika','42x70',5,'Kuća','2014-10-28','2014-10-28',null,40.99);