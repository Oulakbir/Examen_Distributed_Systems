package ma.enset.commercantservice;

import ma.enset.commercantservice.Entity.Cheque;
import ma.enset.commercantservice.Repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommercantServiceApplication implements CommandLineRunner {

    @Autowired
    private ChequeRepository chequeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CommercantServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed data into the H2 database
        Cheque cheque1 = new Cheque();
        cheque1.setChequeNumber("123456");
        cheque1.setBankCode("001");
        cheque1.setAccountNumber("789123");
        cheque1.setClientName("Zahra FREM");
        cheque1.setAmount(2500.50);
        cheque1.setCertified(false);

        Cheque cheque2 = new Cheque();
        cheque2.setChequeNumber("654321");
        cheque2.setBankCode("002");
        cheque2.setAccountNumber("456789");
        cheque2.setClientName("Ilham OULAKBIR");
        cheque2.setAmount(1500.00);
        cheque2.setCertified(false);

        Cheque cheque3 = new Cheque();
        cheque3.setChequeNumber("111222");
        cheque3.setBankCode("003");
        cheque3.setAccountNumber("123456");
        cheque3.setClientName("EL MOSTAFA OULAKBIR");
        cheque3.setAmount(3500.75);
        cheque3.setCertified(true);

        chequeRepository.save(cheque1);
        chequeRepository.save(cheque2);
        chequeRepository.save(cheque3);

        System.out.println("Initial data seeded into the H2 database.");
    }
}
