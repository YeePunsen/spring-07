package Singleton;



public class Recycle2 {
	//¿¡∫∫ Ω
	private static Recycle2 recycle;
	private static Object block = new Object();
	private Recycle2() {
		
	}
	
	public static Recycle2 getInstance() {
		
		if(recycle==null) {
			synchronized (block) {
				if(recycle==null) {
					Recycle2 recycle = new Recycle2();
				}
			}
		}
		
		
		return recycle;
	}

	private static void Synchronized(Object block2) {
		// TODO Auto-generated method stub
		
	}
}
