package com.training.spring.integration.restaurant;


import org.springframework.cloud.openfeign.FeignClient;

import com.training.spring.restaurant.rest.IRestaurantMenuInfoController;

@FeignClient("RESTAURANT")
public interface IRestaurantMenu extends IRestaurantMenuInfoController {

}
