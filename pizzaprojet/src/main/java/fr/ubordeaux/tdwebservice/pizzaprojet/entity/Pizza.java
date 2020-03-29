package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

import java.util.List;

public class Pizza {
    private List<Ingredient> ingredientList;
    private String namePizza;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getNamePizza() {
        return namePizza;
    }

    public void setNamePizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public Pizza(List<Ingredient> ingredientList, String namePizza) {
        this.ingredientList = ingredientList;
        this.namePizza = namePizza;
    }
}
