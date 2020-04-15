package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Step {
    private int nmStep;
    private String descriptionStep;
}
