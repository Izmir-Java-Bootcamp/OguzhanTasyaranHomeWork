package Week2HomeWork1;

import java.util.Scanner;

public class Main {
    /**
     * This is the main class for the application, interacting
     * with the customer, adding to the cart different products to
     * be purchased and finally calculating the total amount to be paid
     */

    /**
     * Allows a cashier to enter the details for a product
     * to be purchased by a customer
     *
     * @param cart the shopping cart of a given customer
     */
    public static void askCustomer(Cart cart) {
        // Code to read from console the product name, seller,
        // price, number of products, discount and
        // if Buy2Take3 applies.
        // Then create a product of the correct type
        // and add it to the shopping cart
    }

    // Main method to interact with a customer
    public static void main(String[] args) {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        Scanner scanner = new Scanner(System.in);

        String customer = scanner.nextLine();
        System.out.println("Hi " + customer + ". Please choose one of the following options:");
        System.out.println("");

        Cart cart = new Cart();

        //Implement the user interface here
        // Ask the user to choose 0 (buy product) or
        // 1 (checkout), depending on what they want to do.
        // Use the method askCustomer
    }
}
