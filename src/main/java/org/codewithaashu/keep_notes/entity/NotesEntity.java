package org.codewithaashu.keep_notes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//this entity is data  from database side. so we have to mapping this data with table

@Data // for creating getter and setter automatically
@Entity
@Table(name = "notes") // define the name of table
public class NotesEntity {
    // create the schema and primary key

    // create id to be primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
}
