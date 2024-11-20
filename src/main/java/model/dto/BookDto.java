package model.dto;

import lombok.*;
import model.Book;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {

    private String isbn;
    private String title;
    private int publicationYear;

}
