package fefolanguage.ast;

import java.util.ArrayList;

import fefolanguage.dataStructures.FefoSymbolTable;

public class FefoProgram {
	private FefoSymbolTable vartable;
	private ArrayList<AbstractCommand> comandos;
	private String progName;
	
	public void generateTarget() {
		
	}
	
	public FefoSymbolTable getVartable() {
		return vartable;
	}
	public void setVartable(FefoSymbolTable vartable) {
		this.vartable = vartable;
	}
	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}
	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
}
