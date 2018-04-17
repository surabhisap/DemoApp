public class MyFamilyTree {
	Person root;

	// Constructor / Initialize tree
	public MyFamilyTree() {
		root = null;
	}

	/* --------------------------------------------------------------
	 This method inserts a new family member into the tree.
	 It takes two parameters - the parent who the new node should
	 be inserted under, and the name of the new member being added.
	 -------------------------------------------------------------- */

	public void insertPerson(String parentName, String personName) {
		Person parent, current;
		Person newMember = new Person(personName);

		// If tree is empty, then the new member becomes the root
		if (root == null)
			root = newMember;

		// Sibling is added to the root's right child
		else if (parentName == "") {
			// Check if root's sibling is empty
			if (root.rightChild == null)
				root.rightChild = newMember;

			// Traverse root's siblings until end, then insert at end
			else {
				current = root;

				while (current.rightChild != null)
					current = current.rightChild;

				current.rightChild = newMember;
			}
		}

		else {
			// Find the parent where we will insert under
			parent = findNode(parentName, root);

			//System.out.println("parent is = " + parent);
			//System.out.println("newMember is = " + newMember + "\n");

			// If that parent doesn't exist, print error message
			if (parent == null)
				System.out.println("Parent doesn't exist");

			// If parent does exist, but has no left child,
			// then the new member becomes left child
			else if (parent.leftChild == null)
				parent.leftChild = newMember;

			// If parent already has a left child, then traverse
			// to the end of it's left children and insert node
			else {
				current = parent.leftChild;

				while (current.rightChild != null)
					current = current.rightChild;

				current.rightChild = newMember;
			}
		}
	}

	/* ------------------------------------------------------------
	 This method recursively finds a node in the family tree,
	 given the name of the node to look for, and the tree.
	 It is run pre-order, and, if found, returns the node
	 ------------------------------------------------------------ */

	public Person findNode(String name, Person localTree) {
		Person current = localTree;

		// Visit the node
		if (current.name.equals(name))
			return current;

		// Pre-order - go left
		if (current.leftChild != null) {
			//System.out.println(name + " is child of " + current.leftChild);
			Person nodeFound = findNode(name, current.leftChild);
			if (nodeFound != null) {
				// return node is found
				return nodeFound;
			}
		}

		// Pre-order - go right
		if (current.rightChild != null) {
			//System.out.println(name + " is sibling of " + current.rightChild);
			return findNode(name, current.rightChild);
		}

		return null;
	}

	/* ------------------------------------------------------------
	 This method prints the family tree, given a parent name
	 and a tree to print from. It will attempt to find the parent
	 node with the given name, then print the entire tree
	 (all children and grand children) from that point.
	 ------------------------------------------------------------ */

	public void printTree(String personName, Person localTree) {
		Person parent, current;

		// Find the parent to start printing from
		parent = findNode(personName, root);
		//System.out.println(personName);

		// If parent doesn't exist, print error message
		if (parent == null)
			System.out.println(personName + " doesn't exist.");

		else {
			current = localTree;

			System.out.println(current);

			if (current.leftChild != null)
				printTree(personName, current.leftChild);

			 if (current.rightChild != null)
				printTree(personName, current.rightChild);
		}

	}
}