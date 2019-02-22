package main.study.staticSingleton;

public class Factory {

	private static volatile Factory INSTANCE = new Factory();
	
	/*private Factory() {
		
	}*/
	
	public static Factory getInstance() {
		if(INSTANCE==null) {
			synchronized (Factory.class) {
				if(INSTANCE==null) {
					INSTANCE = new Factory();
				}
			}
		}
		return INSTANCE;
	}
	
	public enum RepositoryType {
		REPORT, DATABASE
	}
	
	public static Repository getRepository(RepositoryType repositoryType) {
		switch(repositoryType) {
			case REPORT: return new ReportRepository();
			case DATABASE: return new DBRepository();
			default : return new NullRepository();
		}
	}

}
