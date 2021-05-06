package sample;

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

public class EmptyListException extends Exception {

    /**
     * indicates that the indicates that the list is empty
     * @param message tell the user the list is empty
     */

       public EmptyListException(String message) {
           super(message);
        }


}
