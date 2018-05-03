package others;

public class MethodParameters {
	private int par;
	
	private MethodParameters(int val) {
		this.par=val;
	}
	
	private void triple(int num) {
		num = 3 * num;
	}
	
	private void triple(Integer num) {
		num = 3 * num;
	}
	
	private void triple2() {
		par = 3 * par;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodParameters test1=new MethodParameters(1);
		int num = 1;
		test1.triple(num);
		System.out.println(num);
		Integer onum = 1;
		test1.triple(onum);
		System.out.println(onum);
		test1.triple2();
		System.out.println(test1.par);
	}

}
