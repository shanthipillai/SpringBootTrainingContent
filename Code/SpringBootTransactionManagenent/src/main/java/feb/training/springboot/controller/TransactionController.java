package feb.training.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.service.AddToCart;
import feb.training.springboot.service.OrderService;
import feb.training.springboot.service.PaymentService;


@RestController
@RequestMapping("/transactionmanagemnet")
public class TransactionController {

	@Autowired
	AddToCart addtocartservice;
	@Autowired
	OrderService orderservce;
	@Autowired
	PaymentService payemntservice;
	
	
	@PostMapping("/placeorder")
	public void placeOrderService()
	{
		orderservce.placeOrderService();
	}
	
	
	
	@PostMapping("/addcart")
	public void placeCartToOrder()
	{
		addtocartservice.addToCart();
	}
	
	@PostMapping("/payaudit")
	public void paymentAuditUpdates()
	{
		payemntservice.placePaymentService();
	}
}
