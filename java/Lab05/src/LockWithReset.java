import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LockWithReset extends Lock {
	public static void main(String[] args) {
		Combination c = new Combination(1, 2, 3);
		LockWithReset lock = new LockWithReset(5, c);

		 lock.resetNaive();
		//lock.resetRetry();
	}

	public LockWithReset(int upperLimit, Combination combo) {
		super(upperLimit, combo);

	}

	public void resetNaive() {
		boolean ok = true;
		while (ok) {
			String s = JOptionPane.showInputDialog(null,
					"Type a new combination");
			if (s == null) {
				break;
			}
			Scanner sc = new Scanner(s);
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			sc.close();
			Combination testComb = new Combination(n1, n2, n3);
			if(!testComb.isWithinRange(upperLimit)){
				throw new InvalidLockCombinationException();
			}				
			super.theCombo = new Combination(n1, n2, n3);

			ok = false;
		}
	}

	public void resetRetry() {
//		boolean ok = true;
//		while (ok) {
//			String s = JOptionPane.showInputDialog(null,
//					"Type a new combination");
//			Scanner sc = new Scanner(s);
//			ArrayList<Integer> numbers = new ArrayList<Integer>();
//			while (sc.hasNextInt()) {
//				numbers.add(sc.nextInt());
//			}
//			if (numbers.size() < 3) {
//				JOptionPane.showMessageDialog(null,
//						"Type 3 integers separated by space");
//				ok = false;
//			}
//			for(int i=0;i<3;i++){
//				
//			}
//		}

		 boolean ok = true;
		 while(ok)
		 {
			 String s =JOptionPane.showInputDialog(null,
					 "Type a new combination");
			 Scanner sc = new Scanner(s);
			 try{
				 int n1 = sc.nextInt();
				 int n2 = sc.nextInt();
				 int n3 = sc.nextInt();
				 Combination testComb = new Combination(n1, n2, n3);
					if(!testComb.isWithinRange(upperLimit)){
						throw new InvalidLockCombinationException();
					}				
				super.theCombo = new Combination(n1, n2, n3);
				 
				ok=false;		
			 }
			 catch(NoSuchElementException e){
				 JOptionPane.showMessageDialog(null,
				 "Type 3 integers separated by spaces");
			 }
			 catch(InvalidLockCombinationException e){
				 JOptionPane.showMessageDialog(null,
				 "Type 3 integers in the range[0.."+this.getDialLimit()+"]");
			 }
			 catch(Exception e){
			 if(s == null){
			 break;
			 }		 
		 }
		 sc.close();
		 }

		// scanner scan
		// scan next int

		// display input dialog
		// process input for new combo
		// check if user terminates. end if this happens.
		// use scanner to read 3 ints and create new combo
		// throw NoSuchElementException if entry is not 3 numbers.
		// "Type 3 integers separated by spaces")
		// fail if invalid combo. InvalidLockCombinationException.
	}

}
