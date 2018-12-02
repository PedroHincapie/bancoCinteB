package persistencia.entitad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity(name = "Asesor")
@NamedQueries({
	@NamedQuery(name = "Asesor.findAll", query = "SELECT asesor FROM Asesor asesor"),
	@NamedQuery(name = "Asesor.findById", query = "SELECT asesor FROM Asesor asesor WHERE asesor.codigo = :codigo")
//	,
//	@NamedQuery(name = "Asesor.updateAsesor", query = "UPDATE Asesor set asesor WHERE asesor.codigo = :codigo")

})
public class AsesoresEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String especialidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
