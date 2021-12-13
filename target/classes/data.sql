/*INSERT into POST (id, title, content, author) VALUES (1, 'MIU','Life is structured in layers','Dean');
INSERT into POST (id, title, content, author) VALUES (2, 'React','React is a good SPA library','Dean');
INSERT into POST (id, title, content, author) VALUES (3, 'Spring','Spring is awesome','Dean');
INSERT into POST (id, title, content, author)  VALUES (4, 'SpringBoot','This is a module that works over spring modules','John');
*/
INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (1, 'USER');
INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (2, 'ADMIN');

insert into user (id, name , username, password, is_enabled )  VALUES (111, 'user','user','1234',true);
insert into user (id, name , username, password, is_enabled )  VALUES (112, 'Admin','admin','1234',true);

insert into USER_ROLES(USER_ID, ROLE_ID) VALUES (111, 1);
insert into USER_ROLES(USER_ID, ROLE_ID) VALUES (112, 2);

insert into brand (id,name) VALUES (1,'Nike');
insert into brand (id,name) VALUES (2,'Nokia');
insert into brand (id,name) VALUES (3,'Samsung');
insert into brand (id,name) VALUES (4,'Apple');

insert into category (id,name) VALUES (1,'Shoes');
insert into category (id,name) VALUES (2,'Electronics');


insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (1, 1,1, 'Nike Summer shoes confrtable', true,'Nike Zoom 12', 142.2,15);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (2, 2,2, 'Nokia best camera Mobile', true, 'Nokia 7,2', 342.2,50);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (3, 3,2, 'Apple 12 is now goe live', true,'Apple 13 pro', 312.2,20);

insert into product (id, brand_id, category_id, description, is_active, name, price, quantity) VALUES (4, 4,2, 'Google Pixel 5a - 5G with three month free Go-FI', true, 'Pixel 5a', 450.0,12);