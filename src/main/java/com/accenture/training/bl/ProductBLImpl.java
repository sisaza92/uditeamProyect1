package com.accenture.training.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.model.Product;
import com.accenture.training.repository.ProductRepository;

/**
 * This class implements all business rules for a product
 * @author Isaza
 *
 */
@Service
public class ProductBLImpl implements ProductBL{

	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void createProduct(Product product) {
		if (null == product) {
			
		}
		if (null == product.getIntProductType()) {
			
		}
		if (null == product.getStrDescription() || product.getStrDescription().isEmpty()) {
			
		}
		if (null == product.getIntNmbrOfPeople()) {
			
		}
		Integer idProduct = product.getIntId();
		if (null != idProduct && productRepository.exists(idProduct)) {
			
		}
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		if (null == product) {
			
		}
		if (null == product.getIntProductType()) {
			
		}
		if (null == product.getStrDescription() || product.getStrDescription().isEmpty()) {
			
		}
		if (null == product.getIntNmbrOfPeople()) {
			
		}
		productRepository.save(product);
	}

	@Override
	public void deleteProductLogically(Integer idProduct) {
		if (null == idProduct) {
			
		}
		Product product = productRepository.findOne(idProduct);
		product.setBlnIsActive(false);
		productRepository.save(product);
		
	}

	@Override
	public Product findProductById(Integer idProduct) {
		if (null == idProduct) {
			
		}
		Product product = productRepository.findOne(idProduct);
		return product;
	}

	@Override
	public Product findProductByName(String nameProduct) {
		if (null == nameProduct) {
			
		}
		if ("".equals(nameProduct.trim())) {
			
		}
		Product product = productRepository.findByStrName(nameProduct);
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

}
