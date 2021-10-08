package Week2HomeWork1;

public class Buy2Take3Product extends Product {
    //original product
    private final Product original;


    public Buy2Take3Product(Product original) {
        super(original);
        if (original instanceof DiscountedProduct) {
            throw new IllegalArgumentException("You can not buy and take for a discounted product.");
        }
        this.original = original;
    }


    public boolean canBeReduced() {
        return !(this.original instanceof DiscountedProduct);
    }


    public double getPrice(Cart cart) {
        long buy2Take3Count = cart.getProducts().stream().filter(it -> it instanceof Buy2Take3Product).count() / 3;
        if (buy2Take3Count > 0) {
            return this.original.getPrice(cart) * (0.66);
        }
        return this.original.getPrice(cart);
    }
}
