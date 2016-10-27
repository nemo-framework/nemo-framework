package nemo.component.operator.selection;

import java.util.List;

import nemo.component.operator.Operator;
import nemo.solution.Solution;

public abstract class SelectionOperator extends Operator {
	
	public static double DEFAULT_PROBABILITY = 1.0;

	public SelectionOperator(double probability) {
		super(probability);
	}
	
	public abstract List<Solution> execute(List<Solution> population);
}
