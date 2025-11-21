import java.util.ArrayList;
import java.util.List;

public class menuRegistration {
    private List<recipe> recipes;
    private List<menu> menus;

    public menuRegistration() {
        recipes = new ArrayList<>();
        menus = new ArrayList<>();
    }

    // Register a new recipe.
    public void registerRecipe(recipe recipe) {
        if (recipe != null && findRecipe(recipe.getName()) == null) {
            recipes.add(recipe);
        }
    }

    // Find a recipe, given its name.
    public recipe findRecipe(String name) {
        for (recipe r : recipes) {
            if (r.getName().equalsIgnoreCase(name)) {
                return r;
            }
        }
        return null;
    }

    //Find all recipes of a given type.
    public List<recipe> findRecipesByType(String type) {
        List<recipe> resultat = new ArrayList<>();
        for (recipe r : recipes) {
            if (r.getType().equalsIgnoreCase(type)) {
                resultat.add(r);
            }
        }
        return resultat;
    }

    // Register a new menu that contains a sett of recipes.
    public void registerMenu(menu menu) {
        if (menu != null && !menus.contains(menu)) {
            menus.add(menu);
        }
    }

    // Find all menus with totalprice within an intervall.
    public List<menu> findMenusByPriceInterval(double min, double max) {
        List<menu> resultat = new ArrayList<>();
        for (menu m : menus) {
            double total = m.getTotalPrice();
            if (total >= min && total <= max) {
                resultat.add(m);
            }
        }
        return resultat;
    }
}
