SELECT *
  FROM USERS u;

COMMIT;

SELECT * FROM users u;
INSERT INTO users (id, password, usersimage) VALUES('11', '11', '11');

CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999;

INSERT INTO USERS
     VALUES (users_seq.NEXTVAL,
             '22',
             '22',
             '222222');

INSERT INTO USERS
     VALUES (no,
             'id',
             'password',
             'userimage');

SELECT * FROM USERS;

DELETE FROM USERS
      WHERE NO = 3;

SELECT no,
       id,
       password,
       usersimage
  FROM USERS
 WHERE ID = '123' AND PASSWORD = '123';

UPDATE USERS
   SET PASSWORD = '123', USERSIMAGE = '123'
 WHERE NO = 44;

SELECT * FROM USERS;

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '11',
             '11',
             '11',
             '11',
             '11',
             11,
             11);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '22',
             '22',
             '22',
             '22',
             '22',
             22,
             22);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '33',
             '33',
             '33',
             '33',
             '33',
             33,
             33);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '44',
             '44',
             '44',
             '44',
             '44',
             44,
             44);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '55',
             '55',
             '55',
             '55',
             '55',
             55,
             55);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '66',
             '66',
             '66',
             '66',
             '66',
             66,
             66);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '77',
             '77',
             '77',
             '77',
             '77',
             77,
             77);

INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '88',
             '88',
             '88',
             '88',
             '88',
             88,
             88);


INSERT INTO SHOP
     VALUES (shop_seq.NEXTVAL,
             '99',
             '99',
             '99',
             '99',
             '99',
             99,
             99);
			 commit;
			 
			 SELECT * FROM SHOP s;