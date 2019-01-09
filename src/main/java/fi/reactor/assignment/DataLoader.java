package fi.reactor.assignment;

import fi.reactor.assignment.model.Country;
import fi.reactor.assignment.model.PopulationEmission;
import fi.reactor.assignment.repository.CountryRepository;
import fi.reactor.assignment.repository.PopulationEmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PopulationEmissionRepository populationEmissionRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("Saving some countries");
        countryRepository.save(new Country("Uzbekistan", "UZB", "Central Asia", "Low", "Vatan"));
        countryRepository.save(new Country("Russian Federation", "RUS", "Europe", "Middle", "The biggest country in the world"));
        countryRepository.save(new Country("United States of America", "USA", "North America", "High", "The land of brave and free"));
        countryRepository.save(new Country("Brazil", "BRA", "South America", "Low", "Land of wild monkeys"));
        countryRepository.save(new Country("Finland", "FIN", "Europe", "High", "I study here"));
        countryRepository.findAll().forEach(System.out::println);

        log.info("======================");
        log.info("Saving some PopulationEmissions");
        populationEmissionRepository.save(new PopulationEmission(
                countryRepository.findById("UZB").get().getCode(),
                2017,
                30000000,
                1.1,
                countryRepository.findById("UZB").get()
        ));
        populationEmissionRepository.save(new PopulationEmission(
                countryRepository.findById("UZB").get().getCode(),
                2018,
                31000000,
                2.2,
                countryRepository.findById("UZB").get()
        ));
        populationEmissionRepository.findAll().forEach(System.out::println);
    }
}
