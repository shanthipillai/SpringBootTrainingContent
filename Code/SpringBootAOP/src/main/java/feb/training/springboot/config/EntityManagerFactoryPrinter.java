package feb.training.springboot.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerFactoryPrinter {

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void printEntityManagerFactories() {

        System.out.println("======= EntityManagerFactory Beans =======");

        String[] beans = context.getBeanNamesForType(EntityManagerFactory.class);

        for (String bean : beans) {
            System.out.println("EMF Bean: " + bean);
        }

        System.out.println("==========================================");
    }
}