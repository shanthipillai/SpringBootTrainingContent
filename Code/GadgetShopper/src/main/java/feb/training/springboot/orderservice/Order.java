package feb.training.springboot.orderservice;
import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import feb.training.springboot.paymentservice.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class Order {

   
	/*
	 * private final Payment payment;
	 * 
	 * private final Map<String, Integer> products = Map.of( "Laptop", 50000,
	 * "Mouse", 1000, "Keyboard", 2000, "Headset", 3000 );
	 * 
	 * 
	 * 
	 * public Map<String, Integer> fetchProducts() {
	 * 
	 * return Collections.unmodifiableMap(products); }
	 * 
	 * public void pay(int total) {
	 * 
	 * payment.pay(total); }
	 */
	
	 private final Map<String, Integer> products = Map.of(
	            "Laptop", 50000,
	            "Mouse", 1000,
	            "Keyboard", 2000,
	            "Headset", 3000
	    );

	    public Map<String, Integer> fetchProducts() {

	        log.info("Fetching product catalog");

	        log.debug("Product catalog contents: {}", products);

	        return Collections.unmodifiableMap(products);
	    }
}
