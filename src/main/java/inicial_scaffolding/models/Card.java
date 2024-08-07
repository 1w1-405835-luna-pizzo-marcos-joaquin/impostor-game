package inicial_scaffolding.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {
    Long id;
    String word;
}
