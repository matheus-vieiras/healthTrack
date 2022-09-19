package br.com.healthtrack.fiap.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Imc {

	private int idImc;
	private double imc;
	private Calendar dtImc;
	private int idUsuario;

	public Imc() {

	}

	public Imc(int idImc, double imc, Calendar dtImc, int idUsuario) {
		super();
		this.idImc = idImc;
		this.imc = imc;
		this.dtImc = dtImc;
		this.idUsuario = idUsuario;
	}

	public int getIdImc() {
		return idImc;
	}

	public void setIdImc(int idImc) {
		this.idImc = idImc;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public Calendar getDtImc() {
		return dtImc;
	}

	public void setDtImc(Calendar dtImc) {
		this.dtImc = dtImc;
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
		return "Imc [idImc=" + idImc + ", imc=" + imc + ", dtImc=" + sdf.format(dtImc.getTime()) + ", idUsuario="
				+ idUsuario + "]";
	}

}
