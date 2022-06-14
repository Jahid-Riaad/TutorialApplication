package com.tutorial.app.repositories;

import com.tutorial.app.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    List<Tutorial> findAllByPublished(Boolean published);

//    //filter/search functionality using query
    @Query("SELECT t FROM Tutorial t WHERE  t.title LIKE %?1%")
    public List<Tutorial> search(String title);

}
