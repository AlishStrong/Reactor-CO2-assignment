package fi.reactor.assignment.controller;

import fi.reactor.assignment.model.Country;
import fi.reactor.assignment.model.custom.CountryEmission;
import fi.reactor.assignment.service.CountryService;
import fi.reactor.assignment.service.PopulationEmissionService;
import fi.reactor.assignment.service.custom.CustomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);

    @Autowired
    CountryService countryService;

    @Autowired
    PopulationEmissionService populationEmissionService;

    @Autowired
    CustomService customService;

    @GetMapping(value = {"/", "/{year}"})
    public String indexPage(Model model, @PathVariable("year") Optional<Integer> year) {
        List<CountryEmission> countryEmissions = customService.getTopFivePolluters();
        model.addAttribute("topFivePollutors", countryEmissions);
        if (year.isPresent() && (1960 <= year.get() && year.get() <= 2017)) {
            model.addAttribute("selectedYear", year.get());
            model.addAttribute("jvectorMap", customService.getJvectorCountriesAtYear(year.get()));
            return "index";
        } else {
            model.addAttribute("selectedYear", 2010);
            model.addAttribute("jvectorMap", customService.getJvectorCountriesAtYear(2010));
        }
        return "index";
    }

    @GetMapping(value = "/country/{code}")
    public String countryPage(Model model, @PathVariable("code") String code) {
        model.addAttribute("popem", populationEmissionService.getAllPopEmAboutCountry(code));
        model.addAttribute("country", countryService.getCountryByCode(code));
        return "country";
    }

    @GetMapping(value = "/countries/{sorter}")
    public String homePage(Model model, @PathVariable("sorter") String sorter) {
        switch (sorter) {
            case "abc":
                Map<String, List<Country>> abcMap = countryService.getMapCountriesABC();
                model.addAttribute("abcMap", abcMap);
                model.addAttribute("pageTitle", "Alphabet");
                return "all-countries";
            case "region":
                Map<String, List<Country>> regionMap = countryService.getMapCountriesRegion();
                model.addAttribute("regionMap", regionMap);
                model.addAttribute("pageTitle", "Regions");
                return "all-countries";
            case "income":
                Map<String, List<Country>> incomeLevelMap = countryService.getMapCountriesIncomeLevel();
                model.addAttribute("incomeLevelMap", incomeLevelMap);
                model.addAttribute("pageTitle", "Income level");
                return "all-countries";
            default:
                return "error";
        }
    }
}
