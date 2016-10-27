package nemo.variable;

import java.util.BitSet;

public class Binary extends Variable {

	protected BitSet bits;

	public Binary(int numberOfBits) {
		bits = new BitSet(numberOfBits);
	}
	
	public void set(int bit, boolean value) {
		this.bits.set(bit, value);
	}

	public boolean get(int bit) {
		return this.bits.get(bit);
	}

	@Override
	public Variable createRandomVariable() {
		// TODO Auto-generated method stub
		return null;
	}

}
