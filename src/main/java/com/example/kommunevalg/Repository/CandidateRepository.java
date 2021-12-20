package com.example.kommunevalg.Repository;

import com.example.kommunevalg.Model.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    // Metode der finder alle Candidates via parti.
    List<Candidate> findCandidatesByPoliticalParty(String politicalParty);

}
