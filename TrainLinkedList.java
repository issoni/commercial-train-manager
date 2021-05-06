package sample;

/**
 * train car manager for a commercial train
 * @author Ishika Soni
 */

public class TrainLinkedList {

    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private int listSize;
    private double totalTrainLength;
    private double totalTrainValue;
    private double totalTrainWeight;
    private boolean trainIsDangerous;

    /**
     * Constructs an instance of the TrainLinkedList with no TrainCar objects in it.
     * <dt>postcondition
     *      <dd>This TrainLinkedList has been initialized to an empty linked list.
     *      <dd>head, tail, and cursor are all set to null.
     */

    public TrainLinkedList() {
        head = null;
        tail = null;
        cursor = null;
        listSize = 0;
        totalTrainLength = 0.0;
        totalTrainValue = 0.0;
        totalTrainWeight = 0.0;
        trainIsDangerous = false;
    }

    /**
     * Returns a reference to the TrainCar at the node currently referenced by the cursor.
     * <dt>preconditions
     *      <dd>The list is not empty (cursor is not null).
     * @return The reference to the TrainCar at the node currently referenced by the cursor.
     * @throws EmptyListException indicates that the list is empty
     */

    public TrainCar getCursorData() throws EmptyListException {
        if(cursor == null) {
            throw new EmptyListException("The list is empty!");
        }
        return cursor.getCar();
    }

    /**
     * Places car in the node currently referenced by the cursor.
     * <dt>preconditions
     *      <dd>The list is not empty (cursor is not null).
     * <dt>postconditions
     *      <dd>The cursor node now contains a reference to car as its data.
     * @param car the data the cursor is going to get set with
     * @throws EmptyListException indicates that the list is empty
     */

    public void setCursorData(TrainCar car) throws EmptyListException {
        if(cursor == null) {
            throw new EmptyListException("The list is empty!");
        }
        cursor.setCar(car);
    }

    /**
     * Moves the cursor to point at the next TrainCarNode.
     * <dt>preconditions
     *      <dd>The list is not empty (cursor is not null) and cursor does not currently reference the tail of the list.
     * <dt>postconditions
     *      <dd>The cursor has been advanced to the next TrainCarNode, or has remained at the tail of the list.
     */


    public void cursorForward() {
        cursor = cursor.getNext();
        System.out.println("Cursor moved forward.");

    }

    /**
     * Moves the cursor to point at the previous TrainCarNode.
     * <dt>preconditions
     *      <dd>The list is not empty (cursor is not null) and the cursor does not currently reference the head of the list.
     * <dt>postconditions
     *      <dd>The cursor has been moved back to the previous TrainCarNode, or has remained at the head of the list.
     */

    public void cursorBackward() {
        cursor = cursor.getPrev();
        System.out.println("Cursor moved backward.");
    }

    /**
     * Inserts a car into the train after the cursor position.
     * @param newCar the new TrainCar to be inserted into the train.
     * <dt>preconditions
     *      <dd>This TrainCar object has been instantiated
     * <dt>postconditions
     *      <dd>The new TrainCar has been inserted into the train after the position of the cursor.
     *      <dd>All TrainCar objects previously on the train are still on the train, and thier order has been preserved.
     *      <dd>The cursor now points to the inserted car.
     * @throws IllegalArgumentException Indicates that newCar is null.
     */

    public void insertAfterCursor(TrainCar newCar) {

        TrainCarNode newNode = new TrainCarNode(newCar);

        if (newCar == null) {
            throw new IllegalArgumentException("The new car is empty!");
        } else if (cursor == null) {
            head = newNode;
            tail = newNode;
            cursor = newNode;
        } else {
            TrainCarNode next = cursor.getNext();

            newNode.setNext(next);
            cursor.setNext(newNode);

            newNode.setPrev(cursor);
            if (next != null) {
                next.setPrev(newNode);
            }
            cursor = newNode;
            if (next == null) {
                tail = cursor;
            }
        }

        listSize++;
        totalTrainLength += newCar.getCarLength();
        if (newCar.getProductLoad() != null) {
            totalTrainValue += newCar.getProductLoad().getValue();
            trainIsDangerous = newCar.getProductLoad().getIsDangerous();
        }
        totalTrainWeight += newCar.getCarWeight();
    }

    /**
     * Removes the TrainCarNode referenced by the cursor and returns the TrainCar contained within the node.
     * <dt>preconditions
     *      <dd>The cursor is not null.
     * <dt>postconditions
     *      <dd>The TrainCarNode referenced by the cursor has been removed from the train.
     *      <dd>The cursor now references the next node, or the previous node if no next node exists.
     * @return the car that got removed
     */

    public TrainCar removeCursor() {
        listSize--;
        totalTrainLength -= cursor.getCar().getCarLength();
        totalTrainValue -= cursor.getCar().getProductLoad().getValue();
        totalTrainWeight -= cursor.getCar().getCarWeight();

        TrainCarNode current = cursor;

        if(cursor != tail) {
            TrainCarNode temp = cursor.getNext();

            current.setCar(temp.getCar());
            current.setNext(temp.getNext());
            //temp.getNext().setPrev(current);
            System.gc();
            if(cursor.getNext() == null) {
                tail = cursor;
            }
        } else {
            TrainCarNode temp = cursor.getPrev();

            temp.setNext(null);
            current.setPrev(null);
            temp = cursor;
            System.gc();

        }
        return null;

    }

