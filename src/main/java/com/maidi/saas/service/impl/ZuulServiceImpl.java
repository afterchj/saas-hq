package com.maidi.saas.service.impl;

import com.maidi.saas.service.ZuulUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hjchen.chen on 2020/6/4.
 */

@Service
public class ZuulServiceImpl implements ZuulUserService {

    @Autowired
    private ZuulUserService zuulUserService;

    public String getAllUser() {
        return zuulUserService.getAllUser();
    }
}
