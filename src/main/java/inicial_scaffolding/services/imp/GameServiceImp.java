package inicial_scaffolding.services.imp;

import inicial_scaffolding.dtos.CardDto;
import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.entities.GameEntity;
import inicial_scaffolding.entities.PlayerEntity;
import inicial_scaffolding.repositories.GameRepository;
import inicial_scaffolding.services.CardService;
import inicial_scaffolding.services.GameService;
import inicial_scaffolding.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameServiceImp implements GameService {

@Autowired
private GameRepository gameRepository;
@Autowired
private PlayerService playerService;
@Autowired
private CardService cardService;
@Autowired
ModelMapper modelMapper;

    @Override
    public GameEntity getGameById(Long id) {
        GameEntity gameEntity=gameRepository.findById(id).orElse(null);
        if (gameEntity==null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No se encontro el juego");
        }
        return gameEntity;
    }

    @Override
    public GameEntity startGame(int numPlayers, int numImpostors) {
        GameEntity newGame=new GameEntity();
        GameEntity gameSaved= gameRepository.save(newGame);
        List<PlayerEntity>playerEntities=new ArrayList<>();

        for (int i=0;i<numPlayers;i++){

            PlayerEntity playerEntity=playerService.createPlayer("Jugador "+i,false,false,gameSaved);
            playerEntities.add(playerEntity);
        }

        List<Integer>impostors=getImpostors(numPlayers,numImpostors);
        for (int impostor:impostors){
            playerEntities.get(impostor-1).setImpostor(true);
            playerEntities.get(impostor-1).setName("IMPOSTOR");
        }


        gameSaved.setPlayers(playerEntities);
        gameSaved.setCard(cardService.getRandomCard());

        return gameRepository.save(gameSaved);
    }

    @Override
    public CardDto getNextPlayer(Long gameId) {
        Optional<GameEntity> gameEntity=gameRepository.findById(gameId);
        if (gameEntity.isPresent()){
            if (!gameEntity.get().isFinish()){
                for (PlayerEntity p:gameEntity.get().getPlayers()){
                    if(!p.isView()){
                        p.setView(true);
                        gameRepository.save(gameEntity.get());
                        if (!p.isImpostor()){
                            return modelMapper.map(gameEntity.get().getCard(),CardDto.class);
                        }
                        return new CardDto("eres el impostor");
                    }
                }
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Ya fueron revelados todos los jugadores");
            }else {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"El juego ya finalizo");
            }
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No se encontro el game ingresado");
    }

    @Override
    public List<PlayerEntity> finishGame(Long gameId) {
        Optional<GameEntity> gameEntity=gameRepository.findById(gameId);
        if (gameEntity.isPresent()){
            if (!gameEntity.get().isFinish()){
                List<PlayerEntity>impostors=new ArrayList<>();
                for (PlayerEntity p:gameEntity.get().getPlayers()){
                    if (p.isImpostor()){
                        impostors.add(p);
                    }
                }
                gameEntity.get().setFinish(true);
                return impostors;
            }else {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Este juego ya finalizo");
            }
        }
        throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No se encontro el game ingresado");
    }

    @Override
    public List<GameEntity> getAllGames() {
        return gameRepository.findAll();
    }

    private List<Integer> getImpostors(int numPlayers, int numImpostors){
        List<Integer>impostors=new ArrayList<>();
        Random random=new Random();
        for (int i=0;i<numImpostors;i++){
            int impostor=random.nextInt(numPlayers)+1;
            if (!impostors.contains(impostor)){
                impostors.add(impostor);
            }else {i--;}
        }
        return impostors;
    }
}
