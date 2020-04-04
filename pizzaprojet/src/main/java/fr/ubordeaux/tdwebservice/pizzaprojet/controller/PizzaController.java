package fr.ubordeaux.tdwebservice.pizzaprojet.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Ingredient;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Pizza;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
    @RequestMapping("/submitpizza")
    public String pizzaController(){
        return "submitpizza";
    }

    @SuppressWarnings("finally")
	@RequestMapping("/testsavepizza")
    public String testSaveController(HttpRequest request) throws IOException {
        List<Ingredient> ingredientList = new ArrayList<Ingredient>();
        ingredientList.add(new Ingredient("Onion","3 "));
        ingredientList.add(new Ingredient("Lardon","300g"));
        Pizza pizza = new Pizza(ingredientList,"Margherita ");

        //Pizza pizza1 = JSON.parseObject(request.get, Pizza.class);

        //Mettre un object dans jsonObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Data", pizza);

        //Ecrire json string dans dossier
        String destDir = "D:\\";
        File dir = new File(destDir);
        File file = new File(destDir + "pizzarecette.json");
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false),"UTF-8"));
            writer.write(jsonObject.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            return "testSuccess";
        }
    }
}
