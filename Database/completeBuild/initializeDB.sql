DROP DATABASE IF EXISTS movieapp;
CREATE DATABASE movieapp; 
USE movieapp;

  
DROP TABLE IF EXISTS theater;
CREATE TABLE theater (
theaterName         varchar(100) not null,
postalCode 		    varchar(10) not null,
movieListID	 		integer,

primary key (theaterName)
);

DROP TABLE IF EXISTS movieList;
CREATE TABLE movieList (
  id  		  	integer not null,
  movieName      varchar(50),
  primary key(movieName, id)
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  movieName 		  varchar(100) not null,
  exclusiveNews        varchar(100),
  showtimeListID				integer not null,
  primary key (movieName)
);


DROP TABLE IF EXISTS showtimeList;
CREATE TABLE showtimeList (
  id  		  	integer not null,
  showtimeID    integer not null,
  primary key(id, showtimeID)
);

DROP TABLE IF EXISTS showtime;
CREATE TABLE showtime (
  id             integer not null,
  datee              datetime not null,
  totalRows      	integer not null,
  totalCols      	integer not null,
  ticketListID    integer not null,
  primary key (id)
);

DROP TABLE IF EXISTS ticketList;
CREATE TABLE ticketList (
  ticketListID  		  	integer not null,
  ticketID      	  		integer not null,
  primary key(ticketID, ticketListID)
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  id    		integer not null auto_increment,
  ticketStatus    	bool not null,
  seatRow		   	integer not null,
  seatCol		   	integer not null,
  cost		   		double not null,
  primary key (id)
);


DROP TABLE IF EXISTS regUser;
CREATE TABLE regUser (
  username      varchar(30) not null,
  fname		  	varchar(30) not null,
  lname		  	varchar(30) not null,
  phone	  		varchar(100) not null,
  email         varchar(100) not null,
  password   	varchar(100) not null,
  primary key (username)
);

DROP TABLE IF EXISTS paymentInfo;
CREATE TABLE paymentInfo (
  number      	varchar(30) not null,
  month		    int not null,
  year          int not null,
  cvv		  	integer not null,
  username      varchar(30) not null,
-- payProcess
primary key(number)
);

DROP TABLE IF EXISTS receipt;
CREATE TABLE receipt (
  receiptID      integer not null,
  date		  	varchar(30) not null,
  amountPaid	double not null,
  primary key (receiptID)
);

DROP TABLE IF EXISTS voucher;
CREATE TABLE voucher (
  amountLeft        	double not null,
  expiryDate		   	varchar(50) not null,
  primary key(amountLeft, expiryDate)
  -- 
);
