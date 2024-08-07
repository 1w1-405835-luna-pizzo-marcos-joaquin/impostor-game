package inicial_scaffolding.repositories;

import inicial_scaffolding.entities.DumyEntity;
import inicial_scaffolding.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {
}
