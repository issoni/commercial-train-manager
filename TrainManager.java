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

import java.util.Scanner;

public class TrainManager {

    /**
     * The main method runs a menu driven application which first creates an empty TrainLinkedList object.
     */

    public static void main(String[] args) {
        TrainLinkedList newList = new TrainLinkedList();
        TrainCarNode newNode = new TrainCarNode();

        /**
         * The program prompts the user for a command to execute an operation.
         * Once a command has been chosen, the program may ask the user for additional information
         * if necessary, and performs the operation.
         */

        while (true) {
            directory();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a selection: ");
            String selection = input.nextLine();

            /*
             Moves the cursor forward one car (if a next car exists).
             */
            if ("F".equalsIgnoreCase(selection)) {
                    newList.cursorForward();
            }

            /*
             Moves the cursor backward one car (if a previous car exists).
             */
            if ("B".equalsIgnoreCase(selection)) {
                newList.cursorBackward();
            }

            /*
             Inserts a new empty car after the cursor. If the cursor is null
             (i.e. the train is empty), the car is set as the head of the train.
             After insertion, the cursor is set to the newly inserted car.
             */
            if ("I".equalsIgnoreCase(selection)) {
                System.out.print("Enter car length in meters: ");
                String carLengthInMeters = input.nextLine();
                double carLength = Double.parseDouble(carLengthInMeters);

                System.out.print("Enter car weight in tons: ");
                String carWeightInTons = input.nextLine();
                double carWeight = Double.parseDouble(carWeightInTons);

                System.out.println();

                TrainCar newCar = new TrainCar(carLength, carWeight);


                try {
                    newList.insertAfterCursor(newCar);
                    System.out.println("New train car " + carLength + " meters " + carWeight +
                            " tons inserted into train.");
                } catch (IllegalArgumentException e) {
                    System.out.println("The new car is empty!");
                }

            }

            /*
            Removes the car at current position of the cursor.
            After deletion, the cursor is set to the next car in the list if one exists, otherwise the previous car.
            If there is no previous car, the list is empty and the cursor is set to null.
             */
            if ("R".equalsIgnoreCase(selection)) {
                try {
                    if (newList.getCursorData() != null) {
                        System.out.println("Car successully unlinked. The following load has been removed from the train: ");
                        System.out.printf("%7s%15s%15s%15s%n", "Name", "Weight (t)", "Value ($)", "Dangerous");
                        System.out.print("=======================================================\n");

                        try {

                            String dangerous = "";
                            if(newList.getCursorData().getProductLoad().getIsDangerous()) {
                                dangerous = "DANGEROUS";
                            }
                            else {
                                dangerous = "NOT DANGEROUS";
                            }

                            String valueFormatted = String.format("%.2f", newList.getCursorData().getProductLoad().getValue());
                            System.out.printf("%10s%15s%15s%15s%n", newList.getCursorData().getProductLoad().getName(),
                                    newList.getCursorData().getProductLoad().getWeight(), valueFormatted,
                                    dangerous);
                        } catch (EmptyListException e) {
                            System.out.println("The list is empty!");
                        }
                    }
                } catch (EmptyListException e) {
                    System.out.println("The list is empty!");
                }

                newList.removeCursor();
            }


            /*
            Sets the product load at the current position in the list.
             */
            if ("L".equalsIgnoreCase(selection)){
                System.out.print("Enter produce name: ");
                String name = input.nextLine();

                System.out.print("Enter product weight in tons: ");
                String loadWeight = input.nextLine();
                double weight = Double.parseDouble(loadWeight);

                System.out.print("Enter product value in dollars: ");
                String loadValue = input.nextLine();
                double value = Double.parseDouble(loadValue);

                boolean danger;
                System.out.print("Enter is product dangerous? (y/n): ");
                String productDanger = input.nextLine();
                if("y".equalsIgnoreCase(productDanger)) {
                    danger = true;
                } else {
                    danger = false;
                }

                System.out.println();
                ProductLoad newLoad = new ProductLoad(name, weight, value, danger);
                try {
                    newList.getCursorData().setProductLoad(newLoad);
                    //newList.displayTrainValues();
                } catch (EmptyListException e){
                    System.out.println("The list is empty!");
                }


            }


            /*
            Searches the train for all the loads with the indicated name and prints out
            the total weight and value, and whether the load is dangerous or not.
            If the product could not be found, indicate to the user that the train does not contain the indicated product.
             */
            if("S".equalsIgnoreCase(selection)) {
                System.out.print("Enter product name: ");
                String productName = input.nextLine();

                newList.findProduct(productName);
            }


            /*
            Prints the String value of the train to the console.
             */
            if("T".equalsIgnoreCase(selection)) {
                System.out.println(newList.toString());
            }


            /*
            Prints the train manifest - the loads carried by each car.
             */
            if("M".equalsIgnoreCase(selection)) {
                System.out.println();
                newList.printManifest();
            }


            /*
            Removes all the dangerous cars from the train.
             */
            if("D".equalsIgnoreCase(selection)) {
                try {
                    newList.removeDangerousCars();
                } catch (EmptyListException e) {
                    System.out.println("The list is empty!");
                }
            }


            /*
            Terminates the program.
             */
            if("Q".equalsIgnoreCase(selection)) {
                System.out.println("Program terminating successfully...");
                System.exit(0);
            }


        }

    }

    /**
     * prints out the directory every time a selection is done
     */

    public static void directory() {
        System.out.println();
        System.out.println("(F) Cursor Forward");
        System.out.println("(B) Cursor Backward");
        System.out.println("(I) Insert Car After Cursor");
        System.out.println("(R) Remove Car At Cursor");
        System.out.println("(L) Set Product Load");
        System.out.println("(S) Search For Product");
        System.out.println("(T) Display Train");
        System.out.println("(M) Display Manifest");
        System.out.println("(D) Remove Dangerous Cars");
        System.out.println("(Q) Quit");
        System.out.println();
    }
}
