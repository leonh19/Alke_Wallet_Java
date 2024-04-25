package billeteraVirtual;

/**
 * Clase donde se realizan diferentes operaciones bancarias.
 */
public class Transacciones {
	
	
	/**
	 * Obtiene el saldo disponible en una cuenta en una cuenta especifica.
	 * @param cuenta, indica la cuenta de donde se desea obtener la informacion.
	 * @return cuenta.getSaldo() que retorna el saldo disponible en la cuenta
	 */
		public double getSaldoDisponible(Cuenta cuenta) {
			System.out.println("Saldo disponible" + cuenta.getSaldo());	
		return cuenta.getSaldo();
		}
		
		/**
		 * Realizar un deposito en una cuenta especifica.
		 * @param cuenta, es la cuenta donde se desea realizar el deposito.
		 * @param montoDepositar, es el monto que se agregara a la cuenta seleccionada.
		 */
		public void setRealizarDeposito(Cuenta cuenta, double montoDepositar) {
			//Se asume que el deposito de dinero es en simbolo o tipo de moneda de la cuenta
			//esto es si la cuenta esta en USD el deposito sera en USD
			if(montoDepositar > 0) {
				double monto = cuenta.getSaldo() + montoDepositar;//Variable auxiliar para realizar la operación matemática
				cuenta.setSaldo(monto);
				System.out.println("Depósito realizado de manera correcta.");
			}else {
				System.out.println("El monto a despositar es debe ser mayor a cero.");	
			}
		}

		/**
		 * Realizar un retiro a una cuenta especifica.
		 * @param cuenta, es la cuenta donde se desea realizar el retiro.
		 * @param montoRetiro, es el monto que se desea retirar de la cuenta seleccionada.
		 */
		public void setRetirosFondos(Cuenta cuenta, double montoRetiro) {
			//Se asume que el retiro de dinero es en simbolo o tipo de moneda de la cuenta
			//esto es si la cuenta esta en USD el retiro sera en USD
			if(montoRetiro > 0) {
				if(cuenta.getSaldo() >= montoRetiro) {
					double monto = cuenta.getSaldo() - montoRetiro;
					cuenta.setSaldo(monto);
					System.out.println("El retiro de fondos se realizado de manera correcta.");
				}else {
					System.out.println("El monto a retirar debe ser menor o igual al saldo actual " + cuenta.getSaldo());
				}
			}else {
				System.out.println("El monto a retirar debe ser mayor a cero.");
			}
		}
		
		/**
		 * Realizar una transferencia de fondos entre dos cuentas.
		 * @param cuentaOrigen, es el origen del monto a transferir.
		 * @param cuentaDestino, es el destino del monto a transferir.
		 * @param montoTransferencia, es el monto a transferir.
		 */
		public void transferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double montoTransferencia) {
			//TODO: falta la validación de la cuenta, sea valida y exista, no sea que no sea null
			if(montoTransferencia > 0) {
				if(cuentaOrigen.getSaldo() > montoTransferencia) {
					if(cuentaDestino != null) {
						if(cuentaOrigen.getSimbolo() != cuentaDestino.getSimbolo()) {
							ConversorMoneda conversor = new ConversorMoneda();
							double conversion = conversor.Cambio(montoTransferencia, cuentaOrigen.getSimbolo(), cuentaDestino.getSimbolo());
							setRealizarDeposito(cuentaDestino, conversion);
						}else {
							setRealizarDeposito(cuentaDestino, montoTransferencia);
							//double auxOrigen = cuentaOrigen.getSaldo() - montoTransferencia;
							//cuentaOrigen.setSaldo(auxOrigen);
							
							//double auxDestino = cuentaDestino.getSaldo() + montoTransferencia;
							//cuentaDestino.setSaldo(auxDestino);
						}	
						setRetirosFondos(cuentaOrigen, montoTransferencia);
						System.out.println("Transferencia realizada con éxito.");
					}else {
						System.out.println("Cuenta de destino no valida.");
					}
				}else {
					System.out.println("No cuenta con saldo suficiente para poder realizar la transferencia.");
				}
			}else {
				System.out.println("El monto a transferir debe ser mayor a cero.");
			}
			
		}
	}


