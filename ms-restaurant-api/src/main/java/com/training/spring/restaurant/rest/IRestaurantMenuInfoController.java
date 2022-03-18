package com.training.spring.restaurant.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.spring.restaurant.rest.models.Menu;
import com.training.spring.restaurant.rest.models.MenuInfoPrice;

public interface IRestaurantMenuInfoController {

    @PostMapping("/api/v1/restaurant/menu/price")
    public MenuInfoPrice getMenuPrice(@RequestBody final Menu menu);

}
