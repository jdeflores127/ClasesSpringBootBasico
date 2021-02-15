package mx.cursospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrdenesPagoTable")
public class OrdenPago {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) //los id los va a generar la db
	private int idOrdenPago;
	@Column
	private String nombreOrdenante;
	@Column
	private String nombreBeneficiario;
	@Column
	private double montoTotal;
	@Column
	private int pagoLiquidado;
	
	public int getIdOrdenPago() {
		return idOrdenPago;
	}
	public void setIdOrdenPago(int idOrdenPago) {
		this.idOrdenPago = idOrdenPago;
	}
	public String getNombreOrdenante() {
		return nombreOrdenante;
	}
	public void setNombreOrdenante(String nombreOrdenante) {
		this.nombreOrdenante = nombreOrdenante;
	}
	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}
	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public int isPagoLiquidado() {
		return pagoLiquidado;
	}
	public void setPagoLiquidado(int pagoLiquidado) {
		this.pagoLiquidado = pagoLiquidado;
	}
	@Override
	public String toString() {
		return "OrdenPago [idOrdenPago=" + idOrdenPago + ", nombreOrdenante=" + nombreOrdenante
				+ ", nombreBeneficiario=" + nombreBeneficiario + ", montoTotal=" + montoTotal + ", pagoLiquidado="
				+ pagoLiquidado + "]";
	}
}
