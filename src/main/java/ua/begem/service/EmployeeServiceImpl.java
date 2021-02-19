package ua.begem.service;

import ua.begem.dao.EmployeeDAO;
import ua.begem.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void add(Employee employee) {
        try {
            employeeDAO.add(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        try {
            return employeeDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getById(Long id) {
        try {
            return employeeDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
        try {
            employeeDAO.update(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            employeeDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
