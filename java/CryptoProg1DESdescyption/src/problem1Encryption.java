import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//Kyle Myren and Will Touch
//Ciphertext Hex is [8F, 40, 84, 29, 55, B6, 32, 1D]

public class problem1Encryption {
	public static void main(String[] args) 
	{
		// Create cipher and key objects
		Cipher cipher;
		SecretKeySpec key;

		//key, plaintext, and ciphertext as byte arrays
		byte [] keyBytes;
		byte [] pt;
		byte [] ct;

		//given - keybytes
		keyBytes = new byte[] 
				{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
		
		//given - plaintext
		String ptString = "plaintxt";
		pt = ptString.getBytes();
		
		
		//make special key from keybytes
		key = new SecretKeySpec(keyBytes, "DES");
		
		try
		{
			// Create the actual DES cipher, in Electronic Code Book mode, with no padding
			cipher = Cipher.getInstance("DES/ECB/NoPadding");

			// Initialize the cipher with the key and set it up for encryption
			cipher.init(Cipher.ENCRYPT_MODE, key);

			// Encrypt the plaintext using key
			ct = cipher.doFinal(pt);

			// Display the ciphertext
			System.out.println("Ciphertext Bytes in Hex:");
			printByteArray(ct);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//find ciphertext
		
	}
	
	public static void printByteArray(byte [] array)
	{
		System.out.print("[");
		for(int i = 0; i < array.length-1; i++)
		{
			System.out.print(String.format("%1$02X", array[i]) + ", ");
		}
		System.out.print(String.format("%1$02X", array[array.length-1]) + "]\n");
	}
		
}
