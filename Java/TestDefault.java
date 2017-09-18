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
	}
}
