package ma.enset.agencebancaireservice.services;

import ma.enset.agencebancaireservice.entities.Compte;
import ma.enset.agencebancaireservice.entities.Operation;
import ma.enset.agencebancaireservice.repositories.CompteRepository;
import ma.enset.agencebancaireservice.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private final CompteRepository compteRepository;
    private final OperationRepository operationRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository, OperationRepository operationRepository) {
        this.compteRepository = compteRepository;
        this.operationRepository = operationRepository;
    }

    // Create a new compte
    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Get compte by numero
    public Optional<Compte> getCompteByNumero(String numero) {
        return compteRepository.findByNumero(numero);
    }

    // Add operation to a compte
    public Operation addOperation(String numeroCompte, Operation operation) {
        Compte compte = getCompteByNumero(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        operation.setCompte(compte);
        compte.setSolde(compte.getSolde() + operation.getMontant()); // For simplicity, just adding the montant for now
        compteRepository.save(compte);
        return operationRepository.save(operation);
    }

    // Get operations of a compte
    public List<Operation> getOperations(String numeroCompte) {
        Compte compte = getCompteByNumero(numeroCompte)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        return operationRepository.findByCompte(compte);
    }
}
