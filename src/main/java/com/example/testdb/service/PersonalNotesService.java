package com.example.testdb.service;

import com.example.testdb.entity.Note;
import com.example.testdb.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonalNotesService {

    private final PersonsRepository personsRepository;

    @Transactional
    public  void addNote(Long personID, Note note){
        var person = personsRepository.findById(personID).orElseThrow();
        person.addNote(note);
    }
}
