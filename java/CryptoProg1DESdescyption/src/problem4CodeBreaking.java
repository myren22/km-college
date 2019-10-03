//Kyle Myren and Will Touch
//After running for a couple seconds on my desktop program found 10 results with only alpha+spaces
//The result: "Found it" with key [BA, 54, 68, 08, 12, C7, 6D, 63]
//... Is the only intelligible answer out of the 10.

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class problem4CodeBreaking {

	// public byte[] ActualCT = new byte[] { (byte) 0xBB, (byte) 0x73, (byte)
	// 0x05,
	// (byte) 0xD7, (byte) 0x82, (byte) 0xE7, (byte) 0x23, (byte) 0x85 };
	
	public static boolean isAlpha(String name) {
	    return name.matches("[ a-zA-Z]+$");
	}
	
	public static void main(String[] args) 
	{
		// Create cipher and key objects
		Cipher cipher;
		SecretKeySpec key;

		//key, plaintext, and ciphertext as byte arrays
		byte [] keyBytes;
		
		
		byte b1 = (byte) 0xBA;
		byte b2 = (byte) 0x54;
		byte b3 = (byte) 0x68;
		byte b4 = (byte) 0x08;
		byte b5 = (byte) 0x12;

		// byte[] ActualCT = new byte[] { E1, 6E, A5, 77, AF, 54, 39, 04
		byte[] ActualCT = new byte[] { (byte) 0xE1, (byte) 0x6E, (byte) 0xA5,
				(byte) 0x77, (byte) 0xAF, (byte) 0x54, (byte) 0x39, (byte) 0x04 };

		// Note that DES only uses a 56 bit key;
		//low bit of each byte is ignored, so 0x00 gives same result as 0x01 etc
		keyBytes = new byte[]{b1,b2,b3, b4, b5, (byte) 0x00, (byte) 0x00, (byte) 0x04 };
//		new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };


		key = new SecretKeySpec(keyBytes, "DES");

		try
		{
			// Create the actual DES cipher, in Electronic Code Book mode, with no padding
			cipher = Cipher.getInstance("DES/ECB/NoPadding");			

			for (int b6 = -127; b6 <= 128; b6=b6+2) {
				// Cheat by setting b6=-114 ... honest way is to start at -127
//				System.out.println("B6 trying even harder" + " #" + b6);
				for (int b7 = -127; b7 <= 128; b7=b7+2) {
					// System.out.println("B7 Try");
					for (int b8 = -127; b8 <= 128; b8= b8+2) {

						keyBytes = new byte[] { b1, b2, b3, b4, b5, 
								(byte) b6, (byte) b7, (byte) b8 };
						
						key = new SecretKeySpec(keyBytes, "DES");
						
						//Now decrypt the ciphertext with this key
						cipher.init(Cipher.DECRYPT_MODE, key);
						byte [] shouldBePlaintext;
						shouldBePlaintext = cipher.doFinal(ActualCT);
						
						
						if(isAlpha(new String(shouldBePlaintext))){
							// Print the Key byte array
//							System.out.println("BEHOLD THE KEY THAT WE HAVE WAITED FOR. THE KEY THAT WAS PROMISED AND WILL SOLVE ALL THE SHIT.");
							System.out.println("Key Bytes in Hex:");
							printByteArray(keyBytes);
							System.out.println("Decrypts to: " + (new String(shouldBePlaintext)));
							
						}
						else {
							// System.out.println("NOT YET BOI");
						}
					}

				}
			}			
				
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void printByteArray(byte[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(String.format("%1$02X", array[i]) + ", ");
		}
		System.out.print(String.format("%1$02X", array[array.length - 1])
				+ "]\n");
	}
}
