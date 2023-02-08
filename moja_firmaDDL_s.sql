drop database if exists moja_firma;
create database moja_firma DEFAULT CHARACTER SET utf8;
use moja_firma;

create table osoba(
sifra int not null primary key auto_increment,
ime varchar(50) not null,
prezime varchar(50) not null,
uloga varchar(50)not null,
korisnicko_ime varchar(50) not null,
lozinka char (32),
naziv varchar(50), #u slučaju da je rad obavio vanjskisuradnik tj. pravna osoba
oib char(11),
telefon varchar(50),
mob varchar(50),
email varchar(50),
adresa varchar(100),
iban varchar(50),
datumrodenja datetime,
formatdatuma varchar(50),
aktivan boolean,
primjedba varchar(500)
)engine=innodb;


create table proizvod(
sifra int not null primary key auto_increment,
nazivpr varchar(50) not null,
dimenzija varchar(50) ,
kolicinapr char(5) ,
grupaproizvoda varchar(50) ,
datumproizvodnje datetime,
rokizrade datetime,
sirovinskisastav varchar(50) ,
cijena decimal(18,2)
)engine=innodb;
#na jFrame trebam iskombinirati oznakuproizvoda(grupaproizvoda+oznaka(crteza))

create table rad(
sifra int not null primary key auto_increment,
osoba int,
nazivrada varchar(50) not null,
cijenarada decimal(18,2),
kolicina decimal(18,2)
)engine=innodb;

create table clan(
proizvod int not null ,
materijal int not null 
)engine=innodb;

create table clan1(
proizvod int not null,
rad int not null 
)engine=innodb;

create table materijal(
sifra int not null primary key auto_increment,
slika longblob,
nazivmat varchar(50) not null,
dobavljac varchar(50) not null,
cijenamat decimal(18,2),
kolicinamat decimal(18,2), 
datumkupnje datetime
)engine=innodb;

# create table materijal_slika_arhiva(
# materijal int not null,
# slika longblob
# )engine=innodb;

create unique index i1 on osoba(korisnicko_ime);

alter table rad add foreign key (osoba) references osoba(sifra);
alter table clan add foreign key (materijal) references materijal(sifra);
alter table clan add foreign key (proizvod) references proizvod(sifra);
alter table clan1 add foreign key (rad) references rad(sifra);
alter table clan1 add foreign key (proizvod) references proizvod(sifra);
# alter table materijal_slika_arhiva add foreign key (materijal) references materijal(sifra);


insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','administrator','drad',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Marić','administrator','drad1',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Erić','administrator','drad2',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Brkić','administrator','drad3',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Horvat','administrator','drad4',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

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
('Jula','Radovanović','vanjski_suradnik','dradds',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','naručitelj','dradd1',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Lara','Radovanović','naručitelj','dradd2',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Sara','Radovanović','naručitelj','dradd3',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Dubravka','Radovanović','autor','dradd4',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',false,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Mira','Radovanović','autor','dradd5',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');

insert into osoba(ime,prezime,uloga,korisnicko_ime,lozinka,naziv,oib,telefon,mob,email,adresa,iban,datumrodenja,aktivan,primjedba) values 
('Lana','Radovanović','autor','dradd6',md5('d'),'XX',5,15,25,'d','d',35,'1976-10-28',true,'OK');




insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina11.png','Tkanina6','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina22.png','Tkanina1','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina33.png','Tkanina2','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina44.png','Tkanina3','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina55.png','Tkanina4','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Tkanina66.png','Tkanina5','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme11.png','Dugme1','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme22.png','Dugme2','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme33.png','Dugme3','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Dugme44.png','Dugme4','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac11.png','Konac1','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac22.png','Konac2','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac33.png','Konac3','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac44.png','Konac4','dob',136.55,5.00,'2014-10-10');

insert into materijal(slika,nazivmat,dobavljac,cijenamat,kolicinamat,datumkupnje) values
('F:\Moja_FirmaP\slike\Konac55.png','Konac5','dob',136.55,5.00,'2014-10-10');


insert into proizvod (nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Košulja1','L',5,'Odjeća','2014-10-28','2014-10-28','Pamuk',136.55);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Vesta1','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',41.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Košulja2','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',42.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Košulja3','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',43.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Vesta2','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',44.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Hlače1','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',45.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Košulja4','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',46.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Odjelo1','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',47.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Haljina1','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',48.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Sako1','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',49.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Odjelo2','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',60.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Sako2','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',50.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Sako3','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',430.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Sako4','42',5,'Odjeća','2014-10-28','2014-10-28','Pamuk 100%',140.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Slika1','42x50',5,'Kuća','2014-10-28','2014-10-28','Pamuk',240.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Slika2','42x60',5,'Kuća','2014-10-28','2014-10-28','Pamuk',840.99);

insert into proizvod(nazivpr,dimenzija,kolicinapr,grupaproizvoda,datumproizvodnje,rokizrade,sirovinskisastav,cijena)values
('Slika3','42x70',5,'Kuća','2014-10-28','2014-10-28','Pamuk',340.99);


insert into clan(proizvod,materijal) values
(1,4),(1,5),(1,6),(1,7),(1,9),(1,11),(1,12),(1,13),(1,14),(1,15);

insert into clan(proizvod,materijal) values
(2,1),(2,2),(2,5),(2,7),(2,9),(2,10),(2,14),(2,15);

insert into clan(proizvod,materijal) values
(3,1),(3,2),(3,3),(3,6),(3,8),(3,10),(3,13),(3,14),(3,15);

insert into clan(proizvod,materijal) values
(4,2),(4,3),(4,5),(4,7),(4,9),(4,11),(4,13),(4,15);

insert into clan(proizvod,materijal) values
(5,1),(5,2),(5,5),(5,7),(5,8),(5,9),(5,10),(5,11),(5,13),(5,14),(5,15);

insert into clan(proizvod,materijal) values
(6,2),(6,3),(6,4),(6,6),(6,10),(6,11),(6,13),(6,14);

insert into clan(proizvod,materijal) values
(7,1),(7,2),(7,4),(7,5),(7,6),(7,9),(7,11),(7,12),(7,14);

insert into clan(proizvod,materijal) values
(8,1),(8,3),(8,6),(8,7),(8,8),(8,9),(8,13),(8,14);

insert into clan(proizvod,materijal) values
(9,5),(9,6),(9,7),(9,9),(9,11),(9,12),(9,14),(9,15);

insert into clan(proizvod,materijal) values
(10,1),(10,2),(10,3),(10,7),(10,8),(10,13),(10,14),(10,15);

insert into clan(proizvod,materijal) values
(11,3),(11,4),(11,5),(11,6),(11,7),(11,8),(11,9),(11,10),(11,11);

insert into clan(proizvod,materijal) values
(12,1),(12,2),(12,3),(12,4),(12,6),(12,7),(12,10),(12,11);

insert into clan(proizvod,materijal) values
(13,2),(13,3),(13,5),(13,7),(13,8),(13,11),(13,12),(13,14);

insert into clan(proizvod,materijal) values
(14,1),(14,2),(14,3),(14,4),(14,5),(14,6),(14,7),(14,8);

insert into clan(proizvod,materijal) values
(15,3),(15,4),(15,5),(15,6),(15,7),(15,9),(15,11),(15,13);

insert into clan(proizvod,materijal) values
(16,1),(16,2),(16,3),(16,4),(16,5),(16,6),(16,7),(16,8);

insert into clan(proizvod,materijal) values
(17,8),(17,9),(17,10),(17,11),(17,12),(17,13),(17,14),(17,15);


insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(15,'Crtanje',35.00,5);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(9,'Rezeanje',35.00,4);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(10,'Uramljivanje',35.00,1);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(6,'Rad',35.00,7);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(11,'Fotografiranje',35.00,20);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(7,'Grafičkoko crtanje',35.00,3);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(9,'Logiranje',35.00,1);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(10,'Prijevoz',35.00,1000);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(8,'Završna obrada',35.00,4);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(11,'Grafička obrada',35.00,5);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(6,'Priprema rada',35.00,5);

insert into rad(osoba,nazivrada,cijenarada,kolicina)values
(8,'Pregovaranje',35.00,3);

insert into clan1(proizvod,rad) values
(1,1),(1,2),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12);

