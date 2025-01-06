package ma.enset.banquecentraleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.enset.banquecentraleservice.entities.AgenceBancaire;
import ma.enset.banquecentraleservice.repositories.AgenceBancaireRepository;

@SpringBootApplication
public class BanqueCentraleServiceApplication implements CommandLineRunner {

    @Autowired
    private AgenceBancaireRepository agenceBancaireRepository;

    public static void main(String[] args) {
        SpringApplication.run(BanqueCentraleServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Adding sample AgenceBancaire entities to the database
        agenceBancaireRepository.save(new AgenceBancaire(null, "Banque Populaire", "Casablanca", "http://banquepopulaire.com/ws"));
        agenceBancaireRepository.save(new AgenceBancaire(null, "Attijariwafa Bank", "Rabat", "http://attijariwafabank.com/ws"));
        agenceBancaireRepository.save(new AgenceBancaire(null, "BMCE Bank", "Marrakech", "http://bmcebank.com/ws"));
        agenceBancaireRepository.save(new AgenceBancaire(null, "CIH Bank", "Tanger", "http://cihbank.com/ws"));

        System.out.println("Sample data added to H2 database.");
    }
}

