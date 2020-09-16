
public class AvionMilitar extends Avion{
	
	private boolean amigo;
	private int misiles;
	private boolean encriptado;
	
	/*public String toString() {
		return "(Militar) " + super.toString() +
				", misiles = " + misiles +
				", amigo = " + amigo +
				", encriptado = " + encriptado + ".";
	}*/
	
	public boolean getAmigo() {
		return amigo;
	}
	public void setAmigo(boolean amigo) {
		this.amigo = amigo;
	}
	public int getMisiles() {
		return misiles;
	}
	public void setMisiles(int misiles) {
		this.misiles = misiles;
	}
	public boolean getEncriptado() {
		return encriptado;
	}
	public void setEncriptado(boolean encriptado) {
		this.encriptado = encriptado;
	}
}
