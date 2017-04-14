# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hole (
  h_id                          integer not null,
  h_number                      integer,
  h_par                         integer,
  diff_index                    integer,
  score                         integer,
  constraint pk_hole primary key (h_id)
);
create sequence hole_seq;

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

drop table if exists hole;
drop sequence if exists hole_seq;

drop table if exists user;

