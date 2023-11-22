INSERT INTO USER (id,email, password, role, userName) VALUES
(1,'zarn@gmail.com', '$2a$10$fy7b2TMtprXpV5MJ.4izCu5/8.Mw14xqLIZ/hB2uYx3BmJe.h04wK', 'LANDLORD', 'zarn_holland'),
(2,'win@gmail.com', '$2a$10$4rnxx/evww3ENLGqK.XUOO2W19Im/I.a2sRclv2qgFY9lHjNDwK9G', 'USER', 'win_myint');


INSERT INTO DORM(dormID,dormName,dormDesc, price, bedroom , bathroom , img1 , img2, img3 , img4 , city ,amenities , latitude, longitude , landlord_id)VALUES
( 1, 'Regent Mansion', 'There are 16 buildings, 796 rooms, 2 types of rooms : single bed rooms and twin bed rooms. (28 sq m.)
', 4000 ,2, 1 , 'regent1.jpg' , 'regent2.jpg' , 'regent3.jpg' , 'regent4.jpg', 'Mueang Chiang Rai' , 
'Free shuttle bus from dorm to MFU,free wifi,Security System,Exercise Facilities,Hot shower',20.04310274137123, 99.88058033865333,1),
( 2, 'Kittitya Dormitory', 'The dormitory has 3 floors, a fuchsia pink building. orange-red roof, 2 types of rooms : a single bed room with air conditioning and single bed room without air conditioning. (28 sq m.)', 2800 ,1, 1 , 'kittitya1.png' , 'kittityat2.jpg' , 'kittitya3.jpg' , 'kittitya4.jpg', 'Mueang Chiang Rai' , 
'Parking Space,free wifi,Security System,Exercise Facilities,Hot shower',20.04612470070634, 99.88341218098132, 1),
( 3, 'U LOFT Apartment', 'The building has 4 floors, female dormitory, 2 types of rooms : big single bed rooms (27 sq m.) and small bed rooms (30 sq m.)
', 4300 ,1, 1 , 
'uloft1.jpg' , 'uloft2.jpg' , 'uloft3.jpg' , 'uloft4.jpg', 'Mueang Chiang Rai' , 
'Common Room,Parking Space,free wifi,Security System',20.048692419040375, 99.87987866748955, 1),
( 4, 'FahRung Dormitory', 'Small dormitory with 3 floors, female dormitory, 1 type of rooms : single bed rooms (28 sq m.)', 3200 ,1, 1 ,
 'fah1.jpg' , 'fah2.jpg' , 'fah3.jpg' , 'fah4.jpg', 'Mueang Chiang Rai' , 
'Coin operated washing machine,Parking Space,free wifi,Water Dispenser',20.048389455522774, 99.87745394050596, 1),
( 5, 'Baan Soi 5', '2 types of rooms : Private room (1 person) and Twin room (1-2 person)
', 3000 ,1, 1 , 
'baan1.jpg' , 'baan2.jpg' , 'baan3.jpg' , 'baan4.jpg', 'Mueang Chiang Rai' , 
'Shuttle Bus from dorm to MFU,Cafes,Parking Space,free wifi,Exercises Facilities',20.054129748147634, 99.878396579129, 1),
( 6, 'Beyond', '2 types of rooms : single bed rooms and twin bed rooms. ', 5000 ,2, 1 , 
'beyond1.jpg' , 'beyond2.jpg' , 'beyond3.jpg' , 'beyond4.jpg', 'Mueang Chiang Rai' , 
'Security,Parking Space,free wifi,Exercises Facilities',20.046617394297773, 99.88053611166987, 1),
( 7, 'WEANG FAH LUANG', 'The wooden dormitory has 30 rooms,female dormitory, 4 types of rooms : single room, twin room, triple room and quadruple room(4 beds)', 5000 ,2, 2 ,
 'weang1.jpg' , 'weang2.jpg' , 'weang3.jpg' , 'weang4.jpg', 'Mueang Chiang Rai' , 
'Room Service,Security,Parking Space,free wifi',20.04480154434289, 99.8896000539977, 1),
( 8, 'STK', 'There are 12 buildings, 300 rooms, 2 types of rooms : single bed rooms and twin bed rooms. (20 sq m.)', 4800 ,2, 1 , 
'stk1.png' , 'stk2.png' , 'stk3.png' , 'stk4.png', 'Mueang Chiang Rai' , 
'Common Room,Security,Parking Space,free wifi,Exercises Facilities',20.044665739263447, 99.87976215399766, 1),
( 9, 'The Northern MFU', 'There are 5th floor with European Style rooms', 6500 ,2, 2 , 
'northern1.png' , 'northern2.png' , 'northern3.png' , 'northern4.png', 'Mueang Chiang Rai' , 
'Elevator,Security,Parking Space,free wifi,Exercises Facilities',20.04663281972132, 99.88011235838638, 1),
( 10, 'SJD MANSION 2', ' 2 bedrooms with clean and good service and fair price.', 4000 ,1, 1 , 
'sjd1.png' , 'sjd2.png' , 'sjd3.png' , 'sjd4.png', 'Mueang Chiang Rai' , 
'7-11,Security,Parking Space,free wifi,Restaurants',20.04712124039462, 99.88014903995992, 1);


INSERT INTO WISHLIST(id,user_id,dorm_id) VALUES
(1,2,1),
(2,2,3);