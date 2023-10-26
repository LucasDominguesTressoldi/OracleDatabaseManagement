package br.com.fiap.fintech.model;

public class Address {
	public int addressCode;
	public String street;
	public String neighborhood;
	public int number;

	public Address(String street, String neighborhood, int number) {
		super();
		this.street = street;
		this.neighborhood = neighborhood;
		this.number = number;
	}

	public int getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "\nENDEREÇO: { RUA: " + street + " | BAIRRO: " + neighborhood + " | NÚMERO: " + number + " }";
	}	
}
