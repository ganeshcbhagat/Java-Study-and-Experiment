package main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BeanPropertyChangeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BeanPropertyChangeListener bpcl = new BeanPropertyChangeListener(); 
		MyBean myBeanObj = new MyBean();
		myBeanObj.addPropertyChangeListener(bpcl);
		myBeanObj.setName("hello");
		System.out.println("name:="+myBeanObj.getName());
		myBeanObj.setName("New hello");
		System.out.println("name:="+myBeanObj.getName());
	}
}

class MyBean{
	
	private PropertyChangeSupport pcs;
	private String name;
	
	public MyBean() {
		pcs = new PropertyChangeSupport(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldName,newName;
		oldName=this.name;
		newName=name;
		this.name = name;
		System.out.println("Before firePropertyChange");
		pcs.firePropertyChange("name",oldName,newName);
		System.out.println("After firePropertyChange");
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}	
}

class BeanPropertyChangeListener implements PropertyChangeListener{

	@Override
	public void propertyChange(PropertyChangeEvent pce) {
		System.out.println("Property Name: " + pce.getPropertyName());
		System.out.println("Previous balance: " + pce.getOldValue());
		System.out.println("New Balance: " + pce.getNewValue());
	}

}

