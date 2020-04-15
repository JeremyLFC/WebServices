package fr.ubordeaux.tdwebservice.pizzaprojet.entity;

public class Step {
    private int nmStep;
    private String descriptionStep;

    public int getNmStep() {
        return nmStep;
    }

    public void setNmStep(int nmStep) {
        this.nmStep = nmStep;
    }

    public String getDescriptionStep() {
        return descriptionStep;
    }

    public void setDescriptionStep(String descriptionStep) {
        this.descriptionStep = descriptionStep;
    }

    public Step(int nmStep, String descriptionStep) {
        this.nmStep = nmStep;
        this.descriptionStep = descriptionStep;
    }
}
