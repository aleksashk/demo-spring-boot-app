package by.flameksandr.demospringbootapp.controllers;

import by.flameksandr.demospringbootapp.model.Column;
import by.flameksandr.demospringbootapp.repositories.ColumnRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "column")
public class ColumnController {

    private ColumnRepository columnRepository;

    public ColumnController(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    @PostMapping(path = "all")
    public List<Column> getAllColumns() {
        return columnRepository.findAll();
    }

    @PostMapping(path = "add")
    public Column addColumn(@RequestParam String title) {
        Column column = new Column();
        column.setTitle(title);

        columnRepository.save(column);
        return column;
    }

    @PostMapping(path = "delete")
    public String deleteColumn(@RequestParam String id) {
        Column column = columnRepository.findById(Integer.parseInt(id));
        columnRepository.delete(column);
        return "ok";
    }

    @PostMapping(path = "rename")
    public String deleteColumn(@RequestParam String id, String title) {
        Column column = columnRepository.findById(Integer.parseInt(id));
        column.setTitle(title);
        columnRepository.save(column);
        return "ok";
    }
}
