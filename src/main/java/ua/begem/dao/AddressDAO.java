package ua.begem.dao;


import ua.begem.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    // create
    void add(Address address) throws SQLException;

    // read
    List<Address> getAll() throws SQLException;

    Address getById(Long id) throws SQLException;

    // update
    void update(Address address) throws SQLException;

    // delete
    void delete(Long id) throws SQLException;
}
