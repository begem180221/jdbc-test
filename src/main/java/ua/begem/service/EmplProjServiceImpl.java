package ua.begem.service;

import ua.begem.dao.EmplProjDAO;
import ua.begem.entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public class EmplProjServiceImpl implements EmplProjService {
    private EmplProjDAO emplProjDAO;

    public EmplProjServiceImpl(EmplProjDAO emplProjDAO) {
        this.emplProjDAO = emplProjDAO;
    }

    @Override
    public void add(EmplProj emplProj) {
        try {
            emplProjDAO.add(emplProj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmplProj> getAll() {
        try {
            return emplProjDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) {
        try {
            return emplProjDAO.getByEmployeeIdAndProjectId(employeeId, projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(EmplProj emplProj) {
        try {
            emplProjDAO.update(emplProj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long employeeId, Long projectId) {
        try {
            emplProjDAO.delete(employeeId, projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
