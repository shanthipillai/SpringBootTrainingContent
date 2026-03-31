package feb.training.springboot.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
		basePackages = "feb.training.springboot.comoany.repo",
		entityManagerFactoryRef = "companyEM",
		transactionManagerRef = "companyTM"
		
		
		)
public class CompanyConfig {
    @Bean
    @Primary
	@ConfigurationProperties(prefix = "spring.datasource.company")
	public DataSource companyDS()
	{
		return DataSourceBuilder.create().build();
	}
    
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean companyEM(EntityManagerFactoryBuilder builder) {

        Map<String, Object> properties = new HashMap<>();

        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return builder
                .dataSource(companyDS())
                .packages("feb.training.springboot.company.entities")
                .persistenceUnit("companyPU")
                .properties(properties)   // ⭐ ADD THIS
                .build();
    }
    
    @Bean
    @Primary
    public PlatformTransactionManager companyTM(@Qualifier("companyEM") EntityManagerFactory emf)
    {
    	return new JpaTransactionManager(emf);
    }
}
