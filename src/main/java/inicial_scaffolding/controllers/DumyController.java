package inicial_scaffolding.controllers;

import inicial_scaffolding.dtos.DumyDto;
import inicial_scaffolding.models.Dumy;
import inicial_scaffolding.services.IDumyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dumy")
public class DumyController {

    @Autowired
    private IDumyService dumyService;

    @GetMapping("")
    public ResponseEntity<DumyDto>getDumyList(){
        List<Dumy>dumyList=dumyService.getDumyList();
        return  null;
    }
    @GetMapping("{id}")
    public ResponseEntity<DumyDto>getDumyList(@PathVariable Long id){
        Dumy dumy=dumyService.getDumy(id);
        return  null;
    }


    @PostMapping("")
    public ResponseEntity<DumyDto>createDumy(DumyDto dto){
        Dumy dumy=dumyService.createDumy(null);
        return  null;
    }
    @PutMapping("")
    public ResponseEntity<DumyDto>updateDumy(DumyDto dto){
        Dumy dumy=dumyService.updateDumy(null);

        return  null;
    }
    @DeleteMapping("")
    public ResponseEntity<DumyDto>deleteDumy(DumyDto dto){
        Dumy dumy=dumyService.deleteDumy(null);
        return  null;
    }


}
