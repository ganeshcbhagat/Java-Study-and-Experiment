package main;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class PropertyAndVetoableChangeSupport {

	public static void main(String[] args) {
		Employee e = new Employee("Ganesh",100);
		System.out.println("Original Obj:"+e);
		e.addListener(new PropertyListener(), new ConstraintListener(), new MyExceptionListener());
		e.setName("Bhagat");
		System.out.println("Test1:"+e);
		
		e.setSalary(-10000000);
		System.out.println("Test2:"+e);
	}
	
	private static class Employee {
		private String name;
		private float salary;
		
		private PropertyChangeSupport propertyChangeSupport;
		private VetoableChangeSupport vetoableChangeSupport;
		private ExceptionSupport exceptionSupport;
		
		public static final String PROP_NAME="name";
		public static final String PROP_SALARY="salary";
		
		public Employee(String name,float salary) {
			this.name=name;
			this.salary=salary;
			this.propertyChangeSupport = new PropertyChangeSupport(this);
			this.vetoableChangeSupport = new VetoableChangeSupport(this);
			this.exceptionSupport = new ExceptionSupport(this);
		}

		public void addListener(PropertyChangeListener propertyChangeListener, VetoableChangeListener vetoableChangeListener, ExceptionListener exceptionListener) {
			propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
			vetoableChangeSupport.addVetoableChangeListener(vetoableChangeListener);
			exceptionSupport.addExceptionListener(exceptionListener);
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			String oldVal = this.name;
			try {
				this.vetoableChangeSupport.fireVetoableChange(PROP_NAME, oldVal, name);
				this.name = name;
				this.propertyChangeSupport.firePropertyChange(PROP_NAME, oldVal, this.name);
			} catch (PropertyVetoException e) {
				//System.out.println(e.getMessage());
				this.exceptionSupport.fireException(PROP_NAME,e);
			}
		}
		
		public float getSalary() {
			return salary;
		}

		public void setSalary(float salary) {
			float oldVal = this.salary;
			try {
				this.vetoableChangeSupport.fireVetoableChange(PROP_SALARY, oldVal, salary);
				this.salary = salary;
				this.propertyChangeSupport.firePropertyChange(PROP_SALARY, oldVal, this.salary);
			} catch (PropertyVetoException e) {
				//System.out.println(e.getMessage());
				this.exceptionSupport.fireException(PROP_SALARY,e);
			}
		}

		@Override
		public String toString() {
			return "Employee [" + (name != null ? "name=" + name + ", " : "") + "salary=" + salary + "]";
		}
	}
	
	private static class PropertyListener implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
			System.out.println("Property Change:"+propertyChangeEvent.getOldValue()+ "=>"+propertyChangeEvent.getNewValue());
		}
	}
	
	private static class ConstraintListener implements VetoableChangeListener {

		@Override
		public void vetoableChange(PropertyChangeEvent propertyChangeEvent) throws PropertyVetoException {
			if(Employee.PROP_NAME.equalsIgnoreCase(propertyChangeEvent.getPropertyName())) {
				String name = (String)propertyChangeEvent.getNewValue();
				if(name.length()>=10) {
					throw new PropertyVetoException("[Property:"+Employee.PROP_NAME+"] length should be less than 10 character ("+name+")",propertyChangeEvent);
				}
			}
			
			if(Employee.PROP_SALARY.equalsIgnoreCase(propertyChangeEvent.getPropertyName())) {
				float salary = (Float)propertyChangeEvent.getNewValue();
				if(salary<0) {
					throw new PropertyVetoException("[Property:"+Employee.PROP_SALARY+"] value should not be negative ("+salary+")",propertyChangeEvent);
				}
			}
		}
	}
	
	private static class ExceptionSupport {
		
		private List<ExceptionListener> exceptionListenerList;
		private Object source;
		
		public ExceptionSupport(Object source) {
			this.source = source;
			exceptionListenerList = new ArrayList<ExceptionListener>();
		}
		
		public void fireException(String proprtyName, Exception exception) {
			for(ExceptionListener exceptionListener : exceptionListenerList) {
				exceptionListener.onException(proprtyName, source, exception);
			}
		}
		
		public void addExceptionListener(ExceptionListener exceptionListener) {
			if(exceptionListenerList!=null && !exceptionListenerList.contains(exceptionListener)) {
				exceptionListenerList.add(exceptionListener);
			}
		}
		
		public void removeExceptionListener(ExceptionListener exceptionListener) {
			exceptionListenerList.remove(exceptionListener);
		}
	}
	
	private static interface ExceptionListener {
		public void onException(String proprtyName, Object source, Exception exception);
	}

	private static class MyExceptionListener implements ExceptionListener {

		@Override
		public void onException(String proprtyName, Object source, Exception exception) {
			if(source instanceof Employee) {
				Employee e = (Employee)source;
				System.out.println(proprtyName+" : "+e+" : "+exception);
			}
			
		}
	}

}
