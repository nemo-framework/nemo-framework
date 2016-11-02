package nemo.component.operator.mutation;

import nemo.component.operator.Operator;
import nemo.solution.Solution;

public abstract class MutationOperator extends Operator {

	public static double DEFAULT_PROBABILITY = 0.005;

	public MutationOperator(double probability) {
		super(probability);
	}

	public MutationOperator() {
		this(DEFAULT_PROBABILITY);
	}
	
	public abstract Solution execute(Solution solution);
}
