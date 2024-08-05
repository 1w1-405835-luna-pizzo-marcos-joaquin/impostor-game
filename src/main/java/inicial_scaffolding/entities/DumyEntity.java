package inicial_scaffolding.entities;

import jakarta.persistence.*;

@Entity
public class DumyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    private String dumy;


}
