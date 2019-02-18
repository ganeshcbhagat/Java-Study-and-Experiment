package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest1 {

	public static void main(String[] args) {
		Man man1 = new Man("Ganesh",100, "Male12");
		//Person man1 = new Person("Ganesh",100);
		System.out.println("object persisted = " + man1);
	
		File file = new File("Person.txt");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(man1);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Person personTemp = null;
		Man manTemp = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			//personTemp = (Person) ois.readObject();
			manTemp = (Man) ois.readObject();
			System.out.println("1) object de-persisted = " + personTemp);
			System.out.println("2) object de-persisted = " + manTemp);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		file = null;

	}

	static class Person implements Serializable {
		
		protected String name;
		protected double salary;
		
		public Person() {
			this.name="Dummy";
			this.salary = -1;
			System.out.println("1 Constructor Person invoked");
		}

		public Person(String name, double salary) {
			this.name=name;
			this.salary = salary;
			System.out.println("2 Constructor Person invoked");
		}
		
		
		@Override
		public String toString() {
			//return "name=" + name + " salary=" + salary+" xname: "+xname;
			//return "salary=" + salary;
			return "name=" + name + " salary=" + salary;
		}
	}

	static class Man extends Person implements Serializable {
		
		protected String gender="Male";
		
		public Man() {
			System.out.println("1 Constructor Man invoked");
		}
		
		public Man(String name, double salary) {
			super(name, salary);
			System.out.println("2 Constructor Man invoked");
		}
		
		public Man(String gender) {
			this.gender=gender;
			System.out.println("3 Constructor Man invoked");
		}
		
		public Man(String name, double salary, String gender) {
			this(name, salary);
			this.gender=gender;
			System.out.println("4 Constructor Man invoked");
		}

		@Override
		public String toString() {
			return super.toString() + " gender=" + gender;
		}
	}
}
