# --- Sample dataset

# --- !Ups

insert into user (usertype,id,loginname,username,email,password,handicap,numofrounds) values ( 'admin',0,'admin','Alice Admin','admin@products.com','pass',0,0 );
insert into user (usertype,id,loginname,username,email,password,handicap,numofrounds) values ( 'member',1,'yura','yura member','yura@products.com','yura',6.3,15 );



insert into course (c_id,c_name,c_par) VALUES (1,'Portmarnock Golf Club',72 );
insert into course (c_id,c_name,c_par) VALUES (2,'Royal County Down',72 );

insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 1,1,4,1,7,1 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 2,2,4,2,8,1 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 3,3,4,3,7,1 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 4,4,4,4,7,1 );

insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 5,1,4,4,6,2 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 6,2,4,2,5,2 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 7,3,4,3,7,2 );
insert into hole (h_id,h_number,h_par,diff_index,score,course_o_c_id) values ( 8,4,4,1,8,2 );




-- clean
-- h2-browser
-- drop table play_evolutions;