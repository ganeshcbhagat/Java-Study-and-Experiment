package main;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "Ganesh";
		emp.salary = 1;
		emp.age = 26;
		emp.cardNo = 22;
		System.out.println("object persisted = " + emp);
		
		File file = new File("employee.txt");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			
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
		Employee empTemp = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			empTemp = (Employee) ois.readObject();
			System.out.println("object de-persisted = " + empTemp);
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

	static class Person {
		
		public int age;
		public double salary;
		
		public Person() {
			this.age=100;
			this.salary = 100;
		}
	}
	// static class Employee implements Externalizable, ObjectInputValidation {
	static class Employee extends Person implements Serializable, ObjectInputValidation {
		static final long serialVersionUID = -8641748772700166105L;
		public String name;
		transient long cardNo;
		// For Externalizable no argument Constructor is mandatory
		public Employee() {
			this.name = "Rajesh";
		}

	/*	@Override
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeInt(age);
			out.writeDouble(salary);
			out.writeUTF(name);
			out.writeLong(cardNo);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			age = in.readInt();
			salary = in.readDouble();
			name = in.readUTF();
			cardNo = in.readLong();
		}*/

	/*	private void writeObject(ObjectOutputStream out) throws IOException {
			out.writeInt(age);
			out.writeDouble(salary);
			out.writeUTF(name);
			out.writeLong(cardNo);
		}

		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			System.out.println("Reading the object 1");
			in.registerValidation(this, 0);
			age = in.readInt();
			salary = in.readDouble();
			name = in.readUTF();
			cardNo = in.readLong();
			System.out.println("Reading the object 2");
		}*/

		@Override
		public void validateObject() throws InvalidObjectException {
			System.out.println("Validating the object");
			if(!name.equalsIgnoreCase("Ganesh")) {
				throw new InvalidObjectException("Doing data validation");
			}
		}

		@Override
		public String toString() {
			return "name=" + name + " salary=" + salary + " age=" + age + " cardNo=" + cardNo;
			// return "name="+name+" salary="+salary+" age="+age;
		}
	}
}
