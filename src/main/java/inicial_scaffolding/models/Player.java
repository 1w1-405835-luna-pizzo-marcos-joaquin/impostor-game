package inicial_scaffolding.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player {
    private Long id;
    private String name;
    boolean isImposor;

}
