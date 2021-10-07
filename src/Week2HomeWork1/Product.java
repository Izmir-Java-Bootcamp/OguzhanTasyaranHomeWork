package Week2HomeWork1;

/**
 * Class representing a product to be purchased
 */

public class Product {

    // Name of the seller
    private final String seller;
    // Name of the product
    private final String name;
    // Price of the product
    private final double price;

    /**
     * Construct a new Product given the following parameters
     *
     * @param seller
     * @param name
     * @param price
     */
    public Product(String seller, String name, double price) {
        //initialize fields
    }

    /**
     * Construct a new Product from a given product
     *
     * @param original
     */
    public Product(Product original) {
        // Use the constructor implemented above
    }

    /**
     * Return the seller of this product
     *
     * @return seller
     */
    public final String getSeller() {
        //code here
    }

    /**
     * Return the name of this product
     *
     * @return name
     */
    public final String getName() {
        // code here
    }

    /**
     * Return the price of this product
     *
     * @param cart
     * @return price
     */
    public double getPrice(Cart cart) {
        // code here
    }

    /**
     * Returns true if the price of this product
     * can be reduced
     *
     * @return
     */
    public boolean canBeReduced() {
        //Nothing to do here
        return true;
    }

    /**
     * Return the name of the product
     */
    public String toString() {
        // code here
    }
}
