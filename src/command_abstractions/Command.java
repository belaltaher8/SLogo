/**
 * 
 */
package command_abstractions;

import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException;
	
	public int getNumArgs();
	
	public boolean isMathCommand();
	
}