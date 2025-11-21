import java.util.ArrayList;
import java.util.List;

public class menu {
    private String name;
    private List<recipe> recipes;

    public menu(String name) {
        this.name = name;
        this.recipes = new ArrayList<>();
    }

    public String getname() {
        return name;
    }

    public void addRecipe(recipe recipe) {
        if (recipe != null && !recipes.contains(recipe)) {
            recipes.add(recipe);
        }
    }

    public List<recipe> getRecipes() {
        return new ArrayList<>(recipes);
    }

    public double getTotalPrice() {
        double sum = 0;
        for (recipe r : recipes) {
            sum += r.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("menu: " + name + " (total price: " + getTotalPrice() + " kr)\n");
        for (recipe r : recipes) {
            sb.append("  - ").append(r).append("\n");
        }
        return sb.toString();
    }
}
