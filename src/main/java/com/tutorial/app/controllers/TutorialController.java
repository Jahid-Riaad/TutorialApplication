package com.tutorial.app.controllers;

import com.tutorial.app.exceptionHandles.TutorialAlreadyExistsException;
import com.tutorial.app.exceptionHandles.TutorialNotFoundException;
import com.tutorial.app.models.Tutorial;
import com.tutorial.app.repositories.TutorialRepository;
import com.tutorial.app.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialService tutorialService;

    //Create Tutorial
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> saveTutorial(@RequestBody Tutorial tutorial) throws TutorialAlreadyExistsException {

        Tutorial savedTutorial = null;
        try {
            savedTutorial = tutorialService.saveTutorial(tutorial);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<>(savedTutorial, HttpStatus.CREATED);
    }


    //Get all tutorials
    @GetMapping("/tutorials")
    public ResponseEntity<List> getTutorialList() throws TutorialNotFoundException {

        return new ResponseEntity<List>((List) tutorialService.getAllTutorial(), HttpStatus.OK);

    }


    //Get individual tutorial
    @GetMapping("/tutorials/{id}")
    public ResponseEntity getTutorialBylId(@PathVariable("id") int id) throws TutorialNotFoundException {
        return new ResponseEntity(tutorialService.findTutorialById(id), HttpStatus.OK);
    }


    //Update tutorial by ID
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorialById(@PathVariable("id") int id, @RequestBody Tutorial tutorial) throws TutorialAlreadyExistsException {

        Tutorial getTutorial = tutorialService.findTutorialById(id);

        getTutorial.setDescription(tutorial.getDescription());
        getTutorial.setPublished(tutorial.getPublished());
        getTutorial.setTitle(tutorial.getTitle());

        Tutorial updatedTutorial = null;

        try {
            updatedTutorial = tutorialRepository.save(getTutorial);
        } catch (Exception e) {
            System.out.println(e);

        }
        return new ResponseEntity<>(updatedTutorial, HttpStatus.CREATED);
    }

    //Delete tutorial by ID
    @DeleteMapping("/tutorials/{id}")
    public void deleteTutorialByID(@PathVariable("id") int id) throws TutorialNotFoundException {

        Tutorial tutorial;

        if (tutorialRepository.findById(id).isPresent()) {
            tutorialRepository.deleteById(id);
        } else {
            throw new TutorialNotFoundException();
        }

    }

    //Find all published tutorial
    @GetMapping("/tutorials/published")
    public ResponseEntity<List> getPublishedTutorialList() throws TutorialNotFoundException {
        return new ResponseEntity<List>((List) tutorialRepository.findAllByPublished(true), HttpStatus.OK);
    }

    
}
