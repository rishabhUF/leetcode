package trees;


/*
We take index as a iterator for given sorted sub-sequence and
start inorder traversal of given bst, if current node matches with seq[index] then
move index in forward direction by incrementing 1 and after complete traversal
of BST if index==n that means all elements of given sub-sequence have been matched and
exist as a sorted sub-sequence in given BST.
 */
public class CheckIfSortedSequencePartOfBST {

	boolean checkIfSortedSequence(TreeNode root, int[] arr, Index index) {
		if(root == null)
			return false;
		if(arr == null)
			return false;
		boolean left = checkIfSortedSequence(root.left, arr, index);
		if(root.val == arr[index.index]) {
			index.index++;
			if(index.index == arr.length) {
				return true;
			}
		}
		boolean right = checkIfSortedSequence(root.right, arr,index);
		return right || left;
	}

	public static void main(String[] args) {
		CheckIfSortedSequencePartOfBST checkIfSortedSequencePartOfBST = new CheckIfSortedSequencePartOfBST();
		TreeNode root = null;
//		root = insert(root, 8);
//		root = insert(root, 10);
//		root = insert(root, 3);
//		root = insert(root, 6);
//		root = insert(root, 1);
//		root = insert(root, 4);
//		root = insert(root, 7);
//		root = insert(root, 14);
//		root = insert(root, 13);

		int seq[] = {4, 6, 8, 12, 13};
		int n = seq.length;
		Index i = new Index();
		if(checkIfSortedSequencePartOfBST.checkIfSortedSequence(root, seq, i))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
