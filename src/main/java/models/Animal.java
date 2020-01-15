package models;

public abstract class Animal {
    private int id;
    private String animal_name;

    public Animal(String animal_name){
        this.animal_name = animal_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

}
