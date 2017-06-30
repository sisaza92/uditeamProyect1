package com.accenture.training.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.training.bl.ProductBL;
import com.accenture.training.exeption.BLException;
import com.accenture.training.model.Product;

@Controller
public class ProductControllerImpl {

	public static final String VIEW_LIST = "findAllProductsView";
	public static final String VIEW_CREATE = "createProductView";
	public static final String VIEW_UPDATE = "updateProductView";
	public static final String VIEW_DELETE = "deleteProductView";

	public static final String PATH_LIST = "/products";
	public static final String PATH_FIND = "/findProducts";
	public static final String PATH_CREATE = "/createProduct";
	public static final String PATH_UPDATE = "/updateProduct";
	public static final String PATH_DELETE = "/deleteProduct";

	@Autowired
	ProductBL productBL;

	@RequestMapping(value = "/")
	public ModelAndView salude() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("greeting");
		modelAndView.addObject("message", "Mundooooo");
		
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = PATH_FIND)
	public ModelAndView findProductByTypeOrName(@RequestParam String nameProduct,@RequestParam Integer productType) {

		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = null;
		String message = "";
		try {
			products = productBL.findProductsByTypeOrName(productType, nameProduct);
		} catch (BLException e) {
			message = e.getMessage();
		}
		modelAndView.addObject("products", products);
		modelAndView.setViewName(VIEW_LIST);
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = PATH_LIST)
	public ModelAndView findAllProducts() {

		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = null;
		String message = "";
		try {
			products = productBL.findAllProducts();
		} catch (BLException e) {
			message = e.getMessage();
		}
		modelAndView.addObject("products", products);
		modelAndView.setViewName(VIEW_LIST);
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = PATH_CREATE)
	public ModelAndView createProduct() {

		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		String message = "";

		modelAndView.setViewName(VIEW_CREATE);
		modelAndView.addObject("product", product);
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = PATH_CREATE)
	public ModelAndView createProduct(@ModelAttribute(value = "product") Product product) {

		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		try {
			productBL.createProduct(product);
			modelAndView.setViewName("redirect:" + PATH_LIST);
		} catch (BLException e) {
			message = e.getMessage();
			modelAndView.setViewName(VIEW_CREATE);
		}
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = PATH_UPDATE + "/{idProduct}")
	public ModelAndView updateProduct(@PathVariable Integer idProduct) {

		ModelAndView modelAndView = new ModelAndView();
		Product product = null;
		String message = "";
		try {
			product = productBL.findProductById(idProduct);
		} catch (BLException e) {
			message = e.getMessage();
		}
		modelAndView.addObject("product", product);
		modelAndView.setViewName(VIEW_UPDATE);
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = PATH_UPDATE)
	public ModelAndView updateProduct(@ModelAttribute(value = "product") Product product) {

		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		try {
			productBL.updateProduct(product);
			modelAndView.setViewName("redirect:" + PATH_LIST);
		} catch (BLException e) {
			message = e.getMessage();
			modelAndView.setViewName(VIEW_UPDATE);
		}
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = PATH_DELETE + "/{idProduct}")
	public ModelAndView deleteProduct(@PathVariable Integer idProduct) {

		ModelAndView modelAndView = new ModelAndView();
		Product product = null;
		String message = "";
		try {
			productBL.deleteProductLogically(idProduct);
		} catch (BLException e) {
			message = e.getMessage();
		}
		modelAndView.addObject("product", product);
		modelAndView.setViewName("redirect:" + PATH_LIST);
		modelAndView.addObject("message", message);

		return modelAndView;
	}

}
