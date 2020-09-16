
public class Avion {

	private Coordenada coordenadas;
	private String matricula;
	private String marca;
	private String modelo;
	private boolean motor;
	private int rumbo;
	private String origen;
	private String destino;
	private boolean trenAterrizaje;
	private int velocidad;
	private boolean accidentado;
	
	/*public String toString() {
		return "Avion: " + 
				"marca = " + marca +
				", modelo = " + modelo +
				", matricula = " + matricula +
				", origen = " + origen +
				", destino = " + destino +
				", velocidad = " + velocidad +
				", rumbo = " + rumbo +
				", tren aterrizaje = " + trenAterrizaje +
				", motor = " + motor;
				
	}*/
	
	public Coordenada getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean getMotor() {
		return motor;
	}
	public void setMotor(boolean motor) {
		this.motor = motor;
	}
	public int getRumbo() {
		return rumbo;
	}
	public void setRumbo(int rumbo) {
		this.rumbo = rumbo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public boolean getTrenAterrizaje() {
		return trenAterrizaje;
	}
	public void setTrenAterrizaje(boolean trenAterrizaje) {
		this.trenAterrizaje = trenAterrizaje;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public boolean getAccidentado() {
		return accidentado;
	}
	public void setAccidentado(boolean accidentado) {
		this.accidentado = accidentado;
	}

}
