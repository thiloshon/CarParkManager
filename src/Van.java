/**
 * Created by Thiloshon on 12-Nov-16.
 */
public class Van extends Vehicle {
    private int cargoVolume;

    public Van(int cargoVolume, String idPlate, String brand, Date date) {
        this.cargoVolume = cargoVolume;
        this.iDPlate = idPlate;
        this.brand = brand;
        this.date = date;
    }
}
