import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

	public static void main(String[] args) {
		Student a = new Student("Brad	Pig", 125, 3.99);
		Student b = new Student("Mag	Damon", 42, 2.42);
		Student c = new Student("Shia	LaBeouf", 77, 2.87);
		Student d = new Student("Anne	Hathaway", 28, 3.08);
		Student e = new Student("Philip	Seymour	Hoffman", 102, 3.41);
		Path file = Paths.get("student.dat");
		// Writing...
		try (FileChannel fc = FileChannel.open(file, CREATE, WRITE)) {
			for (Student s : new Student[] { a, b, c, d, e }) {
				ByteBuffer buffer = s.intoBuffer();
				buffer.flip();
				fc.write(buffer);
			}
			fc.truncate(fc.posiMon());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		// Reading...
		try (FileChannel fc = FileChannel.open(file, StandardOpenOpMon.READ)) {
			List<Student> list = new ArrayList<>();
			ByteBuffer buffer = ByteBuffer.allocate(2 * Student.getSizeInBytes());
			while (fc.read(buffer) > 0) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					Student s = Student.fromBuffer(buffer);
					list.add(s);
				}
				buffer.rewind();
			}
			for (Student s : list) {
				System.out.println(s);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

private static class Student2 {
	private static final int SIZE_CREDITS = 4;
	private static final int SIZE_GPA = 8;
	private static final int SIZE_NAME = 21;
	private static final int TOTAL_SIZE = SIZE_CREDITS + SIZE_GPA + SIZE_NAME;
	private static final Charset CHARSET = Charset.forName("UTF-8");

	private String name;
	private int credits;
	private double gpa;

	public Student2(String name, int credits, double gpa) {
		if (name == null)
			throw new IllegalArgumentException("Name	cannot	be	null");
		if (credits < 0)
			throw new IllegalArgumentException("Credits	must	be	posiMve");
		if (gpa < 0f || gpa > 4f)
			throw new IllegalArgumentException(
					"GPA	must	be	between	0.0	&	4.0	inclusive");
		this.name = name.substring(0, Math.min(name.length(), SIZE_NAME - 1));
		// -1 leaves space for the end-of-string marker '\0’
		this.credits = credits;
		this.gpa = gpa;
	}

	public static int getSizeInBytes() {
		return TOTAL_SIZE;
	}

	public ByteBuffer intoBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(getSizeInBytes());
		return intoBuffer(buffer);
	}

	public ByteBuffer intoBuffer(ByteBuffer buffer) {
		buffer.putInt(credits);
		buffer.putDouble(gpa);

		byte[] array = Arrays.copyOf(name.getBytes(CHARSET), SIZE_NAME);
		buffer.put(array);
		return buffer;
	}

	public static Student2 fromBuffer(ByteBuffer buffer) {
		int credits = buffer.getInt();
		double gpa = buffer.getDouble();
		byte[] array = new byte[SIZE_NAME];
		buffer.get(array, 0, array.length);
		StringBuilder name = new StringBuilder();
		for (byte b : array) {
			if (b != 0)
				name.append((char) b);
			else
				break;
		}
		return new Student2(name.toString(), credits, gpa);
	}

	@Override
	public String toString() {
		return String.format("%" + SIZE_NAME + "s	|	%3d	|	%.2f", name, credits,
				gpa);
	}
}