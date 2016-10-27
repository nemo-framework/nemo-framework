package nemo.algorithm.ea;

import java.util.List;

import nemo.algorithm.Algorithm;
import nemo.component.initialization.Initialization;
import nemo.problem.Problem;
import nemo.solution.Solution;

public abstract class EvolutionaryAlgorithm extends Algorithm {

	protected int populationSize;
	
	protected Problem problem;

	protected List<Solution> population;
	
	protected Initialization initialization;

	public EvolutionaryAlgorithm(Problem problem) {
		this.problem = problem;
	}

	public List<Solution> getPopulation() {
		return population;
	}

	public void setPopulation(List<Solution> population) {
		this.population = population;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public Problem getProblem() {
		return problem;
	}
	
	public List<Solution> createInitialPopulation() {
		return initialization.execute(problem, populationSize);
	}
	
	public List<Solution> evaluate(List<Solution> population) {
		for (int i = 0; i < populationSize; i++) {
			problem.evaluate(population.get(i));
		}
		return population;
	}
}
