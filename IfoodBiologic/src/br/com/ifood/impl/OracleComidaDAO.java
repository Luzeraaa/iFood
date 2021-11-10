package br.com.ifood.impl; //TODO ADICIONEI MÉTODOS CADASTRAR, ATUALIZAR E DELETAR + CONFIRMAR SQ_TB COMIDA

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ifood.exception.DBException;
import br.com.ifood.singleton.ConnectionManager;
import br.com.ifood.bean.*;
import br.com.ifood.dao.ComidaDAO;

public class OracleComidaDAO implements ComidaDAO{

	private Connection conexao;

	@Override
	public List<Comida> listar() {
		List<Comida> lista = new ArrayList<Comida>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_TIPO_COMIDA");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("ID_TIPO_COMIDA");
				String comida = rs.getString("DS_TIPO_COMIDA");
				Comida categoria = new Comida(codigo,comida);
				lista.add(categoria);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
					rs.close();
					conexao.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return lista;
		}

	@Override
	public void cadastrar(Comida comida) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "INSERT INTO T_TIPO_COMIDA (ID_TIPO_COMIDA, DS_TIPO_COMIDA) VALUES (SQ_TB_PRODUTO.NEXTVAL, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,  comida.getDescricaoComida());
			
			stmt.executeUpdate();
			
		} catch (SQLException e){
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
	public void atualizar(Comida comida) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE T_TIPO_COMIDA SET DS_TIPO_COMIDA = ? WHERE ID_TIPO_COMIDA = ?";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1,  comida.getDescricaoComida());
			stmt.setInt(2,  comida.getIdComida());
			
			stmt.executeUpdate();
			
		} catch (SQLException e){
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
			
			String sql = "DELETE FROM T_TIPO_COMIDA WHERE ID_TIPO_COMIDA = ?";
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
	