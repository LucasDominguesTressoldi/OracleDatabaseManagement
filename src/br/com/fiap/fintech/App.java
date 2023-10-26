package br.com.fiap.fintech;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.fiap.fintech.dao.AddressDao;
import br.com.fiap.fintech.dao.ClientDao;
import br.com.fiap.fintech.dao.Connect;
import br.com.fiap.fintech.model.Client;
import br.com.fiap.fintech.model.Address;

public class App {

	public static void main(String[] args) {
		
		Connection conn = Connect.openConnection();

		Client c = new Client();
		c.setName("Júlia Alvez Carala");
		c.setCel("+55(13)99590-3290");
		c.setCpf("403.487.472-00");
		c.setBirth(LocalDate.of(2010, 9, 30));
		c.setEmail("");
		c.setAddress(new Address("Itapetininga", "Paulo Luiz II", 7113));
		c.address.setAddressCode(1);

		ClientDao client = new ClientDao(conn);
		AddressDao address = new AddressDao(conn);

		client.insert(c);

		List<Client> clients = client.getAll();

		if (!clients.isEmpty()) {
			for (Client clientInList : clients) {
				System.out.println(clientInList);
			}
		} else {
			System.out.println("No clients to show!");
		}

		List<Address> addresses = address.getAll();

		if (!addresses.isEmpty()) {
			for (Address addressesInList : addresses) {
				System.out.println(addressesInList);
			}
		} else {
			System.out.println("No addresses to show!");
		}

		try {
			conn.close();
			System.out.println("\nConnection closed!");
		} catch (SQLException e) {
			System.err.println("Error when trying to close connection!");
//			e.printStackTrace();
		}
	}

}
