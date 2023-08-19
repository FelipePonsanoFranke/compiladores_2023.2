package fefolanguage.ast;

import java.util.ArrayList;

public class CommandLoop extends AbstractCommand {
	public static final int WHILE = 0;
	public static final int DoWHILE = 1;
	private int tipo;
	private String condition;
	private ArrayList<AbstractCommand> listaLoop;
	
	public CommandLoop(String condition, ArrayList<AbstractCommand> listaLoop, int tipo) {
		this.condition = condition;
		this.listaLoop = listaLoop;
		this.tipo = tipo;
	}
	
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public ArrayList<AbstractCommand> getListaRepeticao() {
		return listaLoop;
	}

	public void setListaLoop(ArrayList<AbstractCommand> listaLoop) {
		this.listaLoop = listaLoop;
	}


	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		if(this.tipo == 0) {
			str.append("while (" + condition + "){\n");
			for(AbstractCommand c : listaLoop)
				str.append( c.generateJavaCode());
			
			str.append( "}\n");
		} else {
			str.append("do {\n");
			for(AbstractCommand c : listaLoop)
				str.append( c.generateJavaCode());
			str.append( "}\n");
			str.append("while (" + condition + ");\n");
			
		}
		return str.toString();
	}

}
