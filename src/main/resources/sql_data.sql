
--CREATE SEQUENCE my_sequence START 1000;


INSERT INTO user(id,name,age,membership)VALUES
(20001,'Hardik1',23),
(20002,'Hardik2',34),
(20003,'Hardik3',32);

INSERT INTO membership(id,membership,user_id)VALUES
(10001,'Free',20001),
(10002,'Premium',20002),
(10003,'Gold',20003);


INSERT INTO order(id,product_name,user_id)VALUES
(40001,'Fridge',20001),
(40002,'AC',20002),
(40003,'TV',20003);






