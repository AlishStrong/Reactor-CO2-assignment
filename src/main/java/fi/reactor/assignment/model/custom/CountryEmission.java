package fi.reactor.assignment.model.custom;

//Not an Entity!
//Custom object implementation
public class CountryEmission {
    private String name;
    private String code;
    private Double emission;

    public CountryEmission() {}

    public CountryEmission(String name, String code, Double emission) {
        this.name = name;
        this.code = code;
        this.emission = emission;
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

    public Double getEmission() {
        return emission;
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }

    @Override
    public String toString() {
        return "CountryEmission{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", emission=" + emission +
                '}';
    }
}
