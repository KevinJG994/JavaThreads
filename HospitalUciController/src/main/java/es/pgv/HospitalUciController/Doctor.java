package es.pgv.HospitalUciController;

public class Doctor extends Thread {
	
	
	private String Nombre;
	private HospitalUci objHospitalUci;
	
	public Doctor(String nombre, HospitalUci hospitalUci) {
		this.Nombre = nombre;
		this.objHospitalUci = hospitalUci;
	}
	

	@Override
	public void run() {
		
		//Doctor intenta entrar en la UCI
		this.objHospitalUci.EntrarDoctor(this.Nombre);
		//Se simula una estancia del doctor en la UCI de 3 segundos
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Doctor intenta salir de la UCI
		this.objHospitalUci.SalirDoctor(this.Nombre);
		
	}

}
