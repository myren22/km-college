import java.util.ArrayList;
import java.util.List;

import static	java.nio.file.StandardOpenOption.*;	

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;


public class IOStudy {
	public static void intsToBuffer(int[] array, ByteBuffer buffer){
		if(buffer == null || array==null){
			throw new IllegalArgumentException();
		}
		for(int i: array){
			buffer.append(array[i]);
		}
	}
	
	public static void evenCharsToBuffer(char[]array, ByteBuffer buffer){
		if(buffer == null || array==null){
			throw new IllegalArgumentException();
		}
		for(int i: array){
			buffer.append(array[i]);
		}
	}
	
	public static Double[] doublesFromBuffer(ByteBuffer buffer){
		List<Double> result = new ArrayList<Double>();
		
		while(buffer.hasRemaining()){
			result.add(buffer.getDouble());
		}
		return (Double[]) result.toArray();
	}
	
	public static void stringWithLengthToFile(String[] strings, Path file){
		try(FileChannel fc = FileChannel.open(file,CREATE, WRITE, TRUNCATE_EXISTING)){
			ByteBuffer buffer = ByteBuffer.allocate(12);
			for(int n: new int[]{-5,11,42,58,31,-19,20}){
				if(buffer.remaining()<4){
					buffer.flip();
					fc.write(buffer);
					buffer.clear();
				}
				buffer.putInt(n);
			}
			if(buffer.position()>0){
				buffer.flip();
				fc.write(buffer);
			}
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
