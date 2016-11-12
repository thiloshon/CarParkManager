/**
 * Created by Thiloshon on 12-Nov-16.
 */
public class Motorbike extends Vehicle {
    private int engineSize;

    public Motorbike(int engineSize, String idPlate, String brand, Date date) {
        this.engineSize = engineSize;
        this.iDPlate = idPlate;
        this.brand = brand;
        this.date = date;
    }
}
