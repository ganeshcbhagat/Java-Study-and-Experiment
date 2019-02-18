package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializationTest2 {

	public static void main(String[] args) {
		Person person = new Person("Ganesh", 21);
		Person spouse = new Person("SexyName", 19);
		person.setSpouse(spouse);
		System.out.println("Person object persisted = " + person);

		File file = new File("PersonTemp.txt");

	/*	FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(person);

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
		}*/

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Person personTemp = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			personTemp = (Person) ois.readObject();
			System.out.println("Person object de-persisted = " + personTemp);
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
		
		private static final long serialVersionUID = -747532143626139817L;
		private String name;
		private int age;
		private Person spouse;
		
		public Person(String name, int a) {
			this.name = name;
			this.age = a;
		}
		
		// PersonProxy object get serialized instead of Person Object.
		// Object graph of Person class is send to PersonProxy class as constructor argument 
		// While deserialization it again reconstructing the Person object that logic is written in 'readResolve' method of PersonProxy class 
		private Object writeReplace() throws ObjectStreamException {
			return new PersonProxy(this);
		}

		// Write logic will not consider for serialization
	/*	private void writeObject(ObjectOutputStream out) throws IOException {
			out.writeUTF(name);
			out.writeInt(age);
			out.writeObject(spouse);
		}

		// Read logic will not consider for deserialization
		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			System.out.println("Reading the object 1");
			age = in.readInt();
			name = in.readUTF();
			spouse = (Person) in.readObject();
			System.out.println("Reading the object 2");
		}*/
		
		public String toString() {
			return "[Person: Name=" + name + ", Age=" + age + 
					(spouse!=null ? " [Spouse: Name=" + spouse.getName() + ", Age=" + spouse.getAge()+"]" : "") + "]";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Person getSpouse() {
			return spouse;
		}

		public void setSpouse(Person spouse) {
			this.spouse = spouse;
		}
		
	}

	static class PersonProxy implements Serializable {
		
		private static final long serialVersionUID = -747532143626139817L;
		public String data;
		
		// Person object details are comma separated and stored in the string data.
		// The data String get searialized in the file.
		public PersonProxy(Person orig) {
			data = orig.getName() + "," + orig.getAge();
			if (orig.getSpouse() != null) {
				Person spouse = orig.getSpouse();
				data = data + "," + spouse.getName() + "," + spouse.getAge();
			}
		}
		
		// While desearialization again we are reconstructing the Person object
		private Object readResolve() throws java.io.ObjectStreamException {
			String[] pieces = data.split(",");
			Person result = new Person(pieces[0], Integer.parseInt(pieces[1]));
			if (pieces.length > 2) {
				result.setSpouse(new Person(pieces[2], Integer.parseInt(pieces[3])));
			}
			return result;
		}
	}
}
