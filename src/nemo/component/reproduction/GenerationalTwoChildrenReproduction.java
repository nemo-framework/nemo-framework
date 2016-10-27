package ga.component.reproduction;

import ga.component.operator.crossover.CrossoverOperator;
import ga.component.operator.mutation.MutationOperator;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;

public class GenerationalTwoChildrenReproduction extends Reproduction {

	@Override
	public SolutionSet reproduction(SolutionSet matingPopulation, int offspringSize, CrossoverOperator crossover, MutationOperator mutation) throws ClassNotFoundException {
		
		SolutionSet offspringPopulation = new SolutionSet(offspringSize);
		
		for (int i = 0; i < offspringSize; i += 2) {

			SolutionSet parents = new SolutionSet(2);

			parents.add(matingPopulation.get(i % matingPopulation.size()));
			parents.add(matingPopulation.get((i + 1) % matingPopulation.size()));

			SolutionSet offspring = new SolutionSet(2);

			if (crossover != null) {
				offspring = crossover.execute(parents);
			} else {
				offspring.add(new Solution(parents.get(0)));
				offspring.add(new Solution(parents.get(1)));
			}

			if (mutation != null) {
				mutation.execute(offspring.get(0));
				mutation.execute(offspring.get(1));
			}

			offspringPopulation.add(offspring.get(0));
			offspringPopulation.add(offspring.get(1));
		}
		
		return offspringPopulation;
	}
}
