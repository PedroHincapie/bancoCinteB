package dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dominio.Asesor;
import testdatabuilder.AsesorTestDataBuilder;

public class AsesorTest {

	private static final String CODIGO = "S01H1AT51";
	private static final String NOMBRE_ASESOR = "JUAN CARLOS MADRID";
	private static final String ESPECIALIDAD = "GERENTE OPERATIVO";

	@Test
	public void crearAsesorTest() {

		// arrange
		AsesorTestDataBuilder asesarTestDataBuilder = new AsesorTestDataBuilder(CODIGO, NOMBRE_ASESOR, ESPECIALIDAD);

		// act
		Asesor asesor = asesarTestDataBuilder.build();

		// assert
		assertEquals(CODIGO, asesor.getCodigo());
		assertEquals(NOMBRE_ASESOR, asesor.getNombre());
		assertEquals(ESPECIALIDAD, asesor.getEspecialidad());
	}

}
