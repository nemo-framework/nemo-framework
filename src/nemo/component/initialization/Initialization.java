package nemo.component.initialization;

import java.util.List;

import nemo.component.Component;
import nemo.problem.Problem;
import nemo.solution.Solution;

public abstract class Initialization extends Component {
	
	public abstract List<Solution> execute(Problem problem, int populationSize);
}
