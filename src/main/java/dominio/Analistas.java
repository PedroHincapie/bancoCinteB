package dominio;

import java.util.List;

import dominio.repositorio.RepositorioAsesor;

public class Analistas {

	private RepositorioAsesor repositorioAsesor;


	public Analistas(RepositorioAsesor repositorioAsesor) {
		this.repositorioAsesor = repositorioAsesor;
	}

	public List<Asesor> obtenerAsesores(){
		return this.repositorioAsesor.listarAsesores();
	}

	public Asesor actulizarAsesor(Asesor asesor) {
		return this.repositorioAsesor.actualizar(asesor);
	}

	public Asesor asesorById(String codigo) {
		return this.repositorioAsesor.asesorById(codigo);
	}

	public void eliminarAsesor(Asesor asesor) {
		this.repositorioAsesor.eliminar(asesor);

	}


}
