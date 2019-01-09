package fi.reactor.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PopulationEmission")
public class PopulationEmission {
    @EmbeddedId
    private PopulationEmissionId id;
    private Integer population;

    @Column(nullable = true)
    private Double emission;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "code", insertable = false, updatable = false)
    private Country country;

    public PopulationEmission() {}

    public PopulationEmission(String code, Integer year, Integer population, Double emission, Country country) {
        this.id = new PopulationEmissionId(code, year);
        this.population = population;
        this.emission = emission;
        this.country = country;
    }

    public PopulationEmissionId getId() {
        return id;
    }

    public void setId(PopulationEmissionId id) {
        this.id = id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCode() {
        return this.id.getCode();
    }

    public double getEmission() {
        if (this.emission == null) {
            return 0.0;
        } else {
            return emission;
        }
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "PopulationEmission{" +
                "code=" + id.getCode() +
                "year=" + id.getYear() +
                ", population=" + population +
                ", emission=" + emission +
                '}';
    }
}

@Embeddable
class PopulationEmissionId implements Serializable {
    private String code;
    private Integer year;

    public PopulationEmissionId() {}

    public PopulationEmissionId(String code, Integer year) {
        this.code = code;
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
