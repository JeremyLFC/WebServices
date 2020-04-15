package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

import java.util.List;

public class Pizza {
    private List<Ingredient> ingredientList;
    private String namePizza;
    private List<Step> listSteps;

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

    public List<Step> getListSteps() {
        return listSteps;
    }

    public void setListSteps(List<Step> listSteps) {
        this.listSteps = listSteps;
    }

    public Pizza(List<Ingredient> ingredientList, String namePizza, List<Step> listSteps) {
        this.ingredientList = ingredientList;
        this.namePizza = namePizza;
        this.listSteps = listSteps;
    }
}
