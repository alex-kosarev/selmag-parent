package ag.selm.catalogue.api;

import ag.selm.catalogue.data.ProductCategoryData;
import ag.selm.catalogue.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {

    Optional<ProductCategoryData> findProductCategory(ProductCategoryId id);
}
