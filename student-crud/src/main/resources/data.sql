insert into users
(username,password,enabled)
values
('m1','{noop}m1',1),
('m2','{noop}m2',1),
('m3','{noop}m3',1);

insert into authorities
(username,authority)
values
('m1','teacher'),
('m2','teacher'),
('m3','teacher');

insert into student
(name,surname,teacher)
values
('Əli','Həsənov','m1'),
('İsmayıl','Süleymanlı','m2'),
('Toğrul','Eminov','m3'),
('Ayxan','Nagiyev','m1'),
('Samir','Bayramov','m2'),
('Emil','Quluzade','m3');