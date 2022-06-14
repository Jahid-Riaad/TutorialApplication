package com.tutorial.app.services;

import com.tutorial.app.exceptionHandles.TutorialAlreadyExistsException;
import com.tutorial.app.exceptionHandles.TutorialNotFoundException;
import com.tutorial.app.models.Tutorial;
import com.tutorial.app.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial saveTutorial(Tutorial tutorial) throws TutorialAlreadyExistsException {

        if (tutorialRepository.existsById(tutorial.getId())) {
            throw new TutorialAlreadyExistsException();
        }
        Tutorial saveTutorial = tutorialRepository.save(tutorial);

        return saveTutorial;

    }

    public Tutorial findTutorialById(Integer tutorialId) throws TutorialNotFoundException {

        Tutorial Tutorial;

        if (tutorialRepository.findById(tutorialId).isPresent()) {
            Tutorial = tutorialRepository.findById(tutorialId).get();
        } else {
            throw new TutorialNotFoundException();
        }
        return Tutorial;
    }

    public List getAllTutorial() {
        return (List) tutorialRepository.findAll();
    }

}
