package dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dominio.Analistas;
import dominio.Asesor;
import dominio.repositorio.RepositorioAsesor;
import testdatabuilder.AsesorTestDataBuilder;

public class Analista {
	private static final String CODIGO = "ADC123";

	@Test
	public void obtenerAsesores() {

		// arrange
		AsesorTestDataBuilder asesorTestDataBuilder = new AsesorTestDataBuilder();		
		Asesor asesor = asesorTestDataBuilder.build();

		List<Asesor> asesores = new ArrayList<Asesor>() ;
		asesores.add(asesor);

		RepositorioAsesor repositorioAsesor = mock(RepositorioAsesor.class);

		when(repositorioAsesor.listarAsesores()).thenReturn(asesores);

		Analistas analista = new Analistas(repositorioAsesor);

		// act
		List<Asesor> existeProducto = analista.obtenerAsesores();

		//assert
		assertEquals(CODIGO, existeProducto.get(0).getCodigo());
	}	
}
