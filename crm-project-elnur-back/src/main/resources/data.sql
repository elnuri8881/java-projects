insert into users
(username,password,enabled)
values
('m1','{noop}m1',1);

insert into authorities
(username,authority)
values
('m1','customer');
