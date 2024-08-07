package inicial_scaffolding.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "card_id")//Especifica la columna de unión si es necesario
    @ManyToOne
    private CardEntity card;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)//game es el nombre del atributo en la clase PlayerEntity
    private List<PlayerEntity> players;

    private boolean isFinish;
}
