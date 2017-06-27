package com.accenture.training.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.training.exeption.BLException;
import com.accenture.training.model.Product;
import com.accenture.training.repository.ProductRepository;

/**
 * This class implements all business rules for a product
 * @author Cristian Camilo Isaza - sisaza92@gmail.com
 *
 */
@Service
public class ProductBLImpl implements ProductBL{

	public static final String NULL_PRODUCT_MSG = "The product can not be null";
	public static final String NULL_ID_MSG = "The product id can not be null";
	public static final String NULL_NAME_MSG = "The product name can not be null";
	public static final String EMPTY_NAME_MSG = "The product name can not be empty";
	public static final String NULL_DESCRIPTION_MSG = "The product description can not be null or empty";
	public static final String EMPTY_DESCRIPTION_MSG = "The product description can not be empty";
	public static final String NULL_TYPE_MSG = "The product can not be null";
	public static final String PRODUCT_EXIST_MSG = "The product with this id already exist";
	public static final String PRODUCT_NOT_EXIST_MSG = "The product do not exist";
	public static final String SAVE_INACTIVE_PRODUCT_MSG = "Error saving product: you can not save an inactive product";
	
	private final Boolean ACTIVE_PRODUCT= true;

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * This method validate the product attributes before send it to the
	 * repository layer for create a new registry on database
	 * @param product The product to be created like a registry in database.
	 * @throws BLException Throws a Business Logic exception
	 * for indicate an attribute with errors.
	 */
	@Override
	public void createProduct(Product product) throws BLException {
		
		if (null == product) {
			throw new BLException(NULL_PRODUCT_MSG);
		}
		
		Integer idProduct = product.getIntId();
		Integer idProductType = product.getIntProductType();
		String strName = product.getStrName();
		String strDescription = product.getStrDescription();
		
		if (null == idProduct){
			throw new BLException(NULL_ID_MSG);
		}
		if (null == strName) {
			throw new BLException(NULL_NAME_MSG);
		}
		if (strName.isEmpty()) {
			throw new BLException(EMPTY_NAME_MSG);
		}
		if (null == strDescription) {
			throw new BLException(NULL_DESCRIPTION_MSG);
		}
		if (strDescription.isEmpty()) {
			throw new BLException(EMPTY_DESCRIPTION_MSG);
		}
		if (null == product.getIntNmbrOfPeople()) {
			throw new BLException(NULL_PRODUCT_MSG);
		}
		if (null == idProductType) {
			throw new BLException(NULL_TYPE_MSG);
		}
		if (false == product.getBlnIsActive()) {
			throw new BLException(SAVE_INACTIVE_PRODUCT_MSG);
		}
		//TODO: validate if idtype exists on tblType
		if(null != productRepository.findByIntIdAndBlnIsActive(idProduct, ACTIVE_PRODUCT)) {
			throw new BLException(PRODUCT_EXIST_MSG);
		}
		productRepository.save(product);
	}

	/**
	 * This method validate the product attributes before send it to the
	 * repository layer for save it on database
	 * @param product The product to be updated.
	 * @throws BLException Throws a Business Logic exception
	 * for indicate an attribute with errors.
	 */
	@Override
	public void updateProduct(Product product) throws BLException {
		
		if (null == product) {
			throw new BLException(NULL_PRODUCT_MSG);
		}
		
		Integer idProduct = product.getIntId();
		Integer idProductType = product.getIntProductType();
		String strName = product.getStrName();
		String strDescription = product.getStrDescription();
		
		if (null == idProduct){
			throw new BLException(NULL_ID_MSG);
		}
		if (null == strName) {
			throw new BLException(NULL_NAME_MSG);
		}
		if (strName.isEmpty()) {
			throw new BLException(EMPTY_NAME_MSG);
		}
		if (null == strDescription) {
			throw new BLException(NULL_DESCRIPTION_MSG);
		}
		if (strDescription.isEmpty()) {
			throw new BLException(EMPTY_DESCRIPTION_MSG);
		}
		if (null == product.getIntNmbrOfPeople()) {
			throw new BLException(NULL_PRODUCT_MSG);
		}
		if (null == idProductType) {
			throw new BLException(NULL_TYPE_MSG);
		}
		if (false == product.getBlnIsActive()) {
			throw new BLException(SAVE_INACTIVE_PRODUCT_MSG);
		}
		//TODO: validate if idtype exists on tblType
		if(null == productRepository.findByIntIdAndBlnIsActive(idProduct, ACTIVE_PRODUCT)) {
			throw new BLException(PRODUCT_NOT_EXIST_MSG);
		}
		productRepository.save(product);
	}
	
	/**
	 * This method validate the product attributes before send it to the
	 * repository layer for delete it logically on database 
	 * changing its blnIsActive attribute to false.
	 * @param idProduct The identifier of the product to be deleted logically.
	 * @throws BLException Throws a Business Logic exception
	 * for indicate an attribute with errors.
	 */
	@Override
	public void deleteProductLogically(Integer idProduct) throws BLException {
		if (null == idProduct) {
			throw new BLException(NULL_ID_MSG);
		}		
		Product product = productRepository.findByIntIdAndBlnIsActive(idProduct, ACTIVE_PRODUCT);
		if(null == product) {
			throw new BLException(PRODUCT_NOT_EXIST_MSG);
		}
		product.setBlnIsActive(false);
		productRepository.save(product);
		
	}

	/**
	 * This method validate if the product identifier is not null before
	 * search for it, then validate if the product exists on the database
	 * and return it.
	 * @param idProduct The identifier of the product to be searched.
	 * @throws BLException Throws a Business Logic exception
	 * for indicate an attribute with errors.
	 * @return product The product with the specified idProduct that is active in the database.
	 */
	@Override
	public Product findProductById(Integer idProduct) throws BLException {
		if (null == idProduct) {
			throw new BLException(NULL_ID_MSG);
		}
		Product product = productRepository.findByIntIdAndBlnIsActive(idProduct, ACTIVE_PRODUCT);
		if (null == product) {
			throw new BLException(PRODUCT_NOT_EXIST_MSG);
		}
		return product;
	}

	/**
	 * This method validate if the product name is not null
	 * or empty before search for it, then validate if the
	 * product exists on the database and return it.
	 * @param nameProduct The name of the product to be searched.
	 * @throws BLException Throws a Business Logic exception
	 * for indicate an attribute with errors.
	 * @return product The product with the specified name that is active in the database.
	 */
	@Override
	public Product findProductByName(String nameProduct) throws BLException {
		if (null == nameProduct) {
			throw new BLException(NULL_NAME_MSG);
		}
		if (nameProduct.trim().isEmpty()) {
			throw new BLException(EMPTY_NAME_MSG);
		}
		Product product = productRepository.findByStrNameAndBlnIsActive(nameProduct,ACTIVE_PRODUCT);
		if (null == product) {
			throw new BLException(PRODUCT_NOT_EXIST_MSG);
		}
		return product;
	}

	/**
	 * This method return all products active in the database.
	 * @return products A list of products active in the database.
	 */
	@Override
	public List<Product> findAllProducts() {
		List<Product> products = (List<Product>) productRepository.findByBlnIsActive(ACTIVE_PRODUCT);
		return products;
	}

}
