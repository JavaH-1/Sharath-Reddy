package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Person;

@Controller
public class PersonController {

    @GetMapping("/person")
    public String showForm(Model model) {
        model.addAttribute("person", new Person()); 
        return "person-form"; 
    }

    @PostMapping("/person")
    public String handleForm(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("emailId") String emailId,
            @RequestParam("bloodGroup") String bloodGroup,
            Model model) {

        Person person = new Person(name, age, phoneNumber, emailId, bloodGroup);
        model.addAttribute("person", person);
        return "person-details"; 
    }
}
