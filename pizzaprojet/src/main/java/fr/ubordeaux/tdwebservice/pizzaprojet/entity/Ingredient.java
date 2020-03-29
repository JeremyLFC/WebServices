package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

public class Ingredient {
    String nameIngredient;
    String quantityIngredient;

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public String getQuantityIngredient() {
        return quantityIngredient;
    }

    public void setQuantityIngredient(String quantityIngredient) {
        this.quantityIngredient = quantityIngredient;
    }

    public Ingredient(String nameIngredient, String quantityIngredient) {
        this.nameIngredient = nameIngredient;
        this.quantityIngredient = quantityIngredient;
    }
}
