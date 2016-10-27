package nemo.component.reproduction;

import java.util.List;

import nemo.component.Component;
import nemo.component.operator.crossover.CrossoverOperator;
import nemo.component.operator.mutation.MutationOperator;
import nemo.solution.Solution;

public abstract class Reproduction extends Component{

	public abstract List<Solution> execute(List<Solution>matingPopulation, int offspringSize, CrossoverOperator crossoverOperator, MutationOperator mutationOperator);
}
