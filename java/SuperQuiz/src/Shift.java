
public class Shift {
	public static void shiftRight(int[] array){
		//check size of array
		//if null or 1 leave alone
		if(array.length<2){
			return;
		}
		
		//
		int originalLast = array[array.length-1];
		for(int i=array.length-1; i>0; i--){
			array[i]=array[i-1];
		}
		array[0] = originalLast;
	}
}
