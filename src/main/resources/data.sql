INSERT INTO USER (id,email, password, role, userName) VALUES
(1,'zarn@gmail.com', '$2a$10$fy7b2TMtprXpV5MJ.4izCu5/8.Mw14xqLIZ/hB2uYx3BmJe.h04wK', 'LANDLORD', 'zarn_holland'),
(2,'win@gmail.com', '$2a$10$4rnxx/evww3ENLGqK.XUOO2W19Im/I.a2sRclv2qgFY9lHjNDwK9G', 'USER', 'win_myint');


INSERT INTO DORM(
    dormId, dormName, dormDesc, price, bedroom, bathroom, img1, img2, img3, img4, city, amenities, latitude, longitude, landlord_id
) VALUES
(
    1, 'Regent Mansion', 'This is regent Mansion', 4000, 1, 1, 'dorm1.png', 'dorm1.png', 'dorm1.png', 'dorm1.png', 'Chiang Rai', 'Aircon, hot-shower, balcony', 20.04300195098124, 99.88061252359927, 1
),
(
    2, 'STK Resort', 'This is regent Mansion', 4500, 1, 1, 'dorm2.jpg', 'dorm2.jpg', 'dorm2.jpg', 'dorm2.jpg', 'Chiang Rai', 'Aircon', 20.044534713021523, 99.87971923709337,  1
),
(
    3, 'Regent Mansion', 'This is regent Mansion', 4000, 1, 1, 'dorm3.jpg', 'dorm3.jpg', 'dorm3.jpg', 'dorm3.jpg', 'Chiang Rai', 'Aircon, hot-shower, balcony', 20.04300195098124, 99.88061252359927,  1
),
(
    4, 'Regent Mansion', 'This is regent Mansion', 4000, 1, 1, 'dorm4.jpg', 'dorm4.jpg', 'dorm4.jpg', 'dorm4.jpg', 'Chiang Rai', 'Aircon, hot-shower, balcony', 20.04300195098124, 99.88061252359927,  1
),
(
    5, 'Regent Mansion', 'This is regent Mansion', 4000, 1, 1, 'dorm5.jpg', 'dorm5.jpg', 'dorm5.jpg', 'dorm5.jpg', 'Chiang Rai', 'Aircon, hot-shower, balcony', 20.04300195098124, 99.88061252359927,  1
);
