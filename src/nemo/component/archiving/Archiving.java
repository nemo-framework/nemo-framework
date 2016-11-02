package nemo.component.archiving;

import java.util.List;

import nemo.component.Component;
import nemo.solution.Solution;

public abstract class Archiving extends Component{
	
	public abstract List<Solution> getArchive();
	
	public abstract void archive(List<Solution> population);

}
