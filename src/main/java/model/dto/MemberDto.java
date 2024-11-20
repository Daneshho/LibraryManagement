package model.dto;

import lombok.*;
import model.Gender;

import java.util.Date;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {


    private String name;
    private String nationalCode;
    private Date dateOfBirth;
    private Gender gender;
}
