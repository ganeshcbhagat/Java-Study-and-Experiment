package main;

public interface SingletoneExample {

	public static final SingletoneExample INSTANCE = new SingletoneExampleImpl();
	
	public abstract SingletoneExample getInstance();
	public abstract String getConnectionString();
	public abstract void setConnectionString(String str);
	
	public final class SingletoneExampleImpl implements SingletoneExample {
		
		private String str;
		
		private SingletoneExampleImpl() {
		}
		
		public SingletoneExample getInstance() {
			return this;
		}

		@Override
		public String getConnectionString() {
			return this.str;
		}

		@Override
		public void setConnectionString(String str) {
			this.str = str;
		}
		
		private void test(String str) {
			this.str = str;
		}
		
		
	}
	
}
