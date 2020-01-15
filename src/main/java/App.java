import dao.*;
import models.Animal;
import models.EndangeredAnimal;
import models.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
        Sql2o sql2o = new Sql2o(connectionString, "thomas", "likewater");
        Sql2oAnimalDao animalDao= new Sql2oAnimalDao(sql2o);
        Sql2oEndangeredAnimalDao endangeredDao= new Sql2oEndangeredAnimalDao(sql2o);
        Sql2oSightingDao sightingDao=new Sql2oSightingDao(sql2o);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = animalDao.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = animalDao.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = sightingDao.getAll();
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> endangered = endangeredDao.getAll();
            model.put("endangered", endangered);
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());


    }


}