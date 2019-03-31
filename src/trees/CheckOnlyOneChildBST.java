package trees;

/*
Algo behind the question is when the node has only one left or right child then
it should have the children should be either smaller or greater.
We can do this question two ways
1) Standing at a node check if all the elements are smaller or greater from it.
2) Other approach to find the next and last preOrder successor. If both are smaller of greater return true.

---- >>> Things to take <<< ---
last preorder successor (last element in pre[]) of the node.
ast preorder successor (last element in pre[]) of the node.
---- >>> Things to take <<< ---

 */
public class CheckOnlyOneChildBST {

	public boolean approach1(int[] a){
		if(a == null) return true;

		int n = a.length;
		for(int i=0;i<n-1; i++) {
			boolean smaller = a[i] < a[i+1] ? true : false;
			for(int j=i+1;j<n;j++) {
				boolean inner = a[i] < a[j] ? true : false;
				if(smaller != inner)
					return false;
			}
		}
		return true;
	}

	public boolean approach2(int[] a) {
		if(a == null) return true;
		int n = a.length;
		int nextDiff = 0, prevDiff = 0;
		for(int i=0;i<n-1;i++) {
			nextDiff = a[i] - a[i+1];
			prevDiff = a[i] - a[n-1];
			if(nextDiff * prevDiff < 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		CheckOnlyOneChildBST checkOnlyOneChildBST = new CheckOnlyOneChildBST();
		int pre[] = new int[]{20, 30, 11, 13, 12};
		if (checkOnlyOneChildBST.approach2(pre) == true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
