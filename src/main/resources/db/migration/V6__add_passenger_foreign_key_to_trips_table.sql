ALTER TABLE trips ADD passenger_id INT NOT NULL;
ALTER TABLE trips ADD CONSTRAINT fk_passenger_id FOREIGN KEY (passenger_id) REFERENCES passengers(id);