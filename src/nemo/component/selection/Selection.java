package nemo.component.selection;

import java.util.List;
import nemo.component.Component;
import nemo.component.operator.selection.SelectionOperator;
import nemo.solution.Solution;

public abstract class Selection extends Component {
	
	public abstract List<Solution> execute(List<Solution> population, List<Solution> archive, SelectionOperator selectionOperator);
}
