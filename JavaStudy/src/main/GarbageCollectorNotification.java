package main;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;

import com.sun.management.GarbageCollectionNotificationInfo;

public class GarbageCollectorNotification {
	
	private boolean stop;
	
	public static void main(String[] args) {
		System.out.println("Start");

		GarbageCollectorNotification source = new GarbageCollectorNotification();
		
	    for (GarbageCollectorMXBean gcBean : ManagementFactory.getGarbageCollectorMXBeans()) {
	    	System.out.println("Register GC :"+gcBean.getName());
	        NotificationEmitter emitter = (NotificationEmitter) gcBean;
	        emitter.addNotificationListener(new MyNotificationListener() , new MyNotificationFilter(source), "My Hand Back Object");
	    }
	    
	    source.runBadMethod();
	    
	    System.out.println("End");
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public boolean isStop() {
		return stop;
	}
	
	public void runBadMethod() {
		System.out.println("Bad method running");
		ArrayList<String> list = new ArrayList<String>();
		try { Thread.sleep(1000); } catch (InterruptedException e1) { }
		
		while(!isStop()) {
			try { Thread.sleep(10); } catch (InterruptedException e1) { }
	    	list.add(new String("Item "+Math.random()*100));
	    }
		System.out.println("Bad method Stop");
	}
	
	private static class MyNotificationFilter implements NotificationFilter {
		private static final long serialVersionUID = -3317102473228880417L;
		private Object object;
		
		public MyNotificationFilter(Object object) {
			this.object=object;
		}
		
		@Override
		public boolean isNotificationEnabled(Notification notification) {
			
			//Set source of notification 
			notification.setSource(object);
			
			//Filter  the type only of garbage collection
			if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
				return true;	
			} else {
				return false;
			}
		}
	}
	
	private static class MyNotificationListener implements NotificationListener {
        @Override
        public void handleNotification(Notification notification, Object handback) {
            GarbageCollectionNotificationInfo gcNotInfo = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());
            System.out.println("Garbage collection start: "+ handback+" : "+notification.getSource()+" : "+gcNotInfo.getGcName()+" : "+gcNotInfo.getGcAction()+" : "+gcNotInfo.getGcCause());
            if(notification.getSource() instanceof GarbageCollectorNotification) {
            	System.out.println("Stop running");
            	GarbageCollectorNotification source = (GarbageCollectorNotification) notification.getSource();
            	source.setStop(true);
            }
        }
    }
}
