/*red hot chilli peppers*/
INSERT INTO ARTIST
VALUES (10000, now(), now(), 'Red Hot Chili Peppers are an American rock band formed in Los Angeles in 1983', 'Red Hot Chilli Peppers');

INSERT INTO MEMBER
VALUES (default, now(), now(), 'true', 'guitars', 'John Frusciante', 10000),
       (default, now(), now(), 'true', 'bass', 'Flea', 10000),
       (default, now(), now(), 'true', 'drums', 'Chad Smith', 10000),
       (default, now(), now(), 'true', 'lead vocals', 'Anthony Kiedis', 10000),
       (default, now(), now(), 'false', 'guitars', 'Hillel Slovak', 10000),
       (default, now(), now(), 'false', 'drums', 'Jack Irons', 10000),
       (default, now(), now(), 'false', 'guitars, keyboards', 'Josh Klinghoffer', 10000);

INSERT INTO RELEASE
VALUES (10000, now(), now(), 1984, 'The Red Hot Chili Peppers', 10000),
       (10001, now(), now(), 1985, 'Freakey Styley', 10000),
       (10002, now(), now(), 1995, 'One Hot Minute', 10000),
       (10003, now(), now(), 1999, 'Californication', 10000),
       (10004, now(), now(), 2002, 'By the Way', 10000),
       (10005, now(), now(), 2016, 'The Gateway', 10000),
       (10006, now(), now(), 2022, 'Unlimited Love', 10000),
       (10007, now(), now(), 2022, 'Return of the Dream Canteen', 10000);

INSERT INTO TRACK
VALUES (default, now(), now(), 'Get Up and Jump', 10000),
       (default, now(), now(), 'Out in L.A.', 10000),
       (default, now(), now(), 'Jungle Man', 10001),
       (default, now(), now(), 'Freaky Styley', 10001),
       (default, now(), now(), 'Aeroplane', 10002),
       (default, now(), now(), 'My Friends', 10002),
       (default, now(), now(), 'Californication', 10003),
       (default, now(), now(), 'Parallel Universe', 10003),
       (default, now(), now(), 'On Mercury', 10004),
       (default, now(), now(), 'Throw Away Your Television', 10004),
       (default, now(), now(), 'Go Robot', 10005),
       (default, now(), now(), 'Encore', 10005),
       (default, now(), now(), 'Here Ever After', 10006),
       (default, now(), now(), 'Veronica', 10006),
       (default, now(), now(), 'Eddie', 10007),
       (default, now(), now(), 'Peace and Love', 10007);

/*Nirvana*/
INSERT INTO ARTIST
VALUES (10001, now(), now(), 'Nirvana was an American rock band formed in Aberdeen, Washington, in 1987', 'Nirvana');

INSERT INTO MEMBER
VALUES (default, now(), now(), 'false', 'guitar', 'Kurt Cobain', 10001),
       (default, now(), now(), 'false', 'bass', 'Krist Novoselic', 10001),
       (default, now(), now(), 'false', 'drums', 'Dave Grohl', 10001);

INSERT INTO RELEASE
VALUES (20001, now(), now(), 1989, 'Bleach', 10001),
       (20002, now(), now(), 1991, 'Nevermind', 10001),
       (20003, now(), now(), 1993, 'In Utero', 10001);

INSERT INTO TRACK
VALUES (default, now(), now(), 'School', 20001),
       (default, now(), now(), 'About a Girl', 20001),
       (default, now(), now(), 'Blew', 20001),
       (default, now(), now(), 'Mr. Moustache', 20001),
       (default, now(), now(), 'Lithium', 20002),
       (default, now(), now(), 'In Bloom', 20002),
       (default, now(), now(), 'Something on the Way', 20002),
       (default, now(), now(), 'Polly', 20002),
       (default, now(), now(), 'Hear-Shaped Box', 20003),
       (default, now(), now(), 'All Apologies', 20003),
       (default, now(), now(), 'Pennyroyal tea', 20003),
       (default, now(), now(), 'Scentless Apprentice', 20003);

/*Fleetwood Mac*/
INSERT INTO ARTIST
VALUES (10002, now(), now(), 'Fleetwood Mac are a British-American rock band, formed in London in 1967', 'Fleetwood Mac');

INSERT INTO MEMBER
VALUES (default, now(), now(), 'true', 'drums', 'Mick Fleetwood', 10002),
       (default, now(), now(), 'true', 'bass', 'John McVie', 10002),
       (default, now(), now(), 'true', 'vocals', 'Stevie Nicks', 10002),
       (default, now(), now(), 'true', 'guitar', 'Mike Campbell', 10002),
       (default, now(), now(), 'true', 'keyboards', 'Neil Finn', 10002),
       (default, now(), now(), 'false', 'guitar', 'Peter Green', 10002),
       (default, now(), now(), 'false', 'guitar', 'Jeremy Spencer', 10002),
       (default, now(), now(), 'false', 'vocals', 'Christine McVie', 10002);

INSERT INTO RELEASE
VALUES (30001, now(), now(), 1968, 'Fleetwood Mac', 10002),
       (30002, now(), now(), 1969, 'Then Play On', 10002),
       (30003, now(), now(), 1973, 'Mystery to Me', 10002),
       (30004, now(), now(), 1974, 'Heroes Are Hard To Find', 10002),
       (30005, now(), now(), 1995, 'Time', 10002);

INSERT INTO TRACK
VALUES (default, now(), now(), 'My Heart Beat Like a Hammer', 30001),
       (default, now(), now(), 'Looking for Somebody', 30001),
       (default, now(), now(), 'Coming Your Way', 30002),
       (default, now(), now(), 'When You Say', 30002),
       (default, now(), now(), 'Emerald Eyes', 30003),
       (default, now(), now(), 'Keep On Going', 30003),
       (default, now(), now(), 'Coming Home', 30004),
       (default, now(), now(), 'Angel', 30004),
       (default, now(), now(), 'Winds of Change', 30005),
       (default, now(), now(), 'Dreamin'' the Dream', 30005);