package SMA;

public class Asignatura {

	private static int contador = 0;
	private int identificador = 0;
	private String nombre;
	private float precio;
	private Profesor profesor;
	private String regimen;  //Libre u oficial
	public Asignatura(String nombre, float precio, Profesor profesor, String regimen) {
		super();
		this.identificador = ++contador;
		this.nombre = nombre;
		this.precio = precio;
		this.profesor = profesor;
		this.regimen = regimen;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Asignatura.contador = contador;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Asignatura &&
				((Asignatura)obj).identificador == this.identificador &&
				((Asignatura)obj).nombre.equals(this.nombre) &&
				((Asignatura)obj).precio == this.precio &&
				((Asignatura)obj).profesor.equals(this.profesor) &&
				((Asignatura)obj).regimen.equals(this.regimen)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	
	
}
