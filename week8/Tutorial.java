package week8;

import java.util.*;
public class Tutorial {
    public static void main(String[] args) {
        Ingredient i1 = new Ingredient("Water", "ml");
        Ingredient i2 = new Ingredient("Water2", "ml");
        Ingredient i3 = new Ingredient("Sugar", "ml");
        Ingredient i4 = new Ingredient("Chicken", "kg");
        RecipeComponent rc1 = new RecipeComponent(i1, 11.2);
        RecipeComponent rc2 = new RecipeComponent(i1, 9.2);
        RecipeComponent rc3 = new RecipeComponent(i1, 4.2);
        RecipeComponent rc4 = new RecipeComponent(i2, 4.2);

        RecipeDisplay recipeDisplay = new RecipeSeriousDisplay();
        recipeDisplay.addComponent(rc1);
        recipeDisplay.addComponent(rc2);
        recipeDisplay.addComponent(rc3);
        recipeDisplay.addComponent(rc4);

        recipeDisplay.display();
    }
}

class RecipeDisplay {

    ArrayList<RecipeComponent> components;

    public RecipeDisplay() {

        components = new ArrayList<RecipeComponent>();

    }

    public void addComponent(RecipeComponent rc) {
        components.add(rc);
    }

    public void display() {

        System.out.println("I don't know how to display");

    }

}

class RecipeCasualDisplay extends RecipeDisplay{
    @Override
    public void display() {
        for (RecipeComponent recipeComponent : components){
            System.out.println(recipeComponent);
        }
    }
}


class CompareRecipeDisplay implements Comparator<RecipeComponent>{
    public int compare(RecipeComponent r1, RecipeComponent r2){
        if (r1.amount > r2.amount) {
            return -1;
        }
        if (r1.amount < r2.amount) {
            return 1;
        }
        return 0;
    }
}

class RecipeSeriousDisplay extends RecipeDisplay{
    @Override
    public void display() {
        components.sort(new CompareRecipeDisplay());
        for (RecipeComponent rc : components){
            System.out.println(rc);
        }

//        super.display();
    }
}


class CompareByFirstDigit implements Comparator<RecipeComponent> {
    public int compare(RecipeComponent c1, RecipeComponent c2) {
        String amt1 = Double.toString(c1.amount);
        String amt2 = Double.toString(c2.amount);

        return amt1.compareTo(amt2);
    }
}

class RecipeHackerDisplay extends  RecipeDisplay{
    @Override
    public void display() {
        components.sort(new CompareByFirstDigit());
        for (RecipeComponent rc : components){
            System.out.println(rc);
        }
    }
}

class RecipeComponent{
    Ingredient ing;

    double amount;

    public RecipeComponent(Ingredient ing, double amount) {

        this.ing = ing;

        this.amount = amount;

    }

    public String toString() {

        return (ing.toString() + " - " + amount);

    }
}

class Ingredient {

    String name;

    String measurement;

    public Ingredient(String n, String m) {

        name = n;

        measurement = m;

    }

    public String toString() {

        return String.format("%s %s", name, measurement);

    }

}
