package persistencia.sistema;

import javax.persistence.EntityManager;

import dominio.repositorio.RepositorioAsesor;
import persistencia.conexion.ConexionJPA;
import persistencia.repositorio.RepositorioAsesorPersistente;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}

	public RepositorioAsesor obtenerRepositorioAsesores() {
		return new RepositorioAsesorPersistente(entityManager);
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
