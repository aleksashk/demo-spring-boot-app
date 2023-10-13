package by.flameksandr.demospringbootapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checklist items")
public class CheckListItem {

    @Id
    @jakarta.persistence.Column(name = "checklist_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    private boolean checked;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public CheckListItem(String text, Card card, boolean checked) {
        this.text = text;
        this.card = card;
        this.checked = checked;
    }
}
