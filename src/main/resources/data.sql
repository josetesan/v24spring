INSERT INTO USERS (USERNAME,PASSWORD,ENABLED,CREATE_DATE) values ('jsanc','ventura24',1,current_timestamp);
insert into users (username,PASSWORD,ENABLED,CREATE_DATE) values ('almu','ventura24',1,current_timestamp);

insert into authorities (username,authority) VALUES ('jsanc','user');
insert into authorities (username,authority) VALUES ('almu','user');


insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (1,CURRENT_TIMESTAMP,'PRIMITIVA','TERMINADO',8.35);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (1,CURRENT_TIMESTAMP,'EUROMILLONES','JUGANDO',10.5);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (1,CURRENT_TIMESTAMP,'PEÑA ANIS EL MONO','TERMINADO',104.89);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (0,CURRENT_TIMESTAMP,'LOTERIA NAVIDAD 2X1','JUGANDO',4.37);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (0,CURRENT_TIMESTAMP,'BONOLOTO','TERMINADO',2.8);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (0,CURRENT_TIMESTAMP,'EUROSUEÑOS','JUGANDO',1.24);
insert into depot (USER_ID,DRAW_DATE,PRODUCT,STATUS,AMOUNT)
  VALUES (0,CURRENT_TIMESTAMP,'PEÑA EL NIÑO 24576','JUGANDO',12.8);
