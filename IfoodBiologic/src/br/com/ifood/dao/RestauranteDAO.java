package br.com.ifood.dao;

import java.util.List;

import br.com.ifood.bean.*;
import br.com.ifood.exception.DBException;

public interface RestauranteDAO {

	public void cadastrar(Restaurante restaurante) throws DBException;
	public List<Restaurante> listar();
	public void atualizar(Restaurante restaurante) throws DBException;
	public Restaurante buscar(int id);
	public void remover(int id) throws DBException;
	
}
