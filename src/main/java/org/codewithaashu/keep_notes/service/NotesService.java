package org.codewithaashu.keep_notes.service;

import java.util.ArrayList;

import org.codewithaashu.keep_notes.model.Notes;

public class NotesService {
    ArrayList<Notes> notesList = new ArrayList<>();

    public ArrayList<Notes> getAllNotes() {
        // simply return notesList
        return notesList;
    }

    public Notes getNotes(Long id) {
        // iterate the notesList and if any notes'id is matched with passing id from
        // frontend. then we return that notes
        for (Notes nt : notesList) {
            if (nt.getId() == id) {
                return nt;
            }
        }
        return new Notes();
    }

    public void addNotes(Notes n) {
        // simply add the notes in notesList
        notesList.add(n);
    }

    public ArrayList<Notes> updateNote(Long id, Notes n) {
        // iterate all the notes in notesList . if any notes id will match then set the
        // title and description of that notes by passing notes title and description
        for (Notes nt : notesList) {
            if (nt.getId() == n.getId()) {
                nt.setTitle(n.getTitle());
                nt.setDescription(n.getDescription());
            }
        }
        return notesList;
    }

    public boolean delNotes(Long id) {
        // check if any notes id is matched by passing id. if matched then remove it.
        boolean res = notesList.removeIf(curr -> curr.getId().equals(id));// delete an entry if element exist
        return res;
    }

}
