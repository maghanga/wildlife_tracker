package models;

public abstract class Animal {
    public int id;
    public String animal_name;

    public Animal(){
    }

    public int getId() {
        return id;
    }

    public String getAnimal_name() {
        return animal_name;
    }
}
