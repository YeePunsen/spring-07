package Singleton;

public class Recycle {
	//饿汉式
	private static Recycle recycle = new Recycle();
	private Recycle() {
		
	}//构造方法先变private，禁止调用构造方法
	
	public static Recycle getInstance() {
		return recycle;
	}
}
