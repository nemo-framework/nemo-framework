package nemo.component.operator.crossover;

import java.util.List;

import nemo.component.operator.Operator;
import nemo.solution.Solution;

public abstract class CrossoverOperator extends Operator {

	public static double DEFAULT_PROBABILITY = 0.9;

	public CrossoverOperator(double probability) {
		super(probability);
	}
	
	public List<Solution> execute(List<Solution> parents) {
		if (parents == null) {
			throw new IllegalArgumentException("The mating population cannot be null");
		} else if (parents.size() != 2) {
			throw new IllegalArgumentException("There must be two parents");
		}

		return doCrossover(parents.get(0), parents.get(1));
	}
	
	protected abstract List<Solution> doCrossover(Solution parent1, Solution parent2);
}
