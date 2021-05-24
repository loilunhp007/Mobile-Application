package com.example.bailan2_bai1;

public class Country{

    long geonameId;
    String countryName, countryCode, population, areaInSqKm;

    public Country(long geonameId, String countryName, String countryCode, String population, String areaInSqKm) {
        super();
        this.geonameId = geonameId;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.population = population;
        this.areaInSqKm = areaInSqKm;
    }
    public long getId() {
        return geonameId;
    }
    public void setId(long id) {
        this.geonameId = id;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }
    public String getAreaInSqKm() {
        return areaInSqKm;
    }
    public void setAreaInSqKm(String areaInSqKm) { this.areaInSqKm = areaInSqKm; }




//    long geonameId;
//    String countryName, continent, capital, languages, isoAlpha3, fipsCode, population, isoNumeric,areaInSqKm;
//    String countryCode, postalCodeFormat, continentName, currencyCode;
//    double south, north, east, west;
//
//    public Country(long geonameId, String countryName, String continent, String capital, String languages, String isoAlpha3,
//                   String fipsCode, String population, String isoNumeric, String areaInSqKm, String countryCode,
//                   String postalCodeFormat, String continentName, String currencyCode, double south, double north,
//                   double east, double west){
//        super();
//        this.geonameId = geonameId;
//        this.countryName = countryName;
//        this.continent =  continent;
//        this.capital = capital;
//        this.languages =  languages;
//        this.south = south;
//        this.isoAlpha3 = isoAlpha3;
//        this.north = north;
//        this.fipsCode = fipsCode;
//        this.population = population;
//        this.east = east;
//        this.isoNumeric = isoNumeric;
//        this.areaInSqKm = areaInSqKm;
//        this.countryCode = countryCode;
//        this.west = west;
//        this.postalCodeFormat =postalCodeFormat;
//        this.continentName = continentName;
//        this.currencyCode = currencyCode;
//    }
//    public long getId() {
//        return geonameId;
//    }
//    public void setId(long id) {
//        this.geonameId = id;
//    }
//    public String getCountryName() {
//        return countryName;
//    }
//    public void setCountryName(String countryName) {
//        this.countryName = countryName;
//    }
}