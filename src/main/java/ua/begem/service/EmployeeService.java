package ua.begem.service;


import ua.begem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    void update(Employee address);

    void delete(Long id);
}
