package feb.training.springboot.paymentservice;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UpiPayment implements Payment {

  
    @Override
    public void pay(int amount) {
      
       log.debug("Payment of ₹" + amount + " completed using UPI");
       log.info("Done");
    }
}
