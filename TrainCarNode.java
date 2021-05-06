package sample;

/**
 * train car manager for a commercial train
 * @author Ishika Soni
 */

public class TrainCarNode {

    private TrainCarNode prev;
    private TrainCarNode next;
    private TrainCar car;

    /**
     * default constructor for train car node
     */

    public TrainCarNode() {
        car = null;
        prev = null;
        next = null;
    }

    /**
     * constructor for train car node
     * @param trainCar sets the car
     */

    public TrainCarNode(TrainCar trainCar) {
        car = trainCar;
        prev = null;
        next = null;
    }

    /**
     * getter for link prev
     * @return gets the link prev
     */

    public TrainCarNode getPrev() {
        return prev;
    }

    /**
     * setter for the link prev
     * @param prev sets the link prev
     */

    public void setPrev(TrainCarNode prev) {
        this.prev = prev;
    }

    /**
     * getter for the link next
     * @return gets the link next
     */

    public TrainCarNode getNext() {
        return next;
    }

    /**
     * setter for the link next
     * @param next sets the link next
     */

    public void setNext(TrainCarNode next) {
        this.next = next;
    }

    /**
     * getter for the car
     * @return gets the car
     */

    public TrainCar getCar() {
        return car;
    }

    /**
     * setter for the car
     * @param car sets the car
     */

    public void setCar(TrainCar car) {
        this.car = car;
    }

    /**
     *
     * toString for the current TrainCarNode
     * @return A neatly formatted string containing information about the product load, including it's name,
     * weight in tons, value in dollars, and whether it is dangerous or not.
     */

    public String toString() {
        return "Load: " + car.getProductLoad().getName() + ", " + car.getProductLoad().getWeight() +
                " tons, $" + car.getProductLoad().getValue() + "value, " +
                car.getProductLoad().getIsDangerous() + ".";


    }


}

