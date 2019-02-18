package main;

import java.util.Iterator;  
import java.util.TreeSet;

import java.util.Comparator;

public class TreeSetDemo {  
  
    public static void main(String[] args) {  
  
        //TreeSet<Cricketer> playerSet = new TreeSet<Cricketer>(new CompareCricketer());
        TreeSet<Cricketer> playerSet = new TreeSet<Cricketer>();
        playerSet.add(new Cricketer("Sachin", 1));
        playerSet.add(new Cricketer("Virat", 3));
        playerSet.add(new Cricketer("Raina", 6));
        playerSet.add(new Cricketer("Sachin 12", 1));
        
        Iterator<Cricketer> it = playerSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
 
  //--------------------------------------
//static class Cricketer {
	static class Cricketer implements Comparable<Cricketer> {
  
    private String name;  
    private int battingPosition;  
  
    Cricketer(String cricketerName, int cBattingPosition){  
        this.name = cricketerName;  
        this.battingPosition = cBattingPosition;  
    }  
  
    public String getName() {  
          return name;  
    }  

    public int getBattingPosition() {  
          return battingPosition;  
    }
    
	@Override
	public String toString() {
		return name+" : "+battingPosition;
	}

	@Override
	public int hashCode() {
		//return battingPosition;
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		Cricketer c1 = (Cricketer)object;
		/*if(c1.getBattingPosition() > this.getBattingPosition())
            return false;
        else if (c1.getBattingPosition() < this.getBattingPosition())
            return false;
        else return true;*/
		
		return c1.getName().equals(this.getName());
	}
	
	@Override
	public int compareTo(Cricketer c1) {
		/*if(c1.getBattingPosition() > this.getBattingPosition())
            return -1;
        else if (c1.getBattingPosition() < this.getBattingPosition())
            return 1;
        else return 0;*/
		
		//return (c1==null) ? -1 : c1.getName().equals(this.getName()) ? 0 : 1;
		return c1.getName().compareTo(this.getName());
	}
  
}

//-----------------------------------------------

static class CompareCricketer implements Comparator <Cricketer> {
    @Override
    public int compare(Cricketer arg0, Cricketer arg1) {
        if(arg0.getBattingPosition() > arg1.getBattingPosition())
            return 1;
        else if (arg0.getBattingPosition() < arg1.getBattingPosition())
            return -1;
        else return 0;
    }
}
}
