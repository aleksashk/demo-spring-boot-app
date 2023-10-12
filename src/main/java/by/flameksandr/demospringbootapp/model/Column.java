package by.flameksandr.demospringbootapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int id;

    private String title;

    private List<Card> cardList = new ArrayList<>();
}
