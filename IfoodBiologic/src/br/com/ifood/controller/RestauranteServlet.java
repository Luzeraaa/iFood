package br.com.ifood.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifood.bean.Comida;
import br.com.ifood.bean.Restaurante;
import br.com.ifood.dao.ComidaDAO;
import br.com.ifood.dao.RestauranteDAO;
import br.com.ifood.factory.DAOFactory;
import br.com.ifood.exception.DBException;

@WebServlet("/restaurante")
public class RestauranteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestauranteDAO dao;
	private ComidaDAO comidaDAO;

	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getRestauranteDAO();
		comidaDAO = DAOFactory.getComidaDAO();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;

		case "excluir":
			excluir(request, response);
			break;
		}

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao == null) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}
		switch (acao) {
			case "listar":
				listar(request, response);
				break;
			case "abrir-form-edicao":
				abrirFormEdicao(request, response);
				break;
			case "abrir-form-cadastro":
				abrirFormCadastro(request,response);
				break;
			case "listarTaxa":
				listarTaxa(request, response);
				break;
			case "listarTempo":
				listarTempo(request, response);
				break;
			case "listarPedidoMinimo":
				listarPedido(request, response);
				break;
		}
	}


	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarOpcoesComida(request);
		request.getRequestDispatcher("cadastro-restaurante.jsp").forward(request, response);
	}

	private void carregarOpcoesComida(HttpServletRequest request) {
		List<Comida> lista = comidaDAO.listar();
		request.setAttribute("comidas", lista);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Restaurante restaurante = dao.buscar(id);
		request.setAttribute("restaurante", restaurante);
		carregarOpcoesComida(request);
		request.getRequestDispatcher("edicao-restaurante.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurante> lista = dao.listar();
		request.setAttribute("restaurantes", lista);
		request.getRequestDispatcher("restaurante-listar.jsp").forward(request, response);
	}
	
	private void listarTaxa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurante> listaTaxa = dao.listarTaxa();
		request.setAttribute("restaurantes", listaTaxa);
		request.getRequestDispatcher("restaurante-taxa.jsp").forward(request, response);
	}
	
	private void listarTempo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurante> listaTempo = dao.listarTempo();
		request.setAttribute("restaurantes", listaTempo);
		request.getRequestDispatcher("restaurante-tempo.jsp").forward(request, response);
	}
	
	private void listarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurante> listarPedido = dao.listarPedido();
		request.setAttribute("restaurantes", listarPedido);
		request.getRequestDispatcher("restaurante-saturacao.jsp").forward(request, response);
	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String nome = request.getParameter("restaurante");
			float frete = Float.parseFloat(request.getParameter("frete"));
			int entrega = Integer.parseInt(request.getParameter("tempoEntrega"));
			float pedidoMinimo = Float.parseFloat(request.getParameter("pedidoMinimo"));
			String responsavel = request.getParameter("responsavel");
			String email = request.getParameter("emailResponsavel");
			String cnpj = request.getParameter("cnpj");
			String regiao = request.getParameter("regiao");
			int codigoComida = Integer.parseInt(request.getParameter("comida"));

			Comida comida = new Comida();
			comida.setIdComida(codigoComida);


			Restaurante restaurante = new Restaurante(0, nome, frete, entrega, pedidoMinimo, responsavel, email, cnpj, regiao);
			restaurante.setComida(comida);
			dao.cadastrar(restaurante);

			request.setAttribute("msg", "Produto Cadastrado com sucesso!");

		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao se conectar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados.");
		}

		abrirFormCadastro(request, response);
	}



	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("restaurante");
			float frete = Float.parseFloat(request.getParameter("frete"));
			int entrega = Integer.parseInt(request.getParameter("tempoEntrega"));
			float pedidoMinimo = Float.parseFloat(request.getParameter("pedidoMinimo"));
			String responsavel = request.getParameter("responsavel");
			String email = request.getParameter("emailResponsavel");
			String cnpj = request.getParameter("cnpj");
			String regiao = request.getParameter("regiao");
			int codigoComida = Integer.parseInt(request.getParameter("comida"));

			Comida comida = new Comida();
			comida.setIdComida(codigoComida);

			Restaurante restaurante = new Restaurante(codigo, nome, frete, entrega, pedidoMinimo, responsavel, email, cnpj, regiao);
			restaurante.setComida(comida);
			dao.atualizar(restaurante);

			request.setAttribute("msg", "Produto atualizado com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados.");
		}
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));

		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Restaurante removido");

		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request, response);

	}


}
