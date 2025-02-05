package dev.ningli.content_calendar.Database.JDBCTemplate;

import dev.ningli.content_calendar.Employee.EmployeeEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JDBCTemplateService {

    private final JdbcTemplate jdbcTemplate;

    public JDBCTemplateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EmployeeEntity> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees", (resultSet, rowNum) -> {
            var e = new EmployeeEntity();
            e.setEmail(resultSet.getString("email"));
            // To be finished
            return e;
        });
    }
}
