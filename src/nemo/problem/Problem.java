package nemo.problem;

import nemo.solution.Solution;
import nemo.variable.Binary;
import nemo.variable.Variable;

public abstract class Problem {
	
	protected String solutionType;
	
	protected double maximize(double value) {
		return -1.0 * value;
	}

	protected double minimize(double value) {
		return value;
	}

	

	public Solution createRandomSolution() {

		Variable[] variables = new Variable[getNumberOfVariables()];

		for (int i = 0; i < getNumberOfVariables(); i++) {
			if (solutionType.equalsIgnoreCase("Binary")) {
				variables[i] = new Binary(2);
			}
		}

		return new Solution(this, variables);
	}
	
	/* Methods */
	public abstract void evaluate(Solution solution);

	/* Getters */
	public abstract int getNumberOfVariables();

	public abstract int getNumberOfObjectives();

	public abstract int getNumberOfConstraints();
	
	public abstract String getSolutionType();

	public abstract String getName();

}
