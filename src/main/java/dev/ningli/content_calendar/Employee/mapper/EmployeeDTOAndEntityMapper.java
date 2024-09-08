package dev.ningli.content_calendar.Employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.ningli.content_calendar.Employee.EmployeeDTO;
import dev.ningli.content_calendar.Employee.EmployeeEntity;


import java.util.List;

@Mapper
public interface EmployeeDTOAndEntityMapper {
    EmployeeDTOAndEntityMapper INSTANCE = Mappers.getMapper( EmployeeDTOAndEntityMapper.class );

    EmployeeEntity toEntity (EmployeeDTO employeeDTO);

    EmployeeDTO toDto (EmployeeEntity employeeEntity);

    List<EmployeeEntity> toEntityList (List<EmployeeDTO> employeeDTOs);

    List<EmployeeDTO> toDtoList (List<EmployeeEntity> employeeEntities);
}
