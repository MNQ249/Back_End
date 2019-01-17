
INSERT INTO ROLES( R_Type)
values( 'Aministrator');
INSERT INTO ROLES( R_Type)
VALUES( 'Orginzer');
INSERT INTO ROLES( R_Type)
VALUES('Attender');

INSERT INTO Users (user_id ,user_name,Password , f_name , l_name, Age, City, Email, Gender, Deleted )
VALUES (1089963862, 'Wolf', 'mnq1234', 'Misfer','AlQahtani', 28, 'Riyadh','example@yahoo.com','Male',0 );
INSERT INTO Users (user_id ,user_name,Password , f_name , l_name, Age, City, Email, Gender, Deleted )
VALUES(1092836746, 'Tiger','nam8754', 'Hamad','AlMansour', 25,'Arar', 'yhmyazeed@gmail.com','Male', 0 );
INSERT INTO Users (user_id ,user_name,Password , f_name , l_name, Age, City, Email, Gender, Deleted )
VALUES(1082374567, 'Mango','mbak456' , 'Musa', 'AlMusa', 25,'Dammam', 'Musa@elm.sa', 'Male', 0 );
INSERT INTO Users (user_id ,user_name,Password , f_name , l_name, Age, City, Email, Gender, Deleted)
VALUES(1082563324, 'Lion','AHi1263' , 'Ali', 'Hassan', 25,'Abha', 'AliH@elm.sa', 'Male', 0 );



INSERT INTO EventM( E_name, E_Time, E_City, E_Date, E_max_capacity, Deleted, E_approve, count)
VALUES('Janadriyah', current_time, 'Riyadh','2018-12-11', 300, 0, 1,0 );
INSERT INTO EventM( E_name, E_Time, E_City, E_Date, E_max_capacity, Deleted, E_approve, count)
VALUES('Janadriyah', current_time, 'Jeddah', current_date, 300, 0, 1,0 );
INSERT INTO EventM( E_name, E_Time, E_City, E_Date, E_max_capacity, Deleted, E_approve, count)
VALUES('Janadriyah', current_time, 'Jubail', current_date, 300, 0 , 1,0 );


INSERT INTO TICKETS(T_Available, Canceled)
VALUES( 1, 1);
INSERT INTO TICKETS(T_Available, Canceled)
VALUES(  1, 0);
INSERT INTO TICKETS(T_Available, Canceled)
VALUES(  0, 0);




INSERT INTO REVIEWEVENT( Vote, Rating, Deleted)
VALUES( 'Grate events.....it was osssom ', 5, 0);
INSERT INTO REVIEWEVENT( Vote, Rating, Deleted)
VALUES( 'Very boring. ', 1, 0);
INSERT INTO REVIEWEVENT( Vote, Rating, Deleted)
VALUES( 'not bad. ', 3, 0);





