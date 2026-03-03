package feb.training.springboot.orderservice.exception;

//User Defined Exception 
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String productName) {
        super("Product not found: " + productName);
    }
}