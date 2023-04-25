package ma.emsi.jpahospital52.service;

import ma.emsi.jpahospital52.entities.Consultation;
import ma.emsi.jpahospital52.entities.Medecin;
import ma.emsi.jpahospital52.entities.Patient;
import ma.emsi.jpahospital52.entities.RendezVous;



public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
