package ag.selm.catalogue.api.usecase;

import ag.selm.catalogue.api.FindProductCategoryApi;
import ag.selm.catalogue.data.ProductCategoryData;
import ag.selm.catalogue.id.ProductCategoryId;
import ag.selm.catalogue.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class FindProductCategoryUseCase implements FindProductCategoryApi {

    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public FindProductCategoryUseCase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategory(ProductCategoryId id) {
        return this.findProductCategoryByIdSpi.findProductCategoryById(id);
    }
}
