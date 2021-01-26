package org.playground.dopelemon.service;

import org.playground.dopelemon.model.Student;
import org.playground.dopelemon.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.saveAndFlush(student);
    }
}
