package dev.ningli.content_calendar.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/employees")
public class EmployeeController {


    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return null;
    }
}
