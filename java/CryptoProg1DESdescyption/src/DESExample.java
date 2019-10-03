/*
 * import java crypto libraries
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class DESExample 
{

	/*
	 * Print out a byte array in hex format
	 */
	public static void printByteArray(byte [] array)
	{
		System.out.print("[");
		for(int i = 0; i < array.length-1; i++)
		{
			System.out.print(String.format("%1$02X", array[i]) + ", ");
		}
		System.out.print(String.format("%1$02X", array[array.length-1]) + "]\n");
	}


	public static void main(String[] args) 
	{
		// Create cipher and key objects
		Cipher cipher;
		SecretKeySpec key;

		//key, plaintext, and ciphertext as byte arrays
		byte [] keyBytes;
		byte [] pt;
		byte [] ct;

		// Set up the key bytes (64 bits --> 8 bytes)
		// Note that DES only uses a 56 bit key;
		//low bit of each byte is ignored, so 0x00 gives same result as 0x01 etc
		keyBytes = new byte[] 
				{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };

		// The plaintext block (also, 64 bits --> 8 bytes)...
		String ptString = new String("ABCDEFGH");
		//get ascii byte array from string
		pt = ptString.getBytes();		
		System.out.println("plaintext: "+ptString);
		// Set up the key so it can be used in the algorithm
		key = new SecretKeySpec(keyBytes, "DES");

		//wrap encryption in a try block since many exceptions could be thrown
		try
		{
			// Create the actual DES cipher, in Electronic Code Book mode, with no padding
			cipher = Cipher.getInstance("DES/ECB/NoPadding");

			// Initialize the cipher with the key and set it up for encryption
			cipher.init(Cipher.ENCRYPT_MODE, key);

			// Encrypt the plaintext
			ct = cipher.doFinal(pt);

			// Display the ciphertext
			System.out.println("Key Bytes in Hex:");
			printByteArray(keyBytes);
			System.out.println("Ciphertext Bytes in Hex:");
			printByteArray(ct);

			//Now try encrypting same plaintext with a different key
			//note we can reuse the same cipher object; don't call constructor again!
			//only have to create a new key and re-initialize cipher
			keyBytes[0] += 2;
			key = new SecretKeySpec(keyBytes, "DES");

			cipher.init(Cipher.ENCRYPT_MODE, key);
			ct = cipher.doFinal(pt);
			System.out.println("New Key Bytes in Hex:");
			printByteArray(keyBytes);
			System.out.println("New Ciphertext Bytes in Hex:");
			printByteArray(ct);
			
			//Now decrypt the ciphertext with this key
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte [] shouldBePlaintext;
			shouldBePlaintext = cipher.doFinal(ct);
			System.out.println("Decrypts to: " + (new String(shouldBePlaintext)));
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}