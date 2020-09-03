package Config;

import java.util.Properties;

import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.*;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.citijavatraining.springmvctodo.model"})
class JPAconfig {
	
	@Bean
    public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();

        dataSourceConfig.setDriverClassName("org.h2.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:h2:mem:datajpa");
        dataSourceConfig.setUsername("sa");
        dataSourceConfig.setPassword("");

        return (DataSource) new HikariDataSource(dataSourceConfig);
    }
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource((javax.sql.DataSource) dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
	
	@Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityMangerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityMangerFactory);

        return transactionManager;
    }
}
