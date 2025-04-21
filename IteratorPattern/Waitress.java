// Notice that the menus now are well encapsulated. Before, the waitress was aware that diner menu was an array, and that
// pancake menu was a list. Now it doesn't matter. It just knows to call createIterator() to handle everything.
public class Waitress {
    MenuComponent allMenus;

    // Hand her the top level menu component which contains all other menus.
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    // Printing is handled by the menu component.
    public void printMenu() {
        allMenus.print();
    }
}






// public class Waitress {
//     // Change it to host a list of menus.
//     // Menu pancakeHouseMenu;
//     // Menu dinerMenu;
//     // Menu cafeMenu;
//     List<Menu> menus;

//     // The waitress takes the two menus.

//     public Waitress(List<Menu> menus) { // Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu
//         // We're still dependent on concrete classes, even though they have the same methods. We should code to an interface.
//         // We've replaced the concrete classes with an interface.
//         // this.pancakeHouseMenu = pancakeHouseMenu;
//         // this.dinerMenu = dinerMenu;
//         // this.cafeMenu = cafeMenu;
//         this.menus = menus;
//     }

//     // Nothing else changes.
//     public void printMenu() {
//         // The print method now creates two iterators.
//         // Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
//         // Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
//         // Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

//         // System.out.println("MENU\n" + "----\n" +"BREAKFAST");
//         // printMenu(pancakeIterator);
//         // System.out.println("\n" + "LUNCH");
//         // printMenu(dinerIterator);
//         // System.out.println("\n" + "DINNER");
//         // printMenu(cafeIterator);

//         // Now just iterate over all the menus instead of seperately doing it.
//         Iterator<Menu> menuIterator = menus.iterator();
//         while (menuIterator.hasNext()) {
//             Menu menu = menuIterator.next();
//             // Every implementation of the interface has its own createIterator() method.
//             printMenu(menu.createIterator());
//         }

//     }


//     // Notice we boil it down only to one loop for a method that takes in an iterator. The waitress doesn't care about 
//     // the type of menu or the type of collection used. She just knows how to iterate over the menu items. The actual logic
//     // is handled by the iterator.
//     private void printMenu(Iterator iterator) {
//         while (iterator.hasNext()) {
//             MenuItem menuItem = (MenuItem) iterator.next();
//             System.out.print(menuItem.getName() + ", ");
//             System.out.print(menuItem.getPrice() + " -- ");
//             System.out.println(menuItem.getDescription());
//         }
//     }
// }
