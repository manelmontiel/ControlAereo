import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner teclat = new Scanner(System.in);
	public static EspacioAereo espacioAereo = new EspacioAereo();
	public static PistaAterrizaje pistaAterrizaje = new PistaAterrizaje();
	public static ArrayList<Avion> listaAviones = new ArrayList();
	public static Coordenada aeropuerto = new Coordenada(100, 100, 0);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//altura máxima para sacar el tren aterrizaje: 100m
		Main programa = new Main();
		programa.inici();

	}
	
	private void inici() {
		

		controladorAeri();
	}
	
	private void afegirAvio() {
		if(pistaAterrizaje.getOcupada() == true) {
			System.out.println("");
			System.out.println("No se puede añadir un avión porque la pista de aterrizaje está ocupada!!");
			System.out.println("");
		}
		else if(listaAviones.size() == espacioAereo.getCapacidad()){
			System.out.println("");
			System.out.println("No se puede añadir un avión porque el espacio aereo está lleno.");
			System.out.println("");	
		}
		else {
			System.out.println("Introduzca la matricula del avión:\n");	//si
			String matricula = teclat.next();

			System.out.println("Introduzca la marca del avión:\n");	//si
			String marca = teclat.next();

			System.out.println("Introduzca el modelo del avión:\n");	//si
			String modelo = teclat.next();
			
			//poner capacidad avion
			
			System.out.println("Introduzca el destino del avión:\n");	//no
			String destino = teclat.next();
			
			System.out.println("Es un avión comercial o militar?\n");
			System.out.println("1 - Avión Comercial");
			System.out.println("2 - Avión Militar");
			int tipo = variableInt();
			if(tipo == 1) {
				AvionComercial avionComercial = new AvionComercial(); //100, 100, 0
				avionComercial.setCoordenadas(aeropuerto);
				avionComercial.setMatricula(matricula);
				avionComercial.setMarca(marca);
				avionComercial.setModelo(modelo);
				avionComercial.setOrigen("BCN");
				avionComercial.setDestino(destino);
				avionComercial.setMotor(true);	//se hace al gestionar
				avionComercial.setTrenAterrizaje(true);		//si ha de estar fuera al crearse
				listaAviones.add(avionComercial);
				pistaAterrizaje.setOcupada(true);
			}
			else if(tipo == 2) {
				AvionMilitar avionMilitar = new AvionMilitar();
				avionMilitar.setCoordenadas(aeropuerto);
				avionMilitar.setMatricula(matricula);
				avionMilitar.setMarca(marca);
				avionMilitar.setModelo(modelo);
				avionMilitar.setOrigen("BCN");
				avionMilitar.setDestino(destino);
				avionMilitar.setMotor(true);
				avionMilitar.setTrenAterrizaje(true);
				System.out.println("Es un avión amigo o enemigo");
				System.out.println("1 - Amigo");
				System.out.println("2 - Enemigo");
				int tipoMilitar = variableInt();
				if(tipoMilitar == 1) {
					avionMilitar.setAmigo(true);	//amigo
					listaAviones.add(avionMilitar);
					pistaAterrizaje.setOcupada(true);
				}
				else if(tipoMilitar==2) {
					avionMilitar.setAmigo(false);	//enemigo
					listaAviones.add(avionMilitar);
					pistaAterrizaje.setOcupada(true);
				}
				else {
					System.out.println("No es una opción.");
				}
			}
			else {
				System.out.println("No es una opción.");
			}
		}
	}
	
	private Avion buscarAvion(String matricula) {
		Avion avion = new Avion();
		for(int i=0; i < listaAviones.size(); i++) {
			if(listaAviones.get(i).getMatricula().equals(matricula)) {
				avion = listaAviones.get(i);
				
				return avion;
			}
		}
		return avion;
	}
	
	private void eliminarAvion(Avion avionImportado) {	//revisar si esta bien
		Avion avion = avionImportado;
		if(avion.getCoordenadas().getCoordenadaX() < 0 || avion.getCoordenadas().getCoordenadaX() > 1000) {
			listaAviones.remove(avion);
			System.out.println("El avion ha salido de nuestro espacio aereo.");
		}
		else if(avion.getCoordenadas().getCoordenadaY() < 0 || avion.getCoordenadas().getCoordenadaY() > 1000) {
			listaAviones.remove(avion);
			System.out.println("El avion ha salido de nuestro espacio aereo.");
		}
	}
	
	private void mostrarAviones() {
		System.out.print("            AVION 1  ");
		System.out.print(" AVION 2 ");
		System.out.print(" AVION 3 ");
		System.out.print(" AVION 4 ");
		System.out.print(" AVION 5 ");
		System.out.print(" AVION 6 ");
		System.out.print(" AVION 7 ");
		System.out.print(" AVION 8 ");
		System.out.print(" AVION 9 ");
		System.out.print(" AVION 10 ");
		
		System.out.println();
		System.out.print(" Marca    ");
		for(int i = 0; i < listaAviones.size(); i++){
			System.out.print("     " + listaAviones.get(i).getMarca());
		}
		
		System.out.println();
		System.out.print(" Model	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getModelo());
		}
		
		System.out.println();
		System.out.print(" Matricula");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getMatricula());
		}
		
		/*System.out.println();
		System.out.print(" Tripulantes");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getTripulantes());
		}*/
		
		System.out.println();
		System.out.print(" X	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getCoordenadas().getCoordenadaX());
		}
		
		System.out.println();
		System.out.print(" Y	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getCoordenadas().getCoordenadaY());
		}
		
		System.out.println();
		System.out.print(" Z	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getCoordenadas().getCoordenadaZ());
		}
		
		System.out.println();
		System.out.print(" Velocidad");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getVelocidad());
		}
		
		System.out.println();
		System.out.print(" Origen	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getOrigen());
		}
		
		System.out.println();
		System.out.print(" Destino");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getDestino());
		}
		
		System.out.println();
		System.out.print(" Rumbo	");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getRumbo());
		}
		
		System.out.println();
		System.out.print(" Motor    ");
		for (int a = 0; a < listaAviones.size(); a++) {
			if(listaAviones.get(a).getMotor() == true) {
				System.out.print("	On");
			}else {
				System.out.print("	Off");
			}
		}
		
		System.out.println();
		System.out.print(" Tipo    ");
		for (int a = 0; a < listaAviones.size(); a++) {
			Avion avio = new Avion();
			avio = listaAviones.get(a);
			if(avio instanceof AvionComercial) {
				System.out.print("	Com");
			}else if(avio instanceof AvionMilitar) {
					System.out.print("	Mil");
				
			}
		}
		System.out.println();
		System.out.print(" Lealtad    ");
		for (int a = 0; a < listaAviones.size(); a++) {
			Avion avio = new Avion();
			avio = listaAviones.get(a);
			if(avio instanceof AvionComercial) {
				System.out.print("	Amigo");
			}else if(avio instanceof AvionMilitar) {
				AvionMilitar militar = (AvionMilitar) avio;
				if(militar.getAmigo()) {
					System.out.print("	Amigo");
				}else {
					System.out.print("	Enemigo");
				}
			}
		}
		System.out.println();
		
		/*System.out.println();
		System.out.print(" Missiles");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getMissiles());
		}*/
		
		/*System.out.println();
		System.out.print(" Rango Missiles");
		for (int a = 0; a < listaAviones.size(); a++) {
			System.out.print("	" + listaAviones.get(a).getDistancia());
		}*/
	}
	 
	
	private void controladorAeri() {
		boolean salir = false;
		while(salir == false) {
			
			System.out.println("Escoja que quiere hacer:");
			System.out.println("1 - Crear un avión.");
			System.out.println("2 - Gestionar un avión.");
			System.out.println("3 - Mostrar el espacio aereo actual.");
			System.out.println("4 - Cifrar los aviones de combate.");
			System.out.println("5 - Descifrar los aviones de combate.");
			System.out.println("");
			int opcion = variableInt();
			switch(opcion) {
			
			case 1:
				//crear avion
				
				afegirAvio();
			break;
			case 2:
				System.out.println("Introduzca que avión quiere gestionar(matrícula):");
				String matricula = teclat.next();
				//buscarAvion(matricula);
				Avion avion = buscarAvion(matricula);
				
				/*if((avion.getCoordenadas().getCoordenadaX() != aeropuerto.getCoordenadaX()) ||(avion.getCoordenadas().getCoordenadaY() != aeropuerto.getCoordenadaY())||(avion.getCoordenadas().getCoordenadaZ() != aeropuerto.getCoordenadaZ())) {
					pistaAterrizaje.setOcupada(false);
				}*/	//posar opcio de despegar
				
				if(avion instanceof AvionMilitar) {
					if(((AvionMilitar) avion).getEncriptado() == true) {
						System.out.println("No se puede gestionar un avion encriptado.");
					}
					else {
						System.out.println("Que quiere hacer con este avión:");
						System.out.println("1 - Encender/Apagar motores");
						System.out.println("2 - Acelerar/Frenar");
						System.out.println("3 - Subir/Bajar tren aterrizaje");
						System.out.println("4 - Cambiar X");
						System.out.println("5 - Cambiar Y");
						System.out.println("6 - Subir/Bajar altura");
						System.out.println("7 - Despegar");
						System.out.println("8 - Aterrizar");
						System.out.println("9 - Establecer rumbo");
						
						//gestionar avion
						int opcion2 = variableInt();
						System.out.println("");
						
						switch(opcion2) {
						case 1:
							if(avion.getCoordenadas() != aeropuerto) {
								System.out.println("No puedes apagar los motores en el aire.");
							}else {
								//encender-apagar motores
								System.out.println("Que quiere hacer:");
								System.out.println("1 - Encender Motor");
								System.out.println("2 - Apagar Motor");
								int opcion3 = variableInt();
								System.out.println("");
								if(opcion3 == 1) {
									System.out.println("Motores encendidos.");
									avion.setMotor(true);
								}else if(opcion3 == 2) {
									System.out.println("Motores apagados.");
									avion.setMotor(false);
								}else {
									System.out.println("No es una opción.");
								}
							}
						break;
						case 2:
							//acelerar-frenar(aterrizar-despegar)
							if(avion.getMotor() == false) {
								System.out.println("No puedes acelerar ni frenar sin los motores encendidos.");
							}else {
								System.out.println("Que quiere hacer:");
								System.out.println("1 - Acelerar");
								System.out.println("2 - Frenar");
								int opcion3 = variableInt();
								System.out.println("");
								if(opcion3 == 1) {
									System.out.println("Introduzca la nueva velocidad.");
									int nuevaVelocidad = variableInt();
									System.out.println("");
									if(nuevaVelocidad > avion.getVelocidad()) {
										avion.setVelocidad(nuevaVelocidad);
									}else {
										System.out.println("No puedes acelerar con menos velocidad de la que tenias.");
									}
								}else if(opcion3 == 2) {
									System.out.println("Introduzca la nueva velocidad.");
									int nuevaVelocidad = variableInt();
									System.out.println("");
									if(nuevaVelocidad < avion.getVelocidad()) {
										avion.setVelocidad(nuevaVelocidad);
									}else {
										System.out.println("No puedes frenar con más velocidad de la que tenias.");
									}
								}else {
									System.out.println("No es una opción.");
								}
							}
						break;
						case 3:
							//subir-bajar tren aterrizaje
							System.out.println("Que quiere hacer:");
							System.out.println("1 - Subir tren aterrizaje");
							System.out.println("2 - Bajar tren aterrizaje");
							int opcion3 = variableInt();
							System.out.println("");	//pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ()
							if(opcion3 == 1) {
								if((avion.getCoordenadas().getCoordenadaX()==pistaAterrizaje.limites.getCoordenadaX()) && (avion.getCoordenadas().getCoordenadaY()==pistaAterrizaje.limites.getCoordenadaY())) {//(avion.getCoordenadaX() && avion.getCoordenadaY() && avion.getCoordenadaZ()) == (pistaAterrizaje.getCoordenadaX() && pistaAterrizaje.getCoordenadaY() && pistaAterrizaje.getCoordenadaZ())) { 		//avion.Coordenadas() == (pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ())
									System.out.println("No puedes subir el tren de aterrizaje en la pista o provocaras un accidente.");
								}else {
								System.out.println("Tren de aterrizaje subido.");
								avion.setTrenAterrizaje(false);
								}
							}else if(opcion3 == 2) {
								System.out.println("Tren de aterrizaje bajado.");
								avion.setTrenAterrizaje(true);
							}else {
								System.out.println("No es una opción.");
							}
						break;
						case 4:
							System.out.println("Introduzca la nueva X:");
							opcion3 = variableInt();
							System.out.println("");
							avion.getCoordenadas().setCoordenadaX(opcion3);
							eliminarAvion(avion);
						break;
						case 5:
							System.out.println("Introduzca la nueva Y:");
							opcion3 = variableInt();
							System.out.println("");
							avion.getCoordenadas().setCoordenadaY(opcion3);
							eliminarAvion(avion);
						break;
						case 6:
							//subir-bajar altura
							System.out.println("Que quiere hacer:");
							System.out.println("1 - Subir altura");
							System.out.println("2 - Bajar altura");
							opcion3 = variableInt();
							System.out.println("");
							if(opcion3 == 1) {
								System.out.println("Introduzca la nueva altura:");
								int nuevaAltura = variableInt();
								if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
									System.out.println("No puedes subir altura si no ha despegado el avión.");
								}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
									System.out.println("No puede subir a una altura menor que la que ya tiene.");
								}
								else {
									avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
									System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
								}
							}else if(opcion3 == 2) {
								System.out.println("Introduzca la nueva altura:");
								int nuevaAltura = variableInt();
								if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
									System.out.println("No puedes subir altura si no ha despegado el avión.");
								}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
									System.out.println("No puede subir a una altura menor que la que ya tiene.");
								}
								else {
									avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
									System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
								}
							}else {
								System.out.println("No es una opción.");
							}
						break;
						case 7:	//despegar
							if(avion.getCoordenadas() == aeropuerto) {
								if(avion.getVelocidad() < 250) {
									System.out.println("Necesitas más velocidad para despegar.");
								}else {
									avion.getCoordenadas().setCoordenadaZ(100);
									pistaAterrizaje.setOcupada(false);
									System.out.println("El avión con matricula " + avion.getMatricula() + " ha despegado.");
								}
							}else {
								System.out.println("No puedes despegar si no estas en la pista de aterrizaje.");
							}
						break;
						case 8:	//aterrizar
							if(avion.getCoordenadas().getCoordenadaX() == 100 && (avion.getCoordenadas().getCoordenadaY() < 100 && avion.getCoordenadas().getCoordenadaY() > 120) && avion.getCoordenadas().getCoordenadaZ() < 500) {
								if(avion.getTrenAterrizaje() == true) {
									avion.setCoordenadas(aeropuerto);
									avion.setMotor(false);
									pistaAterrizaje.setOcupada(true);	
								}else {
									System.out.println("No puedes aterrizar sin el tren de aterrizaje bajado.");
								}
							}else {
								System.out.println("No puedes aterrizar fuera de la pista de aterrizaje.");
							}
						break;
						case 9:
							//establecer rumbo
							System.out.println("Establezca el nuevo rumbo:");
							opcion3 = variableInt();
							System.out.println("");
							if(opcion3 < 0 && opcion3 > 360) {
								avion.setRumbo(opcion3);
							}else {
								System.out.println("El rumbo ha de estar entre 0 y 360.");
							}
							
						break;
						case 10:
							if(avion instanceof AvionMilitar) {
								System.out.println("Introduzca a que avión quiere disparar(matrícula):");
								String matricula2 = teclat.next();
								Avion avion2 = buscarAvion(matricula);
								if((avion2.getCoordenadas().getCoordenadaX() <= (avion.getCoordenadas().getCoordenadaX()) + 200) || (avion2.getCoordenadas().getCoordenadaY() <= (avion.getCoordenadas().getCoordenadaY()) + 200) ) {
									if(avion2 instanceof AvionMilitar && ((AvionMilitar) avion2).getAmigo() == false) {
										listaAviones.remove(avion2);
									}else {
										System.out.println("No puedes disparar a ese avión.");
									}
								}else {
									System.out.println("El avión objetivo no está dentro del alcance.");
								}
							}else{
								System.out.println("Este es un avión comercial, no puede disparar.");
							}
						break;
						
						}
					}
				}else {
					System.out.println("Que quiere hacer con este avión:");
					System.out.println("1 - Encender/Apagar motores");
					System.out.println("2 - Acelerar/Frenar");
					System.out.println("3 - Subir/Bajar tren aterrizaje");
					System.out.println("4 - Cambiar X");
					System.out.println("5 - Cambiar Y");
					System.out.println("6 - Subir/Bajar altura");
					System.out.println("7 - Despegar");
					System.out.println("8 - Aterrizar");
					System.out.println("9 - Establecer rumbo");
					
					//gestionar avion
					int opcion2 = variableInt();
					System.out.println("");
					
					switch(opcion2) {
					case 1:
						if(avion.getCoordenadas() != aeropuerto) {
							System.out.println("No puedes apagar los motores en el aire.");
						}else {
							//encender-apagar motores
							System.out.println("Que quiere hacer:");
							System.out.println("1 - Encender Motor");
							System.out.println("2 - Apagar Motor");
							int opcion3 = variableInt();
							System.out.println("");
							if(opcion3 == 1) {
								System.out.println("Motores encendidos.");
								avion.setMotor(true);
							}else if(opcion3 == 2) {
								System.out.println("Motores apagados.");
								avion.setMotor(false);
							}else {
								System.out.println("No es una opción.");
							}
						}
					break;
					case 2:
						//acelerar-frenar(aterrizar-despegar)
						if(avion.getMotor() == false) {
							System.out.println("No puedes acelerar ni frenar sin los motores encendidos.");
						}else {
							System.out.println("Que quiere hacer:");
							System.out.println("1 - Acelerar");
							System.out.println("2 - Frenar");
							int opcion3 = variableInt();
							System.out.println("");
							if(opcion3 == 1) {
								System.out.println("Introduzca la nueva velocidad.");
								int nuevaVelocidad = variableInt();
								System.out.println("");
								if(nuevaVelocidad > avion.getVelocidad()) {
									avion.setVelocidad(nuevaVelocidad);
								}else {
									System.out.println("No puedes acelerar con menos velocidad de la que tenias.");
								}
							}else if(opcion3 == 2) {
								System.out.println("Introduzca la nueva velocidad.");
								int nuevaVelocidad = variableInt();
								System.out.println("");
								if(nuevaVelocidad < avion.getVelocidad()) {
									avion.setVelocidad(nuevaVelocidad);
								}else {
									System.out.println("No puedes frenar con más velocidad de la que tenias.");
								}
							}else {
								System.out.println("No es una opción.");
							}
						}
					break;
					case 3:
						//subir-bajar tren aterrizaje
						System.out.println("Que quiere hacer:");
						System.out.println("1 - Subir tren aterrizaje");
						System.out.println("2 - Bajar tren aterrizaje");
						int opcion3 = variableInt();
						System.out.println("");	//pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ()
						if(opcion3 == 1) {
							if((avion.getCoordenadas().getCoordenadaX()==pistaAterrizaje.limites.getCoordenadaX()) && (avion.getCoordenadas().getCoordenadaY()==pistaAterrizaje.limites.getCoordenadaY())) {//(avion.getCoordenadaX() && avion.getCoordenadaY() && avion.getCoordenadaZ()) == (pistaAterrizaje.getCoordenadaX() && pistaAterrizaje.getCoordenadaY() && pistaAterrizaje.getCoordenadaZ())) { 		//avion.Coordenadas() == (pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ())
								System.out.println("No puedes subir el tren de aterrizaje en la pista o provocaras un accidente.");
							}else {
							System.out.println("Tren de aterrizaje subido.");
							avion.setTrenAterrizaje(false);
							}
						}else if(opcion3 == 2) {
							System.out.println("Tren de aterrizaje bajado.");
							avion.setTrenAterrizaje(true);
						}else {
							System.out.println("No es una opción.");
						}
					break;
					case 4:
						System.out.println("Introduzca la nueva X:");
						opcion3 = variableInt();
						System.out.println("");
						avion.getCoordenadas().setCoordenadaX(opcion3);
						eliminarAvion(avion);
					break;
					case 5:
						System.out.println("Introduzca la nueva Y:");
						opcion3 = variableInt();
						System.out.println("");
						avion.getCoordenadas().setCoordenadaY(opcion3);
						eliminarAvion(avion);
					break;
					case 6:
						//subir-bajar altura
						System.out.println("Que quiere hacer:");
						System.out.println("1 - Subir altura");
						System.out.println("2 - Bajar altura");
						opcion3 = variableInt();
						System.out.println("");
						if(opcion3 == 1) {
							System.out.println("Introduzca la nueva altura:");
							int nuevaAltura = variableInt();
							if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
								System.out.println("No puedes subir altura si no ha despegado el avión.");
							}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
								System.out.println("No puede subir a una altura menor que la que ya tiene.");
							}
							else {
								avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
								System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
							}
						}else if(opcion3 == 2) {
							System.out.println("Introduzca la nueva altura:");
							int nuevaAltura = variableInt();
							if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
								System.out.println("No puedes subir altura si no ha despegado el avión.");
							}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
								System.out.println("No puede subir a una altura menor que la que ya tiene.");
							}
							else {
								avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
								System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
							}
						}else {
							System.out.println("No es una opción.");
						}
					break;
					case 7:	//despegar
						if(avion.getCoordenadas() == aeropuerto) {
							if(avion.getVelocidad() < 250) {
								System.out.println("Necesitas más velocidad para despegar.");
							}else {
								avion.getCoordenadas().setCoordenadaZ(100);
								pistaAterrizaje.setOcupada(false);
								System.out.println("El avión con matricula " + avion.getMatricula() + " ha despegado.");
							}
						}else {
							System.out.println("No puedes despegar si no estas en la pista de aterrizaje.");
						}
					break;
					case 8:	//aterrizar
						if(avion.getCoordenadas().getCoordenadaX() == 100 && (avion.getCoordenadas().getCoordenadaY() < 100 && avion.getCoordenadas().getCoordenadaY() > 120) && avion.getCoordenadas().getCoordenadaZ() < 500) {
							if(avion.getTrenAterrizaje() == true) {
								avion.setCoordenadas(aeropuerto);
								avion.setMotor(false);
								pistaAterrizaje.setOcupada(true);	
							}else {
								System.out.println("No puedes aterrizar sin el tren de aterrizaje bajado.");
							}
						}else {
							System.out.println("No puedes aterrizar fuera de la pista de aterrizaje.");
						}
					break;
					case 9:
						//establecer rumbo
						System.out.println("Establezca el nuevo rumbo:");
						opcion3 = variableInt();
						System.out.println("");
						if(opcion3 < 0 && opcion3 > 360) {
							avion.setRumbo(opcion3);
						}else {
							System.out.println("El rumbo ha de estar entre 0 y 360.");
						}
						
					break;
					case 10:
						if(avion instanceof AvionMilitar) {
							System.out.println("Introduzca a que avión quiere disparar(matrícula):");
							String matricula2 = teclat.next();
							Avion avion2 = buscarAvion(matricula);
							if((avion2.getCoordenadas().getCoordenadaX() <= (avion.getCoordenadas().getCoordenadaX()) + 200) || (avion2.getCoordenadas().getCoordenadaY() <= (avion.getCoordenadas().getCoordenadaY()) + 200) ) {
								if(avion2 instanceof AvionMilitar && ((AvionMilitar) avion2).getAmigo() == false) {
									listaAviones.remove(avion2);
								}else {
									System.out.println("No puedes disparar a ese avión.");
								}
							}else {
								System.out.println("El avión objetivo no está dentro del alcance.");
							}
						}else{
							System.out.println("Este es un avión comercial, no puede disparar.");
						}
					break;
					
					}
				}
				
				/*System.out.println("Que quiere hacer con este avión:");
				System.out.println("1 - Encender/Apagar motores");
				System.out.println("2 - Acelerar/Frenar");
				System.out.println("3 - Subir/Bajar tren aterrizaje");
				System.out.println("4 - Cambiar X");
				System.out.println("5 - Cambiar Y");
				System.out.println("6 - Subir/Bajar altura");
				System.out.println("7 - Despegar");
				System.out.println("8 - Aterrizar");
				System.out.println("9 - Establecer rumbo");
				
				//gestionar avion
				int opcion2 = variableInt();
				System.out.println("");
				
				switch(opcion2) {
				case 1:
					if(avion.getCoordenadas() != aeropuerto) {
						System.out.println("No puedes apagar los motores en el aire.");
					}else {
						//encender-apagar motores
						System.out.println("Que quiere hacer:");
						System.out.println("1 - Encender Motor");
						System.out.println("2 - Apagar Motor");
						int opcion3 = variableInt();
						System.out.println("");
						if(opcion3 == 1) {
							System.out.println("Motores encendidos.");
							avion.setMotor(true);
						}else if(opcion3 == 2) {
							System.out.println("Motores apagados.");
							avion.setMotor(false);
						}else {
							System.out.println("No es una opción.");
						}
					}
				break;
				case 2:
					//acelerar-frenar(aterrizar-despegar)
					if(avion.getMotor() == false) {
						System.out.println("No puedes acelerar ni frenar sin los motores encendidos.");
					}else {
						System.out.println("Que quiere hacer:");
						System.out.println("1 - Acelerar");
						System.out.println("2 - Frenar");
						int opcion3 = variableInt();
						System.out.println("");
						if(opcion3 == 1) {
							System.out.println("Introduzca la nueva velocidad.");
							int nuevaVelocidad = variableInt();
							System.out.println("");
							if(nuevaVelocidad > avion.getVelocidad()) {
								avion.setVelocidad(nuevaVelocidad);
							}else {
								System.out.println("No puedes acelerar con menos velocidad de la que tenias.");
							}
						}else if(opcion3 == 2) {
							System.out.println("Introduzca la nueva velocidad.");
							int nuevaVelocidad = variableInt();
							System.out.println("");
							if(nuevaVelocidad < avion.getVelocidad()) {
								avion.setVelocidad(nuevaVelocidad);
							}else {
								System.out.println("No puedes frenar con más velocidad de la que tenias.");
							}
						}else {
							System.out.println("No es una opción.");
						}
					}
				break;
				case 3:
					//subir-bajar tren aterrizaje
					System.out.println("Que quiere hacer:");
					System.out.println("1 - Subir tren aterrizaje");
					System.out.println("2 - Bajar tren aterrizaje");
					int opcion3 = variableInt();
					System.out.println("");	//pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ()
					if(opcion3 == 1) {
						if((avion.getCoordenadas().getCoordenadaX()==pistaAterrizaje.limites.getCoordenadaX()) && (avion.getCoordenadas().getCoordenadaY()==pistaAterrizaje.limites.getCoordenadaY())) {//(avion.getCoordenadaX() && avion.getCoordenadaY() && avion.getCoordenadaZ()) == (pistaAterrizaje.getCoordenadaX() && pistaAterrizaje.getCoordenadaY() && pistaAterrizaje.getCoordenadaZ())) { 		//avion.Coordenadas() == (pistaAterrizaje.getCoordenadaX(), pistaAterrizaje.getCoordenadaY(), pistaAterrizaje.getCoordenadaZ())
							System.out.println("No puedes subir el tren de aterrizaje en la pista o provocaras un accidente.");
						}else {
						System.out.println("Tren de aterrizaje subido.");
						avion.setTrenAterrizaje(false);
						}
					}else if(opcion3 == 2) {
						System.out.println("Tren de aterrizaje bajado.");
						avion.setTrenAterrizaje(true);
					}else {
						System.out.println("No es una opción.");
					}
				break;
				case 4:
					System.out.println("Introduzca la nueva X:");
					opcion3 = variableInt();
					System.out.println("");
					avion.getCoordenadas().setCoordenadaX(opcion3);
					eliminarAvion(avion);
				break;
				case 5:
					System.out.println("Introduzca la nueva Y:");
					opcion3 = variableInt();
					System.out.println("");
					avion.getCoordenadas().setCoordenadaY(opcion3);
					eliminarAvion(avion);
				break;
				case 6:
					//subir-bajar altura
					System.out.println("Que quiere hacer:");
					System.out.println("1 - Subir altura");
					System.out.println("2 - Bajar altura");
					opcion3 = variableInt();
					System.out.println("");
					if(opcion3 == 1) {
						System.out.println("Introduzca la nueva altura:");
						int nuevaAltura = variableInt();
						if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
							System.out.println("No puedes subir altura si no ha despegado el avión.");
						}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
							System.out.println("No puede subir a una altura menor que la que ya tiene.");
						}
						else {
							avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
							System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
						}
					}else if(opcion3 == 2) {
						System.out.println("Introduzca la nueva altura:");
						int nuevaAltura = variableInt();
						if(avion.getCoordenadas().getCoordenadaZ() == pistaAterrizaje.limites.getCoordenadaZ()) {
							System.out.println("No puedes subir altura si no ha despegado el avión.");
						}else if(avion.getCoordenadas().getCoordenadaZ() < nuevaAltura) {
							System.out.println("No puede subir a una altura menor que la que ya tiene.");
						}
						else {
							avion.getCoordenadas().setCoordenadaZ(nuevaAltura);
							System.out.println("Altura aumentada. La nueva altura es " + avion.getCoordenadas().getCoordenadaZ() + ".");
						}
					}else {
						System.out.println("No es una opción.");
					}
				break;
				case 7:	//despegar
					if(avion.getCoordenadas() == aeropuerto) {
						if(avion.getVelocidad() < 250) {
							System.out.println("Necesitas más velocidad para despegar.");
						}else {
							avion.getCoordenadas().setCoordenadaZ(100);
							pistaAterrizaje.setOcupada(false);
							System.out.println("El avión con matricula " + avion.getMatricula() + " ha despegado.");
						}
					}else {
						System.out.println("No puedes despegar si no estas en la pista de aterrizaje.");
					}
				break;
				case 8:	//aterrizar
					if(avion.getCoordenadas().getCoordenadaX() == 100 && (avion.getCoordenadas().getCoordenadaY() < 100 && avion.getCoordenadas().getCoordenadaY() > 120) && avion.getCoordenadas().getCoordenadaZ() < 500) {
						if(avion.getTrenAterrizaje() == true) {
							avion.setCoordenadas(aeropuerto);
							avion.setMotor(false);
							pistaAterrizaje.setOcupada(true);	
						}else {
							System.out.println("No puedes aterrizar sin el tren de aterrizaje bajado.");
						}
					}else {
						System.out.println("No puedes aterrizar fuera de la pista de aterrizaje.");
					}
				break;
				case 9:
					//establecer rumbo
					System.out.println("Establezca el nuevo rumbo:");
					opcion3 = variableInt();
					System.out.println("");
					if(opcion3 < 0 && opcion3 > 360) {
						avion.setRumbo(opcion3);
					}else {
						System.out.println("El rumbo ha de estar entre 0 y 360.");
					}
					
				break;
				case 10:
					if(avion instanceof AvionMilitar) {
						System.out.println("Introduzca a que avión quiere disparar(matrícula):");
						String matricula2 = teclat.next();
						Avion avion2 = buscarAvion(matricula);
						if((avion2.getCoordenadas().getCoordenadaX() <= (avion.getCoordenadas().getCoordenadaX()) + 200) || (avion2.getCoordenadas().getCoordenadaY() <= (avion.getCoordenadas().getCoordenadaY()) + 200) ) {
							if(avion2 instanceof AvionMilitar && ((AvionMilitar) avion2).getAmigo() == false) {
								listaAviones.remove(avion2);
							}else {
								System.out.println("No puedes disparar a ese avión.");
							}
						}else {
							System.out.println("El avión objetivo no está dentro del alcance.");
						}
					}else{
						System.out.println("Este es un avión comercial, no puede disparar.");
					}
				break;
				
				}*/
			break;
			case 3:
				//mostrar espacio aereo actual
				mostrarAviones();
				
			break;
			case 4:
				//cifrar avion de combate
				System.out.println("Introduzca que avión de combate quiere gestionar(matrícula):");
				String matriculaCombateCifrar = teclat.next();
				//buscarAvion(matricula);
				Avion avionCombateCifrar = buscarAvion(matriculaCombateCifrar);
				
				if(avionCombateCifrar instanceof AvionMilitar) {
					if(((AvionMilitar) avionCombateCifrar).getAmigo() == true) {
						if(((AvionMilitar) avionCombateCifrar).getEncriptado() == false) {
							((AvionMilitar) avionCombateCifrar).setEncriptado(true);
							try {
								avionCombateCifrar.setMarca(cEncriptar.cifrar(avionCombateCifrar.getMarca()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}//marca
							try {
								avionCombateCifrar.setModelo(cEncriptar.cifrar(avionCombateCifrar.getModelo()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								avionCombateCifrar.setOrigen(cEncriptar.cifrar(avionCombateCifrar.getOrigen()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								avionCombateCifrar.setDestino(cEncriptar.cifrar(avionCombateCifrar.getDestino()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                   
						}else {
							System.out.println("Ya está encriptado.");
						}
					}
					else {
						System.out.println("No es un avión amigo, no se puede encriptar.");
					}
				}else {
					System.out.println("No es un avión militar, por tanto no se puede encriptar.");
				}
				//gestionar avion
				/*int opcion2Combate = variableInt();
				System.out.println("");
				
				switch(opcion2Combate) {
				case 1:
					break;
				}*/
			break;
			case 5:
				//descifrar avion de combate
				System.out.println("Introduzca que avión de combate quiere gestionar(matrícula):");
				String matriculaCombateDescifrar = teclat.next();
				//buscarAvion(matricula);
				Avion avionCombateDescifrar = buscarAvion(matriculaCombateDescifrar);
				
				if(avionCombateDescifrar instanceof AvionMilitar) {
					if(((AvionMilitar) avionCombateDescifrar).getAmigo() == true) {
						if(((AvionMilitar) avionCombateDescifrar).getEncriptado() == true) {
							((AvionMilitar) avionCombateDescifrar).setEncriptado(false);
							try {
								avionCombateDescifrar.setMarca(cEncriptar.descifrar(avionCombateDescifrar.getMarca()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}//marca
							try {
								avionCombateDescifrar.setModelo(cEncriptar.descifrar(avionCombateDescifrar.getModelo()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								avionCombateDescifrar.setOrigen(cEncriptar.descifrar(avionCombateDescifrar.getOrigen()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								avionCombateDescifrar.setDestino(cEncriptar.descifrar(avionCombateDescifrar.getDestino()));
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                   
						}else {
							System.out.println("Ya está desencriptado.");
						}
					}
					else {
						System.out.println("No es un avión amigo, no se puede desencriptar.");
					}
				}else {
					System.out.println("No es un avión militar, por tanto no se puede desencriptar.");
				}
			break;
			}
		}
	}
	
	private static int variableInt() {
		Scanner teclat = new Scanner(System.in);
		
		int num;
		
		while(!teclat.hasNextInt()) {
			teclat.next();
			System.out.print("Torna a introduïr el valor: ");
		}
		
		num = teclat.nextInt();
		return num;
		
	}
	
	/*public static void showAirSpace() {
		int counter = 1;
		for(Avion a: espacioAereo) {
			System.out.println(counter + ". " + a.toString());
			counter++;
		}
	}*/
	

}
