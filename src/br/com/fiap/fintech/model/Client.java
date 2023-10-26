package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Client {
	public int id;
	public String name;
	public String cpf;
	public LocalDate birth;
	public String email;
	public String cel;
	public Address address;
	public int addressCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}	

	@Override
	public String toString() {
		return "\nCD_CLIENTE: " + id + " | NM_CLIENTE: " + name + " | NR_CPF: " + cpf + " | DT_NASC: " + birth
				+ " | DS_EMAIl: " + email + " | NR_TELEFONE: " + cel + address;
	}
}
