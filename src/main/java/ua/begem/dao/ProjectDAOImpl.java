package ua.begem.dao;


import ua.begem.bl.Util;
import ua.begem.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    private Connection connection = Util.getConnection();

    @Override
    public void add(Project project) throws SQLException {
        String sqlQuery = "INSERT INTO project (title) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, project.getTitle());

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
    public List<Project> getAll() throws SQLException {
        Statement statement = null;
        List<Project> result = new ArrayList<>();

        String sqlQuery = "SELECT * FROM project";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("id"));
                project.setTitle(resultSet.getString("title"));

                result.add(project);
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
    public Project getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Project project = new Project();

        String sqlQuery = "SELECT * FROM project WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
            }

            project.setId(resultSet.getLong("id"));
            project.setTitle(resultSet.getString("title"));

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
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        String sqlQuery = "UPDATE project SET title=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());

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
        String sqlQuery = "DELETE FROM project WHERE id=?";
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
