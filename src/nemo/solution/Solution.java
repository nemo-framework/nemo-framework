package nemo.solution;

import nemo.problem.Problem;
import nemo.variable.Variable;

public class Solution {

	protected Variable[] variables;

	protected double[] objectives;

	protected Problem problem;

	public Solution(Problem problem, Variable[] variables) {
		this.problem = problem;
		this.variables = variables;
		this.objectives = new double[problem.getNumberOfObjectives()];
	}

	public void setObjective(int i, double value) {
		this.objectives[i] = value;
	}

	public double getObjective(int i) {
		return this.objectives[i];
	}

	public Variable[] getVariables() {
		return this.variables;
	}

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
}
