package fi.reactor.assignment.service.custom;

import fi.reactor.assignment.model.PopulationEmission;
import fi.reactor.assignment.model.custom.CountryEmission;
import fi.reactor.assignment.model.custom.JvectorCountry;
import fi.reactor.assignment.repository.custom.RepositoryCustom;
import fi.reactor.assignment.service.PopulationEmissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomService {

    private static final Logger log = LoggerFactory.getLogger(CustomService.class);

    @Autowired
    PopulationEmissionService populationEmissionService;

    @Autowired
    RepositoryCustom repositoryCustom;

    public List<CountryEmission> getTopFivePolluters() {
        return repositoryCustom.getTopFivePolluters();
    }

    public List<JvectorCountry> getJvectorCountriesAtYear(Integer year) {
        List<PopulationEmission> data = populationEmissionService.getPopEmOfAllAtYear(year);
        List<JvectorCountry> jvectorCountries = data.stream().map((ep) -> {
            JvectorCountry jvectorCountry = countryCodeConverter(ep);
            jvectorCountry.setTricode(ep.getCode());
            return jvectorCountry;
        }).collect(Collectors.toList());
        return jvectorCountries;
    }

    /*
    * This ridiculous method is needed, because the data source uses 3 letters to code countries,
    * while the JvectorMap uses 2 letters to code countries
    * */
    private JvectorCountry countryCodeConverter(PopulationEmission popem) {
        if (popem.getCode().equalsIgnoreCase("abw")) {return new JvectorCountry("ABW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("afg")) {return new JvectorCountry("AF", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ago")) {return new JvectorCountry("AO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("alb")) {return new JvectorCountry("AL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("and")) {return new JvectorCountry("AND", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("are")) {return new JvectorCountry("AE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("arg")) {return new JvectorCountry("AR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("arm")) {return new JvectorCountry("AM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("asm")) {return new JvectorCountry("ASM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("atg")) {return new JvectorCountry("ATG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("aus")) {return new JvectorCountry("AU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("aut")) {return new JvectorCountry("AT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("aze")) {return new JvectorCountry("AZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bdi")) {return new JvectorCountry("BI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bel")) {return new JvectorCountry("BE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ben")) {return new JvectorCountry("BJ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bfa")) {return new JvectorCountry("BF", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bgd")) {return new JvectorCountry("BD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bgr")) {return new JvectorCountry("BG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bhr")) {return new JvectorCountry("BHR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bhs")) {return new JvectorCountry("BS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bih")) {return new JvectorCountry("BA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("blr")) {return new JvectorCountry("BY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("blz")) {return new JvectorCountry("BZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bmu")) {return new JvectorCountry("BMU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bol")) {return new JvectorCountry("BO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bra")) {return new JvectorCountry("BR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("brb")) {return new JvectorCountry("BRB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("brn")) {return new JvectorCountry("BN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("btn")) {return new JvectorCountry("BT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("bwa")) {return new JvectorCountry("BW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("caf")) {return new JvectorCountry("CF", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("can")) {return new JvectorCountry("CA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("che")) {return new JvectorCountry("CH", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("chi")) {return new JvectorCountry("CHI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("chl")) {return new JvectorCountry("CL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("chn")) {return new JvectorCountry("CN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("civ")) {return new JvectorCountry("CI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cmr")) {return new JvectorCountry("CM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cod")) {return new JvectorCountry("CD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cog")) {return new JvectorCountry("CG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("col")) {return new JvectorCountry("CO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("com")) {return new JvectorCountry("COM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cpv")) {return new JvectorCountry("CPV", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cri")) {return new JvectorCountry("CR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cub")) {return new JvectorCountry("CU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cuw")) {return new JvectorCountry("CUW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cym")) {return new JvectorCountry("CYM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cyp")) {return new JvectorCountry("CY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("cze")) {return new JvectorCountry("CZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("deu")) {return new JvectorCountry("DE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("dji")) {return new JvectorCountry("DJ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("dma")) {return new JvectorCountry("DMA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("dnk")) {return new JvectorCountry("DK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("dom")) {return new JvectorCountry("DO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("dza")) {return new JvectorCountry("DZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ecu")) {return new JvectorCountry("EC", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("egy")) {return new JvectorCountry("EG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("eri")) {return new JvectorCountry("ER", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("esp")) {return new JvectorCountry("ES", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("est")) {return new JvectorCountry("EE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("eth")) {return new JvectorCountry("ET", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("fin")) {return new JvectorCountry("FI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("fji")) {return new JvectorCountry("FJ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("fra")) {return new JvectorCountry("FR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("fro")) {return new JvectorCountry("FRO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("fsm")) {return new JvectorCountry("FSM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gab")) {return new JvectorCountry("GA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gbr")) {return new JvectorCountry("GB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("geo")) {return new JvectorCountry("GE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gha")) {return new JvectorCountry("GH", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gib")) {return new JvectorCountry("GIB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gin")) {return new JvectorCountry("GN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gmb")) {return new JvectorCountry("GM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gnb")) {return new JvectorCountry("GW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gnq")) {return new JvectorCountry("GQ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("grc")) {return new JvectorCountry("GR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("grd")) {return new JvectorCountry("GRD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("grl")) {return new JvectorCountry("GL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gtm")) {return new JvectorCountry("GT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("gum")) {return new JvectorCountry("GUM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("guy")) {return new JvectorCountry("GY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("hkg")) {return new JvectorCountry("HKG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("hnd")) {return new JvectorCountry("HN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("hrv")) {return new JvectorCountry("HR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("hti")) {return new JvectorCountry("HT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("hun")) {return new JvectorCountry("HU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("idn")) {return new JvectorCountry("ID", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("imn")) {return new JvectorCountry("IMN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ind")) {return new JvectorCountry("IN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("irl")) {return new JvectorCountry("IE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("irn")) {return new JvectorCountry("IR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("irq")) {return new JvectorCountry("IQ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("isl")) {return new JvectorCountry("IS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("isr")) {return new JvectorCountry("IL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ita")) {return new JvectorCountry("IT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("jam")) {return new JvectorCountry("JM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("jor")) {return new JvectorCountry("JO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("jpn")) {return new JvectorCountry("JP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kaz")) {return new JvectorCountry("KZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ken")) {return new JvectorCountry("KE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kgz")) {return new JvectorCountry("KG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("khm")) {return new JvectorCountry("KH", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kir")) {return new JvectorCountry("KIR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kna")) {return new JvectorCountry("KNA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kor")) {return new JvectorCountry("KR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("kwt")) {return new JvectorCountry("KW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lao")) {return new JvectorCountry("LA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lbn")) {return new JvectorCountry("LB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lbr")) {return new JvectorCountry("LR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lby")) {return new JvectorCountry("LY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lca")) {return new JvectorCountry("LCA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lie")) {return new JvectorCountry("LIE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lka")) {return new JvectorCountry("LK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lso")) {return new JvectorCountry("LS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ltu")) {return new JvectorCountry("LT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lux")) {return new JvectorCountry("LU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("lva")) {return new JvectorCountry("LV", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mac")) {return new JvectorCountry("MAC", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("maf")) {return new JvectorCountry("MAF", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mar")) {return new JvectorCountry("MA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mco")) {return new JvectorCountry("MCO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mda")) {return new JvectorCountry("MD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mdg")) {return new JvectorCountry("MG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mdv")) {return new JvectorCountry("MDV", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mex")) {return new JvectorCountry("MX", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mhl")) {return new JvectorCountry("MHL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mkd")) {return new JvectorCountry("MK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mli")) {return new JvectorCountry("ML", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mlt")) {return new JvectorCountry("MLT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mmr")) {return new JvectorCountry("MM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mne")) {return new JvectorCountry("ME", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mng")) {return new JvectorCountry("MN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mnp")) {return new JvectorCountry("MNP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("moz")) {return new JvectorCountry("MZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mrt")) {return new JvectorCountry("MR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mus")) {return new JvectorCountry("MUS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mwi")) {return new JvectorCountry("MW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("mys")) {return new JvectorCountry("MY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nam")) {return new JvectorCountry("NA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ncl")) {return new JvectorCountry("NC", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ner")) {return new JvectorCountry("NE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nga")) {return new JvectorCountry("NG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nic")) {return new JvectorCountry("NI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nld")) {return new JvectorCountry("NL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nor")) {return new JvectorCountry("NO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("npl")) {return new JvectorCountry("NP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nru")) {return new JvectorCountry("NRU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("nzl")) {return new JvectorCountry("NZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("omn")) {return new JvectorCountry("OM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pak")) {return new JvectorCountry("PK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pan")) {return new JvectorCountry("PA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("per")) {return new JvectorCountry("PE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("phl")) {return new JvectorCountry("PH", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("plw")) {return new JvectorCountry("PLW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("png")) {return new JvectorCountry("PG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pol")) {return new JvectorCountry("PL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pri")) {return new JvectorCountry("PR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("prk")) {return new JvectorCountry("KP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("prt")) {return new JvectorCountry("PT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pry")) {return new JvectorCountry("PY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pse")) {return new JvectorCountry("PSE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("pyf")) {return new JvectorCountry("PYF", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("qat")) {return new JvectorCountry("QA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("rou")) {return new JvectorCountry("RO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("rus")) {return new JvectorCountry("RU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("rwa")) {return new JvectorCountry("RW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sau")) {return new JvectorCountry("SA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sdn")) {return new JvectorCountry("SD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sen")) {return new JvectorCountry("SN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sgp")) {return new JvectorCountry("SGP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("slb")) {return new JvectorCountry("SB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sle")) {return new JvectorCountry("SL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("slv")) {return new JvectorCountry("SV", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("smr")) {return new JvectorCountry("SMR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("som")) {return new JvectorCountry("SO", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("som")) {return new JvectorCountry("AR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("srb")) {return new JvectorCountry("RS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ssd")) {return new JvectorCountry("SS", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("stp")) {return new JvectorCountry("STP", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sur")) {return new JvectorCountry("SR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("svk")) {return new JvectorCountry("SK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("svn")) {return new JvectorCountry("SI", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("swe")) {return new JvectorCountry("SE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("swz")) {return new JvectorCountry("SZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("sxm")) {return new JvectorCountry("SXM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("syc")) {return new JvectorCountry("SYC", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("syr")) {return new JvectorCountry("SY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tca")) {return new JvectorCountry("TCA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tcd")) {return new JvectorCountry("TD", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tgo")) {return new JvectorCountry("TG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tha")) {return new JvectorCountry("TH", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tjk")) {return new JvectorCountry("TJ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tkm")) {return new JvectorCountry("TM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tls")) {return new JvectorCountry("TL", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ton")) {return new JvectorCountry("TON", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tto")) {return new JvectorCountry("TT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tun")) {return new JvectorCountry("TN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tur")) {return new JvectorCountry("TR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tuv")) {return new JvectorCountry("TUV", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("tza")) {return new JvectorCountry("TZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("uga")) {return new JvectorCountry("UG", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ukr")) {return new JvectorCountry("UA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ury")) {return new JvectorCountry("UY", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("usa")) {return new JvectorCountry("US", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("uzb")) {return new JvectorCountry("UZ", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("vct")) {return new JvectorCountry("VCT", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ven")) {return new JvectorCountry("VE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("vgb")) {return new JvectorCountry("VGB", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("vir")) {return new JvectorCountry("VIR", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("vnm")) {return new JvectorCountry("VN", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("vut")) {return new JvectorCountry("VU", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("wsm")) {return new JvectorCountry("WSM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("xkx")) {return new JvectorCountry("XK", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("yem")) {return new JvectorCountry("YE", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("zaf")) {return new JvectorCountry("ZA", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("zmb")) {return new JvectorCountry("ZM", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("zwe")) {return new JvectorCountry("ZW", popem.getPopulation(), popem.getEmission());}
        if (popem.getCode().equalsIgnoreCase("ssa")) {return new JvectorCountry("EH", popem.getPopulation(), popem.getEmission());}

        return null;
    }
}
