package com.accenture.training.bl;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.training.model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
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

	@Test
	public void createProductTest() {
		product = new Product(null, "Leasing Banco", "Este producto es nuevo en nuestro banco", 100, 1, true);
		productBL.createProduct(product);
	}
	
	@Test
	public void updateProductTest(){
		Product product = productBL.findProductById(3);
		product.setStrDescription("Descripcion updateeeed");
		product.setIntProductType(1);
		productBL.updateProduct(product);
	}
	
	@Test
	public void deleteProductTest(){
		productBL.deleteProductLogically(2);
	}
	
	@Test
	public void findProductByIdTest(){
		productBL.findProductById(3);
	}
	
	@Test
	public void findAllProductTest(){
		List<Product> products = productBL.findAllProducts();
		for(Product product : products){
			System.out.println(product.getStrName());
		}
	}

}
