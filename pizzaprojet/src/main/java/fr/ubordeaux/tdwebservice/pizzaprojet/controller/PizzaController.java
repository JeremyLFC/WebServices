package fr.ubordeaux.tdwebservice.pizzaprojet.controller;

import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Ingredient;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Pizza;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Step;
import fr.ubordeaux.tdwebservice.pizzaprojet.service.impl.PizzaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    PizzaServiceImpl pizzaService;

    @RequestMapping("/submitpizza")
    public String pizzaController(){
        return "submitpizza";
    }


    /**
     * @param param the String that recieve from the front end which will be parse into a object {@code Pizza}
     * @return {@code true} if the {@code String} is saved in the file json
     */
    @RequestMapping("/testsavepizza")
    @ResponseBody
    public String testSaveController(@RequestBody String param) throws IOException {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        ingredientList.add(new Ingredient("Onion", 3, "Unit"));
        ingredientList.add(new Ingredient("Lardon", 300, "g"));
        List<Step> listSteps = new ArrayList<Step>();
        listSteps.add(new Step(1, "Etap 1"));
        listSteps.add(new Step(2, "Etap 2"));
        Pizza pizza = new Pizza(ingredientList, "Margherita ", listSteps);
//        Pizza pizza = JSON.parseObject(param, Pizza.class);
        pizzaService.saveRecette(pizza);
        return "success";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/getAllPizzaRecette")
    @ResponseBody
    public String getAllPizzaRecette(){
        return pizzaService.getAllRecette();
    }


}
