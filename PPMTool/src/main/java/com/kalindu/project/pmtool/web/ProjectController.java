package com.kalindu.project.pmtool.web;

import com.kalindu.project.pmtool.domain.Project;
import com.kalindu.project.pmtool.exceptions.ProjectIdException;
import com.kalindu.project.pmtool.services.MapValidationErrorService;
import com.kalindu.project.pmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
            return  mapValidationErrorService.mapValidationError(result);
        }
        Project project1 =projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

    @GetMapping("{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project =projectService.findProjectByIdentifier(projectId.toUpperCase());

        if(project==null){
            throw  new ProjectIdException("Project ID '"+projectId+"' not exists");
        }
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Project> findAllProjects(){

        return projectService.findAllProjects();
    }
}
