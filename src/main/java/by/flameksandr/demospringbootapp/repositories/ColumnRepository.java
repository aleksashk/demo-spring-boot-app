package by.flameksandr.demospringbootapp.repositories;

import by.flameksandr.demospringbootapp.model.Column;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColumnRepository extends CrudRepository<Column, Integer> {
    Column findById(int id);

    List<Column> findAll();
}
