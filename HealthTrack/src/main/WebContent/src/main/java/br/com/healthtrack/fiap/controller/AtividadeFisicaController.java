package br.com.healthtrack.fiap.controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.fiap.dao.AtividadeFisicaDAO;
import br.com.healthtrack.fiap.dao.DAOFactory;
import br.com.healthtrack.fiap.entities.AtividadeFisica;
import br.com.healthtrack.fiap.entities.Peso;
import br.com.healthtrack.fiap.entities.Pessoa;

/**
 * Servlet implementation class AtividadeFisicaController
 */
@WebServlet("/AtividadeFisicaController")
public class AtividadeFisicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtividadeFisicaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("perfil.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getAttribute("email");
		boolean userExists = DAOFactory.getPessoaDAO().verifyIfUserAlreadyExists(email);
		
		if (userExists) {
			Pessoa pessoa = DAOFactory.getPessoaDAO().getPessoaByEmail(email);
			
			String nomeNovoTreino = (String) request.getAttribute("nomeNovoTreino");
			String nomeTipoNovoTreino = (String) request.getAttribute("nomeTipoNovoTreino");
			
			

			
			AtividadeFisica newAtvFisica = new AtividadeFisica(3,nomeNovoTreino, new GregorianCalendar().getInstance(), nomeTipoNovoTreino,
					pessoa.getIdUsuario());
			
			DAOFactory.getAtividadeFisicaDAO().cadastrar(newAtvFisica);
		}
		response.sendRedirect("perfil.jsp");
	}
}
