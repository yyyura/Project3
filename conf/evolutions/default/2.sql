# --- Sample dataset

# --- !Ups

---1
--Users
--http://www.xorbin.com/tools/sha256-hash-calculator
INSERT INTO USER (usertype, id, loginname, username, email, PASSWORD ) VALUES ( 'admin', 0, 'admin', 'Admin', 'admin@golf.com', 'f42d22ffbc343a1368e12db6359b964f1c33e490c032df170a81817100ee7f74' );
INSERT INTO user (usertype, id, loginname, username, email, password)
VALUES ('member', 1, 'yura', 'Yura Member', 'yura@golf.com', '20bcace6ce5f643174f4859053c94c66c010c681238649126424ecdca5612b94');
INSERT INTO user (usertype, id, loginname, username, email, password)
VALUES ('member', 2, 'yura2', 'Yura2 Member', 'yura2@golf.com', '20bcace6ce5f643174f4859053c94c66c010c681238649126424ecdca5612b94');

---Handicap
INSERT INTO handicap(hand_id, handvalue, category, total_rounds_qty, date, user_h_id) VALUES (1,4.5,'0.1 -> 5.4',3,GETDATE(),1);
INSERT INTO handicap(hand_id, handvalue, category, total_rounds_qty, date, user_h_id) VALUES (2,16.2,'12.5 -> 20.4',3,GETDATE(),2);

---2
---Courses
INSERT INTO course (c_id, c_name, c_par) VALUES (1, 'Portmarnock Golf Club', 72);
INSERT INTO course (c_id, c_name, c_par) VALUES (2, 'Royal County Down', 72);
INSERT INTO course (c_id, c_name, c_par) VALUES (3, 'Royal Portrush Golf Club', 72);

---Holes
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (1, 1, 4, 1, 4, 1);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (2, 2, 4, 2, 4, 1);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (3, 3, 5, 3, 4, 1);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (4, 4, 4, 4, 60, 1);

INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (5, 1, 5, 4, 4, 2);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (6, 2, 4, 2, 4, 2);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (7, 3, 4, 3, 4, 2);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (8, 4, 4, 1, 60, 2);

INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (9, 1, 4, 4, 4, 3);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (10, 2, 3, 1, 4, 3);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (11, 3, 4, 3, 4, 3);
INSERT INTO hole (h_id, h_number, h_par, diff_index, score, course_o_c_id) VALUES (12, 4, 4, 2, 60, 3);

---Rounds
INSERT INTO round(r_id, course_r_c_id,user_r_id, gross_score, handicap) VALUES (1,1,1,100,6.3);
INSERT INTO round(r_id, course_r_c_id,user_r_id, gross_score, handicap) VALUES (2,1,1,105,7.3);
INSERT INTO round(r_id, course_r_c_id,user_r_id, gross_score, handicap) VALUES (3,2,2,110,8.4);
INSERT INTO round(r_id, course_r_c_id,user_r_id, gross_score, handicap) VALUES (4,3,2,90,9.2);











-- clean
-- h2-browser
-- drop table play_evolutions;