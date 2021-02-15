package mx.cursospring.apiRest.ordenesPago;

public class OperacionNoProcesadaException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperacionNoProcesadaException(String mensaje){
		super(mensaje);
	}
}
