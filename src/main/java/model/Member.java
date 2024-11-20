package model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
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
public class Member extends Users {


    @ManyToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();
}
