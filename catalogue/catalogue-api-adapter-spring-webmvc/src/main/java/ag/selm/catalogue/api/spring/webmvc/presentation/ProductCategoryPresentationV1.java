package ag.selm.catalogue.api.spring.webmvc.presentation;

public record ProductCategoryPresentationV1(long id, String title, String details,
                                            Long parentId, int version) {
}
