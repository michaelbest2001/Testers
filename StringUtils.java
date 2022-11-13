
public class StringUtils {

	public static String findSortedSequence(String str) {
		// TODO
		String[] stringArr = str.split(" ");
		int maxSequenceLen = 0;
		String maxSequence = "";
		
		for(int i=0; i < stringArr.length; i++) {
			String sequence = stringArr[i];
			int sequenceLen = 0;
			
			for(int j=i; j < stringArr.length-1; j++) {
		
				if (stringArr[j].compareTo(stringArr[j+1]) <= 0) {
					sequence += " " + stringArr[j+1];
					sequenceLen++;
				}
				else {
					break;
				}
			}
			if (sequenceLen >= maxSequenceLen) {
				maxSequenceLen = sequenceLen;
				maxSequence = sequence;
			}
			
		}
		return maxSequence; //Replace this with the correct returned value

	}

	
	public static boolean isEditDistanceOne(String a, String b){
		// TODO
		if(a.equals(b)) {
			return true;
		}
		if(a.length() == b.length()) {
			return oneSwitch(a, b);
		}
		if(a.length() == b.length() - 1) {
			return oneInsertion(a, b);	
		}
		if(b.length() == a.length() - 1) {
			return oneInsertion(b, a);	
		}
		return false; //Replace this with the correct returned value
		}	
	
	private static boolean oneSwitch(String fir, String sec) {
		
		if(fir.length()!=sec.length()) {
			return false;
		}
		int numChanges = 0;
		for(int i=0; i<fir.length(); i++) {
			if (fir.charAt(i) != sec.charAt(i)) {
				numChanges++;
			}
		}
		return numChanges <= 1;
	}
	private static boolean oneInsertion(String fir, String sec) {
		
		if(fir.length() != sec.length() - 1) {
			return false;
		}
		boolean insertion = false;
		int i = 0;
		int j = 0;
		
		while(i < fir.length()) {
			if (fir.charAt(i) == fir.charAt(j)) {
				i++;
				j++;
			}
			else {
				if (fir.charAt(i) == fir.charAt(j+1) && !insertion) {
					j++;
					insertion = true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
}
