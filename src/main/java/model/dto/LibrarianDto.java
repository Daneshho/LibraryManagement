package model.dto;


import jakarta.persistence.*;
import lombok.*;
import model.Gender;
import model.Librarian;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianDto {

    private String name;
    private String nationalCode;
    private Date dateOfBirth;
    private Gender gender;

}
