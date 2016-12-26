/**
 * Created by Thiloshon on 12-Nov-16.
 *
 * Van modal class
 */
public class Van extends Vehicle {
    private int cargoVolume;

    public Van(int cargoVolume, String idPlate, String brand, DateTime date) {
        this.cargoVolume = cargoVolume;
        this.iDPlate = idPlate;
        this.brand = brand;
        this.date = date;
    }
}
