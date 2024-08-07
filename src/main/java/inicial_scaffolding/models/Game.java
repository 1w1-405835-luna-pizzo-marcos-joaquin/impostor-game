package inicial_scaffolding.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {
    Long id;
    Card card;
    List<Player>players;
}
