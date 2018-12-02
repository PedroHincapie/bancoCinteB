package testdatabuilder;



import dominio.Asesor;
public class AsesorTestDataBuilder {

	private static final String CODIGO = "ADC123";
	private static final String NOMBRE = "PEDRO JESUS HINCAPIE GARCIA";
	private static final String ESPECIALIDAD = "GERENTE GENERAL";

	private String codigo;
	private String nombre;
	private String especialidad;

	public AsesorTestDataBuilder() {
		this.codigo = CODIGO;
		this.nombre = NOMBRE;
		this.especialidad = ESPECIALIDAD;
	}

	public AsesorTestDataBuilder(String codigo, String nombre, String especialidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.especialidad = especialidad;
	}

	public AsesorTestDataBuilder conNombre (String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Asesor build() {
		return new Asesor(this.codigo, this.nombre, this.especialidad);
	}
}
