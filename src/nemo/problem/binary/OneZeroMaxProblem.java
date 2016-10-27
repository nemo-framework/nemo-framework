package nemo.problem.binary;

import nemo.problem.Problem;
import nemo.solution.Solution;
import nemo.variable.Binary;

public class OneZeroMaxProblem extends Problem {

	protected int numberOfBits;

	public OneZeroMaxProblem(int numberOfBits) {
		this.numberOfBits = numberOfBits;
	}

	@Override
	public void evaluate(Solution solution) {

		Binary variable = ((Binary) solution.getVariables()[0]);

		int counterOnes = 0;
		int counterZeroes = 0;

		for (int i = 0; i < numberOfBits; i++) {
			if (variable.get(i)) {
				counterOnes++;
			} else {
				counterZeroes++;
			}
		}

		solution.setObjective(0, maximize(counterOnes));
		solution.setObjective(1, maximize(counterZeroes));
	}

	@Override
	public int getNumberOfVariables() {
		return 1;
	}

	@Override
	public int getNumberOfObjectives() {
		return 2;
	}

	@Override
	public int getNumberOfConstraints() {
		return 0;
	}

	@Override
	public int getUpperBound(int variable) {
		return numberOfBits;
	}

	@Override
	public int getLowerBound(int variable) {
		return numberOfBits;
	}

	@Override
	public String getName() {
		return OneZeroMaxProblem.class.getSimpleName();
	}

	@Override
	public String getSolutionType() {
		return "Binary";
	}
}
