package nemo.component.operator.selection;

import java.util.ArrayList;
import java.util.List;
import nemo.solution.Solution;
import nemo.util.PseudoRandom;

public class RandomSelection extends SelectionOperator {

	public RandomSelection(double probability) {
		super(probability);
	}

	@Override
	public List<Solution> execute(List<Solution> population) {

		int populationSize = population.size();

		List<Solution> matingPopulation = new ArrayList<Solution>(populationSize);

		for (int i = 0; i < populationSize; i++) {

			// Generate a random position
			int pos = PseudoRandom.randInt(0, populationSize - 1);

			// Add the selected solution to mating population
			matingPopulation.add(population.get(pos));
		}

		return matingPopulation;
	}
}
