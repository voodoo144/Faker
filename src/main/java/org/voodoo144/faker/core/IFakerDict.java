package org.voodoo144.faker.core;

public interface IFakerDict {
    String[] getWords();
    String[] getFirstNames();
    String[] getLastNames();
    String[] getMiddleNames();
    String[] getCityPrefixes();
    String[] getRegionSuffixes();
    String[] getStreetPrefixes();
    String[] getCountries();
    String[] getRegionsOrStates();
    String[] getCities();
    String[] getStreets();
    String[] getNamePrefixes();
    String[] getNameSuffixes();

    String getPostCodeFormat();
}
