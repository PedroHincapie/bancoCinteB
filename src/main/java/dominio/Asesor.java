package dominio;

public class Asesor {

	private String codigo;
	private String nombre;
	private String especialidad;

	public Asesor(String codigo, String nombre, String especialidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}	
}
