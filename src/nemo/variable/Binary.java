package nemo.variable;

import java.util.BitSet;

import nemo.util.PseudoRandom;

public class Binary extends Variable {

	protected BitSet bits;
	
	protected int numberOfBits;

	public Binary(int numberOfBits) {

		this.numberOfBits = numberOfBits;
		this.bits = new BitSet(numberOfBits);

		for (int i = 0; i < numberOfBits; i++) {

			if (PseudoRandom.randDouble() < 0.5) {
				set(i, true);
			} else {
				set(i, false);
			}
		}
	}
	
	public void set(int bit, boolean value) {
		this.bits.set(bit, value);
	}

	public boolean get(int bit) {
		return this.bits.get(bit);
	}
}
