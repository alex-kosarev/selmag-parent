package ag.selm.customer.api.usecase;

import ag.selm.customer.api.FindProductCategoryApi;
import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;
import ag.selm.customer.spi.catalogue.FindProductCategoryByIdSpi;

import java.util.Optional;

public class CustomerFindProductCategoryUseCase implements FindProductCategoryApi {

    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public CustomerFindProductCategoryUseCase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategory(ProductCategoryId id) {
        return this.findProductCategoryByIdSpi
                .findProductCategoryById(id);
    }
}
