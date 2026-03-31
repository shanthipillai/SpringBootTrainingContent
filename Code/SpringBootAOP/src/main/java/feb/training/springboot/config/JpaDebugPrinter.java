package feb.training.springboot.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;

@Component
public class JpaDebugPrinter {

    @Autowired
    private ApplicationContext context;

    // Inject current EntityManager (proxy)
    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void printAllJpaDetails() {

        System.out.println("\n========= JPA DEBUG INFO =========");

        // 🔹 1. EntityManagerFactories
        Map<String, EntityManagerFactory> emfMap =
                context.getBeansOfType(EntityManagerFactory.class);

        System.out.println("\n--- EntityManagerFactories ---");
        emfMap.forEach((name, emf) -> {
            System.out.println("Bean: " + name);
            System.out.println("Class: " + emf.getClass());
        });

        // 🔹 2. EntityManager (Proxy)
        System.out.println("\n--- EntityManager (Proxy) ---");
        System.out.println("EntityManager class: " + entityManager.getClass());

        // 🔹 3. DataSources
        Map<String, DataSource> dsMap =
                context.getBeansOfType(DataSource.class);

        System.out.println("\n--- DataSources ---");
        dsMap.forEach((name, ds) -> {
            System.out.println("Bean: " + name);
            System.out.println("Class: " + ds.getClass());
        });

        // 🔹 4. TransactionManagers
        Map<String, Object> txMap =
                context.getBeansWithAnnotation(org.springframework.transaction.annotation.Transactional.class);

        System.out.println("\n--- Transactional Beans (for reference) ---");
        txMap.forEach((name, obj) -> {
            System.out.println("Bean: " + name);
        });

        System.out.println("\n=================================\n");
    }
}