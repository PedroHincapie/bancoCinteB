package persistencia.builder;

import dominio.Asesor;
import persistencia.entitad.AsesoresEntity;

public class AsesorBuilder {

	private AsesorBuilder() {}

	public static Asesor convertirADominio(AsesoresEntity asesorEntity) {

		Asesor asesor = null;

		if(asesorEntity != null) {
			asesor = new Asesor(asesorEntity.getCodigo(), asesorEntity.getNombre(), asesorEntity.getEspecialidad());
		}

		return asesor;
	}

	public static AsesoresEntity convertirAEntity(Asesor asesor) {

		AsesoresEntity asesorEntity = new AsesoresEntity();

		asesorEntity.setCodigo(asesor.getCodigo());
		asesorEntity.setNombre(asesor.getNombre());
		asesorEntity.setEspecialidad(asesor.getEspecialidad());

		return asesorEntity;
	}
}
