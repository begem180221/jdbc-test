package ua.begem.dao;


import ua.begem.entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjDAO {
    // create
    void add(EmplProj emplProj) throws SQLException;

    // read
    List<EmplProj> getAll() throws SQLException;

    EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException;

    // update
    void update(EmplProj emplProj) throws SQLException;

    // delete
    void delete(Long employeeId, Long projectId) throws SQLException;
}
