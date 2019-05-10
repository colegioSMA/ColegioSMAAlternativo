package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import SMA.Asignatura;
import SMA.Colegio;
import SMA.ColegioExcepcion;
import SMA.Estudiante;
import SMA.Grupo;
import SMA.Persona;
import SMA.Profesor;
//hasta aqui importo todas las clases anteriores



public class ColegioTest {
	Asignatura asignatura1 = null;
	Colegio colegio1 = null;
	Colegio colegio2 = null;
	Estudiante estudiante1 = null;
	Estudiante estudiante2 = null;
	Persona persona1 = null;
	Profesor profesor1 = null;
	Profesor profesor2 = null;
	Asignatura asignatura2 = null;
	Grupo grupo = null;
//introduzco las clases con valor null para llenarlas mas tarde 
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		profesor1 = new Profesor(18, "Jose", "Calle Sol", 1999, 'M', 400f);
		profesor2 = new Profesor(18, "Fabian", "Calle Sol", 1999, 'M', 500f);
		asignatura1 = new Asignatura("Lengua", 50f, profesor1, "libre");
		asignatura2 = new Asignatura("Historia", 50f, profesor1, "oficial");
		grupo = new Grupo(1, "grupoA");
		List<Asignatura> asignaturas = new ArrayList<>();
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		estudiante1 = new Estudiante(18, "Jaime", "Calle Sol", 1999, 'M', asignaturas, grupo);
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(estudiante1);
		List<Profesor> profesores = new ArrayList<>();
		profesores.add(profesor1);
		profesores.add(profesor2);
		colegio1 = new Colegio(estudiantes, profesores, asignaturas);
		

		estudiante2 = new  Estudiante(21, "Jaime", "Calle Sol", 1998, 'M', asignaturas, grupo);
		List<Asignatura> asignaturas2 = new ArrayList<>();
		asignaturas2.add(asignatura1);
		asignaturas2.add(asignatura2);
		estudiante1 = new Estudiante(21, "Jaime", "Calle Sol", 1998, 'M', asignaturas, grupo);
		
		
		List<Estudiante> estudiantes2 = new ArrayList<>();
		List<Asignatura> asignaturas3 = new ArrayList<>();
		List<Profesor> profesores2 = new ArrayList<>();

		colegio2 = new Colegio(estudiantes2, profesores2, asignaturas3);
}
//introduzco todos los datos a utilizar en los diferentes test y le doy valores.
	
	
	
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void obtienePrecioTotalMatriculaEstudianteTest() {
		assertEquals(100, (int)colegio1.obtienePrecioTotalMatriculaEstudiante(estudiante1));
	}//realizo el precio de la matricula teniendo en cuenta que a ambas asignaturas les puse un precio de 50
	
	@Test
	public void obtienePresupuestoColegioTest() {
		assertEquals(8000, (int)colegio1.obtienePresupuestoColegio());
	}//realizo el presupuesto contando con los 8000 iniciales
	
	@Test
	public void anadeEstudianteTest() {
		assertTrue(colegio1.anadeEstudiante(estudiante2));
		List<Estudiante> estudiantes1 = new ArrayList<>();
		estudiantes1.add(estudiante1);
		colegio2.anadeEstudiante(estudiante1);
		assertArrayEquals(estudiantes1.toArray(), colegio2.getListaEstudiantes().toArray());
	}//creo una lista para que compruebe que no se añada el mismo estudiante 2 veces

	@Test
	public void eliminaAsignaturaTest() {
		assertTrue(colegio1.eliminaAsignatura(asignatura1));
		colegio1.eliminaAsignatura(asignatura2);
		List<Asignatura> asignaturas3 = new ArrayList<>();
		assertArrayEquals(asignaturas3.toArray(), colegio1.getListaAsignaturas().toArray());
	}// realizo el eliminar las asignaturas aunque me salta error ya que no consegui resolver el problema de libre o oficial
	
	@Test
	public void obtieneSueldoTotalProfesoresTest() {
		assertEquals(900, (int)colegio1.obtieneSueldoTotalProfesores());
	}// realizo el sueldo total teniendo en cuenta que uno tiene 400 y otro 500 de sueldo y por lo tanto sera 900
	
	@Test
	public void obtienePresupuestoNetoColegioTest() throws ColegioExcepcion {
		colegio1.obtienePresupuestoNetoColegio();
	}// obtengo el presupuesto con la suma de alumnos asignaturas y profesores
	
	@Test
	public void verificaMaxAlumnosPorGrupoTest() {
		
	}
}
