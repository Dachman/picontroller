CREATE KEYSPACE picontroller
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE picontroller;

CREATE TABLE user (
  userId int PRIMARY KEY,
  userName text,
  userPassword text,
  userRole text
);

CREATE INDEX ON user (userName);
CREATE INDEX ON user(userpassword);

INSERT INTO user (userId, userName, userPassword, userRole)
  VALUES (1, 'dach', 'Dach7!', 'Admin');