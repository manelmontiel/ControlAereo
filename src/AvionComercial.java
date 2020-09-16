
public class AvionComercial extends Avion{
	
	private int tripulantes;
	private int pasageros;
	
	/*public String toString() {
		return "(Comercial) " + super.toString() + ", tripulantes = " + tripulantes + ", pasageros = " + pasageros + ".";
	}*/
	
	public int getTripulantes() {
		return tripulantes;
	}
	public void setTripulantes(int tripulantes) {
		this.tripulantes = tripulantes;
	}
	public int getPasageros() {
		return pasageros;
	}
	public void setPasageros(int pasageros) {
		this.pasageros = pasageros;
	}

}
