package billeteraVirtual;

/**
 * Clase donde se encuentran los valores de una cuenta
 */
public class Cuenta {
	protected Double saldo;// Se recomienda usar BigDecimal
	protected int numeroCuenta;
	protected String banco;
	protected String tipo;// CTE, CTA, CTV, etc
	protected String simbolo;// USD, EUR, CLP

	
	
	/**
	 * 
	 * 
	 * @param saldo, nos permite asignar el saldo de la cuenta.
	 * @param numeroCuenta, nos permite asignar el numero de la cuenta.
	 * @param banco, nos permite asignar el banco asociado a la cuenta
	 * @param tipo, nos permite asignar un tipo de cuenta.
	 * @param simbolo, nos permite asignar un tipo de moneda a la cuenta.
	 */
	//Constructor de la clase
	
	public Cuenta(Double saldo, int numeroCuenta, String banco, String tipo, String simbolo) {
		this.saldo = saldo;// TODO: verificar como se agregaria el saldo inicial
		this.numeroCuenta = numeroCuenta;
		this.banco = banco;
		this.tipo = tipo;
		this.simbolo = simbolo;
	}

	
	//Getter && Setter
	
	/**
	 * 
	 * @return Simbolo, es el valor del atributo Simbolo para esa cuenta.
	 */
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
/**
 * 
 * @return Saldo, es el valor del atributo Saldo para esa cuenta.
 */
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	/**
	 * 
	 * @return NumeroCuenta, es el valor del atributo NumeroCuenta para esa cuenta.
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
/**
 * 
 * @return Banco, es el valor del atributo Banco para esa cuenta.
 */
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
/**
 * 
 * @return Tipo, es el valor del atributo Tipo de moneda para esa cuenta.
 */
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	/**
	 * Muestra el saldo dsiponible en la cuenta
	 */
	public void saldoDisponible() {
		System.out.println("El saldo de la cuenta " + this.getTipo() + " del banco " + this.getBanco() + " es de: "
				+ this.getSaldo() + " " + this.getSimbolo());
	}

	/**
	 *Muestra la concatenacion de los diferentes atributos de la cuenta. 
	 */
	
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numeroCuenta=" + numeroCuenta + ", banco=" + banco + ", tipo=" + tipo
				+ "]";
	}

}
