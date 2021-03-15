package com.bigcommerce.dao;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingAddress{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("form_fields")
	private List<Object> formFields;

	@JsonProperty("street_1")
	private String street1;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("street_2")
	private String street2;

	@JsonProperty("company")
	private String company;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country_iso2")
	private String countryIso2;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("email")
	private String email;

	public void setZip(String zip){
		this.zip = zip;
	}

	public String getZip(){
		return zip;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setFormFields(List<Object> formFields){
		this.formFields = formFields;
	}

	public List<Object> getFormFields(){
		return formFields;
	}

	public void setStreet1(String street1){
		this.street1 = street1;
	}

	public String getStreet1(){
		return street1;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setStreet2(String street2){
		this.street2 = street2;
	}

	public String getStreet2(){
		return street2;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCountryIso2(String countryIso2){
		this.countryIso2 = countryIso2;
	}

	public String getCountryIso2(){
		return countryIso2;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}