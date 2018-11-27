package com.example.steri.fysiodossier;
import java.util.Date;
/**
 * Class that holds the patient properties
 *
 * Created by steri on 22-9-2017.
 */

public class Patient {

    //private variables
    private int id;
    private String initials;
    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String phoneNumber;
    private String email;
    private Date birthDate;
    private String bsn;
    private int insuranceCompany;
    private  String insuranceNumber;

    // Empty constructor
    public Patient(){

    }

    // test constructor
    public Patient(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // constructor TODO make shure that validation of input is handeled in front end view
    public Patient (int id, String firstName, String lastName,
                    String street, String houseNumber, String zipCode, String city, String phoneNumber, String email,
                    Date birthDate, String bsn, int insuranceCompany, String insuranceNumber)
    {
        this.id = id;
        this.firstName  = firstName;
        this.lastName = lastName;
        this.street = street;
        this. houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.bsn = bsn;
        this.insuranceCompany = insuranceCompany;
        this.insuranceNumber = insuranceNumber;

    }


    // TODO getters ands setters afmaken
    // getters and setters
    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet (String street) {
        this.street = street;
    }

    public String getHouseNumber(){
        return this.houseNumber;
    }
    public void setHouseNumber(String houseNumber){
        this.houseNumber = houseNumber;
    }

    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthDate() {
        return (Date) this.birthDate.clone();
    }
    public void setBirthDate (Date date) {
        this.birthDate = (Date)date.clone();
    }
    public String getBsn() {
        return bsn;
    }
    public void setBsn(String bsn) {
        this.bsn = bsn;
    }
    public int getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany (int insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    public String setInsuranceNumber() {
        return insuranceNumber;
    }
    public void getInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber ;
    }
}


