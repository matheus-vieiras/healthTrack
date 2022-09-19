package br.com.healthtrack.fiap.controller;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.fiap.dao.DAOFactory;
import br.com.healthtrack.fiap.entities.Peso;
import br.com.healthtrack.fiap.entities.Pessoa;

/**
 * Servlet implementation class PesoController
 */
@WebServlet("/PesoController")
public class PesoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getAttribute("email");
		HttpSession sessao = request.getSession();
		
		Pessoa pessoa = DAOFactory.getPessoaDAO().getPessoaByEmail(email);
		Peso pesoPessoa = DAOFactory.getPesoDAO().getPesoByUserId(pessoa.getIdUsuario());
		sessao.setAttribute("peso", pesoPessoa);
		response.sendRedirect("peso.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getAttribute("email");
		boolean userExists = DAOFactory.getPessoaDAO().verifyIfUserAlreadyExists(email);
		String novoPeso = (String) request.getAttribute("novoPeso");
		
		if (userExists) {
			Pessoa pessoa = DAOFactory.getPessoaDAO().getPessoaByEmail(email);
			Peso pesoPessoa = DAOFactory.getPesoDAO().getPesoByUserId(pessoa.getIdUsuario());
			
			if (!Objects.isNull(pesoPessoa)) {
				pesoPessoa.setPeso(Double.parseDouble(novoPeso));
				pesoPessoa.setDt_pesagem(new GregorianCalendar().getInstance());
				
				DAOFactory.getPesoDAO().atualizar(pesoPessoa);
			} else {
				pesoPessoa = new Peso(1, Double.parseDouble(novoPeso), new GregorianCalendar().getInstance(), pessoa.getIdUsuario());
				DAOFactory.getPesoDAO().cadastrar(pesoPessoa);
			}
		}
		
		response.sendRedirect("perfil.jsp");
	}

}
