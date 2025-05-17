package com.example.PasswordManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PasswordManager.model.Credential;
import com.example.PasswordManager.service.PasswordService;
import java.util.*;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordService passwordService ;

    @PostMapping("/save")
    public String saveCredential(
            @RequestParam String username ,
            @RequestParam String service ,
            @RequestParam String password) {
        passwordService.saveCredential(username , service , password );
        return "Password saved succesfully";
    }

    @GetMapping("/get")
    public String getPassword(@RequestParam String username , @RequestParam String service) {
        return passwordService.getPassword(username , service);
    }

    @GetMapping("/all")
    public List<Credential> getAllCredential() {
    	return new ArrayList<>(passwordService.getAllCredential());
    }
}