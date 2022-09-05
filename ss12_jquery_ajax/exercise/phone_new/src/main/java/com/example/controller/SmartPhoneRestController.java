package com.example.controller;

import com.example.model.SmartPhone;
import com.example.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("phone")
public class SmartPhoneRestController {
    @Autowired
    private ISmartPhoneService service;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> findAll(){
        Iterable<SmartPhone> phonePage = service.findAll();
        return new ResponseEntity<>(phonePage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBlog(@RequestBody SmartPhone phone){
        Iterable<SmartPhone> phonePage = service.findAll();
        service.save(phone);
        return new ResponseEntity<>(phonePage,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody SmartPhone phone){
        service.update(phone);
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id ){
        Optional<SmartPhone> phone = service.findById(id);
        if(!phone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<SmartPhone> phone = service.findById(id);
        if(phone == null){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }
}
