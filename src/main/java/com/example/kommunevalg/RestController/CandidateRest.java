package com.example.kommunevalg.RestController;

import com.example.kommunevalg.Model.Candidate;
import com.example.kommunevalg.Repository.CandidateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class CandidateRest {

    // Repository objekt jeg bruger til at kommunikere med databasen
    private CandidateRepository candidateRepo;

    // Constructor injected repository objekt
    public CandidateRest(CandidateRepository candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    // Metode der læser indhold fra databasen
    @GetMapping
    public ResponseEntity<List<Candidate>> read() {

        // Instantiere en ny liste der skal indholde kandidater
        List<Candidate> candidates = new ArrayList();

        // Fylder listen op med mit repo objekt
        candidateRepo.findAll().forEach(candidates::add);

        // Returnere den fyldte liste med kandidater med en HTTP status OK
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }

    // GetMapping metode der finder et objekt via ID (Pathvariabel)
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Candidate>> findByID (@PathVariable long id) {

        // Instantiere en optional der bruger mit repo objekt til at finde en kendidat med matchende id (Pathvariabel)
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);

        // Jeg checker om min optionalCandidate er tilstede. Har jeg fat i objektet returneres det, else - NOT FOUND
        if(optionalCandidate.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalCandidate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalCandidate);
        }
    }

    // PostMapping create metode, der opretter et nyt Candidate objekt og sender det til databasen
    @PostMapping
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
        // Her instantiere jeg et nyt candidate objekt, som gemmer på det objekt, der bliver sendt med via RequestBody
        Candidate newCandidate = candidateRepo.save(candidate);

        // Her returnere jeg det nye Candidate objekt via ResponseEntity med status OK.
        return ResponseEntity.status(HttpStatus.OK).body(newCandidate);
    }

    // PutMapping metode der tager et objekt med via. RequestBody, som gemmes i et nyt objekt
    @PutMapping("/{id}")
    public ResponseEntity<Candidate> edit(@RequestBody Candidate candidate) {

        // Ligesom i post metoden, instantiere jeg et nyt Candidate objekt, som via RequestBody indeholder det nye(redigerede) objekt
        Candidate newCandidate = candidateRepo.save(candidate);

        // Her returneres det nye redigerede objekt via ResponseEntity med status 200(OK)
        return  ResponseEntity.status(HttpStatus.OK).body(newCandidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Candidate> delete(@PathVariable long id) {

        // Her laver jeg igen en optional, der med mit repo objekt henter det objekt der skal slettes via Pathvariable
        Optional<Candidate> optionalCandidate = candidateRepo.findById(id);

        // Her bruger jeg igen en if-else statement til at checke om min optionalCandidate er tilstede.
        // Er den tilstede, bruger jeg mit repo objekt til at slette, samt returnere ResponseEntity med status OK
        if(optionalCandidate.isPresent()) {
            candidateRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();

            // Er min optionalCandidate ikke tilstede, returneres ResponseEntity med status NOT FOUND
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // GetMapping metode der returnere Candidates tilhørende det parti der er med som parametre(Pathvariable)
    @GetMapping("/byParty/{politicalParty}")
    public ResponseEntity<List<Candidate>> findByP(@PathVariable String politicalParty) {
        // Her instantiere jeg en ny liste der skal indholde mine sorterede Candidates
        List<Candidate> sortedCandidates = new ArrayList<>();

        // Her bruger jeg mit repo objekt til at hente de Candidates der har det politicalParty der er parameter overført, og tilføjer dem til listen sortedCandidates
        candidateRepo.findCandidatesByPoliticalParty(politicalParty).forEach(sortedCandidates::add);

        // Her returnere jeg min sorterede liste med ResponseEntity status OK
        return ResponseEntity.status(HttpStatus.OK).body(sortedCandidates);
    }

    // GetMapping metode der finder by parti (Uden JPA)
    /*@GetMapping("/byParty/{politicalParty}")
    public ResponseEntity<List<Candidate>> findByParty(@PathVariable String politicalParty) {
        List<Candidate> allCandidates = new ArrayList<>();
        candidateRepo.findAll().forEach(allCandidates::add);

        List<Candidate> sortedCandidates = new ArrayList<>();

        for(Candidate candidate : allCandidates) {
            if(candidate.getPoliticalParty().equals(politicalParty)) {
                sortedCandidates.add(candidate);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(sortedCandidates);
    }*/
}
