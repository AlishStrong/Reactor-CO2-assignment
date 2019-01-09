package fi.reactor.assignment.service;

import fi.reactor.assignment.model.PopulationEmission;
import fi.reactor.assignment.repository.PopulationEmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationEmissionService {
    @Autowired
    PopulationEmissionRepository populationEmissionRepository;

    public List<PopulationEmission> getAllPopEmAboutCountry(String code) {
        return populationEmissionRepository.findByIdCode(code);
    }

    public List<PopulationEmission> getPopEmOfAllAtYear(Integer year) {
        return populationEmissionRepository.findByIdYear(year);
    }

    public PopulationEmission getAtYearOfCountry(String code, Integer year) {
        return populationEmissionRepository.findByIdCodeAndIdYear(code, year);
    }
}
