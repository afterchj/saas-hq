package com.maidi.saas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 2020/6/15 15:59
 * @Created by hjchen
 */

@RestController
public class HomeController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${server.port}")
    private Integer port;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "current profiles is " + profile + ",server port is " + port;
    }
}
