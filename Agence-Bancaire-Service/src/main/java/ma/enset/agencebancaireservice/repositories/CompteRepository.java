package ma.enset.agencebancaireservice.repositories;

import ma.enset.agencebancaireservice.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    Optional<Compte> findByNumero(String numero);
}

