package ma.emsi.jpahospital52.repositories;

import ma.emsi.jpahospital52.entities.Consultation;
import ma.emsi.jpahospital52.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository <Consultation, Long> {


}
