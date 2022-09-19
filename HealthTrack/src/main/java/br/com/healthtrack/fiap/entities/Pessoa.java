package br.com.healthtrack.fiap.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pessoa {

	private int idUsuario;
	private String nome;
	private int altura;
	private Calendar dt_nasc;
	private String email;
	private String genero;
	private String senha;
	private String telefone;

	public Pessoa() {

	}
	
	public Pessoa(int idUsuario, String nome, Calendar dt_nasc, String email, String genero, String senha, String telefone) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.dt_nasc = dt_nasc;
		this.email = email;
		this.genero = genero;
		this.senha = senha;
		this.telefone = telefone;
	}

	public Pessoa(int idUsuario, String nome, int altura, Calendar dt_nasc, String email, String genero,
			String senha, String telefone) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.altura = altura;
		this.dt_nasc = dt_nasc;
		this.email = email;
		this.genero = genero;
		this.senha = senha;
		this.telefone = telefone;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Calendar getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Calendar dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		var sdf = new SimpleDateFormat("dd/mm/yyyy");
		return "Pessoa [idUsuario=" + idUsuario + ", nome=" + nome + ", altura=" + altura + ", dt_nasc="
				+ sdf.format(dt_nasc.getTime()) + ", email=" + email + ", genero=" + genero + ", senha=" + senha
				+ ", telefone=" + telefone + "]";
	}

}
