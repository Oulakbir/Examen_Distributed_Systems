package ma.enset.agencebancaireservice.repositories;

import ma.enset.agencebancaireservice.entities.Compte;
import ma.enset.agencebancaireservice.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByCompte(Compte compte);
}

