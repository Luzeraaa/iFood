package br.com.ifood.dao;

import java.util.List;

import br.com.ifood.bean.*;
import br.com.ifood.exception.DBException;

public interface ComidaDAO {
	
	 List<Comida> listar();
	 void cadastrar(Comida comida) throws DBException;
	 void atualizar(Comida comida) throws DBException;
	 void remover(int id) throws DBException;
	
}
