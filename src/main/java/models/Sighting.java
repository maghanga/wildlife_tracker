package models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Sighting {
    private int animal_id;
    private String sight_location;
    private String ranger_name;

    public Sighting(int animal_id, String sight_location, String ranger_name){
        this.animal_id = animal_id;
        this.sight_location = sight_location;
        this.ranger_name = ranger_name;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public void setSight_location(String sight_location) {
        this.sight_location = sight_location;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }
}
