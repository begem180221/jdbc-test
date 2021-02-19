package ua.begem.dao;


import ua.begem.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    // create
    void add(Employee employee) throws SQLException;

    // read
    List<Employee> getAll() throws SQLException;

    Employee getById(Long id) throws SQLException;

    // update
    void update(Employee employee) throws SQLException;

    // delete
    void delete(Long id) throws SQLException;
}
