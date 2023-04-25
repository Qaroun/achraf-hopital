package ma.emsi.jpahospital52;

import ma.emsi.jpahospital52.entities.*;
import ma.emsi.jpahospital52.repositories.ConsultationRepository;
import ma.emsi.jpahospital52.repositories.MedecinRepository;
import ma.emsi.jpahospital52.repositories.PatientRepository;
import ma.emsi.jpahospital52.repositories.RendezVousRepository;
import ma.emsi.jpahospital52.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.event.MouseWheelEvent;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaHospital52Application  {

    public static void main(String[] args) {
        SpringApplication.run(JpaHospital52Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            MedecinRepository medecinRepository
    ) {
        return args -> {
            Stream.of("Zakaria", "Rayane", "Amine")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("MohammedSaad", "hanane", "Imane")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });


            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Zakaria");


            Medecin medecin=medecinRepository.findByNom("MohammedSaad");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultaion.....");
            hospitalService.saveConsultation(consultation);
        };
    }
}
