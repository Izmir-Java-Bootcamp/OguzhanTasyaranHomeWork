package Week2HomeWork1;


public class Product {

    private final String seller;
    private final String name;
    private final double price;


    public Product(String seller, String name, double price) {
        this.seller = seller;
        this.name = name;
        this.price = price;
    }


    public Product(Product original) {
        this.seller = original.seller;
        this.name = original.name;
        this.price = original.price;
    }


    public final String getSeller() {
        return this.seller;
    }


    public final String getName() {
        return this.name;
    }


    public double getPrice(Cart cart) {
        return this.price;
    }


    public boolean canBeReduced() {
        return true;
    }


    public String toString() {
        return this.name;
    }
}
