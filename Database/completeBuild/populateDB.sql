USE movieapp;

-- Populating theater table
INSERT INTO theater
VALUES	("Chinook Cineplex", "T3F9L0"), 
		("Crowfoot Cineplex", "T2TT32");

        
 -- Populating movie table      
INSERT INTO movie 
VALUES	("NoTimeToDie", "Member get free popcorn",11, "Chinook Cineplex"), 
		("Dune","Follow on IG for discount",12, "Chinook Cineplex"), 
		("MatrixResurrections","Member get free popcorn",13, "Chinook Cineplex"), 
        ("Dune","Follow on IG for discount",21, "Crowfoot Cineplex"), 
		("Eternals","Member get free popcorn",22, "Crowfoot Cineplex");

-- Populating showtimeList table
INSERT INTO showtimeList
VALUES	(11,11),
		(11,12),
		(11,13),
        (12, 21),
        (12, 22),
        (13, 31),
        (21, 111),
        (21, 112),
        (22, 121),
        (22, 122);

        
-- Populating showtime table         
INSERT INTO showtime 
VALUES	(11, "2021-12-08T14:00:00",5,5,11),
		(12, "2021-12-15T16:00:00",5,5,12),
		(13, "2021-12-17T14:00:00",5,5,13),
		(21, "2021-12-18T20:00:00",5,5,21),
		(22, "2021-12-08T22:00:00",5,5,22),
		(31, "2021-12-20T15:00:00",5,5,31),
        (111, "2021-12-15T16:00:00",5,5,111),
		(112, "2021-12-17T13:00:00",5,5,112),
        (121, "2021-12-16T15:40:00",5,5,121),
        (122, "2021-12-18T20:30:00",5,5,122);
       
-- Populating ticketList table
INSERT INTO ticketList
VALUES	(11,11),
		(11,12),
		(12,51),
        (12,52),
		(13,81),
        (13,82),
        (21,101),
        (21,102),
        (22,121),
        (31,151),
        (31, 152),
        (111,181),
        (112,201),
        (112,202),
        (122,221),
        (122,222);

-- Populating ticket table
INSERT INTO ticket 
VALUES	(11,True, 1, 1, 12.50),
		(12,True, 1, 2, 12.50),
        (51,True, 1, 3, 12.50),
        (52,True, 2, 4, 12.50),
        (81,True, 3, 5, 12.50),
        (82,True, 1, 5, 12.50),
        (101,True, 2, 3, 12.50),
        (102,True, 3, 2, 12.50),
        (121,True, 4, 1, 12.50),
        (151,True, 4, 2, 12.50),
        (152,True, 2, 5, 12.50),
        (181,True, 1, 5, 10),
        (201,True, 3, 2, 9),
        (202,True, 1, 2, 10),
        (221,True, 2, 3, 10),
        (222,True, 3, 4, 10);
	  

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

