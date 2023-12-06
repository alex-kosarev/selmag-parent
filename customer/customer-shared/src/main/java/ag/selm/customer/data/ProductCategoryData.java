package ag.selm.customer.data;

import ag.selm.customer.id.ProductCategoryId;

public record ProductCategoryData(ProductCategoryId id, String title, String details) {
}
