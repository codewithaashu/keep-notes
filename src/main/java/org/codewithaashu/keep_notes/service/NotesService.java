package org.codewithaashu.keep_notes.service;

import java.util.ArrayList;

import org.codewithaashu.keep_notes.model.Notes;

public class NotesService {
    ArrayList<Notes> notesList = new ArrayList<>();

    public ArrayList<Notes> getAllNotes() {
        return notesList;
    }

    public void addNotes(Notes n) {
        notesList.add(n);
    }

    public ArrayList<Notes> updateNote(Long id, Notes n) {
        System.out.println(n);
        for (Notes nt : notesList) {
            if (nt.getId() == n.getId()) {
                nt.setTitle(n.getTitle());
                nt.setDescription(n.getDescription());
            }
        }
        return notesList;
    }

    public boolean delNotes(Long id) {
        boolean res = notesList.removeIf(curr -> curr.getId().equals(id));// delete an entry if element exist
        return res;
    }

}
