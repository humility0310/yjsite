	select users.no, users.id 
		FROM users 
		WHERE users.id = '11' ;
		
		INSERT INTO users ( id, password, usersimage) VALUES( '11', '11', '11');
		commit;
		
		
INSERT INTO users (id, password, usersimage) VALUES('22', '22', '22');
commit;
SELECT * FROM users;