package main.study.staticSingleton;

public class NullRepository implements Repository {

	@Override
	public void print() {
		System.out.println("NullRepository : print"+ System.identityHashCode(this));
	}

}
