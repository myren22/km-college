import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class HashFinder {

	// as with encryption, we create and initialize an object
	// that will execute the hash function
	public static MessageDigest md;

	// Truncated versions of hash; just take first few bytes of SHA-1
	// use strings instead of byte arrays as input and output
	// requires java.util.Arrays
	public static String H5(String msg) {
		return byteArrayToHex(Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 5));
		// 6 chars
	}

	public static String H6(String msg) {
		return byteArrayToHex(Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 6));
		// 8 chars
	}

	public static String H7(String msg) {
		return byteArrayToHex(Arrays.copyOfRange(md.digest(msg.getBytes()), 0, 7));//
		// 10 chars
	}

	// for displaying byte arrays
	public static String byteArrayToHex(byte[] array) {
		String s = new String();
		for (int i = 0; i < array.length; i++)
			s = s + String.format("%1$02X", array[i]);
		return s;
	}

	public static void main(String[] args) {
		long startTime   = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		long totalTime;
		// SHA-1 is one of the most widely used hash functions
		// as with cipher object, only call getInstance once
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
//		System.out.println(java.lang.Runtime.getRuntime().maxMemory());
//		Scanner scanner = new Scanner(System.in);
//		// String input = scanner.nextLine();
//		scanner.close();
		// Hashing
		// make hashtable
		// continually add to table messages and their hashs
		// if a new hash == any hash in table return both messages and their
		// hash

		// Mapping
		HashMap<String, String> hash1	= new HashMap<String, String>();
		String bobBuys= "bob buys 1 rubber ducky";
		//byteArrayToHex(md.digest(bobBuys.getBytes())
		hash1.put(H6(bobBuys),"bob buys 1 rubber ducky");
//		long i = 36000000;
		long i = 0;
		String testString = "bob buys "+i+" rubber duckies";
		String testStringHash = H6(testString);	


		while(	
			!hash1.containsKey(testStringHash) 
			)
		{
			if(i%1000000 == 0){
				System.out.println("Hash Size:"+testStringHash.length()/2+",Current Msg : " + testString);
				long elapsedTime = System.currentTimeMillis() - endTime;
				System.out.println("Elapsed time : " + elapsedTime);
				endTime = System.currentTimeMillis() - startTime;
				System.out.println("Total time : " +  endTime);
				endTime = endTime + startTime;		
			}
//			if(i<48000000){
//				hash1.put((testStringHash),testString);
//			}	
			if(i<10000000){
				hash1.put((testStringHash),testString);
			}
			i++;
			testString = "Jim buasdfys "+i+" rubber duckies";
			//testString = "bob buys "+i+" rubber duckies";
			testStringHash = H5(testString);
		}
		System.out.println("Collision between Msg1:" + testString);
		System.out.println("Short hash of is: " + testStringHash);
		System.out.println("Full Hash1: "+ byteArrayToHex((md.digest(testString.getBytes()))));
		System.out.println("...and Msg2:'" + hash1.get(testStringHash)+"'");
		System.out.println("Full Hash2: "+ byteArrayToHex((md.digest(hash1.get(testStringHash).getBytes()))));
		System.out.println("Byte Size: "+ testStringHash.length()/2);
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("TotalTime: " + totalTime);

		
		

	}

}
