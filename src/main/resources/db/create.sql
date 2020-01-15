SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (id serial PRIMARY KEY, name varchar);
CREATE TABLE IF NOT EXISTS sightings (animal_id INTEGER, location varchar,ranger_name varchar);
CREATE TABLE IF NOT EXISTS endangered_animals (id serial PRIMARY KEY, name varchar,animal_health varchar, animal_age integer);
