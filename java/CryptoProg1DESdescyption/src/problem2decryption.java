
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//Kyle Myren and Will Touch
//Decrypts to: readable

public class problem2decryption 
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



		//given Keybytes
		keyBytes = new byte[] 
				//new key 46, 			AA, 		20, 		1E, 		F4, 		3C, 			92, 		D2
				{(byte) 0x46, (byte) 0xAA, (byte) 0x20, (byte) 0x1E, (byte) 0xF4, (byte) 0x3C, (byte) 0x92, (byte) 0xD2 };

		
		
		//given Ciphertext
		byte [] ciphertext;
		ciphertext = new byte[] 
				//new key 2C, 		80, 			18, 		C5, 		DE, 		10, 			CF, 		07
				{(byte) 0x2C, (byte) 0x80, (byte) 0x18, (byte) 0xC5, (byte) 0xDE, (byte) 0x10, (byte) 0xCF, (byte) 0x07 };
		
		
		key = new SecretKeySpec(keyBytes, "DES");

		
		try
		{
			cipher = Cipher.getInstance("DES/ECB/NoPadding");

			// Initialize the cipher with the key and set it up for encryption
//			cipher.init(Cipher.ENCRYPT_MODE, key);

			//No encryption step as we have no plaintext, go straight to decrption			
			
			//Now decrypt the ciphertext with this key
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte [] shouldBePlaintext;
			shouldBePlaintext = cipher.doFinal(ciphertext);
			System.out.println("Decrypts to: " + (new String(shouldBePlaintext)));
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}