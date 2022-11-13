import java.util.Arrays;

public class ArrayUtils {


	public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
		// TODO
		
		if(array.length == 0) {
			return array;
		}	
		int moveRes = Math.abs(move) % array.length;

		if ( move % array.length == 0) {
			return array;
		}
		
		if (moveRes >= array.length/2) {
			moveRes = array.length - moveRes;
			
			if (direction == 'R') {
				direction = 'L';
			}
			else {
				direction = 'R';
			}
		}
		if (move < 0) {
			if (direction == 'R') {
					direction = 'L';
			}
			else {
					direction = 'R';
				}
			}
		shift(array,moveRes,direction);
		return array; //Replace this with the correct returned value
	}

	private static int[] shift(int[] array, int moveRes,char direction) {
		
		int[] newArr = new int[array.length];
	
		if(direction == 'L') {		
			for(int i=0; i< newArr.length; i++) {
				newArr[i] = array[(i+moveRes) % newArr.length];
			}
		}
		else {
			for(int i=0; i< newArr.length; i++) {
				newArr[(i+moveRes) % newArr.length] = array[i];	
			}
		}
		for(int j=0; j < array.length; j++) {
			array[j] = newArr[j];
		}
		return array;
	}
	

	public static int findShortestPath(int[][] m, int i, int j) {
		
		// TODO
		boolean[] visited = new boolean[m.length];
		visited[i] = true;
		if(i == j) {
			return 0;
		}
		int shortest = findShortestRec(m, i, j,visited);
		if(shortest == Math.pow(m.length,2) + 1) {
			return -1;
		}
		return shortest;
	}
		
	private static int findShortestRec(int[][]m, int i, int j,boolean[]visited) {	
		
		
		int[] pathLengthArr = new int[m.length];
		boolean[] visitedInThisPath = Arrays.copyOf(visited, visited.length);
		
		visitedInThisPath[i] = true;
		
		for(int r = 0; r < pathLengthArr.length; r++) {
			pathLengthArr[r] = (int) Math.pow(m.length,2) + 1;
			
		}
		if (i == j && m[i][j] == 1) {
			return 0;
		}
		if ( m[i][j] == 1 && visitedInThisPath[j]==false) {
			return 1;
		}
		for(int v = 0; v < m.length; v++) {
			if(m[i][v]==1 && visited[v]==false) {
				pathLengthArr[v] = findShortestRec(m,v,j,visitedInThisPath)+1;	
			}	
		}
		return arrayMin(pathLengthArr);
	}
	
	private static int arrayMin(int[] array) {
		int min = array[0];
		
		for(int num:array) {
			if(num < min) {
				min = num;
			}
		}
		return min;
	} 
		
	}
	
			
		
