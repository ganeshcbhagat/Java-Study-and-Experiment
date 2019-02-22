package main.study.staticSingleton;

public class ReportRepository implements Repository {

	@Override
	public void print() {
		System.out.println("ReportRepository : print"+ System.identityHashCode(this));
	}

}
