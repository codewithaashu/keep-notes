package org.codewithaashu.keep_notes.controller;

import org.springframework.web.bind.annotation.RestController;

import org.codewithaashu.keep_notes.model.Notes;
import org.codewithaashu.keep_notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

//to make class as a controller we use RestController annotations
@RestController
public class NotesController {
    @Autowired
    NotesService notes;// it automatically create object by using IOC container

    // to create controller of get and mapping with url we use GetMapping
    // annotations
    @GetMapping("/notes")
    public List<Notes> fetchAllNotes() {
        return notes.getAllNotes();
    }

    // to read single notes, we use GetMapping wit url
    @GetMapping("/notes/{id}")
    public Notes getNotes(@PathVariable Long id) {
        return notes.getNotes(id);
    }

    // to create controller of post type, we use PostMapping with url
    @PostMapping("/notes")
    public String createNotes(@RequestBody Notes nt) {
        notes.addNotes(nt);
        return "Notes created successfully";
    }

    // to create controller of update type, we use PutMapping with url
    @PutMapping("/notes/{id}")
    public Notes updateNotes(@PathVariable Long id, @RequestBody Notes n) {
        return notes.updateNote(id, n);
    }

    // to create conroller of delete type, we use DeleteMapping with url
    @DeleteMapping("/notes/{id}")
    public String deleteNotes(@PathVariable Long id) {
        notes.delNotes(id);
        return "Notes deleted successfully";
    }
}
