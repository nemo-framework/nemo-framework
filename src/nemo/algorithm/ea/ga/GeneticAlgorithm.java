package nemo.algorithm.ea.ga;

import java.util.ArrayList;
import java.util.List;
import nemo.algorithm.ea.EvolutionaryAlgorithm;
import nemo.component.archiving.Archiving;
import nemo.component.operator.crossover.CrossoverOperator;
import nemo.component.operator.mutation.MutationOperator;
import nemo.component.operator.selection.SelectionOperator;
import nemo.component.replacement.Replacement;
import nemo.component.reproduction.Reproduction;
import nemo.component.selection.Selection;
import nemo.problem.Problem;
import nemo.solution.Solution;

public abstract class GeneticAlgorithm extends EvolutionaryAlgorithm {
	
	protected Selection selection;
	
	protected Reproduction reproduction;
		
	protected SelectionOperator selectionOperator;
	
	protected CrossoverOperator crossoverOperator;
	
	protected MutationOperator mutationOperator;
	
	protected Replacement replacement;
	
	protected Archiving archiving;
	
	public GeneticAlgorithm(Problem problem) {
		super(problem);
	}

	@Override
	public List<Solution> run() {
		List<Solution> offspringPopulation;
		List<Solution> matingPopulation;

		population = createInitialPopulation();
		population = evaluate(population);

		archive(population);

		while (!isStoppingConditionReached()) {

			matingPopulation = selection(population);

			offspringPopulation = reproduction(matingPopulation);

			offspringPopulation = evaluate(offspringPopulation);

			population = replacement(population, offspringPopulation);

			archive(offspringPopulation);
		}

		return null;
	}
	
	protected List<Solution> selection(List<Solution> parents) {
		return selection.execute(parents, getArchive(), selectionOperator);
	}
	
	protected List<Solution> reproduction(List<Solution> matingPopulation) {
        return this.reproduction(matingPopulation, populationSize);
    }
	
	protected List<Solution> reproduction(List<Solution> matingPopulation, int offspringSize) {
        return reproduction.execute(matingPopulation, offspringSize, crossoverOperator, mutationOperator);
    }
	
	protected List<Solution> replacement(List<Solution> population, List<Solution> offspringPopulation) {
		return replacement.execute(population, offspringPopulation, populationSize);
	}
	
	protected List<Solution> getArchive() {
		if (archiving == null) {
			return new ArrayList<Solution>();
		}

		return archiving.getArchive();
	}

	protected void archive(List<Solution> population) {
		if (archiving == null) {
			return;
		}

		archiving.archive(population);
	}
}
