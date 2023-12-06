package ag.selm.customer.spi.catalogue.spring.web.presentation;

public record ProductCategoryPresentationV1(long id, String title, String details,
                                            Long parentId, int version) {
}
