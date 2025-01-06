package ma.enset.agencebancaireservice.controllers;

import ma.enset.agencebancaireservice.entities.Compte;
import ma.enset.agencebancaireservice.entities.Operation;
import ma.enset.agencebancaireservice.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    // Create a new compte
    @PostMapping
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        Compte createdCompte = compteService.createCompte(compte);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompte);
    }

    // Get compte by numero
    @GetMapping("/{numero}")
    public ResponseEntity<Compte> getCompte(@PathVariable String numero) {
        return compteService.getCompteByNumero(numero)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Get operations of a compte
    @GetMapping("/{numero}/operations")
    public ResponseEntity<List<Operation>> getOperations(@PathVariable String numero) {
        List<Operation> operations = compteService.getOperations(numero);
        return ResponseEntity.ok(operations);
    }

    // Add operation to a compte
    @PostMapping("/{numero}/operations")
    public ResponseEntity<Operation> addOperation(@PathVariable String numero, @RequestBody Operation operation) {
        Operation createdOperation = compteService.addOperation(numero, operation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOperation);
    }
}

