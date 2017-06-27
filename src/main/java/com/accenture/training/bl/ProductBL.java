package com.accenture.training.bl;

import java.util.List;

import com.accenture.training.model.Product;

/**
 * This interface give methods for validate the business rules.
 * @author Isaza
 *
 */
public interface ProductBL {
	
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProductLogically(Integer IdProduct);
	public Product findProductById(Integer IdProduct);
	public Product findProductByName(String nameProduct);
	public List<Product> findAllProducts();
}
