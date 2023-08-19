package fefolanguage.ast;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand{

	private String condition;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;

	
	public CommandDecisao(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf) {
		this.condition = condition;
		this.listaTrue = lt;
		this.listaFalse = lf;
	}
	
	@Override
	public String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("if (" + condition + "){\n");
		for(AbstractCommand c : listaTrue)
			str.append( c.generateJavaCode());
		
		str.append( "}\n");
		if(listaFalse != null) {
			str.append("else {\n");
			for(AbstractCommand c : listaFalse)
				str.append( c.generateJavaCode());
		}
		str.append( "}\n");
		return str.toString();
	}

	@Override
	public String generateJavaScriptCode() {
		StringBuilder str = new StringBuilder();
		str.append("if (" + condition + "){\n");
		for(AbstractCommand c : listaTrue)
			str.append( c.generateJavaScriptCode());
		
		str.append( "}\n");
		if(listaFalse != null) {
			str.append("else {\n");
			for(AbstractCommand c : listaFalse)
				str.append( c.generateJavaScriptCode());
		}
		str.append( "}\n");
		return str.toString();
	}

}
