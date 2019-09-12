package com.fairyt.base.controller;

import com.fairyt.base.model.DemoModel;
import com.fairyt.base.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private DemoService service;

    @GetMapping("/list")
    public List<DemoModel> list(){
        return service.list();
    }
}
