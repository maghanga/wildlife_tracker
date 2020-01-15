package models;

public class EndangeredAnimal extends Animal {

    private String animal_health;
    private String animal_age;

    public EndangeredAnimal(int id, String name, String animal_age, String animal_health){
        this.id = id;
        this.name = name;
        this.animal_health = animal_health;
        this.animal_age = animal_age;
    }

    public String getAnimal_health() {
        return animal_health;
    }

    public String getAnimal_age() {
        return animal_age;
    }

    public void setAnimal_age(String animal_age) {
        this.animal_age = animal_age;
    }
}
