package br.com.healthtrack.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;

import br.com.healthtrack.fiap.dao.DAOFactory;
import br.com.healthtrack.fiap.entities.Peso;
import br.com.healthtrack.fiap.entities.Pessoa;

/**
 * Servlet implementation class PerfilController
 */
@WebServlet("/PerfilController")
public class PerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa pessoa = (Pessoa) request.getSession().getAttribute("usuario");	
		response.sendRedirect("perfil.jsp");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String novoEmail = (String) request.getAttribute("novoEmail");
		String novoSenha = (String) request.getAttribute("novoEmail");
		String novoNome = (String) request.getAttribute("novoEmail");
		String novoGenero = (String) request.getAttribute("novoEmail");
		double novoAltura = (double) request.getAttribute("novoEmail");
		double novoPeso = (double) request.getAttribute("novoEmail");
		
		Pessoa usuarioModificado = (Pessoa) request.getSession().getAttribute("usuario");
		boolean existeUsuarioComEsteEmail = true;
		
		if (!novoEmail.isEmpty() && novoEmail != null) {
			existeUsuarioComEsteEmail = DAOFactory.getPessoaDAO().verifyIfUserAlreadyExists(novoEmail);
		}
		
		
		if (!existeUsuarioComEsteEmail) {
			usuarioModificado.setEmail(novoEmail);
		}
		
		if (!novoSenha.isEmpty() && novoSenha != null) {
			usuarioModificado.setSenha(novoSenha);
		}
		
		if (!novoNome.isEmpty() && novoNome != null) {
			usuarioModificado.setNome(novoNome);
		}
		
		if (!novoGenero.isEmpty() && novoGenero != null) {
			usuarioModificado.setGenero(novoGenero);
		}
		
		if (novoAltura != 0D) {
			usuarioModificado.setAltura((int)novoAltura);
		}
		
		if (novoPeso != 0D) {
			Peso pesoAntigo = DAOFactory.getPesoDAO().getPesoByUserId(usuarioModificado.getIdUsuario());
			pesoAntigo.setPeso(novoPeso);
			DAOFactory.getPesoDAO().atualizar(pesoAntigo);
		}
		response.sendRedirect("perfil.jsp");
	}

}
