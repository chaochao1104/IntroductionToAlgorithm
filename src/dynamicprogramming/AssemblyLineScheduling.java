package dynamicprogramming;

//15.1 Assembly-line scheduling
public class AssemblyLineScheduling {
	
	private static final int[] a1 = new int[] {
		7, 9, 3, 4, 8, 4
	};
	
	private static final int[] a2 = new int[] {
		8, 5, 6, 4, 5, 7
	};
	
	private static final int[] t1 = new int[] {
		2, 3, 1, 3, 4
	};

	private static final int[] t2 = new int[] {
		2, 1, 2, 2, 1
	};
	
	private static final int e1 = 2;
	
	private static final int e2 = 4;
	
	private static final int x1 = 3;
	
	private static final int x2 = 2;
	
	public static void fastestWay(int[] a1, int[] a2, int[] t1, int[] t2, int e1, int e2, int x1, int x2) {
		int[] l1 = new int[a1.length];
		int[] l2 = new int[a1.length];
		int[] f1 = new int[a1.length];
		int[] f2 = new int[a2.length];
		
		f1[0] = e1 + a1[0];
		f2[0] = e2 + a2[0];
		for (int i = 1; i < a1.length; i++) {
			if (f1[i - 1] < f2[i - 1] + t2[i - 1]){
				f1[i] = f1[i - 1] + a1[i];
				l1[i] = 1;
			} else {
				f1[i] = f2[i - 1] + t2[i - 1] + a1[i];
				l1[i] = 2;
			}
			
			if (f2[i - 1] < f1[i - 1] + t1[i - 1]) {
				f2[i] = f2[i - 1] + a2[i];
				l2[i] = 2;
			} else {
				f2[i] = f1[i - 1] + t1[i - 1] + a2[i];
				l2[i] = 1;
			}
		}
		
		System.out.print("f1:");
		prtInts(f1);
		System.out.print("f2:");
		prtInts(f2);
		System.out.println("----------------------");
		
		System.out.print("l1:");
		prtInts(l1);
		System.out.print("l2:");
		prtInts(l2);
	}
	
	private static void prtInts(int[] ints) {
		for (int i : ints)
			System.out.print(i + "| ");
		System.out.println();
	}
	
	public static void main(String... args) {
		fastestWay(a1, a2, t1, t2, e1, e2, x1, x2);
	}
}

