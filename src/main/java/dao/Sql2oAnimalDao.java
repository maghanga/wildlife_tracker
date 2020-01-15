package dao;
import  models.Animal;
import org.sql2o.*;
import java.util.List;

public class Sql2oAnimalDao implements AnimalDao {
    private final Sql2o sql2o;

    public Sql2oAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Animal> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);
        }
    }

    @Override
    public Animal findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animal.class);
        }

    }

    @Override
    public void endanger(int animal_id, String animal_health, String animal_age) {
        String sql = "INSERT INTO endangered_animals (animal_id,animal_health,animal_age) VALUES (:animal_id,:animal_health,:animal_age)";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("animal_id", animal_id)
                    .addParameter("animal_health", animal_health)
                    .addParameter("animal_age", animal_age)
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}