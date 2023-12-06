package ag.selm.customer.spi.catalogue;

import ag.selm.catalogue.api.FindProductCategoryApi;
import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;

import java.util.Optional;

public class DirectFindProductCategoryById implements FindProductCategoryByIdSpi {

    private final FindProductCategoryApi findProductCategoryApi;

    public DirectFindProductCategoryById(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return this.findProductCategoryApi.findProductCategory(
                new ag.selm.catalogue.id.ProductCategoryId(id.value()))
                .map(category -> new ProductCategoryData(new ProductCategoryId(category.id().value()),
                        category.title(), category.details()));
    }
}
