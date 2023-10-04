package es.pgv.HospitalUciController;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Inicio de la simulación");
    	
        HospitalUci objHospitalUci = new HospitalUci();
        
        //Se lanzan 8 hilos de doctores
        for (int i = 1; i <= 8; i++) {
        	Doctor objDoctor = new Doctor("Doctor " + i, objHospitalUci);
        	objDoctor.setPriority(10);
        	objDoctor.start();
        }
        
        //Se lanzan 16 hilos de enfermeros
        for (int i = 1; i <= 16; i++) {
        	Enfermero objEnfermero = new Enfermero("Enfermero " + i, objHospitalUci);
        	objEnfermero.setPriority(8);
        	objEnfermero.start();
        }
        
        //Se lanzan 32 hilos de pacientes
        for (int i = 1; i <= 32; i++) {
        	Paciente objPaciente = new Paciente("Paciente " + i, objHospitalUci);
        	objPaciente.setPriority(1);
        	objPaciente.start();
    		try {
    			Thread.sleep(250);
    		} catch (InterruptedException e) {
    			e.printStackTrace(); 
    		}
        }
        
    }
}
