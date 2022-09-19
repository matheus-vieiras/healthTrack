package br.com.healthtrack.fiap.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Alimento {

	private int idAlimento;
	private String nmAlimento;
	private String tipoAlimento;
	private Calendar dtAlimentacao;
	private int idUsuario;

	public Alimento() {

	}

	public Alimento(int idAlimento, String nmAlimento, String tipoAlimento, Calendar dtAlimentacao, int idUsuario) {
		super();
		this.idAlimento = idAlimento;
		this.nmAlimento = nmAlimento;
		this.tipoAlimento = tipoAlimento;
		this.dtAlimentacao = dtAlimentacao;
		this.idUsuario = idUsuario;
	}

	public int getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(int cdAlimento) {
		this.idAlimento = cdAlimento;
	}

	public String getNmAlimento() {
		return nmAlimento;
	}

	public void setNmAlimento(String nmAlimento) {
		this.nmAlimento = nmAlimento;
	}

	public String getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public Calendar getDtAlimentacao() {
		return dtAlimentacao;
	}

	public void setDtAlimentacao(Calendar dtAlimentacao) {
		this.dtAlimentacao = dtAlimentacao;
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
		return "Alimento [idAlimento=" + idAlimento + ", nmAlimento=" + nmAlimento + ", tipoAlimento=" + tipoAlimento
				+ ", dtAlimentacao=" + sdf.format(dtAlimentacao.getTime()) + ", idUsuario=" + idUsuario + "]";
	}

}
