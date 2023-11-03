insert into tank (id, name, fuel, tax, unit_price) values (0, 'TANQUE_01', 'DIESEL', 13.0, 5.89);
insert into tank (id, name, fuel, tax, unit_price) values (1, 'TANQUE_02', 'GASOLINA', 13.0, 5.37);
							 
insert into pump (id, name, tank_id) values (0, 'BOMBA_01', 0);
insert into pump (id, name, tank_id) values (1, 'BOMBA_02', 0);
insert into pump (id, name, tank_id) values (2, 'BOMBA_03', 1);
insert into pump (id, name, tank_id) values (3, 'BOMBA_04', 1);

insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (11.11, 65.4379,  8.506927,  0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (22.22, 119.3214, 15.511782, 1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (33.33, 196.3137, 25.520781, 2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (44.44, 238.6428, 31.023564, 3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (55.55, 327.1895, 42.534635, 0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (66.66, 357.9642, 46.535346, 1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (77.77, 458.0653, 59.548489, 2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (88.88, 477.2856, 62.047128, 3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (11.11, 65.4379,  8.506927,  0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (22.22, 119.3214, 15.511782, 1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (33.33, 196.3137, 25.520781, 2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (44.44, 238.6428, 31.023564, 3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (55.55, 327.1895, 42.534635, 0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (66.66, 357.9642, 46.535346, 1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (77.77, 458.0653, 59.548489, 2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (88.88, 477.2856, 62.047128, 3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  3, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  0, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  1, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 58.9000,  7.657000,  2, '2023-10-02T00:00:00');
insert into fueling (quantity, amount, taxation, pump_id, date) values (10.00, 53.7000,  6.981000,  3, '2023-10-02T00:00:00');


--int counter = 0;
--for(FuelingDTO f : resp) {
--	Integer pump_id = (counter++) % 4;
--	Tank tank = tankService.findById(Long.valueOf(pump_id) % 2);
--	BigDecimal amount = f.quantity().multiply(tank.getUnitPrice());
--	BigDecimal taxation = tank.getTax().multiply(amount).divide(BigDecimal.valueOf(100));
--	String query = "insert into fueling (quantity, amount, taxation, pump_id, date) values (__QUANTITY__, __AMOUNT__, __TAXATION__, __PUMP_ID__, '2023-10-02T00:00:00');";
--	query = query.replace("__QUANTITY__", f.quantity().toString() );
--	query = query.replace("__AMOUNT__", amount.toString());
--	query = query.replace("__TAXATION__", taxation.toString() );
--	query = query.replace("__PUMP_ID__", pump_id.toString() );
--	System.out.println(query);	
--}
