package ag.selm.catalogue.api.spring.webmvc;

import ag.selm.catalogue.api.FindProductCategoryApi;
import ag.selm.catalogue.api.spring.webmvc.presentation.ProductCategoryPresentationV1;
import ag.selm.catalogue.id.ProductCategoryId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindProductCategoryRestController {

    private final FindProductCategoryApi findProductCategoryApi;

    public FindProductCategoryRestController(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @GetMapping(path = "/api/catalogue/product-categories/{id:\\d+}",
            produces = "application/vnd.selmag.catalogue.product-category.v1+json")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(
            @PathVariable("id") long id
    ) {
        return this.findProductCategoryApi.findProductCategory(new ProductCategoryId(id))
                .map(category -> ResponseEntity.ok(
                        new ProductCategoryPresentationV1(category.id().value(), category.title(),
                                category.details(), category.parentId() != null ? category.parentId().value() : null,
                                category.version())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
