package dominio.integracion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Analistas;
import dominio.Asesor;
import dominio.repositorio.RepositorioAsesor;
import persistencia.sistema.SistemaDePersistencia;
import testdatabuilder.AsesorTestDataBuilder;

public class AsesorTest {

	private static final String CODIGO = "ADC123";
	private static final String NOMBRE = "PEDRO JESUS HINCAPIE GARCIA";
	private static final String ESPECIALIDAD = "GERENTE GENERAL";

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

	//	@Test
	//	public void actulizarAsesor() {
	//
	//		// arrange
	//		Asesor asesor = new AsesorTestDataBuilder("WER123", "JULIAN", "TETETO").build();
	//		repositorioAsesor.agregar(asesor);
	//		asesor.setNombre("Tetas martines");
	//
	//		Analistas analista = new Analistas(repositorioAsesor);
	//
	//		// act
	//		analista.actulizarAsesor(asesor);
	//		//		System.err.println(analista.actulizarAsesor(asesor).getCodigo() +" " + analista.actulizarAsesor(asesor).getNombre() + " "+ analista.actulizarAsesor(asesor).getEspecialidad());
	//
	//		System.err.println("Tamaao :" + analista.obtenerAsesores().size());
	//
	//		System.err.println(analista.obtenerAsesores().get(0).getCodigo() + " " +analista.obtenerAsesores().get(0).getNombre());
	//
	//		// assert
	//		Assert.assertNotNull(analista.asesorById(asesor.getCodigo()));
	//	}

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




}
