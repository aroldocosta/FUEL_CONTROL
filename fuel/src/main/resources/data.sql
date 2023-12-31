-- Usuarios
insert into users (id, name, login, password, role) 
values ('f8d1e2e0-739a-4af8-b72a-79044ccc03f0', 
	    'Admin', 
	    'admin@fuelcontrol.com', 
	    '$2a$10$xDhFXJM95Ok4W2b9aLpoz.j5MZkml8IRPyshmR9zI9qdpYxV/mifu', 
	    'ADMIN'
);

insert into users (id, name, login, password, role) 
values ('2933d5c4-3b47-4355-acf9-b24e358740d1', 
	    'Operador', 
	    'oper@fuelcontrol.com', 
	    '$2a$10$JFwfkqn3CH3zvuUC4M9VzuVBCpqrnCPE5Hi6JUz1LVeCrBvKlYZNa', 
	    'OPERATOR'
);

-- Tanques
insert into tank (id, name, fuel, tax, unit_price) values (1, 'TANQUE1', 'DIESEL', 13.0, 10.00);
insert into tank (id, name, fuel, tax, unit_price) values (2, 'TANQUE2', 'GASOLINA', 13.0, 5.00);

-- Bombas
insert into pump (id, name, tank_id) values (1, 'BOMBA1', 1);							 
insert into pump (id, name, tank_id) values (2, 'BOMBA2', 1);
insert into pump (id, name, tank_id) values (3, 'BOMBA3', 2);
insert into pump (id, name, tank_id) values (4, 'BOMBA4', 2);

-- Abastecimentos
insert into fueling (quantity, payment, taxation, pump_id, date) values (31, 155, 20.15, 1, '2023-11-02T00:00:00');
insert into fueling (quantity, payment, taxation, pump_id, date) values (22, 110, 14.3,  2, '2023-11-02T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (22, 110, 14.3,  1, '2023-11-02T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (40, 200, 26,    2, '2023-11-02T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (18, 90, 11.7,   1, '2023-11-02T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (30, 150, 19.5,  2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (27, 135, 17.55, 1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (37, 185, 24.05, 2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (13, 65, 8.45,   1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (16, 80, 10.4,   2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (26, 130, 16.9,  1, '2023-11-04T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (26, 130, 16.9,  2, '2023-11-04T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (29, 145, 18.85, 1, '2023-11-04T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (30, 150, 19.5,  2, '2023-11-04T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (50, 250, 32.5,  1, '2023-11-04T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (35, 175, 22.75, 2, '2023-11-05T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (38, 380, 49.4,  3, '2023-11-05T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (37, 370, 48.1,  4, '2023-11-05T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (15, 150, 19.5,  3, '2023-11-05T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (33, 330, 42.9,  4, '2023-11-05T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (13, 130, 16.9,  3, '2023-11-06T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (13, 130, 16.9,  4, '2023-11-06T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (30, 300, 39,    3, '2023-11-06T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (17, 170, 22.1,  4, '2023-11-06T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (38, 380, 49.4,  3, '2023-11-06T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (21, 210, 27.3,  4, '2023-11-07T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (49, 490, 63.7,  3, '2023-11-07T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (20, 200, 26,    4, '2023-11-07T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (16, 160, 20.8,  3, '2023-11-07T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (46, 460, 59.8,  4, '2023-11-07T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (35, 350, 45.5,  3, '2023-11-08T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (23, 230, 29.9,  4, '2023-11-08T00:00:00');

----------------------------------------------------------------------------------------------------------------------

--1-18-8insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (11.11, 65.4379,  8.506927,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (22.22, 119.3214, 15.511782, 2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (33.33, 196.3137, 25.520781, 3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (44.44, 238.6428, 31.023564, 4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (55.55, 327.1895, 42.534635, 1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (66.66, 357.9642, 46.535346, 2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (77.77, 458.0653, 59.548489, 3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (88.88, 477.2856, 62.047128, 4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (11.11, 65.4379,  8.506927,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (22.22, 119.3214, 15.511782, 2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (33.33, 196.3137, 25.520781, 3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (44.44, 238.6428, 31.023564, 4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (55.55, 327.1895, 42.534635, 1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (66.66, 357.9642, 46.535346, 2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (77.77, 458.0653, 59.548489, 3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (88.88, 477.2856, 62.047128, 4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  4, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  1, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  2, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  3, '2023-11-03T00:00:00');
--insert into fueling (quantity, payment, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  4, '2023-11-03T00:00:00');


