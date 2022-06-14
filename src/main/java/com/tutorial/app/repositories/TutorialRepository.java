package com.tutorial.app.repositories;

import com.tutorial.app.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    List<Tutorial> findAllByPublished(Boolean published);

//    @Query("select t from tutorials t where t.published = ?1")
//    List<Tutorial> findAllByPublished(Integer published);

}
