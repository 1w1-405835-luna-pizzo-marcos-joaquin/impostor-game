package inicial_scaffolding.services.imp;

import inicial_scaffolding.entities.GameEntity;
import inicial_scaffolding.entities.PlayerEntity;
import inicial_scaffolding.models.Dumy;
import inicial_scaffolding.repositories.IDumyRepository;
import inicial_scaffolding.repositories.PlayerRepository;
import inicial_scaffolding.services.IDumyService;
import inicial_scaffolding.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PlayerServiceImp implements PlayerService {
@Autowired
private PlayerRepository playerRepository;
    @Override
    public List<PlayerEntity> getAllPlayers() {
        List<PlayerEntity>playerEntities=playerRepository.findAll();
        if (playerEntities==null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No se encontraron jugadores");
        }
        return playerEntities;
    }

    @Override
    public PlayerEntity createPlayer(String name, boolean isImpostor,boolean isView, GameEntity game) {
       PlayerEntity playerEntity=new PlayerEntity();
       playerEntity.setName(name);
       playerEntity.setImpostor(isImpostor);
       playerEntity.setGame(game);
       playerEntity.setView(isView);
        PlayerEntity playerSaved=playerRepository.save(playerEntity);
        if (playerSaved==null){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"No se pudo guardar el jugador");
        }
        return playerSaved;
    }
}
