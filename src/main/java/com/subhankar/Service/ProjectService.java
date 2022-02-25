package com.subhankar.Service;

import com.subhankar.Domain.Project;
import com.subhankar.Exceptions.ProjectIdException;
import com.subhankar.Exceptions.ProjectNotFoundException;
import com.subhankar.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.awt.print.PrinterAbortException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project, BindingResult result){

        try{
            project.setProjectIdentifier(project.getProjectIdentifier());
            return projectRepository.save(project);
        }catch (Exception e) {
            throw new ProjectIdException("Project ID Already Exists");
        }
    }
    public Project findByProjectId(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid);
        if(project==null){
            throw new ProjectNotFoundException("Project Not Found");
        }
        else {
            return project;
        }
    }

    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Map<String, String> deleteProject(String projectId) {
        Map<String, String> deleteResponse = new HashMap<>();
        Project project = findByProjectId(projectId);
        projectRepository.delete(project);
        deleteResponse.put(projectId,"Project with the given Project Id Deleted Successfully");
        return deleteResponse;
    }

}
