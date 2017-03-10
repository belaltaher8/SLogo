package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.ASTNode;
import backend.Variable;
import command_abstractions.Command;
import command_abstractions.TurtleCommand;
import commands.Forward;
import commands.Right;
import constants.Constants;
import javafx.scene.paint.Color;
import languages.Language;
import languages.LanguageFactory;
import turtle.Turtle;

/**
 * 
 */

/**
 * @author harirajan
 *
 */
public class SLogoData extends Observable {

	private List<Turtle> myTurtles;
	private List<Variable> myVariables;
	private List<ASTNode> myFunctions;
	private Color myBackgroundColor;
	private int myBackgroundColorIndex;
	private List<Color> myColors;
	private Language myLanguage;

	public SLogoData(Turtle firstTurtle) {
		myTurtles = new ArrayList<>(Arrays.asList(firstTurtle));
		myVariables = new ArrayList<>();
		myFunctions = new ArrayList<>();
		myLanguage = LanguageFactory.getLang(Constants.DEFAULT_LANGUAGE);
		myColors = Constants.DEFAULT_PALLETE_COLORS;
		myBackgroundColor = Color.WHITE; // black
	}
	
	public void moveSelectedTurtles(double forwardDistance, double headingDiff) {
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				Forward fwd = new Forward();
				Right right = new Right();
				fwd.execute(new ArrayList<>(Arrays.asList(forwardDistance)), turtle);
				right.execute(new ArrayList<>(Arrays.asList(headingDiff)), turtle);
			}
		}
		notifyObservers();
	}

	public double runCommand(TurtleCommand cmd, List<Double> params) {
		double ret = 0.0;
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				ret = cmd.execute(params, turtle);
				notifyObservers();
			}
		}
		return ret;
	}


	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		o.update(this, null);
	}
	
	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
	
	public ASTNode getFunction(String functionName) {
		for (ASTNode func : myFunctions) {
			if (func.getFunctionName().equals(functionName)) {
				return func;
			}
		}
		return null; //throw exception here maybe??
	}
	
	public void addFunction(ASTNode newFunction) {
		for (ASTNode func : myFunctions) {
			if (newFunction.getFunctionName().equals(func.getFunctionName())) {
				myFunctions.remove(func);
				break;
			}
		}
		myFunctions.add(newFunction);
	}

	public void changeBackgroundColor(Color col) {
		myBackgroundColor = col;
		notifyObservers();
	}
	public void changeBackgroundColorIndex(int index) {
		myBackgroundColorIndex = index;
		notifyObservers();
	}

	public int getBackgroundColorIndex() {
		return myBackgroundColorIndex;
	}

	public Variable getVariable(String name) {
		for (Variable var : myVariables) {
			if (var.getName().equals(name))
				return var;
		}
		return null; // fix this to throw error when we cant find the variable
	}

	public void addVariable(Variable newVar) {
		System.out.println(newVar);
		deleteVariable(newVar.getName());
		myVariables.add(newVar);
		notifyObservers();
	}
	
	public void deleteVariable(String varName) {
		for (Variable var : myVariables) { 
			if (varName.equals(var.getName())) {
				myVariables.remove(var);
				break;
			}
		}
	}

	public void addTurtle(Turtle turtle) {
		myTurtles.add(turtle);
		notifyObservers();
	}

	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	
	public int getNumTurtles() {
		return myTurtles.size();
	}
	
	public List<Variable> getVariables() {
		return myVariables;
	}
	
	public void setLanguage(String lang) {
		myLanguage = LanguageFactory.getLang(lang);
		notifyObservers();
	}
	
	public void setPenWidth(Double newVal){
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) turtle.setPenWidth(newVal);
		}
		notifyObservers();
	}
	
	public void setPenColor(int index){
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected())  turtle.setPenColor(index, myColors.get(index));
		}
		notifyObservers();
	}
	
	public Language getLanguage() {
		return myLanguage;
	}
	
	public List<ASTNode> getFunctions() {
		return myFunctions;
	}
	
	public Color getBackgroundColor() {
		return myBackgroundColor;
	}
	
	public void changeColor(int index, Color newColor) {
		myColors.set(index, newColor);
		for (Turtle turtle : myTurtles) if (turtle.getColorIndex() == index) turtle.setPenColor(index, newColor);
		notifyObservers();
	}
	
}
