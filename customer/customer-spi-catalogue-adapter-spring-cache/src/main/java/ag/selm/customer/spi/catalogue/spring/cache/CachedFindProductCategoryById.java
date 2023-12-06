package ag.selm.customer.spi.catalogue.spring.cache;

import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;
import ag.selm.customer.spi.catalogue.FindProductCategoryByIdSpi;
import org.springframework.cache.Cache;

import java.util.Optional;

public class CachedFindProductCategoryById implements FindProductCategoryByIdSpi {

    private final FindProductCategoryByIdSpi delegate;

    private final Cache cache;

    public CachedFindProductCategoryById(FindProductCategoryByIdSpi delegate, Cache cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(this.cache.get(id.value(), ProductCategoryData.class))
                .or(() -> this.delegate.findProductCategoryById(id)
                        .map(category -> {
                            this.cache.put(category.id().value(), category);
                            return category;
                        }));
    }
}
