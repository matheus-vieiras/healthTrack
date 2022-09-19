package br.com.healthtrack.fiap.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Peso {
	
	private int idPeso;
	private double peso;
	private Calendar dt_pesagem;
	private int idUsuario;
	
	public Peso() {
		
	}

	public Peso(int idPeso, double peso, Calendar dt_pesagem, int idUsuario) {
		super();
		this.idPeso = idPeso;
		this.peso = peso;
		this.dt_pesagem = dt_pesagem;
		this.idUsuario = idUsuario;
	}

	public int getIdPeso() {
		return idPeso;
	}

	public void setIdPeso(int idPeso) {
		this.idPeso = idPeso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Calendar getDt_pesagem() {
		return dt_pesagem;
	}

	public void setDt_pesagem(Calendar dt_pesagem) {
		this.dt_pesagem = dt_pesagem;
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
		return "Peso [idPeso=" + idPeso + ", peso=" + peso + ", dt_pesagem=" + sdf.format(dt_pesagem.getTime())  + ", idUsuario=" + idUsuario
				+ "]";
	}
	
	

}
