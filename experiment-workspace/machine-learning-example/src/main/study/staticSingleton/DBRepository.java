package main.study.staticSingleton;

public class DBRepository implements Repository {

	@Override
	public void print() {
		System.out.println("DBRepository : print"+ System.identityHashCode(this));
	}

}
