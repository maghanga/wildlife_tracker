package models;
import java.time.LocalDateTime;
import java.util.Objects;

public class Sighting {
    private int id;
    private String sight_location;
    private String ranger_name;
    private LocalDateTime sight_time;

    public Sighting(String sight_location, String ranger_name){
        this.sight_location = sight_location;
        this.ranger_name = ranger_name;
        this.sight_time = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSight_location() {
        return sight_location;
    }

    public void setSight_location(String sight_location) {
        this.sight_location = sight_location;
    }

    public String getRanger_name() {
        return ranger_name;
    }

    public void setRanger_name(String ranger_name) {
        this.ranger_name = ranger_name;
    }

    public LocalDateTime getSight_time() {
        return sight_time;
    }

    public void setSight_time(LocalDateTime sight_time) {
        this.sight_time = sight_time;
    }
}
