//Program written by Kyle Myren and Will Touch
//If running the full key range this program takes 20 minutes on my desktop to find the key
// The key is: [90, 4E, F2, CC, 4A, 8E, 28, 2F]
//To expedite the search process, b5 can be set to 74
//Tested Key and Ciphertext pair in problem2 to verify indepedent decryptability.

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class problem3findingTheKey {

	// public byte[] ActualCT = new byte[] { (byte) 0xBB, (byte) 0x73, (byte)
	// 0x05,
	// (byte) 0xD7, (byte) 0x82, (byte) 0xE7, (byte) 0x23, (byte) 0x85 };

	public static void main(String[] args) {
		byte b1 = (byte) 0x90;
		byte b2 = (byte) 0x4E;
		byte b3 = (byte) 0xF2;
		byte b4 = (byte) 0xCC;

		SecretKeySpec key;
		Cipher cipher;
		byte[] createdCipher;

		// byte[] ActualCT = new byte[] { (byte) 0xBB, (byte) 0x73, (byte) 0x05,
		// (byte) 0xD7, (byte) 0x82, (byte) 0xE7, (byte) 0x23, (byte) 0x85 };
		byte[] ActualCT = new byte[] { (byte) 0xBB, (byte) 0x73, (byte) 0x05,
				(byte) 0xD7, (byte) 0x82, (byte) 0xE7, (byte) 0x23, (byte) 0x85 };
		printByteArray(ActualCT);
		// The plaintext block (also, 64 bits --> 8 bytes)...
		String ptString = new String("Captains");
		// get ascii byte array from string
		byte[] pt = ptString.getBytes();
		// System.out.println("plaintext: " + ptString);

		// ------------
		// min value= -127
		// max value= 128
		try {
			cipher = Cipher.getInstance("DES/ECB/NoPadding");
			for (int b5 = 74; b5 <= 128; b5++) {
				// Cheat by setting b5=74 ... honest way is start at -127
				System.out.println("b5... Another 256th of the way there..." + " #"	+ b5);
				for (int b6 = -114; b6 <= 128; b6++) {
					// Cheat by setting b6=-114 ... honest way is to start at -127
					System.out.println("B6 another 16777216 possibilities checked" + " #" + b6);
					for (int b7 = -127; b7 <= 128; b7++) {
						// System.out.println("B7 Try");
						for (int b8 = -127; b8 <= 128; b8 += 2) {

							byte[] keyBytes = new byte[] { b1, b2, b3, b4,
									(byte) b5, (byte) b6, (byte) b7, (byte) b8 };
							key = new SecretKeySpec(keyBytes, "DES");

							// Initialize the cipher with the key and set it up
							// for encryption
							cipher.init(Cipher.ENCRYPT_MODE, key);

							// Encrypt the plaintext
							createdCipher = cipher.doFinal(pt);
							
								//GOTTA MAKES SURE TO DO *ARRAYS.EQUALS* OR ELSE YOU AINT EVER GONNA FIND IT!
							if (Arrays.equals(createdCipher, ActualCT)) {
								// Print the Key byte array
								System.out
										.println("BEHOLD THE KEY THAT WE HAVE WAITED FOR. THE KEY THAT WAS PROMISED AND WILL DELIVER US FROM THE DARK.");
								System.out.println("Key Bytes in Hex:");
								printByteArray(keyBytes);
								return;
							} else {
								// System.out.println("NOT YET BOI");
							}
						}

					}
				}
			}
		} catch (Exception e) {
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
