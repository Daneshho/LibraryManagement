package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Librarian extends Users {



    @OneToMany(mappedBy = "librarian", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

}