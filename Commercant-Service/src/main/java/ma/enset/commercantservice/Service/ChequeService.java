package ma.enset.commercantservice.Service;

import ma.enset.commercantservice.Entity.Cheque;
import ma.enset.commercantservice.Repository.ChequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChequeService {

    @Autowired
    private ChequeRepository chequeRepository;

    public Cheque createCheque(Cheque cheque) {
        cheque.setCertified(false); // Default to uncertified
        return chequeRepository.save(cheque);
    }

    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    public Cheque getChequeById(Long id) {
        return chequeRepository.findById(id).orElse(null);
    }

    public List<Cheque> getCertifiedCheques() {
        return chequeRepository.findByCertified(true);
    }

    public Cheque updateCheque(Long id, Cheque updatedCheque) {
        Cheque existingCheque = chequeRepository.findById(id).orElse(null);
        if (existingCheque != null) {
            existingCheque.setChequeNumber(updatedCheque.getChequeNumber());
            existingCheque.setBankCode(updatedCheque.getBankCode());
            existingCheque.setAccountNumber(updatedCheque.getAccountNumber());
            existingCheque.setClientName(updatedCheque.getClientName());
            existingCheque.setAmount(updatedCheque.getAmount());
            existingCheque.setCertified(updatedCheque.isCertified());
            return chequeRepository.save(existingCheque);
        }
        return null;
    }

    public void deleteCheque(Long id) {
        chequeRepository.deleteById(id);
    }
}
