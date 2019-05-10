package SMA;

public class Grupo {
	
	private int identificadorGrupo;
	
	private String nombreGrupo;

	public Grupo(int identificadorGrupo, String nombreGrupo) {
		super();
		this.identificadorGrupo = identificadorGrupo;
		this.nombreGrupo = nombreGrupo;
	}

	public int getIdentificadorGrupo() {
		return identificadorGrupo;
	}

	public void setIdentificadorGrupo(int identificadorGrupo) {
		this.identificadorGrupo = identificadorGrupo;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Grupo &&
				((Grupo)obj).identificadorGrupo == identificadorGrupo &&
				((Grupo)obj).nombreGrupo.equals(nombreGrupo)) {
			return true;
		}
		return false;
	}
	
	

}
