package ga.component.reproduction;

import ga.component.operator.crossover.CrossoverOperator;
import ga.component.operator.mutation.MutationOperator;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;

public class SteadyStateReproduction extends Reproduction {

	@Override
	public SolutionSet reproduction(SolutionSet matingPopulation, int offspringSize, CrossoverOperator crossover, MutationOperator mutation) throws ClassNotFoundException {
		
		SolutionSet offspringPopulation = new SolutionSet(offspringSize);

		SolutionSet parents = new SolutionSet(2);

		parents.add(matingPopulation.get(0));
		parents.add(matingPopulation.get(1));

		SolutionSet offspring = new SolutionSet(1);
        
        if (crossover != null) {
            offspring = crossover.execute(parents);
        } else {
            offspring.add(new Solution(parents.get(0)));
        }

        if (mutation != null) {
        	mutation.execute(offspring.get(0));
        }

        offspringPopulation.add(offspring.get(0));

        return offspringPopulation;
	}

}
