package com.chris.springdb.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris on 2017/11/10.
 */
@Api(value = "user", description = "用户", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/user")
public class TestController {

    @RequestMapping(value = "v1.0",method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        return "successfully";
    }

    @ApiOperation(value = "用户登录注册2", notes = "用户2", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "customer/login", method = RequestMethod.POST)
    public String foo2(@ApiParam(value = "用户名", required = true) @RequestParam String name) {
        return name;
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody String data){

        return data;
    }
}
