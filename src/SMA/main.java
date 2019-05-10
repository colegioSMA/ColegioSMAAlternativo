package SMA;

import java.util.Arrays;
import java.util.List;

public class main {
	public static void main(String[] args) {
		List<Estudiante> estudiantes;
		List<Profesor>profesores;
		List<Asignatura> asignaturas;
		Colegio colegio;
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
		Estudiante alumno3 = new Estudiante(15, "Guadalupe", "calle de los ingenieros", 2019-15, 'M', Arrays.asList(Lengua,Filosofia), B);
		estudiantes = Arrays.asList(alumno1,alumno2,alumno3);
		
		colegio = new Colegio(estudiantes, profesores, asignaturas);
		
		System.out.println(colegio.obtieneSueldoTotalProfesores());
	}
}
