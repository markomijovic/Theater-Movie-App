USE movieapp;

-- Populating theater table
INSERT INTO theater
VALUES	("Chinook Cineplex", "T3F9L0", 1), 
		("Crowfoot Cineplex", "T2TT32",2), 
		("CrossIron Cineplex", "TG3V21",1), 
        ("Landmark Cineplex", "T1G3G3", 3);
        
-- Populating movieList table
INSERT INTO movieList
VALUES	(1,"NoTimeToDie"),
		(1,"Dune"),
        (1,"MatrixResurrections"),
		(2,"Dune"),
        (2,"MatrixResurrections"),
		(3,"NoTimeToDie"),
        (3,"Eternals");
        
 -- Populating movie table      
INSERT INTO movie 
VALUES	("NoTimeToDie", "Member get free popcorn",1), 
		("MatrixResurrections","Member get free popcorn",1), 
		("Dune","Follow on IG for discount",2), 
        ("Eternals","Movie Giveaway!",2);     

-- Populating showtimeList table
INSERT INTO showtimeList
VALUES	(1,1),
		(1,2),
		(1,3),
        (1,4),
        (1,5),
        (2,1),
        (2,2),
        (2,3),
        (2,4);

        
-- Populating showtime table         
INSERT INTO showtime 
VALUES	(1, "2021-12-15T14:00:00",5,5,1),
		(2, "2021-12-15T16:00:00",5,5,2),
        (3, "2021-12-16T14:00:00",5,5,3),
        (5, "2021-12-18T20:30:00",5,5,4);
       
-- Populating ticketList table
INSERT INTO ticketList
VALUES	(1,1),
		(1,2),
		(1,3),
        (1,4),
        (1,5),
        (2,6),
        (2,7),
        (2,8),
        (2,9),
        (2,10),
        (2,11),
        (3,12),
        (3,13),
        (4,14),
        (4,15),
        (4,16),
        (4,17);

-- Populating ticket table
INSERT INTO ticket 
VALUES	(1,True, 1, 1, 12.50),
		(2,True, 1, 2, 12.50),
        (3,True, 1, 3, 12.50),
        (4,True, 2, 4, 12.50),
        (5,True, 3, 5, 12.50),
        (6,True, 1, 5, 12.50),
        (7,True, 2, 3, 12.50),
        (8,True, 3, 2, 12.50),
        (9,True, 4, 1, 12.50),
        (10,True, 4, 2, 12.50),
        (11,True, 2, 5, 12.50),
        (12,True, 1, 5, 10),
        (13,True, 3, 2, 9),
        (14,True, 1, 2, 10),
        (15,True, 2, 3, 10),
        (16,True, 3, 4, 10),
        (17,True, 4, 5, 10);
	  

-- Populating regUser table
INSERT INTO regUser 
VALUES	(1,"Bill", "Jones", "4034861894", "bill@gmail.com", "passw0rd"),
		(2,"Bob", "Smith", "40359846241", "bob@gmail.com", "hello"),
		(3,"Rachel", "Green", "4032197862", "rachel@yahoo.com", "world"),
		(4,"Marcus", "Brown", "4035132879", "marcus@gmail.com", "movies"),
		(5,"Kevin", "Durant", "4032159873",  "kevin@ucalgary.ca" ,"pixel6"),
		(6,"Kyrie", "Irving", "4039756418", "kyrie@gmail.com", "basketball");
        
-- Populating paymentInfo table
INSERT INTO paymentInfo 
VALUES	("123456789", 9, 23, 754, 1),
		("987654321", 1, 22, 754, 2),
		("741852963", 12, 24, 754, 3),
		("369258147", 7, 23, 754, 4),
        ("147258369", 11, 23, 754, 5),
        ("789654123", 2, 24, 754, 6);
        
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

