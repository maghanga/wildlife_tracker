package dao;
import models.Animal;
import models.Sighting;

import java.util.List;

public interface AnimalDao {
    List<Animal> getAll();

    Animal findById(int id);

    void endanger(int animal_id, String animal_health, String animal_age);
}
