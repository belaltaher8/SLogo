package commands;

import java.util.List;

import backend.TurtleInfo;
import resources.languages.Resources;

public class Towards implements Command{

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Towards", 2, arguments.size()));
		}
		double x = arguments.get(0);
		double y = arguments.get(1);
		if (y >= turtle.getY()) {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))));
		} else {
			turtle.setHeading(Math.toDegrees(Math.atan((x - turtle.getX()) / (y - turtle.getY()))) + 180);
		}
		return 0.0;
		
		/*
		turtle.setHeading(turtle.getHeading() - rotationAmount);
		return rotationAmount;
		*/
	}
}