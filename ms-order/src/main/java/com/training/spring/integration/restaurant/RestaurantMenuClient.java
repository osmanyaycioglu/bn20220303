package com.training.spring.integration.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.rest.models.OrderRest;
import com.training.spring.restaurant.rest.models.Menu;
import com.training.spring.restaurant.rest.models.MenuInfoPrice;

@Service
public class RestaurantMenuClient {

    @Autowired
    private IRestaurantMenu restaurantMenu;

    public Long getPrice(final OrderRest orderRestParam,
                         final Long personId) {
        Menu menuLoc = new Menu();
        menuLoc.setPersonId(personId);
        menuLoc.setMeals(orderRestParam.getMeals());
        MenuInfoPrice menuPriceLoc = this.restaurantMenu.getMenuPrice(menuLoc);
        return menuPriceLoc.getPrice();
    }

}
