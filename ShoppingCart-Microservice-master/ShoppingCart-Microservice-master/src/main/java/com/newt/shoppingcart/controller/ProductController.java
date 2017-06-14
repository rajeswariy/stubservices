package com.newt.shoppingcart.controller;

import javax.mail.Multipart;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.newt.shoppingcart.model.Product;
import com.newt.shoppingcart.repository.ProductRepository;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import java.util.List;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/shoppingcart/product")
@EnableSwagger2
@Api(value = "product", description = "RESTful API to interact with product resources.")
public class ProductController {
	
	@Autowired
	ProductRepository productRepo;
	
	
	@RequestMapping(value = "search/id/{productId}", method = RequestMethod.GET)
	@ApiOperation(value = "Find By ProductID",responseContainer="Product",response = Product.class)
	public Product findbyproductId(@PathVariable int productId) {
		return productRepo.findByProductId(productId);
	}

	@RequestMapping(value = "search/name/{productName}", method = RequestMethod.GET)
	@ApiOperation(value = "Find By ProductName",responseContainer="Product",response = Product.class)
	public Product findbyproductName(@PathVariable String productName) {
		return productRepo.findByproductName(productName);
	}

	@RequestMapping(method = RequestMethod.GET)
        @ApiOperation(value = "Find all products",responseContainer="List",response = List.class)
	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}

        @ApiOperation(value = "post a product",responseContainer="Product",response = Product.class)
	@RequestMapping(method = RequestMethod.POST)
	public Product create(@RequestBody Product car) {
		return productRepo.save(car);
	}

}
