package billeteraVirtual;

/**
 * Interface relacionada a la clase ConversorMoneda.
 */
public interface OperacionesMoneda {
	Double Cambio(Double cantidad, String simboloOrigen, String simboloDestino);
}
