/**
 * Created by Thiloshon on 12-Nov-16.
 *
 * Motorbike modal class
 */
public class Motorbike extends Vehicle {
    private int engineSize;

    public Motorbike(int engineSize, String idPlate, String brand, DateTime date) {
        this.engineSize = engineSize;
        this.iDPlate = idPlate;
        this.brand = brand;
        this.date = date;
    }
}
