package com.chris.springdb.controller;

import com.chris.springdb.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chris on 2017/11/13.
 */
@Controller
@RequestMapping("/connectdb")
public class ConnecrDBController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "savePerson", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<String> savePerson(HttpServletRequest httpServletRequest,@RequestHeader("Host") String host,@RequestParam String username, @RequestParam String phone, @RequestParam String addrss, @RequestParam String remark) {
        personService.savePerson(username, phone, addrss, remark);
        String token = httpServletRequest.getHeader("token");
        JSONObject json = new JSONObject();
        try {
            json.put("token", token);
            json.put("host", host);
            json.put("username", username);
            json.put("phone", phone);
            json.put("addrss", addrss);
            json.put("remark", remark);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ResponseEntity<String> responseEntity = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "v1.0", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> connectdb01(@RequestParam String name, @RequestParam String password) throws JsonProcessingException {
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
