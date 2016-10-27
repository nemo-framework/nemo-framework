package nemo.component.operator.crossover;

import java.util.List;

import nemo.component.operator.Operator;
import nemo.solution.Solution;

public abstract class CrossoverOperator extends Operator {

	public static double DEFAULT_PROBABILITY = 0.9;

	public CrossoverOperator(double probability) {
		super(probability);
	}

	public CrossoverOperator() {
		this(DEFAULT_PROBABILITY);
	}
	
	public abstract List<Solution> execute(List<Solution> matingPopulation);
}
