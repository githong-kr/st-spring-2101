package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired ApplicationContext ctx;

    @GetMapping
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");

        ArrayList<String> list = new ArrayList<>();
        for( String bean : ctx.getBeanDefinitionNames() ) {
            list.add(bean);
        }

        mv.addObject("beans", list);

        return mv;
    }
}
