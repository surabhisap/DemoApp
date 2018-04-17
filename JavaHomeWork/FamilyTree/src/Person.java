
public class Person {

	Person leftChild, rightChild;
	String name;

	public Person(String personName) {
		leftChild = null;
		rightChild = null;
		name = personName;
	}

	public String toString() {
		return name;
	}

}

