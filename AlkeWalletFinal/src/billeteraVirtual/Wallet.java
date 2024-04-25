package billeteraVirtual;

import java.util.ArrayList;

/**
 * Clase principal del proyecto.
 */
public class Wallet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario ricardo = new Usuario("Ricardo", "Vega", "22.852.543.3", "ricardo@gmail.com", "1234");
		Usuario leonard = new Usuario("Leonard", "Hernandez", "38.7456.748.2", "leonard@gmail.com", "5678");
		
		Cuenta ctaRicardo1 = new Cuenta(0.0, 789521, "Santander", "CTE", "USD");//pos 0
		Cuenta ctaRicardo2 = new Cuenta(0.0, 2557894, "BCO de Chile", "CTE", "CLP");//pos 1 
		
		ricardo.setCuentas(ctaRicardo1);
		ricardo.setCuentas(ctaRicardo2);
		
		Cuenta ctaLeonard1 = new Cuenta(0.0, 225879, "Itau", "CTE", "USD");
		Cuenta ctaLeonard2 = new Cuenta(0.0, 596742, "BCI", "CTE", "CLP");
		
		leonard.setCuentas(ctaLeonard1);
		leonard.setCuentas(ctaLeonard2);
				
		//System.out.println(julio.getCuentas().get(0).toString());
		//System.out.println(leonard.getCuentas().get(0).toString());
		
		Transacciones transacciones = new Transacciones(); 
		
		//Depositar en cuentas
		//Se asume que los depositos van a ser todos en la mondeda o simbolo de la CTA
		
		System.out.println("===== DEPOSITOS ======");
		transacciones.setRealizarDeposito(ctaRicardo1, 1300.0);
		transacciones.setRealizarDeposito(ctaRicardo2, 876990.0);
		transacciones.setRealizarDeposito(ctaLeonard1, 1650.0);
		transacciones.setRealizarDeposito(ctaLeonard2, 679800.0);
		
		//Ver su saldo
		//Aqui pueden implementar un método que permita preguntar el saldo por el número de CTA
		
		System.out.println("===== CONSULTA DE SALDO ======");
		System.out.println("Saldos cuentas de " + ricardo.getNombreCompleto());
		ricardo.getCuentas().get(0).saldoDisponible();
		ricardo.getCuentas().get(1).saldoDisponible();
		
		//retiros de fondos
		
		System.out.println("===== RETIRO DE FONDOS ======");
		transacciones.setRetirosFondos(ricardo.getCuentas().get(0), 500);//retiro de 500 USD
		ricardo.getCuentas().get(0).saldoDisponible();
		
		transacciones.setRetirosFondos(ctaLeonard1, 376);//retiro de 376 USD
		ctaLeonard1.saldoDisponible();//
		
		//Transferencias
		
		System.out.println("===== TRANSFERENCIAS ======");
		transacciones.transferencia(ctaRicardo2, ctaLeonard2, 275000);//Ojo Ambas CTAS estan en CLP
		ctaRicardo2.saldoDisponible();
		ctaLeonard2.saldoDisponible();
		
		transacciones.transferencia(ctaLeonard2, ctaRicardo2 , 200000);//Ojo ctaLeonard2 en CLP y ctaJulio1 USD
		ctaLeonard2.saldoDisponible();
		ctaRicardo1.saldoDisponible();
	}

}
