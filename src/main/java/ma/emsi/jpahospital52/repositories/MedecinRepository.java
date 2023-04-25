package ma.emsi.jpahospital52.repositories;

import ma.emsi.jpahospital52.entities.Medecin;
import ma.emsi.jpahospital52.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository <Medecin, Long> {
    Medecin findByNom(String nom);


}
