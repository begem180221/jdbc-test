package ua.begem.dao;


import ua.begem.bl.Util;
import ua.begem.entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjDAOImpl implements EmplProjDAO {
    private Connection connection = Util.getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        String sqlQuery = "INSERT INTO empl_proj (employee_id, project_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

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
    public List<EmplProj> getAll() throws SQLException {
        Statement statement = null;
        List<EmplProj> result = new ArrayList<>();

        String sqlQuery = "SELECT * FROM empl_proj";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("employee_id"));
                emplProj.setProjectId(resultSet.getLong("project_id"));

                result.add(emplProj);
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
    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException {
        PreparedStatement preparedStatement = null;
        EmplProj emplProj = new EmplProj();

        String sqlQuery = "SELECT * FROM empl_proj WHERE employee_id=? AND project_id=?";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("employee_id"));
            emplProj.setProjectId(resultSet.getLong("project_id"));

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
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
        String sqlQuery = "UPDATE empl_proj SET employee_id=?, project_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

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
    public void delete(Long employeeId, Long projectId) throws SQLException {
        String sqlQuery = "DELETE FROM empl_proj WHERE employee_id=? AND proj_id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(1, projectId);

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
