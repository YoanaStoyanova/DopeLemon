package org.playground.dopelemon.controller;

import org.playground.dopelemon.model.Student;
import org.playground.dopelemon.service.EmailService;
import org.playground.dopelemon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;

    @PostMapping(consumes = "application/json")
    public void addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        try {
            emailService.sendInvitationLink(student);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
