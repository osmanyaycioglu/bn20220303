package com.training.spring.integration.restaurant;


import org.springframework.cloud.openfeign.FeignClient;

import com.training.spring.restaurant.rest.IRestaurantMenuInfoController;

@FeignClient("RESTAURANT-CORE-APIGW")
public interface IRestaurantMenu extends IRestaurantMenuInfoController {

}
