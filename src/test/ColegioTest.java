package test;
//He usado la clase una clase main que he creado para ver los resultados
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import SMA.Asignatura;
import SMA.Colegio;
import SMA.Estudiante;
import SMA.Grupo;
import SMA.Profesor;
import SMA.ColegioExcepcion;
public class ColegioTest {
	List<Estudiante> estudiantes;
	List<Profesor>profesores;
	List<Asignatura> asignaturas;
	Colegio colegio;
	Estudiante alumno3;
	Estudiante alumno4;
	@Before
	public void test() {
		Profesor profe1 = new Profesor(44, "Manuel", "general ricardos", (2019-44), 'H', 1280);
		Profesor profe2 = new Profesor(36, "Diego", "Calle aguacate", 2019-36, 'H', 1236);
		Profesor profe3 = new Profesor(28, "Monica", "calle pan bendito", 2019-28, 'M', 1288);
		profesores= Arrays.asList(profe1,profe2,profe3);
		
		Asignatura Matematicas = new Asignatura("Matematicas", 46, profe1, "oficial");
		Asignatura Lengua = new Asignatura("Lengua", 31, profe2, "oficial");
		Asignatura Filosofia = new Asignatura("Filosofia", 61, profe3, "libre");
		asignaturas = Arrays.asList(Matematicas,Lengua,Filosofia);
		
		Grupo A = new Grupo(0, "Ciencias");
		Grupo B = new Grupo(1, "Letras");
		Grupo C = new Grupo(2, "Sociales");
		
		Estudiante alumno1 = new Estudiante(14, "Ivan", "Calle clarisas", 2019-14, 'H', Arrays.asList(Matematicas,Lengua), A);
		Estudiante alumno2 = new Estudiante(12, "Siomara", "calle piedrahita", 2019-12, 'M', Arrays.asList(Filosofia), C);
		alumno3 = new Estudiante(15, "Guadalupe", "calle de los ingenieros", 2019-15, 'M', Arrays.asList(Lengua,Filosofia), B);
		alumno4 = new Estudiante(14, "Sofia", "calle de los ingenieros", 2019-14, 'M', Arrays.asList(Lengua,Filosofia), C);
		estudiantes = Arrays.asList(alumno1,alumno2,alumno3);
		
		colegio = new Colegio(estudiantes, profesores, asignaturas);
	}
	
	@Test
	public void TestobtienePrecioTotalMatriculaEstudiante() {
		assertEquals(1694.0,colegio.obtienePrecioTotalMatriculaEstudiante(estudiantes.get(0)),0.01);
	}
	
	@Test
	public void testobtienePresupuestoColegio() {
		assertEquals(13060.0, colegio.obtienePresupuestoColegio(),0.01);
	}
	
	@Test
	public void testañadeestudiante1() {
		List<Estudiante> estudiantesprueba = colegio.getListaEstudiantes();
		assertTrue(colegio.anadeEstudiante(alumno3));
		assertArrayEquals(estudiantesprueba.toArray(), colegio.getListaEstudiantes().toArray());
	}
	
	@Test
	public void testeliminaasignatura() {
		Asignatura prueba = colegio.listaAsignaturas.get(0);
		List<Asignatura> asignaturasprueba = Arrays.asList(colegio.getListaAsignaturas().get(1),colegio.getListaAsignaturas().get(2));
		colegio.eliminaAsignatura(prueba);
		assertArrayEquals(asignaturasprueba.toArray(), colegio.getListaAsignaturas().toArray());
		
	}
	
	@Test
	public void testsueldototalprofesores() {
		float sueldototal=0;
		for (Profesor profesor : colegio.getListaProfesores()) {
			sueldototal+=profesor.getSalario();
		}
		
		assertEquals(sueldototal, colegio.obtieneSueldoTotalProfesores(),0.01);
	}
	
	@Test
	public void testverificaMaxAlumnosPorGrupo() {
		assertTrue(colegio.verificaMaxAlumnosPorGrupo());
	}

}
