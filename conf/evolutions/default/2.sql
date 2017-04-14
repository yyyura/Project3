# --- Sample dataset

# --- !Ups

insert into user (usertype,id,loginname,username,email,password,handicap,numofrounds) values ( 'admin',0,'admin','Alice Admin','admin@products.com','pass',0,0 );
insert into user (usertype,id,loginname,username,email,password,handicap,numofrounds) values ( 'member',1,'yura','yura member','yura@products.com','yura',6.3,15 );



insert into course (c_id,c_name,c_par) VALUES (1,'Portmarnock Golf Club',72 );

insert into hole (h_id,h_number,h_par,diff_index,score) values ( 1,1,4,1,7 );
insert into hole (h_id,h_number,h_par,diff_index,score) values ( 2,2,4,2,8 );
insert into hole (h_id,h_number,h_par,diff_index,score) values ( 3,3,4,3,7 );
insert into hole (h_id,h_number,h_par,diff_index,score) values ( 4,4,4,4,7 );







-- h2-browser
-- drop table play_evolutions;