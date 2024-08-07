package inicial_scaffolding.controllers;

import inicial_scaffolding.dtos.CardDto;
import inicial_scaffolding.dtos.DumyDto;
import inicial_scaffolding.entities.CardEntity;
import inicial_scaffolding.entities.GameEntity;
import inicial_scaffolding.entities.PlayerEntity;
import inicial_scaffolding.models.Dumy;
import inicial_scaffolding.services.GameService;
import inicial_scaffolding.services.IDumyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/allGames")
    public ResponseEntity<List<GameEntity>>getAllGames(){
       return ResponseEntity.ok(gameService.getAllGames());
    }
    @GetMapping("/gameById/{id}")
    public ResponseEntity<GameEntity>getGameById(@PathVariable Long id){
        return ResponseEntity.ok(gameService.getGameById(id));
    }


    @PostMapping("/create/{players}/{impostors}")
    public ResponseEntity<GameEntity>createGame(@PathVariable int players,@PathVariable int impostors){
        return ResponseEntity.ok(gameService.startGame(players,impostors));
    }
    @PostMapping("/nextPlayer/{gameId}")
    public ResponseEntity<CardDto>getNextPlayer(@PathVariable Long gameId){
        return ResponseEntity.ok(gameService.getNextPlayer(gameId));
    }
    @PostMapping("/finishGame/{gameId}")
    public ResponseEntity<List<PlayerEntity>>finishGame(@PathVariable Long gameId){
        return ResponseEntity.ok(gameService.finishGame(gameId));
    }

}
