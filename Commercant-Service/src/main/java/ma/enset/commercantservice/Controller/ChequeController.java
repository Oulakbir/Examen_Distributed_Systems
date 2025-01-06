package ma.enset.commercantservice.Controller;

import ma.enset.commercantservice.Entity.Cheque;
import ma.enset.commercantservice.Service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cheques")
public class ChequeController {

    @Autowired
    private ChequeService chequeService;

    @PostMapping
    public ResponseEntity<Cheque> createCheque(@RequestBody Cheque cheque) {
        return ResponseEntity.ok(chequeService.createCheque(cheque));
    }

    @GetMapping
    public ResponseEntity<List<Cheque>> getAllCheques() {
        return ResponseEntity.ok(chequeService.getAllCheques());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cheque> getChequeById(@PathVariable Long id) {
        Cheque cheque = chequeService.getChequeById(id);
        if (cheque != null) {
            return ResponseEntity.ok(cheque);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/certified")
    public ResponseEntity<List<Cheque>> getCertifiedCheques() {
        return ResponseEntity.ok(chequeService.getCertifiedCheques());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cheque> updateCheque(@PathVariable Long id, @RequestBody Cheque updatedCheque) {
        Cheque cheque = chequeService.updateCheque(id, updatedCheque);
        if (cheque != null) {
            return ResponseEntity.ok(cheque);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheque(@PathVariable Long id) {
        chequeService.deleteCheque(id);
        return ResponseEntity.noContent().build();
    }
}

