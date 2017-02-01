use carsharet;

set FOREIGN_KEY_CHECKS = 0;
truncate table cities;
truncate table cars;
truncate table drivers;
truncate table passengers;
truncate table trips;


set FOREIGN_KEY_CHECKS = 1;

insert into cities (name,state,dayrate,nightrate) values
  ('Pune','Maharashtra',25,30),
  ('Bangalore','Karnataka',30,35),
  ('Mumbai','Maharashtra',40,45);

insert into drivers (name,age,gender,licenseno) values
  ('Lucie', 25, 'FEMALE', 'KA1100'),
  ('Jason', 45, 'MALE', 'KA1212');


insert into cars (make,model,year,carno,type,lux_charge,driver_id) values
  ('Honda','City',2015,'KA015539','LUX',5,1);

insert into cars (make,model,year,carno,type,driver_id) values
  ('Honda','Amaze',2017,'KA01111','BASIC',1),
  ('Maruti','800',1995,'KA03007','BASIC',2);


insert into passengers (name,age,gender,credit_balance) values
  ('Chyld', 55, 'MALE', 2000),
  ('Nathan', 30, 'MALE', 4000);

insert into trips (cost,  is_day, distance, duration,  start_time, stop_time, tip, total_cost, passenger_id,car_id) VALUES
  (1181,true,15,45,'08:15:00','09:00:00',10,1300,1,1),
  (630,false,5,20,'08:15:00','08:35:00',0,630,1,1),
  (1125,true,8,45,'08:15:00','09:00:00',10,1237.5,2,3);
