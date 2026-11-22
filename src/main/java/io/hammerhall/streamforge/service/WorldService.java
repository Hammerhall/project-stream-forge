package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.world.City;
import io.hammerhall.streamforge.domain.world.Country;
import io.hammerhall.streamforge.domain.world.CountryLanguage;
import java.util.Collection;

public interface WorldService {

    Collection<Country> findAllCountries();

    Collection<City> findAllCities();

    Collection<CountryLanguage> findAllLanguages();
}
