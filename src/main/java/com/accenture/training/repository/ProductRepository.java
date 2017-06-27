package com.accenture.training.repository;

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

	public Product findByStrName(String strName);
}
