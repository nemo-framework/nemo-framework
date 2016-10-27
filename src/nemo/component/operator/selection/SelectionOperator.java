package nemo.component.operator.selection;

import nemo.component.operator.Operator;

public abstract class SelectionOperator extends Operator {
	
	public static double DEFAULT_PROBABILITY = 1.0;

	public SelectionOperator(double probability) {
		super(probability);
	}
}
