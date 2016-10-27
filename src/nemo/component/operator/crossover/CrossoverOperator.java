package nemo.component.operator.crossover;

import nemo.component.operator.Operator;

public abstract class CrossoverOperator extends Operator {

	public static double DEFAULT_PROBABILITY = 0.9;

	public CrossoverOperator(double probability) {
		super(probability);
	}

	public CrossoverOperator() {
		this(DEFAULT_PROBABILITY);
	}
}