package org.codewithaashu.keep_notes.service;

import java.util.ArrayList;
import java.util.List;

import org.codewithaashu.keep_notes.entity.NotesEntity;
import org.codewithaashu.keep_notes.model.Notes;
import org.codewithaashu.keep_notes.repository.NotesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    // data is retrieve from database through repository in form of entity

    @Autowired
    private NotesRepository notesRepository;

    public List<Notes> getAllNotes() {
        // data is fetch from repository. in repository, data is in entity form. so we
        // get list of entity
        List<NotesEntity> notesEntities = notesRepository.findAll();
        // we need data in modal form
        List<Notes> notesList = new ArrayList<>();
        for (NotesEntity nt : notesEntities) {
            // create a simply modal data
            Notes notes = new Notes();
            BeanUtils.copyProperties(nt, notes);
            // add in modal list
            notesList.add(notes);
        }
        return notesList;
    }

    public Notes getNotes(Long id) {
        // get data from repository
        NotesEntity notesEntity = notesRepository.findById(id).get();// data is in entity form
        // convert entity to modal
        Notes notes = new Notes();// empty modal
        // copy data from entity to modal
        BeanUtils.copyProperties(notesEntity, notes);
        return notes;
    }

    public void addNotes(Notes n) {
        // when we create notes, data is come from user side which is in modal form. but
        // repository needs data in entity form.
        // we will copy modal data into to entity form
        NotesEntity notesEntity = new NotesEntity();
        BeanUtils.copyProperties(n, notesEntity); // in modal form there is no id but in entity form there is id
        notesRepository.save(notesEntity);
    }

    public Notes updateNote(Long id, Notes n) {
        // get data from repository
        NotesEntity notesEntity = notesRepository.findById(id).get();// data is in entity form
        // set data with modal data
        notesEntity.setTitle(n.getTitle());
        notesEntity.setDescription(n.getDescription());
        // save data in repository
        notesRepository.save(notesEntity);
        // get the update entity into form of modal
        Notes notes = new Notes();// empty modal create
        BeanUtils.copyProperties(notesEntity, notes);// fill data in modal
        System.out.println(notes);
        return notes;
    }

    public void delNotes(Long id) {
        // delete note from repository
        notesRepository.deleteById(id);
    }

}
