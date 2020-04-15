package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

public class Ingredient {
    String nameIngredient;
    String quantityIngredient;
    String unitOfMesure;

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

    public String getUnitOfMesure() {
        return unitOfMesure;
    }

    public void setUnitOfMesure(String unitOfMesure) {
        this.unitOfMesure = unitOfMesure;
    }

    public Ingredient(String nameIngredient, String quantityIngredient, String unitOfMesure) {
        this.nameIngredient = nameIngredient;
        this.quantityIngredient = quantityIngredient;
        this.unitOfMesure = unitOfMesure;
    }
}
