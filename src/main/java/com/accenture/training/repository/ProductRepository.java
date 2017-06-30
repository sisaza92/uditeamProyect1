package com.accenture.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	public List<Product> findByintProductTypeAndBlnIsActive(Integer intProductType, Boolean blnIsActive);
	public List<Product> findByBlnIsActive(Boolean blnIsActive);
	public Product findByIntIdAndBlnIsActive(Integer idProduct, Boolean blnIsActive);
	@Query("SELECT p FROM Product p WHERE p.blnIsActive = :isActive and (p.strName LIKE %:name% or p.intProductType = :type)")
	public List<Product> findByintProductTypeOrStrNameAndBlnIsActive(@Param("type") Integer intProductType, @Param("name") String strName, @Param("isActive") Boolean blnIsActive);
}
