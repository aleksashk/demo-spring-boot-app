package by.flameksandr.demospringbootapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checklist-items")
public class CheckListItem {

    @Id
    private int id;

    private String text;

    private boolean checked;

    private Card card;

}
