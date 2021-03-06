package mx.cursospring.model;

import java.util.Date;

public class Historico {
	private Long idHistorico;
	private String idPersona;
	private String tipoMovimiento;
	private Date fechaMovimiento;
	public Long getIdHistorico() {
		return idHistorico;
	}
	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	@Override
	public String toString() {
		return "Historico [idHistorico=" + idHistorico + ", idPersona=" + idPersona + ", tipoMovimiento="
				+ tipoMovimiento + ", fechaMovimiento=" + fechaMovimiento + "]";
	}
}
