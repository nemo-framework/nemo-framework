package nemo.component.operator.crossover;

import java.util.ArrayList;
import java.util.List;
import nemo.solution.Solution;
import nemo.util.PseudoRandom;
import nemo.variable.Binary;
import nemo.variable.Variable;

public class SinglePointCrossover extends CrossoverOperator {

	public SinglePointCrossover(double probability) {
		super(probability);
	}

	protected List<Solution> doCrossover(Solution parent1, Solution parent2) {

		List<Solution> offSpring = new ArrayList<Solution>(2);

		offSpring.add(new Solution(parent1).copy());
		offSpring.add(new Solution(parent2).copy());

		if (PseudoRandom.randDouble() < probability) {
			
			Variable[] variables = parent1.getVariables();
			
			for (int i = 0; i < variables.length; i++) {
				Binary p1 = ((Binary) offSpring.get(0).getVariables()[i]);
				Binary p2 = ((Binary) offSpring.get(1).getVariables()[i]);
				
				// 1. Compute the total number of bits
				int numberOfBits = p1.getNumberOfBits();
				
				// 2. Calculate the point to make the crossover
				int crossoverPoint = PseudoRandom.randInt(0, numberOfBits - 1);

				// Generate the children
				for (int j = 0; j < numberOfBits; j++) {
					if (j <= crossoverPoint) {
						p1.set(j, p1.get(i));
						p2.set(j, p2.get(i));
					} else {
						p1.set(j, p2.get(i));
						p2.set(j, p1.get(i));
					}
				}
			}
		}
		
		return offSpring;
	}
}
