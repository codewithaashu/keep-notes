package org.codewithaashu.keep_notes.repository;

import org.codewithaashu.keep_notes.entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NotesEntity, Long> {

}
