package dao;

import models.EndangeredAnimal;
import org.sql2o.*;
import java.util.List;

public class Sql2oEndangeredAnimalDao implements EndangeredAnimalDao{

    private final Sql2o sql2o;

    public Sql2oEndangeredAnimalDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public List<EndangeredAnimal> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animals")
                    .throwOnMappingFailure(false).executeAndFetch(EndangeredAnimal.class);
        }
    }

    @Override
    public EndangeredAnimal findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered_animals WHERE id = :id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }

    }
}