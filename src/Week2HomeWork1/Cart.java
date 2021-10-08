package Week2HomeWork1;

import java.util.ArrayList;
import java.util.List;


public class Cart {
    // list of products
    private final List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }


    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }


    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }


    public void addProduct(Product product, int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            this.products.add(product);
        }
    }


    public double totalPrice() {
        double sum = 0.0;
        for (Product p : this.products) {
            sum += p.getPrice(this);
        }
        return sum;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
