package by.flameksandr.demospringbootapp.controllers;

import by.flameksandr.demospringbootapp.model.Card;
import by.flameksandr.demospringbootapp.model.CheckListItem;
import by.flameksandr.demospringbootapp.repositories.CardRepository;
import by.flameksandr.demospringbootapp.repositories.CheckListRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "checklist")
public class CheckListItemController {

    private final CheckListRepository checkListRepository;

    private final CardRepository cardRepository;

    public CheckListItemController(CheckListRepository checkListRepository, CardRepository cardRepository) {
        this.checkListRepository = checkListRepository;
        this.cardRepository = cardRepository;
    }


    @RequestMapping(path = "add")
    public CheckListItem addCheckListItem(@RequestParam String text, @RequestParam String cardId) {
        Card card = cardRepository.findById(Integer.parseInt(cardId));
        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setCard(card);
        checkListItem.setText(text);

        checkListRepository.save(checkListItem);
        return checkListItem;
    }

    @RequestMapping(path = "delete")
    public String deleteCheckListItem(@RequestParam String id) {
        CheckListItem checkListItem = checkListRepository.findById(Integer.parseInt(id));
        checkListRepository.delete(checkListItem);
        return "Ok";
    }

    @PostMapping(path = "check")
    public CheckListItem checkItem(@RequestParam String id) {
        CheckListItem checkListItem = checkListRepository.findById(Integer.parseInt(id));
        checkListItem.setChecked(!checkListItem.isChecked());
        checkListRepository.save(checkListItem);
        return checkListItem;
    }
}
