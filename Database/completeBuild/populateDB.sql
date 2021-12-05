USE movieapp;

-- Populating theaterManagement table
INSERT INTO theaterManagement
VALUES	("Cineplex"),
		("Landmark");

-- Populating theaterList table
INSERT INTO theaterList
VALUES	("Cineplex","Crowfoot"),
		("Cineplex","Chinook"),
		("Landmark","CountryHills"),
        ("Landmark", "MarketMall");

-- Populating theater table
INSERT INTO theater
VALUES	("CrowfootWay", "Calgary","AB","T3F9L0", "Crowfoot",1), 
		("CrowfootWay", "Calgary","AB","T3F9L0", "Crowfoot",2), 
		("ChinookMall", "Calgary","AB","T2G8C0","Chinook",1), 
        ("ChinookMall", "Calgary","AB","T2G8C0", "Chinook",2), 
        ("CountryHillsLoop", "Calgary","AB","T5K0L0", "CountryHills",3), 
        ("CountryHillsLoop", "Calgary","AB","T5K0L0", "CountryHills",4), 
        ("MarketMallRoad", "Calgary","AB","T8V5J2", "MarketMall",3), 
        ("MarketMallRoad", "Calgary","AB","T8V5J2", "MarketMall",4);
        
-- Populating movieList table
INSERT INTO movieList
VALUES	(1,"NoTimeToDie"),
		(1,"Dune"),
		(2,"Dune"),
        (2,"MatrixResurrections"),
		(3,"NoTimeToDie"),
        (3,"Eternals"),
        (4,"Eternals"),
        (4,"MatrixResurrections");
        
 -- Populating movie table      
INSERT INTO movie 
VALUES	("NoTimeToDie", "Chinook Cineplex","Member get free popcorn",1), 
		("Dune", "Crowfoot Cineplex","Follow on IG for discount",2), 
        ("MatrixResurrections", "CrossIron Cineplex",null,1), 
        ("Eternals", "Landmark Country Hills","Movie Giveaway!",2);     

-- Populating showtimeList table
INSERT INTO showtimeList
VALUES	(1,"17:00"),
		(1,"18:00"),
		(1,"19:00"),
        (1,"20:00"),
        (1,"21:00"),
        (2,"17:00"),
        (2,"18:00"),
        (2,"19:00"),
        (2,"20:00"),
        (2,"21:00");

        
-- Populating showtime table         
INSERT INTO showtime 
VALUES	("2021", "December", 6, "Monday", "17:00", 5,5,1),
		("2021", "December", 6,"Monday", "18:00",5,5,1),
        ("2021", "December", 6,"Monday", "19:00",5,5,1),
        ("2021", "December", 6,"Monday", "20:00",5,5,1),
        ("2021", "December", 6,"Monday", "21:00",5,5,1),
        ("2021", "December", 7,"Tuesday", "17:00",5,5,1),
        ("2021", "December", 7,"Tuesday", "18:00",5,5,1),
        ("2021", "December", 7,"Tuesday", "19:00",5,5,1),
        ("2021", "December", 7,"Tuesday", "20:00",5,5,1),
		("2021", "December", 7,"Tuesday", "21:00",5,5,1),
		("2021", "December", 11,"Saturday", "17:00",5,5,1),
		("2021", "December", 11,"Saturday", "18:00",5,5,1),
        ("2021", "December", 11,"Saturday", "19:00",5,5,1),
        ("2021", "December", 11,"Saturday", "20:00",5,5,1),
		("2021", "December", 11,"Saturday", "21:00",5,5,1);
       
-- Populating ticketList table
INSERT INTO ticketList
VALUES	(1,1),
		(1,2),
		(1,3),
        (1,4),
        (1,5),
        (1,6),
        (1,7),
        (1,8),
        (1,9),
        (1,10);

-- Populating ticket table
INSERT INTO ticket 
VALUES	(1,True, "A", 1, 12.50),
		(2,True, "A", 2, 12.50),
        (3,True, "A", 3, 12.50),
        (4,True, "A", 4, 12.50),
        (5,True, "A", 5, 12.50),
        (6,True, "B", 1, 12.50),
        (7,True, "B", 2, 12.50),
        (8,True, "B", 3, 12.50),
        (9,True, "B", 4, 12.50),
        (10,True, "B", 5, 12.50);
	  

-- Populating regUser table
INSERT INTO regUser 
VALUES	(1,"Bill", "Jones", "4034861894","passw0rd"),
		(2,"Bob", "Smith", "40359846241","hello"),
		(3,"Rachel", "Green", "4032197862","world"),
		(4,"Marcus", "Brown", "4035132879","movies"),
		(5,"Kevin", "Durant", "4032159873","pixel6"),
		(6,"Kyrie", "Irving", "4039756418","basketball");
        
-- Populating paymentInfo table
INSERT INTO paymentInfo 
VALUES	("123456789", "09/23", 754),
		("987654321", "01/22", 754),
		("741852963", "12/24", 754),
		("369258147", "07/23", 754),
        ("147258369", "11/23", 754),
        ("789654123", "01/24", 754);
        
-- Populating receipt table
INSERT INTO receipt 
VALUES	(1, "23/11/2021", 12.50),
		(2, "03/12/2021", 12.50),
        (3, "02/12/2021", 12.50),
        (4, "03/12/2021", 12.50),
        (5, "01/12/2021", 12.50),
        (6, "01/12/2021", 12.50),
        (7, "29/11/2021", 12.50),
        (8, "30/11/2021", 12.50),
        (9, "28/11/2021", 12.50),
        (10, "01/12/2021", 12.50),
        (11, "03/12/2021", 12.50);
		

-- Populating some vouchers
INSERT INTO voucher
VALUES (10.6, "03/12/2022"),
	   (10.6, "30/11/2022"),
       (12.5, "01/12/2021"),
       (12.5, "28/11/2021");

