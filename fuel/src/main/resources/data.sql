insert into tank (id, fuel, tax, unit_price) values (0, 'DIESEL', 13.0, 5.89);
insert into tank (id, fuel, tax, unit_price) values (1, 'GASOLINA', 13.0, 5.37);
							 
insert into pump (id, name, tank_id) values (1, 'BOMBA_01', 0);
insert into pump (id, name, tank_id) values (2, 'BOMBA_02', 0);
insert into pump (id, name, tank_id) values (3, 'BOMBA_03', 1);
insert into pump (id, name, tank_id) values (4, 'BOMBA_04', 1);

insert into fueling (quantity, pump_id, date) values (11.11, 1, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (22.22, 1, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (33.33, 2, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (44.44, 2, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (55.55, 3, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (66.66, 3, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (77.77, 4, '2022-09-17T00:00:00');
insert into fueling (quantity, pump_id, date) values (88.88, 4, '2022-10-09T00:00:00');
insert into fueling (quantity, pump_id, date) values (11.11, 1, '2022-09-18T00:00:00');
insert into fueling (quantity, pump_id, date) values (22.22, 1, '2022-09-19T00:00:00');
insert into fueling (quantity, pump_id, date) values (33.33, 2, '2022-09-20T00:00:00');
insert into fueling (quantity, pump_id, date) values (44.44, 2, '2022-09-21T00:00:00');
insert into fueling (quantity, pump_id, date) values (55.55, 3, '2022-10-03T00:00:00');
insert into fueling (quantity, pump_id, date) values (66.66, 3, '2022-10-04T00:00:00');
insert into fueling (quantity, pump_id, date) values (77.77, 4, '2022-10-05T00:00:00');
insert into fueling (quantity, pump_id, date) values (88.88, 4, '2022-10-06T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 1, '2023-11-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 1, '2022-10-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 2, '2022-10-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 2, '2022-10-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 3, '2023-11-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 3, '2022-10-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 4, '2022-10-01T00:00:00');
insert into fueling (quantity, pump_id, date) values (10.00, 4, '2022-10-01T00:00:00');



