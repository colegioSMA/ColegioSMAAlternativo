package SMA;

import java.util.Comparator;
import java.util.List;


public class Colegio {
	public List<Estudiante> listaEstudiantes = null;
	public List<Profesor> listaProfesores = null;
	public List<Asignatura> listaAsignaturas = null;
	public static final float PRESUPUESTO_INICIAL = 8000f;
	public static final int NUM_MAX_ALUMNOS_POR_GRUPO = 2;
	public static final int IVA = 21;
	
	public Colegio(List<Estudiante> listaEstudiantes, List<Profesor> listaProfesores,
			List<Asignatura> listaAsignaturas) {
		super();
		this.listaEstudiantes = listaEstudiantes;
		this.listaProfesores = listaProfesores;
		this.listaAsignaturas = listaAsignaturas;
	}

	public boolean verificaMaxAlumnosPorGrupo() {
		
		boolean verificaMaximo = true;
		
		listaEstudiantes.sort(new Comparator<Estudiante>() {

			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				// TODO Auto-generated method stub
				return o1.getGrupo().getIdentificadorGrupo() - o2.getGrupo().getIdentificadorGrupo();
			}
			
		});
		int numAlumunosPorGrupo=1;
		for (int i=0;i<listaEstudiantes.size()-1;i++) {
			
			if (listaEstudiantes.get(i).getGrupo().getIdentificadorGrupo() != 
					listaEstudiantes.get(i+1).getGrupo().getIdentificadorGrupo()) {
				if (numAlumunosPorGrupo > NUM_MAX_ALUMNOS_POR_GRUPO) {
					verificaMaximo = false;
					break;
				}
				numAlumunosPorGrupo = 1;
			}
			else {
				numAlumunosPorGrupo = numAlumunosPorGrupo + 1;
			}
		}
		if (numAlumunosPorGrupo > NUM_MAX_ALUMNOS_POR_GRUPO) { //Para el último grupo
			verificaMaximo = false;
		}
		return verificaMaximo;
	}
	
	
	public  float obtienePrecioTotalMatriculaEstudiante(Estudiante e) {
		float precioTotal = 0f;
		for (Asignatura asignatura : e.getListaAsignaturas()) {
			precioTotal = precioTotal+asignatura.getPrecio()+asignatura.getPrecio()*IVA;
			
		}
		return precioTotal;
	}

	public float obtienePresupuestoColegio() {

		float presupuesto = 0f;
		for (Estudiante estudiante : listaEstudiantes) {
			for (Asignatura asignatura : estudiante.getListaAsignaturas()) {
				presupuesto = presupuesto+asignatura.getPrecio()+asignatura.getPrecio()*IVA;
			}
		}
		return PRESUPUESTO_INICIAL + presupuesto;
	}

	public boolean eliminaEstudiante(Estudiante estudiante) {
		return listaEstudiantes.remove(estudiante);
	}

	public boolean anadeEstudiante(Estudiante estudiante) {
		if (listaEstudiantes.contains(estudiante)) {
			return true;
		}
		else {
			listaEstudiantes.add(estudiante);
			return false;
		}
	}
	public boolean eliminaProfesor(Profesor profesor) {
		return listaProfesores.remove(profesor);
	}

	public boolean anadeProfesor(Profesor profesor) {
		return listaProfesores.add(profesor);
	}
	public boolean eliminaAsignatura(Asignatura asignatura) {
		return listaAsignaturas.remove(asignatura);

	}

	public boolean anadeAsignatura(Asignatura asignatura) {
		return listaAsignaturas.add(asignatura);
	}
	public float obtieneSueldoTotalProfesores() {
		float sueldoTotal = 0f;

		for (Profesor profesor : listaProfesores) {

			sueldoTotal = sueldoTotal+profesor.getSalario();
		}
		return sueldoTotal;
	}

	public float obtienePresupuestoNetoColegio() throws ColegioExcepcion {
		float presupuestoTotalNeto = obtienePresupuestoColegio() - obtieneSueldoTotalProfesores();
		if (presupuestoTotalNeto < 0)
			throw new ColegioExcepcion("Presupuesto negativo");
		else
			return presupuestoTotalNeto;
	}

	public List<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public List<Profesor> getListaProfesores() {
		return listaProfesores;
	}

	public void setListaProfesores(List<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

}
