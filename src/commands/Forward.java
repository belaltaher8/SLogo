/**
 * 
 */
package commands;

import java.util.List;

import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Forward implements Command {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.lang.Double[])
	 */
	@Override
	public double execute(ASTNode arg1,ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) throws IllegalArgumentException {
		double fwdAmount = arg1.evaluate();
		System.out.println(arg1.evaluate());
		turtle.setX(turtle.getX() + fwdAmount * Math.sin(Math.toRadians(turtle.getHeading())));
		turtle.setY(turtle.getY() - fwdAmount * Math.cos(Math.toRadians(turtle.getHeading())));
		turtle.display();
		if (arg2 != null) arg2.evaluate();
		return fwdAmount;
	}
	
}
