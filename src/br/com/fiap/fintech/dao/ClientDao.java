package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.model.Address;
import br.com.fiap.fintech.model.Client;

public class ClientDao {

	private Connection conn;

	public ClientDao(Connection conn) {
		this.conn = conn;
	}

	public List<Client> getAll() {
		String sql = "SELECT C.*, E.NM_RUA, E.NM_BAIRRO, E.NR_CASA FROM T_SIP_CLIENTE C, T_SIP_ENDERECO E WHERE "
				+ "C.CD_ENDERECO = E.CD_ENDERECO ORDER BY CD_CLIENTE";
		List<Client> clients = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			clients = new ArrayList<Client>();

			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("CD_CLIENTE"));
				c.setName(rs.getString("NM_CLIENTE"));
				c.setCpf(rs.getString("NR_CPF"));
				c.setBirth(rs.getDate("DT_NASC").toLocalDate());
				c.setEmail(rs.getString("DS_EMAIL"));
				c.setCel(rs.getString("NR_TELEFONE"));

				int addressCode = rs.getInt("CD_ENDERECO");
				String street = rs.getString("NM_RUA");
				String neighborhood = rs.getString("NM_BAIRRO");
				int number = rs.getInt("NR_CASA");
				c.setAddress(new Address(street, neighborhood, number));
				c.setAddressCode(addressCode);

				clients.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Error when trying to get all data from t_sip_cliente!");
			e.printStackTrace();
		}
		return clients;
	}

	public void insert(Client c) {
		String sql = "INSERT INTO T_SIP_CLIENTE (NM_CLIENTE, NR_CPF, DT_NASC, DS_EMAIL, NR_TELEFONE, CD_ENDERECO) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		AddressDao address = new AddressDao(conn);
		address.insert(c.getAddress());

		try {
			Date date = Date.valueOf(c.getBirth());

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, c.getName());
			ps.setString(2, c.getCpf());
			ps.setDate(3, date);
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getCel());
			ps.setInt(6, c.getAddress().getAddressCode());

			ps.execute();

			System.out.println("Client registered successfully!");
		} catch (SQLException e) {
			System.err.println("Error when trying to register the client into t_sip_cliente!");
//			e.printStackTrace();
		}
	}

}
