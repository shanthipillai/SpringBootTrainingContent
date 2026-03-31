package feb.training.springboot.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages = "feb.training.springboot.client.repo",
		entityManagerFactoryRef = "clientEM",
		transactionManagerRef = "clientTM"
		
		
		)
public class ClientConfig {
    @Bean
	@ConfigurationProperties("spring.datasource.client")
	public DataSource clientDS()
	{
		return DataSourceBuilder.create().build();
	}
    @Bean
    public LocalContainerEntityManagerFactoryBean clientEM(org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");  
        properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");

        return builder
                .dataSource(clientDS())
                .packages("feb.training.springboot.client.entities")
                .persistenceUnit("clientpu")
                .properties(properties)   // ⭐ ADD THIS
                .build();
    }
    
    @Bean
    public PlatformTransactionManager clientTM(@Qualifier("clientEM")
    		EntityManagerFactory emf) {
    	return new JpaTransactionManager(emf);
    }
}
