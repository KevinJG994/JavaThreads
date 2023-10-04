package es.pgv.HospitalUciController;

public class HospitalUci {
	
	private int Pacientes;
	
	private int Doctores;
	
	private int Enfermeros;
	
	private final int MaxNumPacientes = 16;
	private final int MaxNumDoctores = 8;
	private final int MaxNumEnfermeros = 16;
	
	
	public HospitalUci() {
		this.Pacientes = 0;
		this.Doctores = 0;
		this.Enfermeros = 0;
	}
	
	public synchronized void EntrarPaciente(String NombrePaciente) {
	    try {
	    	
	    	while ((Pacientes + 1) >= MaxNumPacientes || Doctores == 0 && Enfermeros == 0) {
	            System.out.println("El " + NombrePaciente + " está esperando a ser ingresado en UCI.");
	            wait();
	        }

	        this.Pacientes++;
	        System.out.println("El " + NombrePaciente + " ha sido ingresado en UCI. (Pacientes=" + this.Pacientes + ", Doctores=" + this.Doctores + ", Enfermeros=" + this.Enfermeros + ")");
	        notifyAll();
	        

	    } catch (InterruptedException ex) {
	        ex.printStackTrace();
	    }
	}


	
	public synchronized void SalirPaciente(String NombrePaciente) {
	    
		this.Pacientes--;
	    System.out.println("El " + NombrePaciente + " ha salido de la UCI. (Pacientes=" + this.Pacientes + ", Doctores=" + this.Doctores + ", Enfermeros=" + this.Enfermeros + ")");
	    notifyAll();
	    
	    try {
	        Thread.sleep(10000);
	    } catch (InterruptedException ex) {
	        ex.printStackTrace();
	    }
	}


	
	public synchronized void EntrarDoctor(String NombreDoctor) {
	    try {
	    	
	        if (Doctores == 0) {
	            // Permitir que el primer doctor entre sin verificar las condiciones
	            this.Doctores++;
	            System.out.println("El " + NombreDoctor + " ha entrado al servicio UCI. (Pacientes=" + this.Pacientes + ", Doctores=" + this.Doctores + ", Enfermeros=" + this.Enfermeros + ")");
	            notifyAll();
	            return;
	        }

	        while ( Doctores >= MaxNumDoctores || (Pacientes / 4 <= Doctores)) {
	            System.out.println("El " + NombreDoctor + " está a la espera de entrar al servicio UCI.");
	            wait();
	        }

	        this.Doctores++;
	        System.out.println("El " + NombreDoctor + " ha entrado al servicio UCI. (Pacientes="+this.Pacientes+", Doctores="+this.Doctores+", Enfermeros="+this.Enfermeros+")");
	        notifyAll();


	    } catch (InterruptedException ex) {
	        ex.printStackTrace();
	    }
	}
		  
	
    public synchronized void SalirDoctor(String NombreDoctor) {
		
    	Doctores--;
		System.out.println("El " + NombreDoctor + " ha abandonado el servicio UCI. (Pacientes="+this.Pacientes+", Doctores="+this.Doctores+", Enfermeros="+this.Enfermeros+")");
		notifyAll(); // Notificar a otros hilos que estén esperando (si los hay)    
		   
		try {
		        Thread.sleep(3000);
		    } catch (InterruptedException ex) {
		        ex.printStackTrace();
		    }
		}
    
	
	
    public synchronized void EntrarEnfermero(String NombreEnfermero) {
    	try {
    		
    	     if (Enfermeros == 0) {
    	            // Permitir que el primer enfermero entre sin verificar las condiciones
    	            this.Enfermeros++;
    	            System.out.println("El " + NombreEnfermero + " ha entrado al servicio UCI. (Pacientes=" + this.Pacientes + ", Doctores=" + this.Doctores + ", Enfermeros=" + this.Enfermeros + ")");
    	            notifyAll();
    	            return;
    	        }
    	     
        	 while ( Enfermeros >= MaxNumEnfermeros  || (Pacientes / 2 <= Enfermeros)) {
                System.out.println("El " + NombreEnfermero + " está a la espera de entrar al servicio UCI.");
                wait();
            }
            
            this.Enfermeros++;
            System.out.println("El " + NombreEnfermero + " ha entrado al servicio UCI. (Pacientes="+this.Pacientes+", Doctores="+this.Doctores+", Enfermeros="+this.Enfermeros+")");
            notifyAll();

            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
	
    public synchronized void SalirEnfermero(String NombreEnfermero) {
		
    	Enfermeros--;
		System.out.println("El " + NombreEnfermero + " ha abandonado el servicio UCI. (Pacientes="+this.Pacientes+", Doctores="+this.Doctores+", Enfermeros="+this.Enfermeros+")");
        notifyAll(); 
 
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    
    }

}


