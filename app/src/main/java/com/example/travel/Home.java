package com.example.travel;

class Home{
    //Address constants
    protected static String ADDRESS_ONE = "123 Main Street St. Louisville OH 43071";
    protected static String ADDRESS_TWO = "432 Main Long Road St. Louisville OH 43072";
    protected static String ADDRESS_THREE = "786 High Street Pollocksville MA 02134";
    
    private String streetNumber;
    private String streetName;
    private String zipcode;
    
    public Home(){
        streetNumber = "";
        streetName = "";
        zipcode = "";
    }

    public Home(String address){
        streetNumber = findStreetNumber(address);
        streetName = address.substring((streetNumber.length() + 1), (address.length() - 9));
        zipcode = address.substring((address.length() - 8), (address.length()));;
    }

    public String findStreetNumber (String address){
        String streetNumber = "";
        int spaceIndex = 0;

        spaceIndex = address.indexOf(" ");
        streetNumber = address.substring(0, spaceIndex);
      
        return streetNumber;
    }

    public String getZipCode(){

        return this.zipcode;
    }

    public String toString(){
        return this.streetNumber + " " + this.streetName + " " + this.zipcode;
    }

    protected boolean hasZipcode(String input){

        return this.getZipCode().equals(input);
    }
}