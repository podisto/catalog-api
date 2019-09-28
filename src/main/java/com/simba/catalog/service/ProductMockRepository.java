package com.simba.catalog.service;

import com.simba.catalog.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-09-28
 */
public class ProductMockRepository {
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "P001", "Product 1", "Product 1 Description", 25));
        products.add(new Product(2L, "P002", "Product 2", "Product 2 Description", 32));
        products.add(new Product(3L, "P003", "Product 3", "Product 3 Description", 50));
        return products;
    }
}
