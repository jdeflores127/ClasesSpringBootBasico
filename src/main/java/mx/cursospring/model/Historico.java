package mx.cursospring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HistoricoMovimientos")
public class Historico {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) //los id los va a generar la db
	private Long idHistorico;
	@Column
	private int idPersona;
	@Column
	private String tipoMovimiento;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaMovimiento;
	
	public Long getIdHistorico() {
		return idHistorico;
	}
	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
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
