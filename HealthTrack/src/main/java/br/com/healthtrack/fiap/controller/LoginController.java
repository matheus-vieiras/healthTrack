package br.com.healthtrack.fiap.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.fiap.dao.DAOFactory;
import br.com.healthtrack.fiap.entities.Pessoa;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		String email = (String) request.getAttribute("email");
		Pessoa pessoa = DAOFactory.getPessoaDAO().getPessoaByEmail(email);
		boolean loginAvailale = false;

		if (!Objects.isNull(pessoa)) {
			String senha = (String) request.getAttribute("senha");
			
			if (pessoa.getSenha().equals(senha)) {
				loginAvailale = true;
				sessao.setAttribute("usuario", pessoa);
			}

		}
		
		request.setAttribute("loginDisponivel", loginAvailale);
		response.sendRedirect("perfil.jsp");
	}

}
