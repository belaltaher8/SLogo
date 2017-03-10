/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.ControlCommand;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class IfElse extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
		
		double ret = 0.0; 
		if (params.get(0).evaluate() == constants.Constants.TRUE) {
			ret = params.get(1).evaluate();
		} else {
			ret = params.get(2).evaluate();
		}
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 3;
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.ControlCommand#indicesOfRequiredBlocks()
	 */
	@Override
	protected List<Integer> indicesOfRequiredBlocks() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.ControlCommand#indicesOfRequiredVariables()
	 */
	@Override
	protected List<Integer> indicesOfRequiredVariables() {
		// TODO Auto-generated method stub
		return null;
	}
}
