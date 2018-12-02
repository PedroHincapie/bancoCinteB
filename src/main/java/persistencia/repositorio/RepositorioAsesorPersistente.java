package persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Asesor;
import dominio.excepcion.AsesorException;
import dominio.repositorio.RepositorioAsesor;
import persistencia.builder.AsesorBuilder;
import persistencia.entitad.AsesoresEntity;

public class RepositorioAsesorPersistente implements RepositorioAsesor {

	private static final String CODIGO = "codigo";
	private static final String LISTAR_ASESORES = "Asesor.findAll";
	private static final String ASESOR_FIND_BY_CODIGO = "Asesor.findById";
	private static final String ASESOR_NO_EXISTE = "Asesor no existe";


	private EntityManager entityManager;

	public RepositorioAsesorPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	private List<AsesoresEntity> obtenerAsesores() {
		Query query = entityManager.createNamedQuery(LISTAR_ASESORES);

		List<AsesoresEntity> resultList = query.getResultList();

		return resultList;

	}

	@SuppressWarnings("unchecked")
	private AsesoresEntity obtenerAsesoresByCodigo(String codigo) {
		Query query = entityManager.createNamedQuery(ASESOR_FIND_BY_CODIGO);
		query.setParameter(CODIGO, codigo);

		List<AsesoresEntity> resultList = query.getResultList();
		return !resultList.isEmpty() ? resultList.get(0) : null;
	}

	@Override
	public void agregar(Asesor asesor) {
		entityManager.persist(AsesorBuilder.convertirAEntity(asesor));
	}

	@Override
	public List<Asesor> listarAsesores() {

		List<AsesoresEntity> asesorEntity = obtenerAsesores();
		List<Asesor> listAsesores = new ArrayList<>();
		for (AsesoresEntity asesorEnt : asesorEntity) {
			listAsesores.add(AsesorBuilder.convertirADominio(asesorEnt));
		}
		return listAsesores;
	}

	@Override
	public Asesor actualizar(Asesor asesor) {
		AsesoresEntity asesorE = obtenerAsesoresByCodigo(asesor.getCodigo());

		if( null == asesorE){
			throw new AsesorException(ASESOR_NO_EXISTE);
		}

		asesorE.setCodigo(asesor.getCodigo());
		asesorE.setNombre(asesor.getNombre());
		asesorE.setEspecialidad(asesor.getEspecialidad());			

		return AsesorBuilder.convertirADominio(entityManager.merge(asesorE));	
	}

	@Override
	public void eliminar(Asesor asesor) {
		AsesoresEntity asesorE = obtenerAsesoresByCodigo(asesor.getCodigo());
		entityManager.remove(asesorE);
	}

	@Override
	public Asesor asesorById(String codigo) {
		return AsesorBuilder.convertirADominio(obtenerAsesoresByCodigo(codigo));
	}
}
