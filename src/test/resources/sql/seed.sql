use carsharet;

set FOREIGN_KEY_CHECKS = 0;
truncate table cities;
truncate table cars;
truncate table drivers;
truncate table passengers;

set FOREIGN_KEY_CHECKS = 1;

insert into cities (name,state,dayrate,nightrate) values
  ('Pune','Maharashtra',25,30),
  ('Bangalore','Karnataka',30,35),
  ('Mumbai','Maharashtra',40,45);


insert into cars (make,model,year,carno,type,lux_charge) values
  ('Honda','City',2015,'KA015539','LUX',5);

insert into cars (make,model,year,carno,type) values
  ('Honda','Amaze',2017,'KA01111','BASIC'),
  ('Maruti','800',1995,'KA03007','BASIC');



  insert into drivers (name,age,gender,licenseno) values
  ('Lucie', 25, 'FEMALE', 'KA1100');

insert into passengers (name,age,gender,credit_balance) values
  ('Chyld', 55, 'MALE', 2000);
