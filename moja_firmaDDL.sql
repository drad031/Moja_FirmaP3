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

