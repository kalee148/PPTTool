package com.kalindu.project.pmtool.services;


import com.kalindu.project.pmtool.domain.Project;
import com.kalindu.project.pmtool.exceptions.ProjectIdException;
import com.kalindu.project.pmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw  new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectIdentifier){
        return  projectRepository.findByProjectIdentifier(projectIdentifier);
    }

    public Iterable<Project> findAllProjects(){

        return  projectRepository.findAll();
    }
}
