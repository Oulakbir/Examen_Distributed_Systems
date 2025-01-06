package ma.enset.banquecentraleservice.controllers;

import ma.enset.banquecentraleservice.entities.AgenceBancaire;
import ma.enset.banquecentraleservice.services.AgenceBancaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceBancaireController {
    private final AgenceBancaireService service;

    public AgenceBancaireController(AgenceBancaireService service) {
        this.service = service;
    }

    @GetMapping
    public List<AgenceBancaire> getAllAgences() {
        return service.getAllAgences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenceBancaire> getAgenceById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAgenceById(id));
    }

    @PostMapping
    public ResponseEntity<AgenceBancaire> saveAgence(@RequestBody AgenceBancaire agence) {
        return ResponseEntity.ok(service.saveAgence(agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        service.deleteAgence(id);
        return ResponseEntity.noContent().build();
    }
}
