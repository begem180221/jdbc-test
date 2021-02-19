package ua.begem.service;


import ua.begem.entity.Address;

import java.util.List;

public interface AddressService {

    void add(Address address);

    List<Address> getAll();

    Address getById(Long id);

    void update(Address address);

    void delete(Long id);


}
