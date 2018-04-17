import java.util.Scanner;

public class FamilyTreeDriver {
	public static void main(String[] args) {
		/*MyFamilyTree myTree = new MyFamilyTree();

		myTree.insertPerson("", "Grandma Marx");
		myTree.insertPerson("", "Great-Aunt Peggie");
		myTree.insertPerson("", "Great-Aunt Katherine");
		myTree.insertPerson("Grandma Marx", "Aunt Sarah");
		myTree.insertPerson("Grandma Marx", "Aunt Tory");
		myTree.insertPerson("Grandma Marx", "Uncle Frank");
		myTree.insertPerson("Grandma Marx", "Uncle Charles");
		myTree.insertPerson("Grandma Marx", "Mom");

		myTree.insertPerson("Aunt Sarah", "Morgan");
		myTree.insertPerson("Aunt Sarah", "Tommy");
		myTree.insertPerson("Aunt Sarah", "Austin");
		myTree.insertPerson("Aunt Sarah", "Luke");

		myTree.insertPerson("Aunt Tory", "Tim");

		myTree.insertPerson("Mom", "Barret");
		myTree.insertPerson("Mom", "Jeremy");
		myTree.insertPerson("Mom", "Elliot");*/
		
		MyFamilyTree myTree = new MyFamilyTree();

		myTree.insertPerson("", "Grandma Marx");
		myTree.insertPerson("", "Great-Aunt Peggie");
		myTree.insertPerson("", "Great-Aunt Katherine");
		myTree.insertPerson("Grandma Marx", "Aunt Sarah");
		myTree.insertPerson("Grandma Marx", "Aunt Tory");
		myTree.insertPerson("Grandma Marx", "Uncle Frank");
		myTree.insertPerson("Grandma Marx", "Uncle Charles");
		myTree.insertPerson("Grandma Marx", "Mom");

		myTree.insertPerson("Aunt Sarah", "Morgan");
		myTree.insertPerson("Aunt Sarah", "Tommy");
		myTree.insertPerson("Aunt Sarah", "Austin");
		myTree.insertPerson("Aunt Sarah", "Luke");

		myTree.insertPerson("Aunt Tory", "Tim");

		myTree.insertPerson("Mom", "Barret");
		myTree.insertPerson("Mom", "Jeremy");
		myTree.insertPerson("Mom", "Elliot");
		
		myTree.printTree("Grandma Marx", myTree.findNode("Grandma Marx",
	    myTree.root));
	}
	
	// method to to test sorting algorithms
	private static void addPerson(Scanner sc) {
		
		System.out.println(""); // to print a empty line in output
		String userInput = "";
		
		do {
			
			System.out.print("Enter the name of person to be added ");
			String personName = sc.nextLine();
			
			System.out.print("Enter parent name or leave empty if root ");
			String parentName = sc.nextLine(); 
			
			MyFamilyTree myTree = new MyFamilyTree();
			myTree.insertPerson(parentName, personName);
			
			System.out.println(""); 
			System.out.print("Press 1 to continue adding person or 2 to print family tree");
			userInput = sc.nextLine();
			
			if(userInput.equalsIgnoreCase("2")) {
				myTree.printTree(personName, myTree.findNode(personName, myTree.root));
			}
			
		} while (userInput.equalsIgnoreCase("1"));
		
	}
}