package ma.enset.banquecentraleservice.services;

import ma.enset.banquecentraleservice.entities.AgenceBancaire;
import ma.enset.banquecentraleservice.repositories.AgenceBancaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceBancaireService {
    private final AgenceBancaireRepository repository;

    public AgenceBancaireService(AgenceBancaireRepository repository) {
        this.repository = repository;
    }

    public List<AgenceBancaire> getAllAgences() {
        return repository.findAll();
    }

    public AgenceBancaire getAgenceById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Agence not found"));
    }

    public AgenceBancaire saveAgence(AgenceBancaire agence) {
        return repository.save(agence);
    }

    public void deleteAgence(Long id) {
        repository.deleteById(id);
    }
}
