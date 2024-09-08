package dev.ningli.content_calendar.Employee;

import dev.ningli.content_calendar.Employee.mapper.EmployeeDTOAndEntityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<EmployeeDTO> getEmployees() {
        return EmployeeDTOAndEntityMapper
                .INSTANCE
                .toDtoList(employeeService.findAll());
    }

    @GetMapping("/api/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
        Optional<EmployeeEntity> employee = employeeService.findById(id);

        return employee.map(EmployeeDTOAndEntityMapper.INSTANCE::toDto).orElse(null);
    }

}
