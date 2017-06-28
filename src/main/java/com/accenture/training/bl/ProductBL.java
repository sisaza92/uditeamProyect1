package com.accenture.training.bl;

import java.util.List;

import com.accenture.training.exeption.BLException;
import com.accenture.training.model.Product;

/**
 * This interface give methods for validate the business rules.
 * @author Isaza
 *
 */
public interface ProductBL {
	
	public void createProduct(Product product) throws BLException;
	public void updateProduct(Product product) throws BLException;
	public void deleteProductLogically(Integer IdProduct) throws BLException;
	public Product findProductById(Integer IdProduct) throws BLException;
	public Product findProductByNameContaining(String nameProduct) throws BLException;
	public List<Product> findAllProducts() throws BLException;
}
