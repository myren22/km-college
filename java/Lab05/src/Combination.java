public class Combination {
	public int pin1;
	public int pin2;
	public int pin3;

	public Combination(int pin1, int pin2, int pin3) {
		this.pin1 = pin1;
		this.pin2 = pin2;
		this.pin3 = pin3;
	}

	public int[] getNumbers() {
		int[] myIntArray = { pin1, pin2, pin3 };
		return myIntArray;
	}

	public boolean isWithinRange(int upperLimit) {
		if ((pin1 >= 0) && (pin1 <= upperLimit)) {
			if ((pin2 >= 0) && (pin2 <= upperLimit)) {
				if ((pin3 >= 0) && (pin3 <= upperLimit)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object otherCombination) {
		if (otherCombination instanceof Combination) {
			int[] otherpin = ((Combination) otherCombination).getNumbers();
			if (otherpin[0] == pin1	 && otherpin[1] == pin2 && otherpin[2] == pin3)
				return true;

			// should I have a for loop to verify that the pins match?
		}

		return false;

	}
}
