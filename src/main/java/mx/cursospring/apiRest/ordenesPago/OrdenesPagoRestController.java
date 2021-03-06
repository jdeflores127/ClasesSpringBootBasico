package mx.cursospring.apiRest.ordenesPago;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.cursospring.model.OrdenPago;
import mx.cursospring.repository.OrdenPagoRepository;

@RestController
@RequestMapping("/apiOrdenesPago")
public class OrdenesPagoRestController {
	@Autowired OrdenPagoRepository ordenpagorepository;
	
	@GetMapping("/ordenesPago")
	public List<OrdenPago> obtenerOrdenesPago() {
		List<OrdenPago> ordenesPendientesPago = ordenpagorepository.findByPagoLiquidado(0);
		return ordenesPendientesPago;
	}
	
	@GetMapping("liquidarOrden/{id}")
	public String liquidarOrden(@PathVariable("id") int idOrden) {
		Optional<OrdenPago> orden=ordenpagorepository.findById(idOrden);
		if(orden.isPresent())
		{
			if(orden.get().isPagoLiquidado()==1) {
				return "la orden ya fue liquidada";
			}
			else
			{
				orden.get().setPagoLiquidado(1);
				ordenpagorepository.save(orden.get());
				return "pago liquidado exitosamente";
			}
		}
		return "orden no encontrada";
	}
	
	@PostMapping("/ordenesPago")
	public String registrarPago(@RequestBody OrdenPago ordenPago){
		ordenPago.setIdOrdenPago(0);
		//save servia para hacer un insert en la base de datos
		//save sirve para modificar datos
		OrdenPago orden = ordenpagorepository.save(ordenPago);
		return "registro insertado con exito";
	}
	
	@PutMapping("/ordenesPago")
	public OrdenPago modificarOrden(@RequestBody OrdenPago ordenPago) {
		OrdenPago orden = ordenpagorepository.save(ordenPago);
		return orden;
	}
	
	@DeleteMapping("/ordenesPago/{id}")
	public String borrarOrden(@PathVariable("id") int idOrden){
		try {
			ordenpagorepository.deleteById(idOrden);
		}catch(Exception e) {
			throw new OperacionNoProcesadaException("registro con el id="+idOrden+"no pudo ser borrado");
		}
		return "orden borrada";
	}
	
	
	
}
