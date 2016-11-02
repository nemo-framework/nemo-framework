package nemo.component.reproduction;

import java.util.ArrayList;
import java.util.List;
import nemo.component.operator.crossover.CrossoverOperator;
import nemo.component.operator.mutation.MutationOperator;
import nemo.solution.Solution;

public class GenerationalTwoChildrenReproduction extends Reproduction {

	@Override
	public List<Solution> execute(List<Solution> matingPopulation, int offspringSize, CrossoverOperator crossoverOperator, MutationOperator mutationOperator) {

		List<Solution> offspringPopulation = new ArrayList<Solution>(offspringSize);

		for (int i = 0; i < offspringSize; i += 2) {

			List<Solution> parents = new ArrayList<Solution>(2);

			parents.add(matingPopulation.get(i % matingPopulation.size()));
			parents.add(matingPopulation.get((i + 1) % matingPopulation.size()));

			List<Solution> offspring = new ArrayList<Solution>(2);

			if (crossoverOperator != null) {
				offspring = crossoverOperator.execute(parents);
			} else {
				offspring.add(new Solution(parents.get(0)));
				offspring.add(new Solution(parents.get(1)));
			}

			if (mutationOperator != null) {
				mutationOperator.execute(offspring.get(0));
				mutationOperator.execute(offspring.get(1));
			}

			offspringPopulation.add(offspring.get(0));
			offspringPopulation.add(offspring.get(1));
		}

		return offspringPopulation;
	}
}
