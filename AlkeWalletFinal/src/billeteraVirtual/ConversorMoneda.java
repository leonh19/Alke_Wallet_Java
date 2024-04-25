package billeteraVirtual;

// TODO: pendiente ver como implementar interface

/**
 * Clase donde se realizan las soperaciones de conversion de monedas.
 */
public class ConversorMoneda implements OperacionesMoneda {
	protected String tipo;// Dolar, Euro, Peso Chileno
	protected String simbolo;// USD, EUR, CLP
	protected Double valor;// Monto a convertir

	/**
	 * Constructor completo para inicializar la clase ConversorMoneda.
	 * 
	 * @param tipo,    nos permite asignar un tipo de moneda a convertir.
	 * @param simbolo, nos permite asignar el simbolo de la moneda elegida.
	 * @param valor,   nos permite asignar el valor cambiario de la moneda.
	 */
	// Constructor
	public ConversorMoneda(String tipo, String simbolo, Double valor) {
		this.tipo = tipo;
		this.simbolo = simbolo;
		this.valor = valor;
	}

	/**
	 * Constructor vacio.
	 */
	public ConversorMoneda() {
	}

	/**
	 * Implementa el método `Cambio` de la interfaz `OperacionesMoneda`. Convierte
	 * un monto entre dos monedas especificadas por sus símbolos.
	 * 
	 * @param valor, el monto a convertir.
	 * @param simboloOrigen, el símbolo de la moneda origen (ejemplo. "USD", "EUR",
	 *                       "CLP").
	 * @param simboloDestino, el símbolo de la moneda destino (ejemplo. "USD", "EUR",
	 *                       "CLP").
	 * @return el monto convertido en la moneda destino.
	 */
	@Override
	public Double Cambio(Double valor, String simboloOrigen, String simboloDestino) {

		// para pruebas se dejo los factores de conversión fijos

		double factorCLPtoUSD = 0.0011;
		double factorCLPtoEUR = 0.00098;
		double factorCLPtoAR = 0.91;
		Double conversion = 0.0;

		if (simboloOrigen.equals("CLP") && simboloDestino.equals("USD")) {
			conversion = valor * factorCLPtoUSD;
		} else if (simboloOrigen.equals("CLP") && simboloDestino.equals("EUR")) {
			conversion = valor * factorCLPtoEUR;
		} else if (simboloOrigen.equals("CLP") && simboloDestino.equals("AR")) {
			conversion = valor * factorCLPtoAR;
		} else if (simboloOrigen.equals("USD") && simboloDestino.equals("CLP")) {
			conversion = valor / factorCLPtoUSD;
		} else if (simboloOrigen.equals("EUR") && simboloDestino.equals("CLP")) {
			conversion = valor / factorCLPtoEUR;
		} else if (simboloOrigen.equals("AR") && simboloDestino.equals("CLP")) {
			conversion = valor / factorCLPtoAR;
		} else {
			System.out.println("No existe conversión para esta combinación de monedas");
		}

		return conversion;
	}
	/**
	 * 
	 * @return Tipo, es el valor del atributo tipo en el ConversorMoneda.
	 */
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return Simbolo, es el valor del atributo Simbolo en el ConversorMoneda.
	 */
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	/**
	 * 
	 * @return Valor, es el valor del atributo Valor en el ConversorMoneda.
	 */
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
