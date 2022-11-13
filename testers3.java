import java.util.Arrays;
public class testers3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int move = Integer.parseInt(args[0]);
		char direction = args[1].charAt(0);
		int i = Integer.parseInt(args[2]);
		int j = Integer.parseInt(args[3]);
		String sentence = args[4];
		String a = args[5];
		String b = args[6];
		
		int [] arr= {1,2,3,4,5,6,7,8,9,10};
		int[][] graph = {{1, 1, 0, 0,1,0,1}, {0, 0, 1, 0,0,0,0}, {0, 0, 0, 1,0,0,0}, {0, 0, 0, 0,1,0,0},{1, 0, 0, 0,0,0,0},{0, 0, 0, 1,0,0,1},{0, 0, 0, 0,0,1,0}};
		
		System.out.println(Arrays.toString(ArrayUtils.shiftArrayCyclic(arr,move,direction)));
		System.out.println(ArrayUtils.findShortestPath(graph,i,j));
		System.out.println(StringUtils.findSortedSequence(sentence));
		System.out.println(StringUtils.isEditDistanceOne(a,b));
	}

}
