package br.com.ifood.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifood.bean.Comida;
import br.com.ifood.bean.Restaurante;
import br.com.ifood.dao.RestauranteDAO;
import br.com.ifood.exception.DBException;
import br.com.ifood.singleton.ConnectionManager;



public class OracleRestauranteDAO implements RestauranteDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Restaurante restaurante) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_RESTAURANTE (ID_RESTAURANTE, NOME_RESTAURANTE, VLR_FRETE, TP_ENTREGA, VLR_PEDIDO_MIN, NOME_RESP, EMAIL_RESP, NR_CNPJ, DS_REGIAO, T_TIPO_COMIDA_ID_TIPO_COMIDA) VALUES"
					+ "(SQ_ID_RESTAURANTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, restaurante.getNomeRestaurante());
			stmt.setFloat(2, restaurante.getValorFrete());
			stmt.setInt(3, restaurante.getTempoEntrega());
			stmt.setFloat(4, restaurante.getValorPedido());
			stmt.setString(5, restaurante.getNomeResponsavel());
			stmt.setString(6, restaurante.getEmailResponsavel());
			stmt.setString(7, restaurante.getCnpj());
			stmt.setString(8, restaurante.getRegiao());
			stmt.setInt(9, restaurante.getComida().getIdComida());
			
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Restaurante> listar() {
		List<Restaurante> lista = new ArrayList<Restaurante>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_RESTAURANTE");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("ID_RESTAURANTE");
				String nome = rs.getString("NOME_RESTAURANTE");
				float frete = rs.getFloat("VLR_FRETE");
				int entrega = rs.getInt("TP_ENTREGA");	
				float pedidoMin = rs.getFloat("VLR_PEDIDO_MIN");
				String responsavel = rs.getString("NOME_RESP");
				String email = rs.getString("EMAIL_RESP");
				String cnpj = rs.getString("NR_CNPJ");
				String regiao = rs.getString("DS_REGIAO");

				Restaurante restaurante = new Restaurante(codigo, nome, frete, entrega, pedidoMin, responsavel, email, cnpj, regiao);
				lista.add(restaurante);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;

	}

	@Override
	public Restaurante buscar(int id) {
		Restaurante restaurante = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement(
					"SELECT * FROM T_RESTAURANTE "
					+ "INNER JOIN T_TIPO_COMIDA "
					+ "ON T_RESTAURANTE.T_TIPO_COMIDA_ID_TIPO_COMIDA = T_TIPO_COMIDA.ID_TIPO_COMIDA"
					+ " WHERE T_RESTAURANTE.ID_RESTAURANTE = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("ID_RESTAURANTE");
				String nome = rs.getString("NOME_RESTAURANTE");
				float frete = rs.getFloat("VLR_FRETE");
				int entrega = rs.getInt("TP_ENTREGA");	
				float pedidoMin = rs.getFloat("VLR_PEDIDO_MIN");
				String responsavel = rs.getString("NOME_RESP");
				String email = rs.getString("EMAIL_RESP");
				String cnpj = rs.getString("NR_CNPJ");
				String regiao = rs.getString("DS_REGIAO");
				
				int codigoComida = rs.getInt("ID_TIPO_COMIDA");
				String nomeComida = rs.getString("DS_TIPO_COMIDA");
				

				restaurante = new Restaurante (codigo, nome, frete, entrega, pedidoMin, responsavel, email, cnpj, regiao);
				Comida comida = new Comida(codigoComida, nomeComida);
				restaurante.setComida(comida);
				
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return restaurante;
	}
	
	
	@Override
	public void atualizar(Restaurante restaurante) throws DBException {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_RESTAURANTE SET NOME_RESTAURANTE = ?, VLR_FRETE = ?, TP_ENTREGA = ?, VLR_PEDIDO_MIN = ?, NOME_RESP = ?, EMAIL_RESP = ?, NR_CNPJ = ?, DS_REGIAO = ?, T_TIPO_COMIDA_ID_TIPO_COMIDA = ? WHERE ID_RESTAURANTE = ?";

			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, restaurante.getNomeRestaurante());
			stmt.setFloat(2, restaurante.getValorFrete());
			stmt.setInt(3, restaurante.getTempoEntrega());
			stmt.setFloat(4, restaurante.getValorPedido());
			stmt.setString(5, restaurante.getNomeResponsavel());
			stmt.setString(6, restaurante.getEmailResponsavel());
			stmt.setString(7, restaurante.getCnpj());
			stmt.setString(8, restaurante.getRegiao());
			stmt.setInt(9, restaurante.getComida().getIdComida());
			stmt.setInt(10, restaurante.getIdRestaurante());
			
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int id) throws DBException {
		
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "DELETE FROM T_RESTAURANTE WHERE ID_RESTAURANTE = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1,  id);
			
			stmt.executeUpdate();
			
		} catch (SQLException e){
			e.printStackTrace();
			throw new DBException("Erro ao deletar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
	}

}
