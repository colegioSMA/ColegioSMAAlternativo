package SMA;

public class Profesor extends Persona{


	private float salario;
	private static final float plusConvenio = 300f;
	public Profesor(int edad, String nombre, String direccion, int anyoNacimiento, char genero, float salario) {
		super(edad, nombre, direccion, anyoNacimiento, genero);
		this.salario = salario;
	}

	public float getSalario() {
		return salario+plusConvenio;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Profesor && 
				super.equals(obj) &&
				((Profesor)obj).salario == this.salario){
					return true;
				}
				return false;
	}
	
	
}
