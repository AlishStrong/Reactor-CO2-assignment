package fi.reactor.assignment.repository.custom;

import fi.reactor.assignment.model.custom.CountryEmission;
import fi.reactor.assignment.model.custom.CountryEmissionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryCustomImpl implements RepositoryCustom {

    private static final Logger log = LoggerFactory.getLogger(RepositoryCustomImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

/*
    Query to get top 10 polluters of our world from 2000

    select country.name as 'Country',
    country.code as 'Code',
    sum(PopulationEmission.emission) as 'Emissions'
    from country
    join PopulationEmission on PopulationEmission.code = country.code
    where PopulationEmission.year between 2000 and 2017
    group by country.name, country.code
    order by sum(PopulationEmission.emission) desc
    limit 10;

     */

    @Override
    public List<CountryEmission> getTopFivePolluters() {
        String sql = "select country.name as 'Country', " +
                "country.code as 'Code', " +
                "sum(PopulationEmission.emission) as 'Emissions' " +
                "from country " +
                "join PopulationEmission on PopulationEmission.code = country.code " +
                "where PopulationEmission.year between 2000 and 2017 " +
                "group by country.name, country.code " +
                "order by sum(PopulationEmission.emission) desc " +
                "limit 5";
        RowMapper<CountryEmission> rowMapper = new CountryEmissionMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
