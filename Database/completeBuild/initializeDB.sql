DROP DATABASE IF EXISTS movieapp;
CREATE DATABASE movieapp; 
USE movieapp;


DROP TABLE IF EXISTS theaterManagement;
CREATE TABLE theaterManagement (
  theaterListID   varchar(50) not null,
  primary key (theaterListID)
);

DROP TABLE IF EXISTS theaterList;
CREATE TABLE theaterList (
  theaterListID   	varchar(50) not null,
  theaterID			varchar(50) not null,
  primary key (theaterID, theaterListID),
  foreign key (theaterListID) references theaterManagement(theaterListID)
);

  
DROP TABLE IF EXISTS theater;
CREATE TABLE theater (
  street  		  	varchar(50) not null,
  city      	  	varchar(50) not null,
  province 		 	varchar(100) not null,
postalCode 		varchar(10) not null,
 theaterID			varchar(50) not null,
 movieListID	 		integer not null,

primary key (movieListID, postalCode),
foreign key (theaterID) references theaterList(theaterID)
);

DROP TABLE IF EXISTS movieList;
CREATE TABLE movieList (
  movieListID  		  	integer not null,
  movieName      	  	varchar(50) not null,
  primary key(movieName, movieListID),
  foreign key (movieListID) references theater (movieListID)
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  movieName 		  varchar(100) not null,
  theaterName         varchar(100) not null,
  exclusiveNews        varchar(100),
  showtimeListID				integer not null,
  primary key (showtimeListID, movieName, theaterName),
  foreign key (movieName) references movieList(movieName)
);


DROP TABLE IF EXISTS showtimeList;
CREATE TABLE showtimeList (
  showtimeListID  		  	integer not null,
  showtimeID      	  		varchar(12) not null,
  primary key(showtimeID, showtimeListID),
  foreign key (showtimeListID) references movie (showtimeListID)
);

DROP TABLE IF EXISTS showtime;
CREATE TABLE showtime (
  year  	  	varchar(12) not null,
  month      	varchar(12) not null, 
  date			integer not null,
  day		  	varchar(12) not null,
  time		  	varchar(12) not null,
  totalRows      	integer not null,
  totalCols      	integer not null,
 -- TicketTracker  varchar(1000) not null,
 ticketListID    integer not null,
  primary key (ticketListID, year,month,date,time),
  foreign key (time) references showtimeList (showtimeID)
);

DROP TABLE IF EXISTS ticketList;
CREATE TABLE ticketList (
  ticketListID  		  	integer not null,
  ticketID      	  		integer not null,
  primary key(ticketID, ticketListID),
  foreign key (ticketListID) references showtime (ticketListID)
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  ticketID    		integer not null,
  ticketStatus    	bool not null,
  seatRow		   	varchar(5) not null,
  seatCol		   	integer not null,
  cost		   		double not null,

  primary key (ticketid),
  foreign key (ticketID) references ticketList (ticketID)
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
