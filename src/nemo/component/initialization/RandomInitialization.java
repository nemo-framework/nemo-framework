package nemo.component.initialization;

import java.util.ArrayList;
import java.util.List;
import nemo.problem.Problem;
import nemo.solution.Solution;

public class RandomInitialization extends Initialization {

	@Override
	public List<Solution> execute(Problem problem, int populationSize) {

		List<Solution> population = new ArrayList<Solution>(populationSize);

		for (int i = 0; i < populationSize; i++) {
			population.add(problem.createRandomSolution());
		}

		return population;
	}

}
