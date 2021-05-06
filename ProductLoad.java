package sample;

/**
 * train car manager for a commercial train
 * @author Ishika Soni
 */

public class ProductLoad {

    private String name;
    private double weight;
    private double value;
    private boolean isDangerous;

    /**
     * constructor for the product load
     * @param productName the name of the product
     * @param productWeight the weight of the product in tons
     * @param productValue the value of the product in dollars
     * @param productDanger the product is dangerous or not
     */

    public ProductLoad(String productName, double productWeight, double productValue, boolean productDanger) {
        name = productName;
        weight = productWeight;
        value = productValue;
        isDangerous = productDanger;
    }

    /**
     * getter for name
     * @return gets the name of the product
     */

    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name sets the name of the product
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for weight
     * @return gets the weight of the product
     */

    public double getWeight() {
        return weight;
    }

    /**
     * setter for weight
     * @param weight sets the weight of the product
     * @throws IllegalArgumentException indicates the weight is not within the valid range (negative value)
     */

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("The weight is not within the valid range!");
        } else {
            this.weight = weight;
        }
    }

    /**
     * getter for value
     * @return gets the value of the product
     */

    public double getValue() {
        return value;
    }

    /**
     * setter for value
     * @param value sets the value of the product
     * @throws IllegalArgumentException indicates the value is not within the valid range (negative value)
     */

    public void setValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("The value is not within the valid range!");
        } else {
            this.value = value;
        }
    }

    /**
     * getter for the info if the product is dangerous or not
     * @return gets the info if the product is dangerous or not
     */

    public boolean getIsDangerous() {
        return isDangerous;
    }

    /**
     * setter for the info if the product is dangerous or not
     * @param isDangerous sets the info if the product is dangerous or not
     */

    public void setDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

}


