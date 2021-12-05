DROP DATABASE IF EXISTS movieapp;
CREATE DATABASE movieapp; 
USE movieapp;

/* Not required
DROP TABLE IF EXISTS theaterManagement;
CREATE TABLE theaterManagement (
  listofTheater   theater
  primary key (listofTheater)
);
*/

DROP TABLE IF EXISTS theater;
CREATE TABLE theater (
  street  		  	varchar(50) not null,
  city      	  	varchar(50) not null,
  province 		 	varchar(100) not null,
 postalCode 		varchar(10) not null,
 -- movieList	 		varchar(1000) not null,
  primary key (postalCode)
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  movieName 		  varchar(100) not null,
  theaterName         varchar(100) not null,
  exclusiveNews        varchar(100),
  -- showtimes				varchar(1000) not null,
  primary key (movieName)
);

DROP TABLE IF EXISTS showtime;
CREATE TABLE showtime (
  year  	  	varchar(12) not null,
  month      	varchar(12) not null, 
  date			integer not null,
  day		  	varchar(12) not null,
  time		  	varchar(12) not null,
  -- rowId & cols are captured in ticket.
  -- rowId      	varchar(12) not null,
 -- cols      		integer not null,
 -- TicketTracker  varchar(1000) not null,
  
  primary key (year,month,day,time)
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  ticketid     		integer not null,
  ticketStatus    	bool not null,
  seatRow		   	varchar(5) not null,
  seatCol		   	integer not null,
  cost		   		double not null,

  primary key (ticketid)
);


DROP TABLE IF EXISTS regUser;
CREATE TABLE regUser (
  username      varchar(30) not null,
  fname		  	varchar(30) not null,
  lname		  	varchar(30) not null,
  phone	  		varchar(100) not null,
  password   	varchar(100) not null,
  primary key (username)
);

DROP TABLE IF EXISTS paymentInfo;
CREATE TABLE paymentInfo (
  number      	varchar(30) not null,
  expiry		varchar(30) not null,
  cvv		  	integer not null,
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
