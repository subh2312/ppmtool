package com.subhankar.Controller;


import com.subhankar.Domain.Project;

import com.subhankar.Service.ProjectService;
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
@CrossOrigin
public class projectController {

    @Autowired
    private ProjectService projectService;
    private Map<String,String > errors= new HashMap<>();

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        if(result.hasErrors()){
            for (FieldError err : result.getFieldErrors()){
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        try {
            return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project, result), HttpStatus.CREATED);
        }catch (Exception e){
            errors.put(project.getProjectIdentifier(),e.getMessage());
        }
        return  new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createNewProject(@PathVariable(name = "id") long id,@Valid @RequestBody Project project, BindingResult result){

        if(result.hasErrors()){
            for (FieldError err : result.getFieldErrors()){
                errors.put(err.getField(), err.getDefaultMessage());
            }
        }
        try {
            return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project, result), HttpStatus.CREATED);
        }catch (Exception e){
            errors.put(project.getProjectIdentifier(),e.getMessage());
        }
        return  new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/{projectid}")
    public ResponseEntity<?> getByProjectId(@PathVariable(name = "projectid")String projectid){
        try {
            return new ResponseEntity<Project>(projectService.findByProjectId(projectid), HttpStatus.OK);
        }catch (Exception e){
            errors.put(projectid,e.getMessage());
            return  new ResponseEntity<Map<String,String>>(errors, HttpStatus.OK);

        }

    }

    @GetMapping("")
    public Iterable<Project> getAllProject(){
            return  projectService.getAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable(name = "projectId")String projectId){

            return  new ResponseEntity<Map<String,String>>(projectService.deleteProject(projectId), HttpStatus.OK);

    }

}
