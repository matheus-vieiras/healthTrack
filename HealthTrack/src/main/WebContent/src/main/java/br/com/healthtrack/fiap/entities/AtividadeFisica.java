package br.com.healthtrack.fiap.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AtividadeFisica {
	
	private int idTreino;
	private String nomeTreino;
	private Calendar dtTreino;
	private String tipoTreino;
	private int idUsuario;
	
	public AtividadeFisica() {
		
	}

	public AtividadeFisica(int idTreino, String nomeTreino, Calendar dtTreino, String tipoTreino, int idUsuario) {
		super();
		this.idTreino = idTreino;
		this.nomeTreino = nomeTreino;
		this.dtTreino = dtTreino;
		this.tipoTreino = tipoTreino;
		this.idUsuario = idUsuario;
	}

	public int getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(int idTreino) {
		this.idTreino = idTreino;
	}

	public String getNomeTreino() {
		return nomeTreino;
	}

	public void setNomeTreino(String nomeTreino) {
		this.nomeTreino = nomeTreino;
	}

	public Calendar getDtTreino() {
		return dtTreino;
	}

	public void setDtTreino(Calendar dtTreino) {
		this.dtTreino = dtTreino;
	}

	public String getTipoTreino() {
		return tipoTreino;
	}

	public void setTipoTreino(String tipoTreino) {
		this.tipoTreino = tipoTreino;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		var sdf = new SimpleDateFormat("dd/mm/yyyy");
		return "AtividadeFisica [idTreino=" + idTreino + ", nomeTreino=" + nomeTreino + ", dtTreino=" + sdf.format(dtTreino.getTime()) 
				+ ", tipoTreino=" + tipoTreino + ", idUsuario=" + idUsuario + "]";
	}
	
	
}
