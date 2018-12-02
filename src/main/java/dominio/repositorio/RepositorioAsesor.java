package dominio.repositorio;

import java.util.List;

import dominio.Asesor;

public interface RepositorioAsesor {

	/**
	 * Permite obtener un lista de asesores
	 * @return
	 */
	List<Asesor> listarAsesores();

	/**
	 * Permite agregar una asesor al repositorio de asesores
	 * @param asesor
	 */
	void agregar(Asesor asesor);

	/**
	 * Permite actualizar el registro de un asesor
	 * @param asesor
	 */
	Asesor actualizar(Asesor asesor);

	/**
	 * Permite eliminar un asesor
	 * @param asesor
	 */
	void eliminar(Asesor asesor);

	/**
	 * Permite consultar por codigo del asesor
	 * @param id
	 */
	Asesor asesorById(String codigo);
}