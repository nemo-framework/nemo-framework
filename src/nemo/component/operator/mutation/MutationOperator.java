package nemo.component.operator.mutation;

import nemo.component.operator.Operator;

public abstract class MutationOperator extends Operator {

	public static double DEFAULT_PROBABILITY = 0.005;

	public MutationOperator(double probability) {
		super(probability);
	}

	public MutationOperator() {
		this(DEFAULT_PROBABILITY);
	}
}
