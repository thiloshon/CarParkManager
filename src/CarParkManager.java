/**
 * Created by Thiloshon on 12-Nov-16.
 */
public interface CarParkManager {

    /**
     * method to add vehicle
     */
    void addVehicle();

    /**
     * method to delete vehicle
     */
    void deleteVehicle();

    /**
     * method to print list of vehicles
     */
    void printList();

    /**
     * method to print several statistics of the vehicles
     */
    void printStatistics();

    /**
     * method to return data related to a specific date
     */
    void dateQuery();

    /**
     * method to calculate the final charges
     */
    void calculatePrice();

}
