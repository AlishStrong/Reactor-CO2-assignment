package fi.reactor.assignment.repository;

import fi.reactor.assignment.model.PopulationEmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PopulationEmissionRepository extends JpaRepository<PopulationEmission, Map<String, Integer>> {
    PopulationEmission findByIdCodeAndIdYear(String code, Integer year);
    List<PopulationEmission> findByIdCode(String code);
    List<PopulationEmission> findByIdYear(Integer year);
}