insert into clan1(proizvod,rad) values
(2,1),(2,2),(2,5),(2,7),(2,9),(2,10),(2,11),(2,12);

insert into clan1(proizvod,rad) values
(3,1),(3,2),(3,4),(3,5),(3,6),(3,7),(3,8),(3,9),(3,10),(3,11),(3,12);

insert into clan1(proizvod,rad) values
(4,2),(4,4),(4,5),(4,7),(4,9),(4,10),(4,11),(4,12);

insert into clan1(proizvod,rad) values
(5,1),(5,2),(5,4),(5,5),(5,6),(5,7),(5,8),(5,9),(5,10),(5,11),(5,12);

insert into clan1(proizvod,rad) values
(6,2),(6,4),(6,5),(6,6),(6,7),(6,8),(6,9),(6,10),(6,11),(6,12);

insert into clan1(proizvod,rad) values
(7,1),(7,2),(7,4),(7,5),(7,6),(7,9),(7,11),(7,12);

insert into clan1(proizvod,rad) values
(8,1),(8,4),(8,5),(8,6),(8,7),(8,8),(8,9),(8,10),(8,11),(6,12);

insert into clan1(proizvod,rad) values
(9,1),(9,2),(9,4),(9,5),(9,6),(9,7),(9,8),(9,9),(9,10),(9,11),(9,12);

insert into clan1(proizvod,rad) values
(10,1),(10,2),(10,4),(10,5),(10,6),(10,7),(10,8),(10,9),(10,10),(10,11),(10,12);

insert into clan1(proizvod,rad) values
(11,1),(11,2),(11,4),(11,5),(11,6),(11,7),(11,8),(11,9),(11,10),(11,11),(11,12);

insert into clan1(proizvod,rad) values
(12,1),(12,2),(12,4),(12,5),(12,6),(12,7),(12,8),(12,9),(12,10),(12,11),(12,12);

insert into clan1(proizvod,rad) values
(13,1),(13,2),(13,4),(13,5),(13,6),(13,7),(13,8),(13,9),(13,10),(13,11),(13,12);

insert into clan1(proizvod,rad) values
(14,1),(14,2),(14,4),(14,5),(14,6),(14,7),(14,8),(14,9),(14,10),(14,11),(14,12);

insert into clan1(proizvod,rad) values
(15,1),(15,2),(15,3),(15,4),(15,5),(15,6),(15,7),(15,8),(15,9),(15,10),(15,11),(15,12);

insert into clan1(proizvod,rad) values
(16,1),(16,2),(16,3),(16,4),(16,5),(16,6),(16,7),(16,8),(16,9),(16,10),(16,11),(16,12);

insert into clan1(proizvod,rad) values
(17,1),(17,2),(17,3),(17,4),(17,5),(17,6),(17,7),(17,8),(17,9),(17,10),(17,11),(17,12);


