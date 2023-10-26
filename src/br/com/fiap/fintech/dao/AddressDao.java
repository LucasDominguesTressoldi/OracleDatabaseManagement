package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Address;

public class AddressDao {

	private Connection conn;

	public AddressDao(Connection conn) {
		this.conn = conn;
	}

	public List<Address> getAll() {
		String sql = "SELECT * FROM T_SIP_ENDERECO ORDER BY CD_ENDERECO";
		List<Address> address = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			address = new ArrayList<Address>();

			while (rs.next()) {
				int addressCode = rs.getInt("CD_ENDERECO");
				String street = rs.getString("NM_RUA");
				String neighborhood = rs.getString("NM_BAIRRO");
				int number = rs.getInt("NR_CASA");

				Address a = new Address(street, neighborhood, number);
				a.setAddressCode(addressCode);

				address.add(a);
			}
		} catch (SQLException e) {
			System.out.println("Error when trying to get all data from t_sip_endereco!");
//			e.printStackTrace();
		}
		return address;
	}

	public void insert(Address a) {
		String sql = "INSERT INTO T_SIP_ENDERECO (NM_RUA, NM_BAIRRO, NR_CASA) "
				+ "VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, a.getStreet());
			ps.setString(2, a.getNeighborhood());
			ps.setInt(3, a.getNumber());

			ps.execute();

			System.out.println("Address registered successfully!");
		} catch (SQLException e) {
			System.err.println("Error when trying to register the address into t_sip_endereco!");
//			e.printStackTrace();
		}
	}

}
