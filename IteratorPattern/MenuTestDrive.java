
import java.util.List;

public class MenuTestDrive {
    public static void main(String[] args) {
        // Note that we have already added menu items to the menu in the constructor.
        // Menu pancakeHouseMenu = new PancakeHouseMenu();
        // Menu dinerMenu = new DinerMenu();
        // Menu cafeMenu = new CafeMenu();
        // List<Menu> menus = List.of(pancakeHouseMenu, dinerMenu, cafeMenu);

        // We use the composite pattern we coded.
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert!");
        // Did not add menu items. Should do it here, instead of initializing it during the construction like before.
        // Our root menu.
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus put together");
        
        // adding all items.
        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                    true, 3.89));
        
        dessertMenu.add(new MenuItem(
            "Apple Pie", "Apple pie with a flakey crust, topped with vanilla ice cream", 
            true,
            1.59));
             
        // Add desserts to the diner menu.
        dinerMenu.add(dessertMenu);
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // Create a waitress and pass her the menus.
        Waitress waitress = new Waitress(allMenus);


        // Print the menus without knowing the details of the menus or the menu items.
        waitress.printMenu();

    }
}
