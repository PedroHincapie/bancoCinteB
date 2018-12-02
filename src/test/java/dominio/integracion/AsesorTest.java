package dominio.integracion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Analistas;
import dominio.Asesor;
import dominio.excepcion.AsesorException;
import dominio.repositorio.RepositorioAsesor;
import persistencia.sistema.SistemaDePersistencia;
import testdatabuilder.AsesorTestDataBuilder;

public class AsesorTest {

	private static final String CODIGO = "ADC123";
	private static final String NOMBRE = "PEDRO JESUS HINCAPIE GARCIA";
	private static final String ESPECIALIDAD = "GERENTE GENERAL";
	private static final String ASESOR_NO_EXISTE = "Asesor no existe";

	private SistemaDePersistencia sistemaPersistencia;

	private RepositorioAsesor repositorioAsesor;


	@Before
	public void setUp() {

		sistemaPersistencia = new SistemaDePersistencia();

		repositorioAsesor = sistemaPersistencia.obtenerRepositorioAsesores();


		sistemaPersistencia.iniciar();
	}

	@After
	public void tearDown() {
		sistemaPersistencia.terminar();
	}

	@Test
	public void listarAsesores() {

		// arrange
		Asesor asesor = new AsesorTestDataBuilder().build();
		repositorioAsesor.agregar(asesor);

		Analistas analista = new Analistas(repositorioAsesor);

		// act - assert
		Assert.assertNotNull(analista.obtenerAsesores());
	}

	@Test
	public void actulizarAsesor() {

		// arrange
		Asesor asesor = new AsesorTestDataBuilder("WER123", "JULIAN", "GERENTE DE OPERACIONES").build();
		repositorioAsesor.agregar(asesor);

		asesor.setNombre(NOMBRE);
		asesor.setEspecialidad(ESPECIALIDAD);

		Analistas analista = new Analistas(repositorioAsesor);

		// act - assert
		Assert.assertEquals(NOMBRE, analista.actulizarAsesor(asesor).getNombre());
	}

	@Test
	public void buscarAsesorById() {

		// arrange
		Asesor asesor = new AsesorTestDataBuilder().build();
		repositorioAsesor.agregar(asesor);

		Analistas analista = new Analistas(repositorioAsesor);

		// act - assert
		Assert.assertEquals(CODIGO, analista.asesorById(asesor.getCodigo()).getCodigo());
		Assert.assertEquals(NOMBRE, analista.asesorById(asesor.getCodigo()).getNombre());
		Assert.assertEquals(ESPECIALIDAD, analista.asesorById(asesor.getCodigo()).getEspecialidad());
	}

	@Test
	public void deleteAsesorById() {

		// arrange
		Asesor asesor = new AsesorTestDataBuilder().build();
		repositorioAsesor.agregar(asesor);

		Analistas analista = new Analistas(repositorioAsesor);

		// act
		analista.eliminarAsesor(asesor);

		Assert.assertNull(analista.asesorById(asesor.getCodigo()));
	}

	@Test
	public void actulizarAsesorSinExistir() {

		// arrange
		Asesor asesor = new AsesorTestDataBuilder(NOMBRE, "JULIAN", "GERENTE DE OPERACIONES").build();

		Analistas analista = new Analistas(repositorioAsesor);

		// act - assert
		try {
			analista.actulizarAsesor(asesor);
		} catch (AsesorException e) {
			Assert.assertEquals(ASESOR_NO_EXISTE, e.getMessage());
		}
	}
}
