package dev.ningli.content_calendar.Student.controller;

import java.util.ArrayList;
import java.util.List;

import dev.ningli.content_calendar.Student.entity.StudentRecord;
import dev.ningli.content_calendar.Student.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final List<StudentRecord> students = new ArrayList<>();
    @PostConstruct
    private void loadStudent(){
        students.add(new StudentRecord("John", "Doe"));
        students.add(new StudentRecord("Mikey", "Mouse"));
        students.add(new StudentRecord("Tom", "Cat"));
        students.add(new StudentRecord("Use", "Record"));
    }

    @GetMapping("/api/students")
    public List<StudentRecord> getAllStudents() {
        return students;
    }

    @GetMapping("/api/students/{studentId}")
    public StudentRecord getStudentById(@PathVariable Integer studentId)  {

        if(studentId > students.size() || studentId < 0) {
            throw new StudentNotFoundException("The student with id " + studentId + " does not exist");
        }
        return students.get(studentId);
    }

}
