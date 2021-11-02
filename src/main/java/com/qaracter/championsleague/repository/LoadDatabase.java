package com.qaracter.championsleague.repository;

import com.qaracter.championsleague.model.AdmittedCountries;
import com.qaracter.championsleague.model.Competition;
import com.qaracter.championsleague.model.CompetitionWinners;
import com.qaracter.championsleague.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class that contains the preset content (Teams, Competitions, Winners, Countries)
 */
@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TeamRepository teamRepository,
                                   CompetitionRepository competitionRepository,
                                   CompetitionWinnersRepository competitionWinnersRepository,
                                   AdmittedCountriesRepository admittedCountriesRepository) {

        return args -> {
            log.info("Preloading " + teamRepository.save(new Team("Madrid", "Spain", "https://pbs.twimg.com/profile_images/1284197749030887429/7n6w-Urk_400x400.jpg")));
            log.info("Preloading " + teamRepository.save(new Team("Barcelona", "Spain", "Madrid", "https://pbs.twimg.com/profile_images/1409740934217142273/-RmOAoJG_400x400.jpg")));
            log.info("Preloading " + teamRepository.save(new Team("Munich", "Germany", "Dortmund", "https://1.bp.blogspot.com/-um5PXx4iQ2I/XcHguqlUIRI/AAAAAAABWj0/hKJabU4vQzE8QHDo6-bQalZN-45Xdt9rgCLcBGAsYHQ/s1600/FC%2BBayern%2BMunchen.png")));
            log.info("Preloading " + teamRepository.save(new Team("Dortmund", "Germany", "Munich", "https://a.espncdn.com/i/teamlogos/soccer/500/124.png")));

            log.info("Preloading " + competitionRepository.save(new Competition("UEFA Champions League")));
            Long ECLId = competitionRepository.findCompByName("UEFA Champions League").get().getId();

            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "PT")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "ES")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "FR")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "GB")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "BE")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "DE")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "IT")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "NL")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "BE")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "CH")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "AT")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "BY")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "PL")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "DK")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "CZ")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "SI")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "HR")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "RS")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "BG")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "GR")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "RO")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "TR")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "CY")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "MD")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "UA")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "HU")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "SK")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "RU")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "AZ")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "KZ")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "SE")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "NO")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "FI")));
            log.info("Preloading " + admittedCountriesRepository.save(new AdmittedCountries(ECLId, "IL")));


            Long madridId = teamRepository.findTeamByName("Madrid").get().getId();
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1955/1956")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1956/1957")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1957/1958")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1958/1959")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1959/1960")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1965/1966")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1997/1998")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "1999/2000")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "2001/2002")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "2013/2014")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "2015/2016")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "2016/2017")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(madridId, ECLId, "2017/2018")));

            Long FBCId = teamRepository.findTeamByName("Barcelona").get().getId();
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "1991/1992")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2005/2006")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2008/2009")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2010/2011")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2014/2015")));

            Long MunichId = teamRepository.findTeamByName("Munich").get().getId();
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "1973/1973")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "1974/1975")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "1975/1976")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2000/2001")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2012/2013")));
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "2019/2020")));

            Long DortmundId = teamRepository.findTeamByName("Dortmund").get().getId();
            log.info("Preloading " + competitionWinnersRepository.save(
                    new CompetitionWinners(FBCId, ECLId, "1996/1997")));
        };
    }
}
