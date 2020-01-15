package models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Sighting {
    private int animal_id;
    private String location;
    private String ranger_id;

    public Sighting(int animal_id, String location, String ranger_id){
        this.animal_id = animal_id;
        this.location = location;
        this.ranger_id = ranger_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public void setranger_id(String ranger_id) {
        this.ranger_id = ranger_id;
    }
}
