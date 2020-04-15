package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pizza {
    private List<Ingredient> ingredientList;
    private String namePizza;
    private String descriptionPizza;
    private List<String> listSteps;
}
