package nemo.component.operator.crossover;

import java.util.List;

import nemo.solution.Solution;

public class SinglePointCrossover extends CrossoverOperator {

	@Override
	public List<Solution> execute(List<Solution> parents) {
		if (parents == null) {
			throw new IllegalArgumentException("The mating population cannot be null");
		} else if (parents.size() != 2) {
			throw new IllegalArgumentException("There must be two parents");
		}

		return doCrossover(parents.get(0), parents.get(1));
	}
	
	public List<Solution> doCrossover(Solution parent1, Solution parent2) {

		return null;
	}

}
