/**
 * Created by Thiloshon on 13-Nov-16.
 *
 */

/**
 * The Main Class. Runs the Start Method of Interface
 */

public class Main {
    public static void main(String[] args) {
        WestminsterCarParkManager manager = new WestminsterCarParkManager();
        manager.welcomePage(); // To Print Initial CarParkManager Details
        manager.start(); // The Option Menus
    }
}