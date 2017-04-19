# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  c_id                          bigint not null,
  c_name                        varchar(255),
  c_par                         integer,
  constraint pk_course primary key (c_id)
);
create sequence course_seq;

create table handicap (
  hand_id                       integer not null,
  hand_value                    double,
  category                      varchar(255),
  total_rounds_qty              integer,
  date                          timestamp,
  member_o_id                   bigint,
  constraint pk_handicap primary key (hand_id)
);
create sequence handicap_seq;

create table hole (
  h_id                          integer not null,
  h_number                      integer,
  h_par                         integer,
  diff_index                    integer,
  score                         integer,
  course_o_c_id                 bigint,
  constraint pk_hole primary key (h_id)
);
create sequence hole_seq;

create table round (
  r_id                          bigint not null,
  course_r_c_id                 bigint,
  member_r_id                   bigint,
  gross_score                   double,
  net_score                     double,
  constraint pk_round primary key (r_id)
);
create sequence round_seq;

create table user (
  usertype                      varchar(31) not null,
  id                            bigint auto_increment not null,
  loginname                     varchar(255),
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (id)
);

alter table handicap add constraint fk_handicap_member_o_id foreign key (member_o_id) references user (id) on delete restrict on update restrict;
create index ix_handicap_member_o_id on handicap (member_o_id);

alter table hole add constraint fk_hole_course_o_c_id foreign key (course_o_c_id) references course (c_id) on delete restrict on update restrict;
create index ix_hole_course_o_c_id on hole (course_o_c_id);

alter table round add constraint fk_round_course_r_c_id foreign key (course_r_c_id) references course (c_id) on delete restrict on update restrict;
create index ix_round_course_r_c_id on round (course_r_c_id);

alter table round add constraint fk_round_member_r_id foreign key (member_r_id) references user (id) on delete restrict on update restrict;
create index ix_round_member_r_id on round (member_r_id);


# --- !Downs

alter table handicap drop constraint if exists fk_handicap_member_o_id;
drop index if exists ix_handicap_member_o_id;

alter table hole drop constraint if exists fk_hole_course_o_c_id;
drop index if exists ix_hole_course_o_c_id;

alter table round drop constraint if exists fk_round_course_r_c_id;
drop index if exists ix_round_course_r_c_id;

alter table round drop constraint if exists fk_round_member_r_id;
drop index if exists ix_round_member_r_id;

drop table if exists course;
drop sequence if exists course_seq;

drop table if exists handicap;
drop sequence if exists handicap_seq;

drop table if exists hole;
drop sequence if exists hole_seq;

drop table if exists round;
drop sequence if exists round_seq;

drop table if exists user;

