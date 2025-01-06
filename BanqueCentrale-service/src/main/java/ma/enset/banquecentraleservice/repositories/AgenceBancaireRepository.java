package ma.enset.banquecentraleservice.repositories;


import ma.enset.banquecentraleservice.entities.AgenceBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceBancaireRepository extends JpaRepository<AgenceBancaire, Long> {
}
