package com.baizhi.controller;


import com.baizhi.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poem")
public class PoemController {
    @Autowired
    private PoemService poemService;


    @RequestMapping("/findAll")
    public List<Object> findAll(String key) throws Exception {
        List<Object> objects = poemService.queryAll(key);
        return objects;
    }


}
