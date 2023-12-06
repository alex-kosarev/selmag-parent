package ag.selm.catalogue.spi;

import ag.selm.catalogue.data.ProductCategoryData;
import ag.selm.catalogue.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {

    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id);
}
