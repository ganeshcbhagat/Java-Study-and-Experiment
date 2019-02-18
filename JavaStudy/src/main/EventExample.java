package main;

import java.util.EventObject;
import java.util.Vector;
import java.util.EventListener;

public class EventExample {

	public static void main(String[] args) {

		Source source = new Source();
		//source.addListener(new Gui());
		source.addListener(new Network());
		source.send();
		System.out.println("-----------");
		source.receive();
		
	}

	private static abstract class Event extends EventObject {
		public Event(Object source) {
			super(source);
		}
		
		abstract void preEvent();
		abstract void actionperformed();
		abstract void postEvent();
		
	}
	
	private static class EmailSent extends Event {
		public EmailSent(Object source) {
			super(source);
		}

		@Override
		void preEvent() {
			System.out.println("preEvent in EmailSent");
		}

		@Override
		void actionperformed() {
			System.out.println("actionperformed in EmailSent");
		}

		@Override
		void postEvent() {
			System.out.println("postEvent in EmailSent");
		}
	}
	
	private static class EmailReceive extends Event {
		public EmailReceive(Object source) {
			super(source);
		}

		@Override
		void preEvent() {
			System.out.println("preEvent in EmailReceive");
		}

		@Override
		void actionperformed() {
			System.out.println("actionperformed in EmailReceive");
		}

		@Override
		void postEvent() {
			System.out.println("postEvent in EmailReceive");
		}
	}

	private static interface Listener extends EventListener  {
		public void eventOccurred(Event evt);
	}
	
	private static class Gui implements Listener {
		
		@Override
		public void eventOccurred(Event evt) {
			updateGui(evt);
		}
		
		public void updateGui(Event evt) {
			System.out.println("Updating GUI");
			evt.preEvent();
			evt.actionperformed();
			evt.postEvent();
		}
	}
	
	private static class Network implements Listener {
		
		@Override
		public void eventOccurred(Event evt) {
			updateGui(evt);
		}
		
		public void updateGui(Event evt) {
			System.out.println("Network Connection");
			evt.preEvent();
			evt.actionperformed();
			evt.postEvent();
		}
	}
	
	private static class Source  {
		
		private Vector<Listener> listenerList = new Vector<Listener>();
		
		public boolean addListener(Listener listener) {
			if(listener==null) return false;
			if(listenerList.contains(listener)) return true;
			return listenerList.add(listener);
		}
		
		public boolean removeListener(Listener listener) {
			return listenerList.remove(listener);
		}
		
		public void send() {
			System.out.println("Sending an email");
			fireEvent(new EmailSent(this));
		}
		
		public void receive() {
			System.out.println("Receive an email");
			fireEvent(new EmailReceive(this));
		}
		
		private void fireEvent (Event evt) {
			for(Listener listener : listenerList) {
				listener.eventOccurred(evt);
			}
		}
	}
	
}
