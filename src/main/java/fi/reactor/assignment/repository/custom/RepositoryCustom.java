package fi.reactor.assignment.repository.custom;

import fi.reactor.assignment.model.custom.CountryEmission;

import java.util.List;

public interface RepositoryCustom {
    List<CountryEmission> getTopFivePolluters();
}
