USE movieapp;

-- Populating movie table

INSERT INTO theater
VALUES	("Crowfoot Way", "Calgary","AB","T3F9L0"), 
		("Chinook Mall", "Calgary","AB","T2G8C0"), 
        ("Infinite Loop", "Edmonton","AB","G9L92F"), 
        ("Beaver Road", "Fort McMurray","AB","X9D2K0");
        
        
INSERT INTO movie 
VALUES	('No Time To Die', "Chinook Cineplex","Member get free popcorn"), 
		("Dune", "Crowfoot Cineplex","Follow on IG for discount"), 
        ("Matrix", "CrossIron Cineplex",null), 
        ("Eternals", "Landmark Country Hills","Movie Giveaway!");     



        
-- Populating showtime table         
INSERT INTO showtime 
VALUES	("2021", "December", 6, "Monday", "9:00"),
		("2021", "December", 6,"Monday", "9:00"),
        ("2021", "December", 6,"Monday", "9:00"),
        ("2021", "December", 6,"Monday", "9:00"),
        ("2021", "December", 6,"Monday", "9:00"),
        ("2021", "December", 7,"Tuesday", "20:00"),
        ("2021", "December", 7,"Tuesday", "20:00"),
        ("2021", "December", 7,"Tuesday", "20:00"),
        ("2021", "December", 7,"Tuesday", "20:00"),
		("2021", "December", 7,"Tuesday", "20:00"),
		("2021", "December", 11,"Saturday", "21:30"),
		("2021", "December", 11,"Saturday", "21:30"),
        ("2021", "December", 11,"Saturday", "21:30"),
        ("2021", "December", 11,"Saturday", "21:30"),
		("2021", "December", 11,"Saturday", "21:30");
       
INSERT INTO ticket 
VALUES	('No Time To Die', "Chinook Cineplex","Member get free popcorn"), 
		("Dune", "Crowfoot Cineplex","Follow on IG for discount"), 
        ("Matrix", "CrossIron Cineplex",null), 
        ("Eternals", "Landmark Country Hills","Movie Giveaway!");     



-- Populating ticket table
INSERT INTO ticket 
VALUES	(1,"True", "A", 1, 12.50),
		(2,"True", "A", 2, 12.50),
        (3,"True", "A", 3, 12.50),
        (4,"True", "A", 4, 12.50),
        (5,"True", "A", 5, 12.50),
        (6,"True", "B", 1, 12.50),
        (7,"True", "B", 2, 12.50),
        (8,"True", "B", 3, 12.50),
        (9,"True", "B", 4, 12.50),
        (10,"True", "B", 5, 12.50);
	  

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

