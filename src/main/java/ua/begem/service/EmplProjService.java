package ua.begem.service;


import ua.begem.entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjService {

    void add(EmplProj emplProj);

    List<EmplProj> getAll();

    EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    void update(EmplProj emplProj);

    void delete(Long employeeId, Long projectId);
}
