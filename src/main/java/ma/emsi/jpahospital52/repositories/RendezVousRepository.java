package ma.emsi.jpahospital52.repositories;

import ma.emsi.jpahospital52.entities.Patient;
import ma.emsi.jpahospital52.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository <RendezVous, String> {


}
