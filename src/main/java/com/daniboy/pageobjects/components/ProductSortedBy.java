package com.daniboy.pageobjects.components;

public enum ProductSortedBy {
    NAME_ASCENDING("nameAsc"),
    NAME_DESCENDING("nameDesc"),
    PRICE_ASCENDING("priceAsc"),
    PRICE_DESCENDING("priceDesc");


    private String accessibilityId;
    ProductSortedBy(String accessibilityId) {
        this.accessibilityId = accessibilityId;
    }

    public String getAccessibilityId() {
        return accessibilityId;
    }
}
