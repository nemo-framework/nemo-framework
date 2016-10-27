package nemo.component.selection;

import java.util.List;
import nemo.component.operator.selection.SelectionOperator;
import nemo.solution.Solution;

public class OnlyArchiveSelection extends Selection {

   	@Override
	public List<Solution> execute(List<Solution> population, List<Solution> archive, SelectionOperator selectionOperator) {
		return selectionOperator.execute(archive);
	}
}
