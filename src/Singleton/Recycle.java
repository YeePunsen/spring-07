package Singleton;

public class Recycle {
	//����ʽ
	private static Recycle recycle = new Recycle();
	private Recycle() {
		
	}//���췽���ȱ�private����ֹ���ù��췽��
	
	public static Recycle getInstance() {
		return recycle;
	}
}
