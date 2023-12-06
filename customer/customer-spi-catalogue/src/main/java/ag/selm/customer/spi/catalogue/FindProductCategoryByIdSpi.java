package ag.selm.customer.spi.catalogue;

import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {

    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id);
}
