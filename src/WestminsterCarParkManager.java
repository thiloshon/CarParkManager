import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Thiloshon on 12-Nov-16.
 */
public class WestminsterCarParkManager implements CarParkManager {

    ArrayList<Vehicle> vehicleArray = new ArrayList<>();
    int spaceLeft = 20;
    Scanner sc = new Scanner(System.in);


    @Override
    public void addVehicle() {
        if (spaceLeft > 0) {
            System.out.println("Which type would you like to add? ( V / C / B )");
            String type = sc.nextLine();
            type.toUpperCase();

            System.out.println("ID Plate Number:");
            String idPlate = sc.nextLine();
            System.out.println("Brand Please:");
            String brand = sc.nextLine();


            switch (type) {
                case "V": {
                    if (spaceLeft > 1) {
                        System.out.println("Cargo Volume:");
                        int cargoVolume = sc.nextInt();
                        vehicleArray.add(new Van(cargoVolume, idPlate, brand));
                        spaceLeft -= 2;
                    } else {
                        System.out.println("No Space Left");
                    }

                }
                break;
                case "C": {
                    System.out.println("Number of Doors:");
                    int numberOfDoors = sc.nextInt();
                    System.out.println("Color:");
                    String color = sc.nextLine();
                    vehicleArray.add(new Car(color, numberOfDoors, idPlate, brand));
                    spaceLeft--;

                }
                break;
                case "B": {
                    System.out.println("Engine Size:");
                    int engineSize = sc.nextInt();
                    vehicleArray.add(new Motorbike(engineSize, idPlate, brand));
                    spaceLeft--;
                }
                break;
            }
        } else {
            System.out.println("No Space Left");
        }
    }


    @Override
    public void deleteVehicle() {
        System.out.println("Type the ID Plate Number");
        String idPlate = sc.nextLine();

        Iterator iterator = vehicleArray.iterator();

        while (iterator.hasNext()) {
            Vehicle element = (Vehicle) iterator.next();
            if (element.getiDPlate().equalsIgnoreCase(idPlate)) {
                vehicleArray.remove(element);
                System.out.println("Removed");
                break;
            }
            System.out.println("Not Found");
        }

    }

    @Override
    public void printList() {
        for (int x = vehicleArray.size(); x >= 0; x--) {
            System.out.println(vehicleArray.get(x).getiDPlate());
            System.out.println(vehicleArray.get(x).getDate());
            System.out.println(vehicleArray.get(x).getClass());
        }
    }

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
        System.out.println("Car: " + (carCount / vehicleArray.size()) * 100);
        System.out.println("Van: " + (vanCount / vehicleArray.size()) * 100);
        System.out.println("Motorbike: " + (bikeCount / vehicleArray.size()) * 100);

        System.out.println("Vehicle parked for long: ");
        System.out.println(vehicleArray.get(0).getiDPlate());

        System.out.println("Vehicle parked last: ");
        System.out.println(vehicleArray.get(vehicleArray.size() - 1).getiDPlate());

    }

    @Override
    public void dateQuery() {

    }

    @Override
    public void calculatePrice() {

    }
}
