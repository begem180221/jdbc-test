package ua.begem.dao;


import ua.begem.bl.Util;
import ua.begem.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection = Util.getConnection();

    @Override
    public void add(Employee employee) throws SQLException {

        String sqlQuery = "INSERT INTO employee (first_name, last_name, birthday, address_id) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Employee> getAll() throws SQLException {
        Statement statement = null;
        List<Employee> result = new ArrayList<>();

        String sqlQuery = "SELECT * FROM employee";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressId(resultSet.getLong("address_id"));

                result.add(employee);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return result;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Employee employee = new Employee();

        String sqlQuery = "SELECT * FROM employee WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
            }

            employee.setId(resultSet.getLong("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressId(resultSet.getLong("address_id"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {

        String sqlQuery = "UPDATE employee SET first_name=?, last_name=?, birthday=?, address_id=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());
            preparedStatement.setLong(5, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void delete(Long id) throws SQLException {

        String sqlQuery = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
