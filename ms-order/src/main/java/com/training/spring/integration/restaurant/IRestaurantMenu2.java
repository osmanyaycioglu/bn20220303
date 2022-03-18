package com.training.spring.integration.restaurant;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.spring.restaurant.rest.models.Menu;
import com.training.spring.restaurant.rest.models.MenuInfoPrice;

// @FeignClient("RESTAURANT")
public interface IRestaurantMenu2 {

    @PostMapping("/api/v1/restaurant/menu/price")
    public MenuInfoPrice xyz(@RequestBody final Menu menu);
}
