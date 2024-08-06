package inicial_scaffolding.repositories;

import inicial_scaffolding.entities.DumyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<DumyEntity,Long> {
}
