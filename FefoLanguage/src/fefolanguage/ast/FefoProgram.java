package fefolanguage.ast;

import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

import fefolanguage.dataStructures.FefoSymbol;
import fefolanguage.dataStructures.FefoSymbolTable;

public class FefoProgram {
	private FefoSymbolTable vartable;
	private ArrayList<AbstractCommand> comandos;
	private String progName;

	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass{\n");
		str.append("public static void main(String args[]){\n");
		str.append("Scanner scanner = new Scanner(System.in);\n");
		for (FefoSymbol symbol: vartable.getAllSymbols()) 
			str.append( symbol.generateJavaCode() + "\n");
		
		for(AbstractCommand command : comandos) {
			str.append(command.generateJavaCode());
		}
		str.append("}\n");
		str.append("}\n");
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.print(str);
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
