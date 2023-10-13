package by.flameksandr.demospringbootapp.repositories;

import by.flameksandr.demospringbootapp.model.CheckListItem;
import org.springframework.data.repository.CrudRepository;

public interface CheckListRepository extends CrudRepository<CheckListItem, Integer> {
    CheckListItem findById(int id);
}
