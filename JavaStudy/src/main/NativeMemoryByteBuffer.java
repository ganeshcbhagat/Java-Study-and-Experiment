package main;

import java.nio.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NativeMemoryByteBuffer {

	public static void main(String[] args) throws Exception {

		   Thread.sleep(900);
		    
		    int size = 1000;
		    
		    ByteBuffer buffer = ByteBuffer.allocateDirect(size*1024); //Direct Memory
		    //ByteBuffer buffer = ByteBuffer.allocate(size*1000); //Indirect Memory
		    System.out.println("------------------------------------");
		    //System.out.println("Is a direct buffer: " + buffer.isDirect());
			
			Person arr[] = new Person[size];
			int byteSize[] = new int[size];
			
			byte byteX[]=null;
			for (int i = 0; i < size; i++) {
				Person p = new Person("Ganesh "+i,10*i);
				System.out.println("Putting Object in Heap memory "+p);
				arr[i]=p;
				byteX = NativeMemoryByteBuffer.toByteArray(p);
				buffer.put(byteX);
				byteSize[i]=byteX.length;
				Thread.sleep(10);
			}
			
			buffer.flip();
			System.out.println("------------------------------------");
			System.out.println("Removing object from heap memory");
			Thread.sleep(500);
			
			for (int i = 0; i < size; i++) {
				System.gc();
				arr[i]=null;
				//Thread.sleep(10);
			}
			
			arr=null;
			arr=new Person[size];
			
			System.out.println("------------------------------------");
			System.out.println("Taking back object from Native memory");
			Thread.sleep(500);
			
			byte bytes[] = new byte[byteX.length];
			for (int i = 0; i < size; i++) {
				bytes = new byte[byteSize[i]];
				buffer.get(bytes);
				arr[i]=(Person) NativeMemoryByteBuffer.toObject(bytes);
				System.out.println("Retriving at "+i+" = "+arr[i]);
				Thread.sleep(10);
			}
			
			Thread.sleep(4000);
			System.out.println("End");
			
	}

	private static class Person implements Serializable{
		private static final long serialVersionUID = -3307705161260682135L;
		public String name;
		public float salary;
		
		public Person(String name, float salary) {
			this.name = name;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Person [" + (name != null ? "name=" + name + ", " : "") + "salary=" + salary + "]";
		}
		
	}
	
	// toByteArray and toObject are taken from: http://tinyurl.com/69h8l7x
    public static byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return bytes;
    }

    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return obj;
    }
}
