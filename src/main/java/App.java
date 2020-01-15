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
        String connectionString = "jdbc:h2:~/wildlife_tracker.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "thomas", "likewater");
        Sql2oAnimalDao animalDao= new Sql2oAnimalDao(sql2o);
        Sql2oEndangeredAnimalDao endangeredDao= new Sql2oEndangeredAnimalDao(sql2o);
        Sql2oSightingDao sightingDao=new Sql2oSightingDao(sql2o);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = animalDao.getAll();
            model.put("animals", animals);
            return new ModelAndView(model, "index.hbs");
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

        get("/sightings/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sighting = sightingDao.getAll();
            List<Animal> animal = animalDao.getAll();
            model.put("sighting", sighting);
            model.put("animal", animal);
            return new ModelAndView(model, "sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/add/:animal_id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sighting = sightingDao.getAll();
            List<Animal> animal = animalDao.getAll();
            model.put("sighting", sighting);
            model.put("animal", animal);
            return new ModelAndView(model, "endangered.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int animal_id = Integer.valueOf(req.queryParams("animal_id"));
            String name = (animalDao.findById(animal_id)).getAnimal_name();
            String age =  req.queryParams("age");
            String health = req.queryParams("health");
            System.out.println(req.queryParams("animal_id"));
            System.out.println(animal_id);
            animalDao.endanger(animal_id,health,age);
            res.redirect("/sightings");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/sightings", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int animal_id = Integer.valueOf(req.queryParams("animal_id"));
            String ranger_name =  req.queryParams("ranger_name");
            String location = req.queryParams("location");
            System.out.println(req.queryParams("animal_id"));
            System.out.println(animal_id);
            Sighting newSighting = new Sighting(animal_id,location,ranger_name);
            sightingDao.add(newSighting);
            res.redirect("/sightings");
            return null;
        }, new HandlebarsTemplateEngine());
    }


}