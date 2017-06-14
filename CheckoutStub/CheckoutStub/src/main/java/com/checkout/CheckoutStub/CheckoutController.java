/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.checkout.CheckoutStub;
import io.swagger.client.api.CheckoutControllerApi;
import io.swagger.client.*;
import io.swagger.client.model.*;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author rajeshwariy
 */
@RestController
@RequestMapping("/checkout")
public class CheckoutController extends CheckoutControllerApi {
    
     @RequestMapping(value = "/addCheckoutDetails", method = RequestMethod.POST)
    @Override
    public String registerCustomerUsingPOST(ProductCheckoutDetails productcheckoutdtls) throws ApiException {
       String k="raji";
        if(productcheckoutdtls != null)
         {
             k=productcheckoutdtls.getCustomerName();
         }  
        return k;
    }
}
