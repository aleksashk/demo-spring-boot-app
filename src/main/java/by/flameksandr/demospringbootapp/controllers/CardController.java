package by.flameksandr.demospringbootapp.controllers;

import by.flameksandr.demospringbootapp.model.Card;
import by.flameksandr.demospringbootapp.model.Column;
import by.flameksandr.demospringbootapp.repositories.CardRepository;
import by.flameksandr.demospringbootapp.repositories.ColumnRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "card")
public class CardController {

    private CardRepository cardRepository;

    private ColumnRepository columnRepository;

    public CardController(CardRepository cardRepository, ColumnRepository columnRepository) {
        this.cardRepository = cardRepository;
        this.columnRepository = columnRepository;
    }

    @PostMapping(path = "add")
    public Card addCars(@RequestParam String title, @RequestParam String columnId) {
        Column column = columnRepository.findById(Integer.parseInt(columnId));
        Card card = new Card();
        card.setTitle(title);
        card.setColumn(column);

        cardRepository.save(card);
        return card;
    }

    @PostMapping(path = "delete")
    public String deleteCard(@RequestParam String id) {
        Card card = cardRepository.findById(Integer.parseInt(id));
        cardRepository.delete(card);
        return "Ok";
    }

    @PostMapping(path = "descr")
    public String changeDescription(@RequestParam String descr, @RequestParam String id) {
        Card card = cardRepository.findById(Integer.parseInt(id));
        card.setDescription(descr);
        cardRepository.save(card);
        return "Ok";
    }

    @PostMapping(path = "copy")
    public Card copyCard(@RequestParam String id) {
        Card card = cardRepository.findById(Integer.parseInt(id));
        Card newCard = new Card(card);
        return newCard;
    }

    @PostMapping(path = "move")
    public Card moveCard(@RequestParam String cardId, @RequestParam String columnId) {
        Card card = cardRepository.findById(Integer.parseInt(cardId));
        Column column = columnRepository.findById(Integer.parseInt(columnId));
        card.setColumn(column);
        cardRepository.save(card);
        return card;
    }
}
