package thiagodnf.component.initialization;

import java.util.List;

import thiagodnf.component.Component;
import thiagodnf.problem.Problem;
import thiagodnf.solution.Solution;

public abstract class Initialization extends Component {
	
	public abstract List<Solution> execute(Problem problem, int populationSize);
}
