package br.com.ifood.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ifood.singleton.*;


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
	}
	