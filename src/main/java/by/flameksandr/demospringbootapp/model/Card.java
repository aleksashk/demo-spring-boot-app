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
@Table(name = "cards")
public class Card {

    @Id
    @jakarta.persistence.Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CheckListItem> checkListItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "column_id")
    private Column column;
}
