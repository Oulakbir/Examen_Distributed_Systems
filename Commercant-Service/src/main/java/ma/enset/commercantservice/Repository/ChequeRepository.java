package ma.enset.commercantservice.Repository;


import ma.enset.commercantservice.Entity.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    List<Cheque> findByCertified(boolean certified);
}
