package thiagodnf.algorithm.ea.ga;

import java.util.List;

import thiagodnf.algorithm.ea.EvolutionaryAlgorithm;
import thiagodnf.problem.Problem;
import thiagodnf.solution.Solution;

public abstract class GeneticAlgorithm extends EvolutionaryAlgorithm {

	public GeneticAlgorithm(Problem problem) {
		super(problem);
	}

	@Override
	public List<Solution> run() {
		List<Solution> offspringPopulation;
		List<Solution> matingPopulation;

		population = createInitialPopulation();
		population = evaluatePopulation(population);

		while (false) {
			matingPopulation = selection(population);
			offspringPopulation = reproduction(matingPopulation);
			offspringPopulation = evaluatePopulation(offspringPopulation);
			population = replacement(population, offspringPopulation);

		}
		
		return null;
	}

}
