package Week2HomeWork1;

import java.util.Scanner;

public class Main {

    public static void askCustomer(Cart cart) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to buy a product\n" +
                    "Enter 0 to checkout and proceed with the payment\n");
            int selection = sc.nextInt();
            sc.nextLine();
            if (selection == 0) {
                System.out.println(cart.toString());
                System.out.println("Total price: " + cart.totalPrice());
                break;
            }
            System.out.println("Product name: ");
            String productName = sc.nextLine();
            System.out.println("Seller: ");
            String seller = sc.nextLine();

            System.out.println("Price: ");
            double price = sc.nextDouble();

            Product original = new Product(seller, productName, price);

            System.out.print("How many: ");
            int count = sc.nextInt();

            System.out.print("Discount (enter 0 if no discount applies): ");
            double discount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Does Buy2Take3 apply? Y/N: ");
            String isBuy2Take3 = sc.nextLine();

            if (discount > 0 && isBuy2Take3.equals("Y")) {
                throw new IllegalArgumentException("These choices can not be applied");
            }

            if (discount != 0) {
                Product p = new DiscountedProduct(original, discount);
                cart.addProduct(p, count);
                continue;
            }

            if (isBuy2Take3.equals("Y")) {
                Product p = new Buy2Take3Product(original);
                cart.addProduct(p, count);
                continue;
            }

            cart.addProduct(original, count);
        }

    }

    // Main method to interact with a customer
    public static void main(String[] args) {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        Scanner scanner = new Scanner(System.in);

        String customer = scanner.nextLine();
        System.out.println("Hi " + customer + ". Please choose one of the following options:");
        Cart cart = new Cart();


        askCustomer(cart);
    }
}