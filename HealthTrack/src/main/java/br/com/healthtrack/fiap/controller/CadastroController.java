package br.com.healthtrack.fiap.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.fiap.dao.DAOFactory;
import br.com.healthtrack.fiap.entities.Pessoa;

/**
 * Servlet implementation class PessoaController
 */
@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("novo-usuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String) request.getAttribute("email");
		
		boolean usuarioJaCadastrado = DAOFactory.getPessoaDAO().verifyIfUserAlreadyExists(email);
		request.setAttribute("jaExiste", usuarioJaCadastrado);
		
		if (usuarioJaCadastrado) {
			response.setStatus(400);
			return;
		}
		
		String senha = (String) request.getAttribute("senha");
		Calendar dtNasc = (Calendar) request.getAttribute("dtNasc");
		String nome = (String) request.getAttribute("nome");
		String genero = (String) request.getAttribute("genero");
		String telefone = (String) request.getAttribute("telefone");
		
		Pessoa pessoa = new Pessoa(10, nome, dtNasc, email, genero, senha, telefone);
		DAOFactory.getPessoaDAO().cadastrar(pessoa);
		response.sendRedirect("perfil.jsp");
	}

}
