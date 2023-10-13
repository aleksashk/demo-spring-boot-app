package by.flameksandr.demospringbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"cards"})
    private Column column;

    public Card(Card card) {
        this.title = card.getTitle();
        this.description = card.getDescription();
        this.column = card.getColumn();
        for (CheckListItem item : card.getCheckListItems()) {
            this.checkListItems.add(new CheckListItem(item.getText(), this, item.isChecked()));
        }
    }
}
