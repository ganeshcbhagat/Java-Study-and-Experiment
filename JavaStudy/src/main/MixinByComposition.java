package main;

import java.util.ArrayList;
import java.util.List;

public class MixinByComposition {

	public static void main(String[] args) {

		System.out.println("Program Start");
		
		AircraftCarrier aircraftCarrier = new AircraftCarrier();
		aircraftCarrier.addCargo(new Cargo("Metal"));
		aircraftCarrier.addCargo(new Cargo("RDX"));
		
		System.out.println(aircraftCarrier.getListOfCargo());
		System.out.println("--------------------------------------");
		
		aircraftCarrier.land(new Aircraft("Sukhoi"));
		aircraftCarrier.land(new Aircraft("Jagwar"));
		
		System.out.println(aircraftCarrier.getListOfAircraft());
		System.out.println("--------------------------------------");
		
		aircraftCarrier.removeCargo(new Cargo("Metal"));
		aircraftCarrier.takeoff(new Aircraft("Sukhoi"));
		
		System.out.println(aircraftCarrier.getListOfCargo());
		System.out.println(aircraftCarrier.getListOfAircraft());
		
		System.out.println("Program End");
		
	}

	private static class Carrier {
		private List<Cargo> cargoList = new ArrayList<Cargo>();
		
		public List<Cargo> getListOfCargo(){
			return cargoList;
		}
		
		public boolean addCargo(Cargo cargo){
			return cargoList.add(cargo);
		}
		
		public boolean removeCargo(Cargo cargo){
			return cargoList.remove(cargo);
		}

		@Override
		public String toString() {
			return "Carrier [" + (cargoList != null ? "cargoList=" + cargoList : "") + "]";
		}
	}
	
	private static class Airport {
		private List<Aircraft> aircraftList = new ArrayList<Aircraft>();
		
		public List<Aircraft> getListOfAircraft(){
			return aircraftList;
		}
		
		public void takeoff(Aircraft aircraft){
			aircraftList.remove(aircraft);
			System.out.println("Aircraft:"+ aircraft.getName()+" get takeoff");
		}
		
		public void land(Aircraft aircraft){
			aircraftList.add(aircraft);
			System.out.println("Aircraft:"+ aircraft.getName()+" get landed");
		}

		@Override
		public String toString() {
			return "Airport [" + (aircraftList != null ? "aircraftList=" + aircraftList : "") + "]";
		}
		
	}
	
	private static class AircraftCarrier {
		private Airport airport;
		private Carrier carrier;
		
		public AircraftCarrier() {
			this.airport = new Airport();
			this.carrier = new Carrier();
		}
		
		public boolean addCargo(Cargo cargo){
			return carrier.addCargo(cargo);
		}
		
		public boolean removeCargo(Cargo cargo){
			return carrier.removeCargo(cargo);
		}
		
		public void takeoff(Aircraft aircraft){
			airport.takeoff(aircraft);
		}
		
		public void land(Aircraft aircraft){
			airport.land(aircraft);
		}
		
		public List<Cargo> getListOfCargo(){
			return carrier.getListOfCargo();
		}
		
		public List<Aircraft> getListOfAircraft(){
			return airport.getListOfAircraft();
		}
		
	}
	
	private static class Cargo {
		private String material;

		public Cargo() {

		}
		
		public Cargo(String material) {
			this.material= material;
		}
		
		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((material == null) ? 0 : material.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cargo other = (Cargo) obj;
			if (material == null) {
				if (other.material != null)
					return false;
			} else if (!material.equals(other.material))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Cargo [" + (material != null ? "material=" + material : "") + "]";
		}
		
	}
	
	private static class Aircraft {
		private String name;

		public Aircraft() {

		}
		
		public Aircraft(String name) {
			this.name= name;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aircraft other = (Aircraft) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Aircraft [" + (name != null ? "name=" + name : "") + "]";
		}
		
	}
}