    /**
     * Determines the number of TrainCar objects currently on the train.
     * @return The number of TrainCar objects on this train.
     */

    public int size() {
        return listSize;
    }

    /**
     * Returns the total length of the train in meters.
     * @return The sum of the lengths of each TrainCar in the train.
     */

    public double getLength() {
        return totalTrainLength;
    }

    /**
     * Returns the total value of product carried by the train.
     * @return The sum of the values of each TrainCar in the train.
     */

    public double getValue() {
        return totalTrainValue;
    }

    /**
     * Returns the total weight in tons of the train.
     * @return The sum of the weight of each TrainCar plus the sum of the ProductLoad carried by that car.
     */

    public double getWeight() {
        return totalTrainWeight;
    }

    /**
     * Whether or not there is a dangerous product on one of the TrainCar objects on the train.
     * @return Returns true if the train contains at least one TrainCar carrying a dangerous ProductLoad, false otherwise.
     */

    public boolean isDangerous() {
        return trainIsDangerous;
    }

    /**
     * Searches the list for all ProductLoad objects with the indicated name and sums together their weight and value
     * @param name the name of the ProductLoad to find on the train.
     */

    public void findProduct(String name) {
        double totalWeight = 0;
        double totalValue = 0;
        int count = 0;
        String danger = "";


        TrainCarNode current = new TrainCarNode();
        current = head;

        while (current != null) {
            if (name.equalsIgnoreCase(current.getCar().getProductLoad().getName())) {
                count++;
                totalWeight += current.getCar().getProductLoad().getWeight();
                totalValue += current.getCar().getProductLoad().getValue();

                if (current.getCar().getProductLoad().getIsDangerous()) {
                    danger = "DANGEROUS";
                } else {
                    danger = "NOT DANGEROUS";
                }
            }
            current = current.getNext();
        }

        if (count <= 0) {
            System.out.println("No record of " + name + " on board train.");
        } else {
            String valueFormatted = String.format("%.2f", totalValue);
            System.out.println("The following products were found on " + count + " cars:\n");
            System.out.printf("%s%20s%20s%20s", "Name", "Weight (t)", "Value ($)", "Dangerous");
            System.out.println("\n=================================================================\n");
            System.out.printf("%s%20s%20s%20s%n", name, totalWeight, valueFormatted, danger);
        }
    }


    /**
     * Prints a neatly formatted table of the car number, car length, car weight, load name,
     * load weight, load value, and load dangerousness for all of the car on the train.
     */

    public void printManifest() {
        System.out.printf("%-30s %16s %n", "CAR:", "LOAD:");
        System.out.printf("%7s%15s%15s%5s%10s%15s%15s%15s", "Num", "Length (m)", "Weight (t)", "|",
                "Name", "Weight (t)", "Value ($)", "Dangerous\n");
        System.out.print("=========================================" +
                "+" + "==================================" +
                "=====================\n");

        TrainCarNode current = head;

        int count = 0;
        while (current != null) {
            count++;
            TrainCar car = current.getCar();
            ProductLoad load = car.getProductLoad();

            String productName = "Empty";
            double productWeight = 0.0;
            double productValue = 0.0;
            boolean productDanger = false;
            String dangerString = "NO";
            if (load != null) {
                productName = load.getName();
                productWeight = load.getWeight();
                productValue = load.getValue();
                productDanger = load.getIsDangerous();
                if (productDanger) {
                    dangerString = "YES";
                } else {
                    dangerString = "NO";
                }
            }

            String valueFormatted = String.format("%.2f", productValue);
            System.out.printf("%7s%15s%15s%5s%10s%15s%15s%15s%n", count, current.getCar().getCarLength(),
                            current.getCar().getCarWeight(), "|", productName, productWeight,
                    valueFormatted, dangerString);
            current = current.getNext();
        }

    }

    /**
     * Removes all dangerous cars from the train, maintaining the order of the cars in the train.
     * <dt>postconditions
     *      <dd>All dangerous cars have been removed from this train.
     * The order of all non-dangerous cars must be maintained upon the completion of this method.
     */

    public void removeDangerousCars() throws EmptyListException {
        cursor = head;

        if(cursor == null){
            throw new EmptyListException("The list is empty!");
        }

        while(cursor != null) {
            if (cursor.getCar().getProductLoad().getIsDangerous()) {
                removeCursor();
            }
            cursor = cursor.getNext();
        }

        System.out.println("Dangerous cars successfully removed from the train.");
    }

    /**
     * Returns a neatly formatted String representation of the train.
     * @return A neatly formatted string containing information about the train, including it's size (number of cars),
     * length in meters, weight in tons, value in dollars, and whether it is dangerous or not.
     */

    public String toString() {
        String dangerous = "";
        if(!isDangerous()) {
            dangerous = "DANGEROUS";
        }
        else {
            dangerous = "NOT DANGEROUS";
        }

        String valueFormatted = String.format("%.2f", getValue());
        return "Train: " + size() + " cars, " + getLength() + " meters, " +
                getWeight() + " tons, $" + valueFormatted +
                " value, " + dangerous + ".";
    }




}



