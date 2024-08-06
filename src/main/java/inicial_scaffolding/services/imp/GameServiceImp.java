package inicial_scaffolding.services.imp;

import inicial_scaffolding.models.Dumy;
import inicial_scaffolding.repositories.IDumyRepository;
import inicial_scaffolding.services.IDumyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IDumyService {
    @Autowired
    private IDumyRepository dumyRepository;
    @Override
    public Dumy getDumy(Long id) {
        return null;
    }

    @Override
    public List<Dumy> getDumyList() {
        return null;
    }

    @Override
    public Dumy createDumy(Dumy dumy) {
        return null;
    }

    @Override
    public Dumy deleteDumy(Dumy dumy) {
        return null;
    }

    @Override
    public Dumy updateDumy(Dumy dumy) {
        return null;
    }
}
