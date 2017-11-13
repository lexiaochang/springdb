package com.chris.springdb.controller;

import com.chris.springdb.model.TestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    /*
    * 初识get，post请求
    * */
    @RequestMapping(value = "v1.0", method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        return "successfully";
    }

    /*
    **Api~等都为注解
    */
    @ApiOperation(value = "用户登录注册2", notes = "用户2", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "customer/login", method = RequestMethod.POST)
    public String foo2(@ApiParam(value = "用户名", required = true) @RequestParam String name) {
        return name;
    }

    /*@ResponseBody String name 会打印整个post内容 用&分开
    * http://10.11.26.27:8080/user/test01?name=aaa&password=bbb
    * */
    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    @ResponseBody
    public String test01(@RequestParam String name, @RequestParam String password) {

        return name + "]]]]" + password;
    }

    /*
    **http://10.11.26.27:8080/user/test02
    * */
    @RequestMapping(value = "/test02", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> test02(@RequestParam String name, @RequestParam String password) throws JsonProcessingException {
        JSONObject json = new JSONObject();
        try {
            json.put("success", password);
            json.put("message", name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ResponseEntity<String> re = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        return re;
    }


    @RequestMapping(value = "/test03", method = RequestMethod.POST)
    @ResponseBody
    public TestModel test03(@RequestParam String name, @RequestParam String password) {
        TestModel testModel = new TestModel(name, password);
        return testModel;
    }


}
