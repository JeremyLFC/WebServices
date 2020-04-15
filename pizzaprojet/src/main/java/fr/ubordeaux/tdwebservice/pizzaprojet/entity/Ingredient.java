package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    String nameIngredient;
    double quantityIngredient;
    String unitOfMesure;
}
