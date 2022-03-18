package com.training.spring.integration.person;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PERSON")
public interface IHello {

    @GetMapping("/first/hello1/{abc}/{xyz}")
    public ResponseEntity<String> abc(@PathVariable("abc") final String name,
                                      @PathVariable("xyz") final String surname);

    @GetMapping("/first/hello2")
    public String hello2(@RequestParam("abc") final String name,
                         @RequestParam("xyz") final String surname);


}
