package com.chris.springdb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris on 2017/11/13.
 */
@Controller
@RequestMapping("/connectdb")
public class ConnecrDBController {

    @RequestMapping(value = "/v1.0", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> connectdbv1(@RequestParam String name, @RequestParam String password) throws JsonProcessingException {
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


}
