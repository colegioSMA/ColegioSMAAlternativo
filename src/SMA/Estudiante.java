package SMA;

import java.util.List;

public class Estudiante extends Persona{

	private List<Asignatura> listaAsignaturas = null;
	private Grupo grupo;
	public Estudiante(int edad, String nombre, String direccion, int anyoNacimiento, char genero,
			List<Asignatura> listaAsignaturas, Grupo grupo) {
		super(edad, nombre, direccion, anyoNacimiento, genero);
		this.listaAsignaturas = listaAsignaturas;
		this.grupo = grupo;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}


	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Estudiante && 
				super.equals(obj) &&
				((Estudiante)obj).getListaAsignaturas().equals(this.listaAsignaturas) &&
				((Estudiante)obj).getGrupo().equals(this.grupo)){
					return true;
				}
				return false;
	}
	
	
}
