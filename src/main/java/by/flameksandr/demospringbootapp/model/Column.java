package by.flameksandr.demospringbootapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "columns")
public class Column {

    @Id
    @jakarta.persistence.Column(name = "column_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @jakarta.persistence.Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL)
    private List<Card> cardList = new ArrayList<>();
}
