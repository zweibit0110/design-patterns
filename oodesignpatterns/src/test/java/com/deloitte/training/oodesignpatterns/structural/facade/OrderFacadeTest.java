package com.deloitte.training.oodesignpatterns.structural.facade;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class OrderFacadeTest {
    
    private OrderFacade facade;
    
    @Before
    public void initFacade() {
        facade = new OrderFacade(new OrderService(), new InventoryService(), new DeliveryService(), new PaymentService());
    }
    
    @Test
    public void processOrder() {
        String orderId = "123";
        
        String result = facade.placeOrder(orderId);
        
        assertThat(result, allOf(
                containsString("-------------------------"),
                containsString("processing order"),
                containsString("inventory was checked"),
                containsString("delivery has been assigned"),
                containsString("payment has been done"),
                containsString("has been placed"),
                containsString(orderId)
        ));
        
    }
    
}
