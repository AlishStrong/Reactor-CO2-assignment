package fi.reactor.assignment.model.custom;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryEmissionMapper implements RowMapper<CountryEmission> {
    @Override
    public CountryEmission mapRow(ResultSet resultSet, int i) throws SQLException {
        CountryEmission countryEmission = new CountryEmission();
        countryEmission.setName(resultSet.getNString(1));
        countryEmission.setCode(resultSet.getNString(2));
        countryEmission.setEmission(resultSet.getDouble(3));
        return countryEmission;
    }
}
