package Singleton;

public class Test {

	public static void main(String[] args) {
		Recycle recycle1 = Recycle.getInstance();
		Recycle recycle2 = Recycle.getInstance();
	
		System.out.println(recycle1==recycle2);
		
		Recycle2 recycle3 = Recycle2.getInstance();
		Recycle2 recycle4 = Recycle2.getInstance();
	
		System.out.println(recycle3==recycle4);
	}

}
