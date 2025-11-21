public class testClient {
    public static void main(String[] args) {
        menuRegistration register = new menuRegistration();

        // Register a few recipes
        recipe r1 = new recipe("Bruschetta", "forrett", 89.0);
        recipe r2 = new recipe("Biff", "hovedrett", 249.0);
        recipe r3 = new recipe("Iskrem", "dessert", 79.0);

        register.registerRecipe(r1);
        register.registerRecipe(r2);
        register.registerRecipe(r3);

        // Make a menu
        menu weekendMenu = new menu("Helgemeny");
        weekendMenu.addRecipe(r1);
        weekendMenu.addRecipe(r2);
        weekendMenu.addRecipe(r3);

        register.registerMenu(weekendMenu);

        // Test: find recipe
        System.out.println("Finner rett 'Biff': " + register.findRecipe("Biff"));

        // Test: find all "hovedretter"
        System.out.println("\nHovedretter:");
        for (recipe r : register.findRecipesByType("hovedrett")) {
            System.out.println("  " + r);
        }

        // Test: find menus in a given interval
        System.out.println("\nMenuer med totalpris mellom 300 og 500:");
        for (menu m : register.findMenusByPriceInterval(300, 500)) {
            System.out.println(m);
        }
    }
}
