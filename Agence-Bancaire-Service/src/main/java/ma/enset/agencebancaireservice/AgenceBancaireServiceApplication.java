package ma.enset.agencebancaireservice;

import ma.enset.agencebancaireservice.entities.Compte;
import ma.enset.agencebancaireservice.entities.Operation;
import ma.enset.agencebancaireservice.entities.TypeCompte;
import ma.enset.agencebancaireservice.entities.TypeOperation;
import ma.enset.agencebancaireservice.repositories.CompteRepository;
import ma.enset.agencebancaireservice.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class AgenceBancaireServiceApplication {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    public static void main(String[] args) {
        SpringApplication.run(AgenceBancaireServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Création de comptes
            Compte compte1 = new Compte();
            compte1.setNumero("12345");
            compte1.setSolde(1000.00);
            compte1.setReferenceClient("client1");
            compte1.setType(TypeCompte.COURANT);

            Compte compte2 = new Compte();
            compte2.setNumero("67890");
            compte2.setSolde(5000.00);
            compte2.setReferenceClient("client2");
            compte2.setType(TypeCompte.EPARGNE);

            compteRepository.saveAll(List.of(compte1, compte2));

            // Création d'opérations
            Operation operation1 = new Operation();
            operation1.setDate(LocalDateTime.now());
            operation1.setMontant(200.00);
            operation1.setNumeroCheque("CHQ123");
            operation1.setType(TypeOperation.DEBIT);
            operation1.setDescription("Retrait d'argent");
            operation1.setCompte(compte1);

            Operation operation2 = new Operation();
            operation2.setDate(LocalDateTime.now());
            operation2.setMontant(1500.00);
            operation2.setNumeroCheque("CHQ456");
            operation2.setType(TypeOperation.CREDIT);
            operation2.setDescription("Dépôt d'argent");
            operation2.setCompte(compte2);

            operationRepository.saveAll(List.of(operation1, operation2));

            System.out.println("Données d'exemple insérées dans la base de données.");
        };
    }
}
