package dev.ningli.content_calendar.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> findById(Integer id){
        return employeeRepository.findById(id);
    }

}
