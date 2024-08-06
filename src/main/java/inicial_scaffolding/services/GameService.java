package inicial_scaffolding.services;

import inicial_scaffolding.models.Dumy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    Dumy getDumy(Long id);
    List<Dumy>getDumyList();
    Dumy createDumy(Dumy dumy);
    Dumy deleteDumy(Dumy dumy);
    Dumy updateDumy(Dumy dumy);

}
