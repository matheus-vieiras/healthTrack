package br.com.healthtrack.fiap.dao;

public abstract class DAOFactory {

	public static final AlimentoDAO getAlimentoDAO() {
		return new AlimentoDAO();
	}
	
	public static final AtividadeFisicaDAO getAtividadeFisicaDAO() {
		return new AtividadeFisicaDAO();
	}
	
	public static final ImcDAO getImcDAO() {
		return new ImcDAO();
	}
	
	public static final PesoDAO getPesoDAO() {
		return new PesoDAO();
	}
	
	public static final PessoaDAO getPessoaDAO() {
		return new PessoaDAO();
	}
	
}
