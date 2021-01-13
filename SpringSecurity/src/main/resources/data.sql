Insert into app_user(id,created_by,created_date,email,first_name,last_name,password,username) values(1,'mkedari',CURRENT_TIMESTAMP(),'mukund.kedari@email.com','Mukund','Kedari','mkedari123','mkedari');
Insert into app_user(id,created_by,created_date,email,first_name,last_name,password,username) values(2,'mkedari',CURRENT_TIMESTAMP(),'abhi.kasbe@email.com','Abhi','Kasbe','akasbe123','akasbe');
Insert into app_user(id,created_by,created_date,email,first_name,last_name,password,username) values(3,'mkedari',CURRENT_TIMESTAMP(),'pallavi.kedari@email.com','Pallavi','Kedari','pkedari123','pkedari');

INSERT INTO user_permission_group(USER_PERMISSION_ID,CREATED_BY,CREATED_DATE,PERMISSION_GROUP,USER_ID) values(1, 'mkedari', CURRENT_TIMESTAMP(), 'USER', 1);
INSERT INTO user_permission_group(USER_PERMISSION_ID,CREATED_BY,CREATED_DATE,PERMISSION_GROUP,USER_ID) values(2, 'mkedari', CURRENT_TIMESTAMP(), 'ADMIN', 1);
INSERT INTO user_permission_group(USER_PERMISSION_ID,CREATED_BY,CREATED_DATE,PERMISSION_GROUP,USER_ID) values(3, 'mkedari', CURRENT_TIMESTAMP(), 'USER', 2);
INSERT INTO user_permission_group(USER_PERMISSION_ID,CREATED_BY,CREATED_DATE,PERMISSION_GROUP,USER_ID) values(4, 'mkedari', CURRENT_TIMESTAMP(), 'USER', 3);