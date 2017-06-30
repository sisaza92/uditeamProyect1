package com.accenture.training.bl;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.training.exeption.BLException;
import com.accenture.training.model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductBLImplTest {

	@Autowired
	private ProductBL productBL;
	
	private Product product;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void createNullProductTest() throws BLException{
		product = null;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_PRODUCT_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void createProductWithNullIdTest() throws BLException{
		product = new Product(null, "New Product", "This is a new Product in the bank", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_ID_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void createProductWithEmptyNameTest() throws BLException{
		product = new Product(0, "       ", "This is a new Product in the bank", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.EMPTY_NAME_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void createProductWithEmptyDescriptionTest() throws BLException{
		product = new Product(0, "New Product", "", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.EMPTY_DESCRIPTION_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void createProductInactiveTest() throws BLException{
		product = new Product(0, "New Product", "This is a new Product in the bank", 100, 1, false);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.SAVE_INACTIVE_PRODUCT_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void createExistentProductTest() throws BLException{
		product = new Product(5, "Leasing Banco", "Este producto es nuevo en nuestro banco", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.PRODUCT_EXIST_MSG);
		productBL.createProduct(product);
	}
	
	@Test
	public void updateNullProductTest() throws BLException{
		product = null;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_PRODUCT_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void updateProductWithNullIdTest() throws BLException{
		product = new Product(null, "New Product", "This is a new Product in the bank", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_ID_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void updateProductWithEmptyNameTest() throws BLException{
		product = new Product(0, "  ", "This is a new Product in the bank", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.EMPTY_NAME_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void updateProductWithEmptyDescriptionTest() throws BLException{
		product = new Product(0, "New Product", "", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.EMPTY_DESCRIPTION_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void updateProductInactiveTest() throws BLException{
		product = new Product(0, "New Product", "This is a new Product in the bank", 100, 1, false);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.SAVE_INACTIVE_PRODUCT_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void updateInexistentProductTest() throws BLException{
		product = new Product(2, "Leasing Banco", "Este producto es nuevo en nuestro banco", 100, 1, true);;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.PRODUCT_NOT_EXIST_MSG);
		productBL.updateProduct(product);
	}
	
	@Test
	public void deleteInexistentProductTest() throws BLException{
		Integer idProduct = 2;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.PRODUCT_NOT_EXIST_MSG);
		productBL.deleteProductLogically(idProduct);
	}
	
	@Test
	public void deleteProducWithIdNulltTest() throws BLException{
		Integer idProduct = null;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_ID_MSG);
		productBL.deleteProductLogically(idProduct);
	}
	
	@Test
	public void findProductByNullIdTest() throws BLException{
		Integer idProduct = null;
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.NULL_ID_MSG);
		Product product = productBL.findProductById(idProduct);		
	}
	
	@Test
	public void findProductByEmptyNameTest() throws BLException{
		String nameProduct = "";
		thrown.expect(BLException.class);
		thrown.expectMessage(ProductBLImpl.EMPTY_NAME_MSG);
		List<Product> products = productBL.findProductsByName(nameProduct);		
	}
}
