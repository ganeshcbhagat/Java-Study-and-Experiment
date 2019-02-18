package main;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {

			//Here the order of patients to be treated by a doctor can be determined by checking if it's a emergency case or not.
			System.out.println("Program Start");
		 	PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(new PriorityBasedOnEmergeny());

		    patientQueue.add(new Patient(1, "Patient1", false));
		    patientQueue.add(new Patient(2, "Patient2", false));
		    patientQueue.add(new Patient(3, "Patient3", true));
		    patientQueue.add(new Patient(4, "Patient4", false));
		    patientQueue.add(new Patient(5, "Patient5", true));

		    System.out.println("Doctor's waiting for patients  : ");
		    while(true) {
		        Patient currentPatient = patientQueue.poll();
		        if(currentPatient == null) {
		            break;
		        }
		        System.out.println("inspection of "+currentPatient);
		    }
		    System.out.println();
		    System.out.println("Program End");
	}

	private static class PriorityBasedOnEmergeny implements Comparator<Patient> {

		@Override
		public int compare(Patient patient1, Patient patient2) {
			return (patient1.isEmergencyCase() == patient2.isEmergencyCase()) ? 
														(Integer.valueOf(patient1.getId()).compareTo(patient2.getId()))
                                                      : (patient1.isEmergencyCase() ? -1 : 1);
		}
	}
	
	private static class Patient {
		private int id;
		private String name;
		private boolean emergencyCase;

		public Patient(int id, String name, boolean emergencyCase) {
			this.id = id;
			this.name = name;
			this.emergencyCase = emergencyCase;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isEmergencyCase() {
			return emergencyCase;
		}

		public void setEmergencyCase(boolean emergencyCase) {
			this.emergencyCase = emergencyCase;
		}

		@Override
		public String toString() {
			return "Patient [id=" + id + ", name=" + name + ", emergencyCase=" + emergencyCase + "]";
		}
		
	}

}
