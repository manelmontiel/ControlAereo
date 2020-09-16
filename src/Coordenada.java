
public class Coordenada {

	private int coordenadaX = 0;
	private int coordenadaY = 0;
	private int coordenadaZ = 0;
	
	public Coordenada(int sCoordenadaX, int sCoordenadaY, int sCoordenadaZ) {
		coordenadaX = sCoordenadaX;
		coordenadaY = sCoordenadaY;
		coordenadaZ = sCoordenadaZ;
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public int getCoordenadaZ() {
		return coordenadaZ;
	}
	public void setCoordenadaZ(int coordenadaZ) {
		this.coordenadaZ = coordenadaZ;
	}

}
