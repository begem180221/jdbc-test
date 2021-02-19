package ua.begem.service;


import ua.begem.dao.AddressDAO;
import ua.begem.entity.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDAO addressDAO;

    public AddressServiceImpl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public void add(Address address) {
        try {
            addressDAO.add(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Address> getAll() {
        try {
            return addressDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address getById(Long id) {
        try {
            return addressDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Address address) {
        try {
            addressDAO.update(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            addressDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
