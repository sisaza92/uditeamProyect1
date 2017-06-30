package com.accenture.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.training.model.Product;

/**
 * This interface give all access operations over the database.
 * @author Cristian Camilo - sisaza92@gmail.com
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

	public List<Product> findByStrNameContainingAndBlnIsActive(String strName, Boolean blnIsActive);
	public List<Product> findByBlnIsActive(Boolean blnIsActive);
	public Product findByIntIdAndBlnIsActive(Integer idProduct, Boolean blnIsActive);
	public List<Product> findByintProductTypeOrStrNameAndBlnIsActive(Integer intProductType,String strName, Boolean blnIsActive);
}
