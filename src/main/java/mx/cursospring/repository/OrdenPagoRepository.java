package mx.cursospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.cursospring.model.OrdenPago;

public interface OrdenPagoRepository extends JpaRepository<OrdenPago,Integer>{
	//regresamos los ordenes pendientes de pago
	public List<OrdenPago> findByPagoLiquidado(int isLiquidado);
	  
}
