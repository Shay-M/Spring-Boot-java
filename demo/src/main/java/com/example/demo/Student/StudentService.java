package com.example.demo.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// @Component for semantics we use:
@Service
public class StudentService {

    public List<Student> getStudent() {
        return List.of(
                new Student(
                        1L,
                        "name",
                        "email@happy",
                        LocalDate.of(2000, 12, 10)
                        , 21
                )
        );
    }
}
