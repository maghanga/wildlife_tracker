package dao;

import models.EndangeredAnimal;

import java.util.List;

public interface EndangeredAnimalDao {


    List<EndangeredAnimal> getAll();

    EndangeredAnimal findById(int id);
}

