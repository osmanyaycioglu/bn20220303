package com.training.spring.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/first")
public class FirstRest {

    // /first/hello1/osman/yay ----> GET
    @GetMapping("/hello1/{abc}/{xyz}")
    public String hello(@PathVariable("abc") final String name,
                        @PathVariable("xyz") final String surname) {
        return "hello " + name + " " + surname;
    }

    // /first/hello2?abc=osman&xyz=yay ----> GET
    @GetMapping("/hello2")
    public String hello2(@RequestParam("abc") final String name,
                         @RequestParam("xyz") final String surname) {
        return "hello " + name + " " + surname;
    }

    // /first/hello3/osman?xyz=yay ----> GET
    @GetMapping("/hello3/{abc}")
    public String hello3(@PathVariable("abc") final String name,
                         @RequestParam("xyz") final String surname) {
        return "hello " + name + " " + surname;
    }

    @PostMapping("/hello4")
    public String hello4(@RequestBody final Person personParam) {
        return "hello " + personParam;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestHeader("abc") final String name,
                         @RequestHeader("xyz") final String surname) {
        return "hello 5 " + name + " " + surname;
    }


    // /first/hello ----> GET
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String helloGET() {
        return "hello GET";
    }

    @PostMapping("/hello")
    public String helloPOST() {
        return "hello POST";
    }

    @PutMapping("/hello")
    public String helloPUT() {
        return "hello PUT";
    }

    @PatchMapping("/hello")
    public String helloPATCH() {
        return "hello PATCH";
    }

    @DeleteMapping("/hello")
    public String helloDELETE() {
        return "hello DELETE";
    }

}
