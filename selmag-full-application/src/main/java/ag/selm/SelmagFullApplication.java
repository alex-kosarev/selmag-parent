package ag.selm;

import ag.selm.catalogue.api.usecase.FindProductCategoryUseCase;
import ag.selm.catalogue.spi.spring.jdbc.MappingSqlQueryFindProductCategoryById;
import ag.selm.customer.api.usecase.CustomerFindProductCategoryUseCase;
import ag.selm.customer.spi.catalogue.DirectFindProductCategoryById;
import ag.selm.customer.spi.catalogue.spring.cache.CachedFindProductCategoryById;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@EnableCaching
@SpringBootApplication
public class SelmagFullApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelmagFullApplication.class, args);
    }

    @Bean
    FindProductCategoryUseCase findProductCategoryUseCase(DataSource dataSource) {
        return new FindProductCategoryUseCase(
                new MappingSqlQueryFindProductCategoryById(dataSource)
        );
    }

    @Bean
    CustomerFindProductCategoryUseCase customerFindProductCategoryUseCase(
            FindProductCategoryUseCase findProductCategoryUseCase,
            CacheManager cacheManager) {
        return new CustomerFindProductCategoryUseCase(
                new CachedFindProductCategoryById(
                        new DirectFindProductCategoryById(findProductCategoryUseCase),
                cacheManager.getCache("customer/product-categories/by-id"))
        );
    }
}
