package ma.enset.banquecentraleservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AgenceBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String ville;
    private String webServiceUrl;

    public AgenceBancaire(Long id, String nom, String ville, String webServiceUrl) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.webServiceUrl = webServiceUrl;
    }
}

