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


# --- !Downs

drop table if exists hole_test;
drop sequence if exists hole_test_seq;

