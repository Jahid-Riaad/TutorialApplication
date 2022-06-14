package com.tutorial.app.services;

import com.tutorial.app.models.Tutorial;
import com.tutorial.app.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;


}
