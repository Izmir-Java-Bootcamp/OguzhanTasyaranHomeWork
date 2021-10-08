package Week2HomeWork1;


public class DiscountedProduct extends Product {
    // Original product
    private final Product original;

    // Discount in percent (%)
    private final double discount;

    public DiscountedProduct(Product original, double discount) {
        super(original);
        if (original instanceof Buy2Take3Product) {
            throw new IllegalArgumentException("Product can not be discounted, its Buy2Take3");
        }

        this.original = original;
        this.discount = discount;
    }


    public double getPrice(Cart cart) {
        return this.original.getPrice(cart) - this.original.getPrice(cart) * (this.discount / 100.0);
    }


    public String toString() {
        return this.original.getName() + "[discounted " + this.discount + " %]";
    }
}
