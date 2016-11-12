/**
 * Created by Thiloshon on 12-Nov-16.
 */
public class Car extends Vehicle {
    int numberOfDoors;
    String color;

    public Car(String color, int numberOfDoors, String idPlate, String brand) {
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.iDPlate = idPlate;
        this.brand = brand;
    }
}
