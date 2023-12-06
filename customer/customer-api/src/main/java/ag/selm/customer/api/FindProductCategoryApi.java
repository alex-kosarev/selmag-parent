package ag.selm.customer.api;

import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {

    Optional<ProductCategoryData> findProductCategory(ProductCategoryId id);
}
