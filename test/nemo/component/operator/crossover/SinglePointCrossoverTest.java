package nemo.component.operator.crossover;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import nemo.problem.Problem;
import nemo.problem.binary.OneZeroMaxProblem;
import nemo.solution.Solution;

public class SinglePointCrossoverTest {

	protected static Problem fakeProblem;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fakeProblem = new OneZeroMaxProblem(12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfNegativeProbabilityIsPassed() {
		 new SinglePointCrossover(-0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfProbabilityGreaterThanOneIsPassed() {
		 new SinglePointCrossover(1.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfNullParentsIsPassed() {
		CrossoverOperator operator = new SinglePointCrossover(0.9);		
		operator.execute(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfNoParentsIsPassed() {
		CrossoverOperator operator = new SinglePointCrossover(0.9);
		
		List<Solution> parents = new ArrayList<Solution>();
		
		operator.execute(parents);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfOnlyOneParentIsPassed() {
		CrossoverOperator operator = new SinglePointCrossover(0.9);
		
		List<Solution> parents = new ArrayList<Solution>();
		
		parents.add(new Solution(fakeProblem));
		
		operator.execute(parents);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailIfTheParentsListContainsMoreThanTwoSolutionsIsPassed() {
		CrossoverOperator operator = new SinglePointCrossover(0.9);
		
		List<Solution> parents = new ArrayList<Solution>();
		
		parents.add(new Solution(fakeProblem));
		parents.add(new Solution(fakeProblem));
		parents.add(new Solution(fakeProblem));
		
		operator.execute(parents);
	}

}
