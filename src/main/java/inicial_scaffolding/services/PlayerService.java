package inicial_scaffolding.services;

import inicial_scaffolding.entities.GameEntity;
import inicial_scaffolding.entities.PlayerEntity;
import inicial_scaffolding.models.Dumy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    public List<PlayerEntity>getAllPlayers();
    public PlayerEntity createPlayer(String name, boolean isImpostor,boolean isView, GameEntity game);
}
