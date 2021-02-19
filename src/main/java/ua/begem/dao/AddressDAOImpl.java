package ua.begem.dao;


import ua.begem.bl.Util;
import ua.begem.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    private Connection connection = Util.getConnection();

    @Override
    public void add(Address address) throws SQLException {

        String sqlQuery = "INSERT INTO address (country, city, street, post_code) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());

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
    public List<Address> getAll() throws SQLException {
        Statement statement = null;
        List<Address> result = new ArrayList<>();

        String sqlQuery = "SELECT * FROM address";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("post_code"));

                result.add(address);
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
    public Address getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Address address = new Address();

        String sqlQuery = "SELECT * FROM address WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
            }

            address.setId(resultSet.getLong("id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setPostCode(resultSet.getString("post_code"));



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
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {

        String sqlQuery = "UPDATE address SET country=?, city=?, street=?, post_code=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

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

        String sqlQuery = "DELETE FROM address WHERE id=?";
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
