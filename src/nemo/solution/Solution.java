package nemo.solution;

import nemo.problem.Problem;
import nemo.variable.Variable;

public class Solution {

	protected Variable[] variables;

	protected double[] objectives;

	protected Problem problem;

	public Solution(Problem problem) {
		this.problem = problem;
		this.variables = new Variable[problem.getNumberOfVariables()];
		this.objectives = new double[problem.getNumberOfObjectives()];
	}
	
	/**
	 * Copy Constructor
	 * 
	 * @param solution Original Solution
	 */
	public Solution(Solution solution) {
		this.problem = solution.getProblem();
		this.objectives = solution.getObjectives().clone();

		for (int i = 0; i < problem.getNumberOfVariables(); i++) {
			variables[i] = solution.getVariables()[i].copy();
		}
	}

	public Problem getProblem() {
		return this.problem;
	}

	public void setObjective(int i, double value) {
		this.objectives[i] = value;
	}

	public double getObjective(int i) {
		return this.objectives[i];
	}
	
	public double[] getObjectives() {
		return this.objectives;
	}

	public Variable[] getVariables() {
		return this.variables;
	}	

	public void setVariables(Variable[] variables) {
		this.variables = variables;
	}
	
	public Solution copy() {
		return new Solution(this);
	}
}
