package fi.reactor.assignment.repository;

import fi.reactor.assignment.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByRegion(String region);
    List<Country> findByIncomelevel(String incomeLevel);
    List<Country> findByRegionAndIncomelevel(String region, String incomeLevel);
    Country findByCode(String code);
    Country findByName(String name);
}
