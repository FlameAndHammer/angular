create table users(
  username varchar_ignorecase(50) not null primary key,
  password varchar_ignorecase(100) not null,
  enabled boolean not null);

create table authorities (
  username varchar_ignorecase(50) not null,
  authority varchar_ignorecase(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users VALUES('admin','$2a$10$S38E3b9CUcFxK4P7lsDp6.VvpeYtrBW/b5BTHPLiCSofDc38FMrR6',true);
INSERT INTO authorities VALUES('admin','ROLE_ADMIN');

INSERT INTO users VALUES('user','$2a$10$S38E3b9CUcFxK4P7lsDp6.VvpeYtrBW/b5BTHPLiCSofDc38FMrR6',true);
INSERT INTO authorities VALUES('user','ROLE_USER');
