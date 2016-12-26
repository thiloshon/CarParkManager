/**
 * Created by Thiloshon on 12-Nov-16.
 *
 * Car modal class
 */
public class Car extends Vehicle {
    private int numberOfDoors;
    private String color;

    public Car(String color, int numberOfDoors, String idPlate, String brand, DateTime date) {
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.iDPlate = idPlate;
        this.brand = brand;
        this.date = date;
    }
}
