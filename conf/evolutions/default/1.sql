# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hole_test (
  id                            integer not null,
  hole_number                   integer,
  par                           integer,
  diffindex                     integer,
  score                         integer,
  constraint pk_hole_test primary key (id)
);
create sequence hole_test_seq;

create table user (
  usertype                      varchar(31) not null,
  id                            bigint auto_increment not null,
  loginname                     varchar(255),
  username                      varchar(255),
  email                         varchar(255),
  password                      varchar(255),
  handicap                      double,
  numofrounds                   integer,
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists hole_test;
drop sequence if exists hole_test_seq;

drop table if exists user;

