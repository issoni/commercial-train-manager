package sample;

/**
 * train car manager for a commercial train
 * @author Ishika Soni
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
