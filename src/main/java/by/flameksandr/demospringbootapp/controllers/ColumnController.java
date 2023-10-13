package by.flameksandr.demospringbootapp.controllers;

import by.flameksandr.demospringbootapp.model.Column;
import by.flameksandr.demospringbootapp.repositories.ColumnRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "column")
public class ColumnController {

    private ColumnRepository columnRepository;

    public ColumnController(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    @PostMapping(path = "all")
    @ResponseBody
    public List<Column> getAllColumns() {
        List<Column> columns = columnRepository.findAll();
        return columns;
    }
}
