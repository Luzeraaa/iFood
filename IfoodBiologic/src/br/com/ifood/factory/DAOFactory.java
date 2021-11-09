package br.com.ifood.factory;

import br.com.ifood.dao.ComidaDAO;
import br.com.ifood.dao.RestauranteDAO;
import br.com.ifood.impl.OracleComidaDAO;
import br.com.ifood.impl.OracleRestauranteDAO;

public class DAOFactory {

	public static RestauranteDAO getRestauranteDAO() {
		
		return new OracleRestauranteDAO();
		
	}
	
	public static ComidaDAO getComidaDAO() {
		return new OracleComidaDAO();
	}
}

