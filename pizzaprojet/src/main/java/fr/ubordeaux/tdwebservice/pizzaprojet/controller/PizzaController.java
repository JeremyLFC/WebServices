package fr.ubordeaux.tdwebservice.pizzaprojet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Ingredient;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Pizza;
import fr.ubordeaux.tdwebservice.pizzaprojet.service.impl.PizzaServiceImpl;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
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

	@RequestMapping("/testsavepizza")
    @ResponseBody
    public String testSaveController(@RequestBody String param) throws IOException {
//        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
//        ingredientList.add(new Ingredient("Onion",3, "Unit"));
//        ingredientList.add(new Ingredient("Lardon",300, "g"));
//        List<String> listSteps = new ArrayList<String>();
//        listSteps.add("Etap 1");
//        listSteps.add("Etap 2");
//        Pizza pizza = new Pizza(ingredientList,"Margherita ","this pizza is so dilicious", listSteps);
        Pizza pizza = JSON.parseObject(param, Pizza.class);
        pizzaService.saveRecette(pizza);
        return "success";
    }

    @RequestMapping("/getAllPizzaRecette")
    @ResponseBody
    public String getAllPizzaRecette(){
        return pizzaService.getAllRecette();
    }
}
