import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Thiloshon on 12-Nov-16.
 *
 * The CarParkManager which implements the CarParkManager Interface
 */
public class WestminsterCarParkManager implements CarParkManager {

    private ArrayList<Vehicle> vehicleArray = new ArrayList<>();
    private int spaceLeft = 20; // The capacity of the Vehicle Park
    private Scanner sc = new Scanner(System.in);


    /**
     * method to add vehicle
     * Gets the type of vehicle and creates vehicles instances accordingly.
     */
    @Override
    public void addVehicle() {
        if (spaceLeft > 0) { // space should be greater than 0 for all vehicles
            System.out.println("Which type would you like to add? ( V / C / B )");
            sc.nextLine();
            String type = sc.nextLine();
            type = type.toUpperCase();

            System.out.println("ID Plate Number:");
            String idPlate = sc.nextLine();

            System.out.println("Brand Please:");
            String brand = sc.nextLine();

            System.out.println("Date: (YYYY MM DD)");
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(year + " " + month + " " + day);

            System.out.println("Time: (HH MM)");
            int hour = sc.nextInt();
            int min = sc.nextInt();
            DateTime date = null;
            try {
                date = new DateTime(day, hour, min, month, year);
            } catch (Exception e) {
                e.printStackTrace();
                addVehicle();
            }

            switch (type) {
                case "V": { // Van centric inputs
                    if (spaceLeft > 1) { // space should be greater than 1 for vans
                        System.out.println("Cargo Volume:");
                        int cargoVolume = sc.nextInt();
                        vehicleArray.add(new Van(cargoVolume, idPlate, brand, date));
                        spaceLeft -= 2;
                    } else {
                        System.out.println("No Space Left");
                    }

                }
                break;
                case "C": { // Car centric inputs
                    System.out.println("Number of Doors:");
                    int numberOfDoors = sc.nextInt();
                    System.out.println("Color:");
                    String color = sc.nextLine();
                    vehicleArray.add(new Car(color, numberOfDoors, idPlate, brand, date));
                    spaceLeft--;

                }
                break;
                case "B": { // Bike centric inputs
                    System.out.println("Engine Size:");
                    int engineSize = sc.nextInt();
                    vehicleArray.add(new Motorbike(engineSize, idPlate, brand, date));
                    spaceLeft--;
                }
                break;
            }
        } else {
            System.out.println("No Space Left");
        }

        start();
    }


    /**
     * method to delete vehicle
     */
    @Override
    public void deleteVehicle() {
        System.out.println("Type the ID Plate Number");
        sc.nextLine();
        String idPlate = sc.nextLine();

        Iterator iterator = vehicleArray.iterator();

        while (iterator.hasNext()) {
            Vehicle element = (Vehicle) iterator.next();
            if (element.getiDPlate().equalsIgnoreCase(idPlate)) {
                vehicleArray.remove(element);
                System.out.println("Removed");
                break;
            }
        }
        start();

    }


    /**
     * method to print list of vehicles
     */
    @Override
    public void printList() {
        for (int x = vehicleArray.size() - 1; x >= 0; x--) {
            System.out.println(vehicleArray.get(x).getiDPlate());
            System.out.println(vehicleArray.get(x).getDate().year + " " + vehicleArray.get(x).getDate().month + " " + vehicleArray.get(x).getDate().day + " " + vehicleArray.get(x).getDate().hour + " " + vehicleArray.get(x).getDate().minute);
            System.out.println(vehicleArray.get(x).getClass().toString().split(" ")[1]);
        }
        start();
    }


    /**
     * method to print several statistics of the vehicles
     */
    @Override
    public void printStatistics() {
        int carCount = 0;
        int vanCount = 0;
        int bikeCount = 0;

        for (int x = 0; x < vehicleArray.size(); x++) {
            if (vehicleArray.get(x).getClass() == Car.class) {
                carCount++;
            } else if (vehicleArray.get(x).getClass() == Van.class) {
                vanCount++;
            } else if (vehicleArray.get(x).getClass() == Motorbike.class) {
                bikeCount++;
            }
        }

        System.out.println("Percentages of vehicles parked:");
        System.out.println("Car: " + (carCount / (double) vehicleArray.size()) * 100);
        System.out.println("Van: " + (vanCount / (double) vehicleArray.size()) * 100);
        System.out.println("Motorbike: " + (bikeCount / (double) vehicleArray.size()) * 100);

        System.out.println("Vehicle parked for long: ");
        System.out.println(vehicleArray.get(0).getiDPlate());

        System.out.println("Vehicle parked last: ");
        System.out.println(vehicleArray.get(vehicleArray.size() - 1).getiDPlate());

        start();
    }


    /**
     * method to return data related to a specific date
     */
    @Override
    public void dateQuery() {
        System.out.println("Date: (YYYY MM DD)");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        boolean check = false;

        for (Vehicle vehicle : vehicleArray) {
            if (vehicle.date.year == year && vehicle.date.month == month && vehicle.date.day == day) {
                System.out.println(vehicle.getiDPlate());
                check = true;
            }
        }

        if (!check) {
            System.out.println("No Vehicles Found");
        }
        start();
    }


    /**
     * method to calculate the final charges
     */
    @Override
    public void calculatePrice() {

        System.out.println("Current Date: (YYYY MM DD)");
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println("Current Time: (HH MM)");
        int hour = sc.nextInt();
        int min = sc.nextInt();

        DateTime date = null;
        try {
            date = new DateTime(day, hour, min, month, year);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Vehicle vehicle : vehicleArray) {
            int[] ans = vehicle.date.difference(date);

            int amount = ans[0] * 30;
            if (ans[1] > 3) {
                amount += (9 + ans[1] - 3);
            } else {
                amount += (ans[1] * 3);
            }

            System.out.println(vehicle.getiDPlate() + " " + amount);
        }

        start();
    }


    /**
     * The First output. Welcome page.
     */
    public void welcomePage() {

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- WESTMINSTER CAR PARK MANAGER ---------------------- WESTMINSTER CAR PARK MANAGER ---------------------- WESTMINSTER CAR PARK MANAGER -------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                  WELCOME TO THE WESTMINSTER CAR PARK MANAGER");
        System.out.println("");

    }


    /**
     * The First Menu. Other methods calls this method often since this is the primary menu.
     */
    public void start() {

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1 Add New Vehicle");
        System.out.println("2 Delete Vehicle");
        System.out.println("3 Print Vehicle List");
        System.out.println("4 Print Statistics");
        System.out.println("5 Find Vehicles by Date");
        System.out.println("6 Print Charges");
        System.out.println("");

        int option;

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Please Choose Numeral Between 1 to 6:");
                sc.next();
            }
            option = sc.nextInt();

            if (!(option >= 1 && option <= 6)) {
                System.out.println("Please Choose Your Option Between 1 to 6:");
            }
        } while (option < 1 || option > 6);

        switch (option) {
            case 1:
                addVehicle();
                break;
            case 2:
                deleteVehicle();
                break;
            case 3:
                printList();
                break;
            case 4:
                printStatistics();
                break;
            case 5:
                dateQuery();
                break;
            case 6:
                calculatePrice();
                break;
        }
    }

}
