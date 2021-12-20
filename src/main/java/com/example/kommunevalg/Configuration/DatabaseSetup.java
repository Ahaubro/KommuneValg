package com.example.kommunevalg.Configuration;

import com.example.kommunevalg.Model.Candidate;
import com.example.kommunevalg.Repository.CandidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

// Configurations klasse der skriver hardcodede kandidater i databasen ved applikationens start
@Configuration
public class DatabaseSetup implements CommandLineRunner {

    CandidateRepository candidateRepo;

    // Constructor injected repository objekt
    public DatabaseSetup(CandidateRepository candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    @Override
    public void run (String ...args) throws Exception {

        // Kandidater fra SF
        candidateRepo.save(new Candidate("Ulla Holm", "SF", 261));
        candidateRepo.save(new Candidate("Kjeld Bønkel", "SF", 28));
        candidateRepo.save(new Candidate("Anne Grethe Olsen", "SF", 9));
        candidateRepo.save(new Candidate("Lone Krag", "SF", 10));
        candidateRepo.save(new Candidate("Børge S. Buur", "SF", 1));

        // Kandidater fra socialdemokratiet
        candidateRepo.save(new Candidate("Marcel Meijer", "A", 491));
        candidateRepo.save(new Candidate("Michael Kristensen", "A", 48));
        candidateRepo.save(new Candidate("Helle Hansen", "A", 44));
        candidateRepo.save(new Candidate("Karina Knobelauch", "A", 45));
        candidateRepo.save(new Candidate("Stefan Hafstein Wolffbrandt", "A", 35));
        candidateRepo.save(new Candidate("Robert V. Rasmussen", "A", 42));
        candidateRepo.save(new Candidate("Pia Ramsing", "A", 22));
        candidateRepo.save(new Candidate("Anders Baun Sørensen", "A", 22));

        // Kandidater fra Det konservative Folkeparti
        candidateRepo.save(new Candidate("Per Urban Olsen", "C", 333));
        candidateRepo.save(new Candidate("Peter Askjær", "C", 41));
        candidateRepo.save(new Candidate("Martin Sørensen", "C", 29));
        candidateRepo.save(new Candidate("Louise Bramstorp", "C", 12));
        candidateRepo.save(new Candidate("Sigfred Jensen", "C", 36));
        candidateRepo.save(new Candidate("Jørn C. Nissen", "C", 27));
        candidateRepo.save(new Candidate("Morten Ø. Kristensen", "C", 35));
        candidateRepo.save(new Candidate("Susanne Andersen", "C", 11));
        candidateRepo.save(new Candidate("Iulian V. Paiu", "C", 12));
        candidateRepo.save(new Candidate("Per Hingel", "C", 3));


        // Kandidater fra Dansk Folkepartu
        candidateRepo.save(new Candidate("Per Mortensen", "DF", 21));

        // Kandidater fra Venstre
        candidateRepo.save(new Candidate("Søren Wiese", "V", 310));
        candidateRepo.save(new Candidate("Anita Elgaard Højholt Olesen", "V", 140));
        candidateRepo.save(new Candidate("Carsten Bruun", "V", 88));
        candidateRepo.save(new Candidate("Mogens Exner", "V", 22));
        candidateRepo.save(new Candidate("Anja Guldborg", "V", 23));
        candidateRepo.save(new Candidate("Klaus Holdorf", "V", 3));

        // Kandidater fra Enhedslisten
        candidateRepo.save(new Candidate("Katrine Høegh Mc Quaid", "Ø", 43));
        candidateRepo.save(new Candidate("Jette M. Søgaard", "Ø", 27));
        candidateRepo.save(new Candidate("Søren Caspersen", "Ø", 1));
        candidateRepo.save(new Candidate("Pia Birkmand", "Ø", 5));

    }
}
