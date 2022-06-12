package com.example.testdb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname",nullable = false)
    private String firstName;

    @Column(name = "lastname",nullable = false)
    private String lastName;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note){
        note.setPerson(this);
        notes.add(note);
    }

}
