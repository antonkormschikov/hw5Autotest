package data;

public enum RussiaCityData implements ICityData {
    MOSCOW("Москва",CountryData.RUSSIA);

    private String name;
    private CountryData countryData;
    RussiaCityData(String name, CountryData countryData){
        this.name=name;
        this.countryData= countryData;
    }
    public String getName(){
        return name;
    }
    public CountryData getCountryData(){
        return countryData;
    }

}
