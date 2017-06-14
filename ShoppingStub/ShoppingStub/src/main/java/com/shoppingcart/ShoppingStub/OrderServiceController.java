package com.shoppingcart.ShoppingStub;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshwariy
 */
import java.util.*;
import io.swagger.client.*;
import io.swagger.client.model.*;
import io.swagger.client.api.OrderServiceControllerApi;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcart/OrderService")
public class OrderServiceController extends OrderServiceControllerApi
{
    private static List<ShoppingCart> shopingcartlist = new ArrayList();
    private static List<ShoppingCartItems> shopingcartitemslist = new ArrayList();
   static ShoppingCart p1,p2,p3;
   static ShoppingCartItems s1,s2;
 static
   {
       p1=new ShoppingCart();p1.setCustomerId(1);p1.setProductId(1);p1.setShoppingcartId(1);p1.setStatus("process");p1.setCreatedDate(new DateTime());
         p2=new ShoppingCart();p2.setCustomerId(2);p1.setProductId(2);p2.setShoppingcartId(2);p2.setStatus("delivered");p2.setCreatedDate(new DateTime());
          // p3=new ShoppingCart();
      shopingcartlist.add(p1 );
      shopingcartlist.add( p2);   
    //shopingcartlist.add(p3);
     s1 = new ShoppingCartItems();s1.setCustomerId(1);s1.setPrice(199f);s1.setProductDesc("easy to usew");s1.setProductId(1);s1.setProductName("mobile");
     s1.setShoppingcartId(1);s1.setShoppingcartitemsId(1);s1.setStatus("in process");
     
     s2 = new ShoppingCartItems();s2.setCustomerId(2);s2.setPrice(139f);s2.setProductDesc("simple usew");s2.setProductId(2);s2.setProductName("tv");
     s2.setShoppingcartId(2);s2.setShoppingcartitemsId(2);s1.setStatus("checked");
     shopingcartitemslist.add(s1);
          shopingcartitemslist.add(s2);
    }
  @Override
    @RequestMapping(value = "create/{customerId}/{customerName}/{productId}/{productName}/{price}/{productdesc}", method = RequestMethod.POST,produces = "application/json")
     public Map<String, String> createOrderUsingPOST(@PathVariable Integer customerId,@PathVariable String customerName,@PathVariable Integer productId,@PathVariable String productName,@PathVariable Float price,@PathVariable String productdesc) throws ApiException {
       HashMap<String, String> statusmsg = new HashMap<String,String>();
       statusmsg.put("totalcost",""+15000);
       return statusmsg;
    }
//     @RequestMapping(value = "deleteOrder/{shopcartItemsID}/{customerId}/{productId}", method = RequestMethod.DELETE, produces = "application/json")
//      public Map<String, String> deleteOrderUsingDELETE(@PathVariable Integer shopcartItemsID,@PathVariable Integer customerId,@PathVariable Integer productId) throws ApiException {
//        ApiResponse<Map<String, String>> resp = deleteOrderUsingDELETEWithHttpInfo(shopcartItemsID, customerId, productId);
//        return resp.getData();
//    }
      @Override
      @RequestMapping(value = "get/shoppingcart/{shopcartId}", method = RequestMethod.GET,produces = "application/json")
 public ShoppingCart getByShopcartIdUsingGET(@PathVariable Integer shopcartId) throws ApiException {
        p1.setShoppingcartId(shopcartId);
        return p1;
    }
  @Override
 @RequestMapping(value = "get/{shopcartItmId}", method = RequestMethod.GET,produces = "application/json")
 public ShoppingCartItems getOrderUsingGET(@PathVariable Integer shopcartItmId) throws ApiException {
        s1.setShoppingcartId(shopcartItmId);
        return s1;
    }
  @Override
 @RequestMapping(value = "get/productList/{customerId}", method = RequestMethod.GET,produces = "application/json")
 public List<ShoppingCartItems> orderCheckoutUsingGET(@PathVariable Integer customerId) throws ApiException {
        return shopingcartitemslist;
    }
}
