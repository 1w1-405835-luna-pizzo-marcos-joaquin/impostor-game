package inicial_scaffolding.services.imp;

import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.models.Card;
import inicial_scaffolding.models.Dumy;
import inicial_scaffolding.repositories.CardRepository;
import inicial_scaffolding.repositories.IDumyRepository;
import inicial_scaffolding.services.CardService;
import inicial_scaffolding.services.IDumyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@Service
public class CardServiceImp implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CardEntity> getAllCards() {
        List< CardEntity> cardEntity=cardRepository.findAll();
        if (cardEntity==null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No se encontraron cartas");
        }
        return cardEntity;
    }

    @Override
    public CardEntity getRandomCard() {
        List<CardEntity>cardEntityList=getAllCards();
        Collections.shuffle(cardEntityList);

        return cardEntityList.get(0);
    }
}
