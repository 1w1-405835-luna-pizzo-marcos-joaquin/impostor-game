package inicial_scaffolding.services;

import inicial_scaffolding.dtos.CardDto;
import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.entities.GameEntity;
import inicial_scaffolding.entities.PlayerEntity;
import inicial_scaffolding.models.Card;
import inicial_scaffolding.models.Dumy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    public GameEntity getGameById(Long id);
    public GameEntity startGame(int numPlayers, int numImpostors);
    public CardDto getNextPlayer(Long gameId);
    public List<PlayerEntity>finishGame(Long gameId);
    public List<GameEntity>getAllGames();
}
