package nemo.problem;

import nemo.solution.Solution;
import nemo.variable.Binary;
import nemo.variable.Variable;

public abstract class Problem {
	
	public Solution createRandomSolution() {

		String solutionType = getSolutionType();

		Variable[] variables = new Variable[getNumberOfVariables()];

		for (int i = 0; i < getNumberOfVariables(); i++) {

			if (solutionType.equalsIgnoreCase("Binary")) {
				variables[i] = new Binary(getUpperBound(i));
			} else if (solutionType.equalsIgnoreCase("Integer")) {
				// TODO Implementar para inteiro
			}
		}
		
		Solution solution = new Solution(this);
		
		solution.setVariables(variables);

		return new Solution(this);
	}
	
	protected double maximize(double value) {
		return -1.0 * value;
	}

	protected double minimize(double value) {
		return value;
	}
			
	/* Methods */
	public abstract void evaluate(Solution solution);

	/* Getters */
	public abstract int getNumberOfVariables();

	public abstract int getNumberOfObjectives();

	public abstract int getNumberOfConstraints();
	
	public abstract int getUpperBound(int variable);
	
	public abstract int getLowerBound(int variable);
	
	public abstract String getSolutionType();
	
	public abstract String getName();

}
