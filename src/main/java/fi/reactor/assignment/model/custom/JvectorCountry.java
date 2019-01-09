package fi.reactor.assignment.model.custom;

//Not an Entity!
//Custom object implementation
public class JvectorCountry {
    String tricode;
    String bicode;
    Integer population;
    Double emission;

    public JvectorCountry() {}

    public JvectorCountry(String bicode, Integer population, Double emission) {
        this.bicode = bicode;
        this.population = population;
        this.emission = emission;
    }

    public JvectorCountry(String tricode, String bicode, Integer population, Double emission) {
        this.tricode = tricode;
        this.bicode = bicode;
        this.population = population;
        this.emission = emission;
    }

    public String getTricode() {
        return tricode;
    }

    public void setTricode(String tricode) {
        this.tricode = tricode;
    }

    public String getBicode() {
        return bicode;
    }

    public void setBicode(String bicode) {
        this.bicode = bicode;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getEmission() {
        return emission;
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }

    @Override
    public String toString() {
        return "JvectorCountry{" +
                "tricode='" + tricode + '\'' +
                ", bicode='" + bicode + '\'' +
                ", population=" + population +
                ", emission=" + emission +
                '}';
    }
}
