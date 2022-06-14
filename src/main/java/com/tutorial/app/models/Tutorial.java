package com.tutorial.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "tutorials" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name ="description")
    String description;

    @Column(name ="published")
    boolean published;

    @Column(name ="title")
    String title;



}
