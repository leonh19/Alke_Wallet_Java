package billeteraVirtual;

import java.util.ArrayList;

//saldo disponible, realizar depósitos y retiros de fondos

/**
 * Clase donde se encuentran todos los valores del Usuario.
 */
public class Usuario {
	protected String nombre;
	protected String apellido;
	protected String rut;
	protected String correo;
	protected String contrasena;//TODO: Implementar a futuro restricción de acceso
	protected ArrayList<Cuenta> cuentas;
	protected int edad;
	
	/**
	 * Cosntructor completo de la clase Usuarios
	 * @param nombre, nos permite asignar el nombre al usuario.
	 * @param apellido, nos permite asignar el apellido al usuario.
	 * @param rut, nos permite asignar el rol unico tributario al usuario.
	 * @param correo, nos permite asignar el correo al usuario.
	 * @param contrasena, nos permite asignar la contraseña al usuario. 
	 */
	public Usuario(String nombre, String apellido, String rut, String correo, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.correo = correo;
		this.contrasena = contrasena;
		this.cuentas = new ArrayList<>();
	}
	
	//TODO: Implementar método para mostrar la información de las cuentas
	/**
	 * 
	 * @return Nombre, es el valor del atributo Nombre en la clase Usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return Apellido, es el valor del atributo Apellido en la clase Usuario.
	 */
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return Rut, es el valor del atibuto Rut en la clase Uusario.
	 */
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	/**
	 * 
	 * @return Correo, es el valor del atibuto Correo en la clase Uusario.
	 */
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	/**
	 * 
	 * @return Contraseña, es el valor del atibuto Contraseña en la clase Uusario.
	 */
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}

	/**
	 * 
	 * @return Edad, es el valor del atibuto Edad en la clase Uusario.
	 */
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * 
	 * @return NombreCompleto, es el valor que se obtiene mediante el metodo NombreCompleto.
	 */
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellido;
	}
	
}

