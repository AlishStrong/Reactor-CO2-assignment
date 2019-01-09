package fi.reactor.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    private String name;

    @Id
    private String code;
    private String region;
    private String incomelevel;
    private String comments;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY)
    private List<PopulationEmission> populationEmissions;

    public Country() {}

    public Country(String name, String code, String region, String incomelevel, String comments) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.incomelevel = incomelevel;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIncomelevel() {
        return incomelevel;
    }

    public void setIncomelevel(String incomelevel) {
        this.incomelevel = incomelevel;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<PopulationEmission> getPopulationEmissions() {
        return populationEmissions;
    }

    public void setPopulationEmissions(List<PopulationEmission> populationEmissions) {
        this.populationEmissions = populationEmissions;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", incomelevel='" + incomelevel + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
