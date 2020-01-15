SET MODE PostgreSQL;

create table if not exists animals (id serial PRIMARY KEY, name varchar);
create table if not exists sightings (animal_id INTEGER, location varchar,ranger_id INTEGER);
create table if not exists endangered (id serial PRIMARY KEY, name varchar,health varchar, age integer);
