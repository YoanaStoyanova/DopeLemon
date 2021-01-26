package org.playground.dopelemon.controller;

import org.playground.dopelemon.model.Student;
import org.playground.dopelemon.model.Teacher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "register")
public class RegistrationController {

    @PostMapping(path = "student")
    public void registerStudent(@RequestParam @Valid Student student) {

    }

    public void registerTeacher(@RequestParam @Valid Teacher teacher) {

    }
}
