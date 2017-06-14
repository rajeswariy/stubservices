package com.shoppingcart.ShoppingStub;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import io.swagger.client.api.ProductControllerApi;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.client.model.*;
import java.util.*;
import io.swagger.client.*;

/**
 *
 * @author rajeshwariy
 */
@RestController
 @RequestMapping(value= "/products")
public class ProductController extends ProductControllerApi
{
    private static List<Product> products = new ArrayList();
   static Product p1,p2,p3;
 static
   {
       p1=new Product();p1.setProductId(1);p1.setProductName("laptap");p1.setProductPrice(30000f);
         p2=new Product();p2.setProductId(2);p2.setProductName("mobile");p2.setProductPrice(25000f);
           p3=new Product();p3.setProductId(3);p3.setProductName("tv");p3.setProductPrice(10000f);
          
      products.add( p2);   
    products.add(p3);
   
     
    }
    
   
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public List<Product> findAll() throws ApiException 
    {
        //List list=(List)products;
         return products;
    }
      @Override
      @RequestMapping(value = "search/id/{productId}", method = RequestMethod.GET,  produces = "application/json")
    public Product findbyproductIdUsingGET(@PathVariable Integer productId) throws ApiException {
       p1.setProductId(productId);
        return p1;
    }
          @Override
          @RequestMapping(value = "search/name/{productName}", method = RequestMethod.GET)
	public Product findbyproductNameUsingGET(@PathVariable String productName) throws ApiException {
           p2.setProductName(productName);
        return p2;
    }
        
   

}
