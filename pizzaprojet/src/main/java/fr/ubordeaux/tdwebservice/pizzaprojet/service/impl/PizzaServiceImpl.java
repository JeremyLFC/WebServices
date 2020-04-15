package fr.ubordeaux.tdwebservice.pizzaprojet.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Pizza;
import fr.ubordeaux.tdwebservice.pizzaprojet.service.PizzaService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class PizzaServiceImpl implements PizzaService {

    /**
     * This is the path that file pizzarecette.json will be saved.{@value}
     */
    private final String destPath = this.getClass().getResource("/META-INF/resources/static/").getPath();

    /**
     * This is the methode that will write a new pizza to the file pizzarecette.json
     * @param pizza this is the object that recieve from front and be parsed
     * @throws IOException IoException when the configuration of the build path is changed
     */
    @Override
    public void saveRecette(Pizza pizza) throws IOException {
        BufferedWriter writer = null;
        String dataRead = this.getAllRecette();
        JSONArray listPizza;
        if (!dataRead.isEmpty()) {
            listPizza = JSON.parseArray(this.getAllRecette());
        } else {
            listPizza = new JSONArray();
        }
        //Mettre un object dans jsonObject

        System.out.println(listPizza.toString());
        listPizza.add(pizza);

        //Ecrire json string dans dossier
        File file = new File(destPath + "pizzarecette.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8));
            writer.write(listPizza.toJSONString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            System.out.println("Write successfully!");
        }
    }


    /**
     * This is the methode that read all the data in the file pizzarecette.json
     * @return {@code String} is not null, or {@code ""} if it is null;
     */
    @Override
    public String getAllRecette() {
        BufferedReader reader = null;
        File file = new File(destPath + "pizzarecette.json");
        String laststr = "";
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return laststr;
    }
}
