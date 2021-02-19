package ua.begem.service;

import ua.begem.dao.ProjectDAO;
import ua.begem.entity.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public void add(Project project) {
        try {
            projectDAO.add(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getAll() {
        try {
            return projectDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Project getById(Long id) {
        try {
            return projectDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Project project) {
        try {
            projectDAO.update(project);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            projectDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
