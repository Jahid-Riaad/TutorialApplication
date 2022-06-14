package com.tutorial.app.repositories;

import com.tutorial.app.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    Tutorial findTutorialById(int tutorialId);

}
