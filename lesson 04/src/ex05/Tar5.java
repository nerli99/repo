package ex05;

public class Tar5 {

	public static void main(String[] args) {
		int a = (int) (Math.random() * 101);
		int b = (int) (Math.random() * 101);
		int c = (int) (Math.random() * 101);

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);

		if (a > b) {
			if (a > c) {
				System.out.println(a);
			} else {
				System.out.println(c);
			}
		}else {
			if(b > c) {
				System.out.println(b);
			}else {
				System.out.println(c);
			}
		}
	}

}
