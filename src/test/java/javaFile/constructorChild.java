package javaFile;

public class constructorChild extends constructorBase{
	public constructorChild() {
		System.out.println("Child without parameter");
	}
	public constructorChild(int a) {
		System.out.println("Child with parameter");
	}
	public void main(String[] args) {
		constructorChild ch=new constructorChild();
		System.out.println(ch);
	}

}
