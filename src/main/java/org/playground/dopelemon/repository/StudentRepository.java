package org.playground.dopelemon.repository;

import org.playground.dopelemon.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findById(Integer studentId);

    Student saveAndFlush(Student student);

}
