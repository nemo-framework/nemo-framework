package thiagodnf.component.operator;

import thiagodnf.component.Component;

public abstract class Operator extends Component {

	protected double probability;

	public Operator(double probability) {
		if (probability < 0 || probability > 1) {
			throw new IllegalArgumentException("Probability should be between 0 and 1");
		}

		this.probability = probability;
	}
}
