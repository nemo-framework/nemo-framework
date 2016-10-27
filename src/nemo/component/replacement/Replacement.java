package nemo.component.replacement;

import java.util.List;

import nemo.component.Component;
import nemo.solution.Solution;

public abstract class Replacement extends Component{

	public abstract List<Solution> execute(List<Solution> population, List<Solution> offspring, int populationSize);
	
}
