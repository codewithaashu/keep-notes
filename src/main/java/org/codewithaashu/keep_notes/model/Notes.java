package org.codewithaashu.keep_notes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//these data members are private. so we cannot access directly . so we declare getter and setter method.
//there is one option that we manually define the setter and getter. but it takes a labour
//second option we use lombork, which automatically define the getter and setter

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {
    private Long id;
    private String title;
    private String description;
}