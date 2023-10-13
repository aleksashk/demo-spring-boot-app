package by.flameksandr.demospringbootapp.repositories;

import by.flameksandr.demospringbootapp.model.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
    Card findById(int id);
}
