/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.CustomerStub;
import org.joda.time.DateTime;
import io.swagger.client.api.CustomerControllerApi;
import org.springframework.web.bind.annotation.*;
import io.swagger.client.model.Customer;
import java.util.Date;
import io.swagger.client.*;
import java.time.Instant;
import java.util.*;
/**
 *
 * @author rajeshwariy
 */
@RestController
@RequestMapping("/customer")
public class CustomerStubController extends CustomerControllerApi{
    
    private static List<Customer> customers = new ArrayList();
   static Customer p1,p2,p3;
 static
   {
       p1=new Customer();
         p1.setAddress1("add1");p1.setAddress2("add2");p1.setAge(15);p1.setCity("Kmm");p1.country("india");
         p1.setCustomerEmail("raji@");p1.setCustomerId(11);p1.setCustomerName("tt");p1.setDob(new DateTime());
         p1.setFirstName("rr");p1.setLastName("hhc");p1.setPassword("34eff");p1.setPhone("2133223");p1.setPincode("21332");
         p1.setState("tela");p1.setStatus("progress");
         
         p2=new Customer();
         p2.setAddress1("add1");p2.setAddress2("add2");p2.setAge(15);p2.setCity("Kmm");p2.country("india");
         p2.setCustomerEmail("raji@");p2.setCustomerId(11);p2.setCustomerName("tt");p2.setDob(new DateTime());
         p2.setFirstName("rr");p2.setLastName("hhc");p2.setPassword("34eff");p2.setPhone("2133223");p2.setPincode("21332");
         p2.setState("tela");p2.setStatus("progress");
         
           p3=new Customer();
        customers.add(p1 );
        customers.add( p2);   
        customers.add(p3);
   
     
    }
    @Override
        @RequestMapping(value = "/byname/{customerName}", method = RequestMethod.GET, produces = "application/json")
    public Customer findCustomerbyFirstNameUsingGET(@PathVariable String customerName) throws ApiException {
        p1.setFirstName(customerName);
        return p1;
    }

    
      @Override
        @RequestMapping(value = "/login/{username:.+}", method = RequestMethod.GET, produces = "application/json")
     public Customer findCustomerbyUsernameUsingGET(@PathVariable String username) throws ApiException {
        p1.setUsername(username);
        return p1;
    }
       @Override
       @RequestMapping(value = "/allcustomers", method = RequestMethod.GET, produces = "application/json")
     public List<Customer> listCustomersUsingGET() throws ApiException {
       return customers;
    }
       @Override
       @RequestMapping(value = "/add", method = RequestMethod.POST)
     public Customer registerCustomerUsingPOST(@RequestBody Customer customer) throws ApiException {
        return customer;
    }
       @Override
        @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
     public Customer findCustomerbyIDUsingGET(@PathVariable Integer id) throws ApiException {
       p1.setCustomerId(id);
       return p1;
    }
    
}
