package sample;
//the package is commented out to make it easier for grader

/**
 * train car manager for a commercial train
 * @author Ishika Soni
 * @e-mail: ishika.soni@stonybrook.edu
 * @authorID: Stony Brook ID: 113492059
 * @HW#: 2
 * @course: CSE 214
 * @recitation: R02
 * @TA: William Simunek
 */

public class TrainCar {

    private final double CAR_LENGTH;
    private final double CAR_WEIGHT;
    private ProductLoad load;

    /**
     * constructor for the train car
     * @param lengthOfCar the length of the car in meters
     * @param weightOfCar the weight of the car in tons
     */

    public TrainCar(double lengthOfCar, double weightOfCar) {
        CAR_LENGTH = lengthOfCar;
        CAR_WEIGHT = weightOfCar;
        load = null;
    }

    /**
     * getter for the car length
     * @return gets the length of the car
     */

    public double getCarLength() {
        return CAR_LENGTH;
    }

    /**
     * getter for the car weight
     * @return gets the weight of the car
     */

    public double getCarWeight() {
        return CAR_WEIGHT;
    }

    /**
     * getter for the product load
     * @return gets the load of the product
     */

    public ProductLoad getProductLoad() {
        return load;
    }

    /**
     * setter for the product load
     * @param load sets the load of the product
     */

    public void setProductLoad(ProductLoad load) {
        this.load = load;
    }

    /**
     * determines whether the car is empty or not
     * @return true if the car is empty, otherwise false
     */

    public boolean isEmpty() {
        return load == null;
    }

}
