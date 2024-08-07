package inicial_scaffolding.services;

import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.models.Card;
import inicial_scaffolding.models.Dumy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    public List<CardEntity>getAllCards();
    public CardEntity getRandomCard();

}
