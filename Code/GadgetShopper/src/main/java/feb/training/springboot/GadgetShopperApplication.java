package feb.training.springboot;

import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.classic.Logger;
import feb.training.springboot.orderservice.Order;
import feb.training.springboot.orderservice.exception.ProductNotFoundException;
import feb.training.springboot.paymentservice.Payment;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GadgetShopperApplication {

	public static void main(String[] args) {
	/*ApplicationContext context	=SpringApplication.run(GadgetShopperApplication.class, args);

    Order order = context.getBean(Order.class);
    Payment payment = context.getBean(Payment.class);

    Map<String, Integer> products = order.fetchProducts();
    Scanner sc = new Scanner(System.in);

    int total = 0;
    String choice;

    do {
        log.debug("\nAvailable Products:");
        products.forEach((name, price) ->  
                System.out.println(name + " : ₹" + price)
        );

        System.out.print("Enter product name: ");
        String selectedProduct = sc.nextLine();

        Integer price = products.get(selectedProduct);

        if (price != null) {
            total += price;
            System.out.println(selectedProduct + " added : ₹" + price);
        } else {
            System.out.println("Invalid product name!");
        }

        System.out.print("Do you want to add another product? (yes/no): ");
        choice = sc.nextLine();

    } while (choice.equalsIgnoreCase("yes"));

    System.out.println("\nFinal Total Amount : ₹" + total);

    payment.pay(total);
}
}


*/
		log.info("Starting ShoppingApplication");

        ApplicationContext context =
                SpringApplication.run(GadgetShopperApplication.class, args);

        log.debug("Fetching Order and Payment beans from ApplicationContext");

        Order order = context.getBean(Order.class);
        Payment payment = context.getBean(Payment.class);

        Map<String, Integer> products = order.fetchProducts();
        log.info("Fetched {} products", products.size());

        Scanner sc = new Scanner(System.in);

        int total = 0;
        String choice;

        do {
            log.debug("Displaying available products");

            System.out.println("\nAvailable Products:");
            products.forEach((name, price) ->
                    System.out.println(name + " : ₹" + price)
            );

            System.out.print("Enter product name: ");
            String selectedProduct = sc.nextLine();
            log.info("Product selected by user: {}", selectedProduct);

            Integer price = products.get(selectedProduct);

            if (price != null) {
                total += price;
                System.out.println(selectedProduct + " added : ₹" + price);
            } else {
                throw new ProductNotFoundException(selectedProduct);
            }


            System.out.print("Do you want to add another product? (yes/no): ");
            choice = sc.nextLine();
            log.debug("User choice to continue: {}", choice);

        } while (choice.equalsIgnoreCase("yes"));

        log.info("Final total calculated: ₹{}", total);
        System.out.println("\nFinal Total Amount : ₹" + total);

        log.info("Initiating payment");
        payment.pay(total);

        log.info("ShoppingApplication finished successfully");
    }
}