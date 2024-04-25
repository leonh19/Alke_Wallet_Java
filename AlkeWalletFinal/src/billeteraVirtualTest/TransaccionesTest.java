package billeteraVirtualTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import billeteraVirtual.Cuenta;
import billeteraVirtual.Transacciones;

class TransaccionesTest {

	private Cuenta cuenta;

	@BeforeEach
	public void SetUp() {
		cuenta = new Cuenta(1000.0, 34567, "Itau", "CTA", "CLP");
	}

	@Test
	public void testGetSaldoDisponible() {
		Transacciones transacciones = new Transacciones();
		double balanceAvailable = 1000.0;

		double actualBalance = transacciones.getSaldoDisponible(cuenta);

		assertEquals(balanceAvailable, actualBalance, "El saldo disponible no es correcto");

	}

	@Test
	public void testSetRealizarDeposito_MontoValido() {
		Transacciones transacciones = new Transacciones();
		double depositAmount = 500.0;
		double expectedBalance = 1500.0;

		transacciones.setRealizarDeposito(cuenta, depositAmount);

		double actualBalance = cuenta.getSaldo();

		assertEquals(expectedBalance, actualBalance, "Saldo después del depósito incorrecto");
	}

	@Test
	public void testSetRealizarDeposito_MontoInvalido() {
		Transacciones transacciones = new Transacciones();
		double depositAmount = -100.0;
		String expectedMessage = "El monto a despositar es debe ser mayor a cero.";
	}

	@Test
	public void testSetRealizarRetiro_MontoValido() {
		Transacciones transacciones = new Transacciones();
		double retiroAmount = 100.0;
		double expectedBalance = 900.0;

		transacciones.setRetirosFondos(cuenta, retiroAmount);

		double actualBalance = cuenta.getSaldo();

		assertEquals(expectedBalance, actualBalance, "Saldo después del retiro incorrecto");
	}

	@Test
	public void testSetRetirosFondos_ValidAmount_InsufficientBalance() {
		Transacciones transacciones = new Transacciones();
		double retiroAmount = 1200.0; // Withdrawal amount exceeding balance

		// Verify that no balance update occurs
		double initialBalance = cuenta.getSaldo();

		transacciones.setRetirosFondos(cuenta, retiroAmount);

		double actualBalance = cuenta.getSaldo();

		// Assert that balance remains unchanged
		assertEquals(initialBalance, actualBalance,
				"Saldo no debería actualizarse para retiros con saldo insuficiente");
	}

	@Test
	public void testSetRetirosFondos_InvalidAmount() {
		Transacciones transacciones = new Transacciones();
		double retiroAmount = -100.0; // Invalid negative withdrawal amount

		// Verify that no balance update occurs
		double initialBalance = cuenta.getSaldo();

		transacciones.setRetirosFondos(cuenta, retiroAmount);

		double actualBalance = cuenta.getSaldo();

		// Assert that balance remains unchanged
		assertEquals(initialBalance, actualBalance, "Saldo no debería actualizarse para retiros inválidos");
	}
}
