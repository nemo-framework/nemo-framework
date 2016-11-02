package nemo.component.reproduction;

import java.util.ArrayList;
import java.util.List;
import nemo.component.operator.crossover.CrossoverOperator;
import nemo.component.operator.mutation.MutationOperator;
import nemo.solution.Solution;

public class SteadyStateReproduction extends Reproduction {

	@Override
	public List<Solution> execute(List<Solution> matingPopulation, int offspringSize, CrossoverOperator crossoverOperator, MutationOperator mutationOperator) {
		
		List<Solution> offspringPopulation = new ArrayList<Solution>(offspringSize);

		List<Solution> parents = new ArrayList<Solution>(2);

		parents.add(matingPopulation.get(0));
		parents.add(matingPopulation.get(1));

		List<Solution> offspring = new ArrayList<Solution>(1);

		if (crossoverOperator != null) {
			offspring = crossoverOperator.execute(parents);
		} else {
			offspring.add(new Solution(parents.get(0)));
		}

		if (mutationOperator != null) {
			mutationOperator.execute(offspring.get(0));
		}

		offspringPopulation.add(offspring.get(0));

		return offspringPopulation;
	}

}
