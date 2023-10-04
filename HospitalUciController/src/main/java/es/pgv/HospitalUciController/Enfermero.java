package es.pgv.HospitalUciController;

public class Enfermero extends Thread {
	
	private String Nombre;
	private HospitalUci objHospitalUci;
	
	public Enfermero(String nombre, HospitalUci hospitalUci) {
		this.Nombre = nombre;
		this.objHospitalUci = hospitalUci;
	}
	

	@Override
	public void run() {
		
		//Enfermero intenta entrar en la UCI
		this.objHospitalUci.EntrarEnfermero(this.Nombre);
		
		//Se simula una estancia del enfermero en la UCI de 3 segundos
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Enfermero intenta salir de la UCI
		this.objHospitalUci.SalirEnfermero(this.Nombre);
		
	}
	
}
