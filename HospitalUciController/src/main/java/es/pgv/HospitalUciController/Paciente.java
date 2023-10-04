package es.pgv.HospitalUciController;

public class Paciente extends Thread {
		
		private String Nombre;
		private HospitalUci objHospitalUci;
		
		public Paciente(String nombre, HospitalUci hospitalUci) {
			this.Nombre = nombre;
			this.objHospitalUci = hospitalUci;
		}

		@Override
		public void run() {
			
			//Paciente intenta entrar en la UCI
			this.objHospitalUci.EntrarPaciente(this.Nombre);
			//Se simula una estancia del paciente en la UCI de 10 segundos
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Paciente intenta salir de la UCI
			this.objHospitalUci.SalirPaciente(this.Nombre);
			
		}
}
