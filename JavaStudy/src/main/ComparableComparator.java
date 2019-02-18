package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparableComparator {

	public static void main(String[] args) {
		
		Set<Employee> employeeListObj = new HashSet<Employee>();
		employeeListObj.add(new Employee(3,"Three"));
		employeeListObj.add(new Employee(1,"One"));
		employeeListObj.add(new Employee(5,"Five"));
		employeeListObj.add(new Employee(4,"Four"));
		employeeListObj.add(new Employee(2,"Two"));
		employeeListObj.add(new Employee(2,"Two")); // to make uniqueness in HashSet you need to override the hashCode and equal method
		
		//employeeListObj.add(null);
		
		System.out.println(employeeListObj);
		
		Set <Employee> employeeSetObj = new TreeSet<Employee>(employeeListObj);
		//Collections.sort(employeeSetObj);
		System.out.println(employeeSetObj);
		/*Collections.sort(employeeListObj, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return (e1.id<e2.id ? -1 : e1.id>e2.id ? 1 : 0);
			}});
		System.out.println(employeeListObj);*/
	}

	static class Employee implements Comparable<Employee>
	{
		int id;
		String name;
		
		public Employee(int id,String name) {
			this.id=id;
			this.name=name;
		}
		
		@Override
		public String toString() {
			return id+":"+name;
		}

	/*	@Override
		public int hashCode() {
			return name.hashCode()*id;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj==null) return false;
			Employee e = (Employee) obj;
			return (this.name.equals(e.name)) && (this.id==e.id?true:false) ;
		}*/
		
		@Override
		public int compareTo(Employee employee) {
			return (this.id<employee.id ? -1 : this.id>employee.id ? 1 : 0);
		}
	}
}
