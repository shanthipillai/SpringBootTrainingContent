package feb.training.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepo {
	OrderRepo()
	{
		System.out.println("Order Repo bean created by container");
	}
}
