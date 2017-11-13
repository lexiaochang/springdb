package com.chris.springdb.controller;

import com.chris.springdb.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chris on 2017/11/13.
 */
@Controller
@RequestMapping("/connectdb")
public class ConnecrDBController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "savePerson", method = RequestMethod.GET)
    @ResponseBody
    public String savePerson(){
        personService.savePerson();
        return "success!";
    }

    @RequestMapping(value = "v1.0", method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        return "successfully";
    }

}
