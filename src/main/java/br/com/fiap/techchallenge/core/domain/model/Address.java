package br.com.fiap.techchallenge.core.domain.model;

public class Address {

    private final String id;
    private String postalCode;
    private String streetName;
    private String additionalInfo;
    private String neighborhood;
    private String city;
    private String stateProvince;
    private String country;


    public Address(
            String id,
            String postalCode,
            String streetName,
            String additionalInfo,
            String neighborhood,
            String city,
            String stateProvince,
            String country) {

        this.id = id;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
        this.neighborhood = neighborhood;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }


    public Address(String postalCode,
                   String streetName,
                   String additionalInfo,
                   String neighborhood,
                   String city,
                   String stateProvince,
                   String country) {

        this.id = null;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
        this.neighborhood = neighborhood;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }



}
