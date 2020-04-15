package fr.ubordeaux.tdwebservice.pizzaprojet.service;

import fr.ubordeaux.tdwebservice.pizzaprojet.entity.Pizza;

import java.io.IOException;

public interface PizzaService {
    void saveRecette(Pizza pizza) throws IOException;
    String getAllRecette();

}
