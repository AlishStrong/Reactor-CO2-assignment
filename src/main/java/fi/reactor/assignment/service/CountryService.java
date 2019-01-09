package fi.reactor.assignment.service;

import fi.reactor.assignment.model.Country;
import fi.reactor.assignment.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }

    public List<Country> getAllCountriesABC() {
        List<Country> countries = getAllCountries();
        countries.sort(Comparator.comparing(Country::getName));
        return countries;
    }

    public List<Country> getAllCountriesRegion() {
        List<Country> countries = getAllCountriesABC();
        countries.sort(Comparator.comparing(Country::getRegion));
        return countries;
    }

    public List<Country> getAllCountriesIncome() {
        List<Country> countries = getAllCountriesABC();
        countries.sort(Comparator.comparing(Country::getIncomelevel));
        return countries;
    }

    public Map<String, List<Country>> getMapCountriesABC() {
        List<Country> countries = getAllCountriesABC();
        Map<String, List<Country>> toReturn = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            String key = String.valueOf(ch);
            final char chkey = ch;
            List<Country> countriesABC = countriesABC = countries.stream()
                    .filter((c) -> {return c.getName().charAt(0) == chkey;})
                    .collect(Collectors.toList());
            if (countriesABC.size() > 0) {
                toReturn.put(key, countriesABC);
            }
        }
        return toReturn;
    }

    public Map<String, List<Country>> getMapCountriesRegion() {
        Map<String, List<Country>> toReturn = new HashMap<>();
        getAllCountriesRegion().stream().forEach((country) -> {
            if (toReturn.containsKey(country.getRegion())) {
                toReturn.get(country.getRegion()).add(country);
            } else {
                String key = country.getRegion();
                List<Country> countryList = new ArrayList<>();
                countryList.add(country);
                toReturn.put(key, countryList);
            }
        });
        return toReturn;
    }

    public Map<String, List<Country>> getMapCountriesIncomeLevel() {
        SortedMap<String, List<Country>> toReturn = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = valueConversion(o1);
                String s2 = valueConversion(o2);
                return s1.compareTo(s2);
            }
            public String valueConversion(String s) {
                switch (s.toLowerCase()) {
                    case "high income":
                        return "a";
                    case "upper middle income":
                        return "b";
                    case "lower middle income":
                        return "c";
                    case "low income":
                        return "d";
                    default:return "";
                }
            }
        });
        getAllCountriesRegion().stream().forEach((country) -> {
            if (toReturn.containsKey(country.getIncomelevel())) {
                toReturn.get(country.getIncomelevel()).add(country);
            } else {
                String key = country.getIncomelevel();
                List<Country> countryList = new ArrayList<>();
                countryList.add(country);
                toReturn.put(key, countryList);
            }
        });
        toReturn.forEach((k,v) -> {v.sort(Comparator.comparing(Country::getName));});
        return toReturn;
    }
}
