/**
 * Created by Thiloshon on 12-Nov-16.
 *
 * Abstract Vehicle class. Car, Van, Bike classes extends this class.
 */
abstract public class Vehicle {
    protected String iDPlate;
    protected String brand;
    protected DateTime date;

    public String getIDPlate() {
        return iDPlate;
    }

    public DateTime getDate() {
        return date;
    }
}
