package com.temporaryproject.forkjoinproduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate products.
 */
public class ProductListGenerator {

    /**
     * Generates a list of product with name as per the size provide in the parameter of the method.
     * @param size
     * @return
     */
    public List<Product> generate (int size) {

        List<Product> productList = new ArrayList<>();

        for(int i = 0; i< size; i++){
            Product product = new Product();
            product.setName("Product "+i);
            product.setPrice(10);
            productList.add(product);
        }
        return productList;
    }

}
