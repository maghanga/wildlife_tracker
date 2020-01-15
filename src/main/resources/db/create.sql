SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (id serial PRIMARY KEY, animal_name varchar);
CREATE TABLE IF NOT EXISTS sightings (animal_id INTEGER, sight_location varchar,ranger_id INTEGER);
CREATE TABLE IF NOT EXISTS endangered_animals (id serial PRIMARY KEY, animal_name varchar,animal_health varchar, animal_age integer);
