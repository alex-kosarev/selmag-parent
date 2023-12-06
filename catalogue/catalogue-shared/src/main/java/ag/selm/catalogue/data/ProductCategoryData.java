package ag.selm.catalogue.data;

import ag.selm.catalogue.id.ProductCategoryId;

public record ProductCategoryData(ProductCategoryId id, String title, String details,
                                  ProductCategoryId parentId, int version) {
}
