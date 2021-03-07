package com.example.demo.part.com.controller;


import com.example.demo.entity.Tmp;
import com.example.demo.repo.jpa.TmpRepo;
import com.example.fwk.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/tmps")
public class TmpController extends BaseController {

    @Autowired
    TmpRepo repo;

    @GetMapping
    public ArrayList<Tmp> getAll() {

        Iterable<Tmp> it = repo.findAll();
        Iterator<Tmp> iterator = it.iterator();

        // 1
        ArrayList<Tmp> list = new ArrayList<>();
        while(iterator.hasNext()) {
            list.add(iterator.next());
        }
//
//        // 2
//        it.forEach(tmp -> {
//            list.add(tmp);
//        });

        return list;
    }
}
