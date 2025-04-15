// java concept check for default vales.
class A
{
	String a="Satyam";

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
}
public class TestDefault {
	public static void main(String[] args) {
		A ab= new A();
		System.out.println(ab.getA());
		int arr[][]=new int[4][5];
		System.out.println("row=>"+arr.length);
		System.out.println("col=>"+arr[0].length);
	}
}
