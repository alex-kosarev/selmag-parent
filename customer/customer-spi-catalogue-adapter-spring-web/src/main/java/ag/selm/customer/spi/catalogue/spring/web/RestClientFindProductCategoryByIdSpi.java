package ag.selm.customer.spi.catalogue.spring.web;

import ag.selm.customer.data.ProductCategoryData;
import ag.selm.customer.id.ProductCategoryId;
import ag.selm.customer.spi.catalogue.FindProductCategoryByIdSpi;
import ag.selm.customer.spi.catalogue.spring.web.presentation.ProductCategoryPresentationV1;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import java.util.Optional;

public class RestClientFindProductCategoryByIdSpi implements FindProductCategoryByIdSpi {

    private final RestClient restClient;

    public RestClientFindProductCategoryByIdSpi(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return this.restClient.get()
                .uri("http://localhost:8081/api/catalogue/product-categories/%d".formatted(id.value()))
                .exchange((req, res) -> {
                    if (res.getStatusCode() == HttpStatus.OK) {
                        return Optional.of(res.bodyTo(ProductCategoryPresentationV1.class))
                                .map(payload ->
                                        new ProductCategoryData(new ProductCategoryId(payload.id()),
                                                payload.title(), payload.details()));
                    }

                    return Optional.empty();
                });
    }
}
