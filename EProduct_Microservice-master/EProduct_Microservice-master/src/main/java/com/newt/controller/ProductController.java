package com.newt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import com.newt.model.Product;
import com.newt.service.ProductService;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@CrossOrigin
@RestController
@RequestMapping("/products")
@EnableSwagger2
@Api(value = "product", description = "RESTful API to interact with product resources.")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "search/id/{productId}", method = RequestMethod.GET,  produces = "application/json")
	@ApiOperation(value = "Find By ProductID",responseContainer="Product",response = Product.class)
	public Product findbyproductId(@PathVariable int productId) {
		
		return productService.findByproductId(productId);
	}

	@RequestMapping(value = "search/name/{productName}", method = RequestMethod.GET)
	@ApiOperation(value = "Find By ProductName",responseContainer="Product",response = Product.class)
	public Product findbyproductName(@PathVariable String productName) {
		return productService.findByProductName(productName);
	}
		
	@RequestMapping(method = RequestMethod.GET)
        @ApiOperation(value = "Find all products",responseContainer="List",response = List.class)
	public List<Product> findAll() {
		Iterable iter=productService.findAll();
                List li=(List)iter;
                System.out.println(li);
                
                return li;
	}

	@ApiOperation(value = "post a product",responseContainer="Product",response = Product.class)
	@RequestMapping(method = RequestMethod.POST)
	public Product create(@RequestBody Product car) {
		return productService.save(car);
	}
}

