package nemo.component.selection;

import java.util.ArrayList;
import java.util.List;
import nemo.component.operator.selection.SelectionOperator;
import nemo.solution.Solution;

public class PopulationAndArchiveSelection extends Selection{
	
	@Override
	public List<Solution> execute(List<Solution> population, List<Solution> archive, SelectionOperator selectionOperator) {
		List<Solution> union = new ArrayList<Solution>();

		union.addAll(population);
		union.addAll(archive);

		return selectionOperator.execute(union);
	}
}
