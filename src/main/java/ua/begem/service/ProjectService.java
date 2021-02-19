package ua.begem.service;


import ua.begem.entity.Project;

import java.util.List;

public interface ProjectService {

    void add(Project project);

    List<Project> getAll();

    Project getById(Long id);

    void update(Project project);

    void delete(Long id);
}
