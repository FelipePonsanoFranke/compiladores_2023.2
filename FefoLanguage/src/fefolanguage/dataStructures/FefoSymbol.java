package fefolanguage.dataStructures;

public class FefoSymbol {
	
	public static final int INTEGER = 0;
	public static final int DOUBLE = 1;
	public static final int TEXT = 2;
	public static final int BOOLEAN = 3;
	
	
	protected String name;
	private int type;
	private boolean value;
	private boolean usado = false;

	public FefoSymbol (String name) {
		this.name = name;
	}
	
	public FefoSymbol(String name, int type, boolean value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}


	public boolean getValue() {
		return value;
	}


	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "FefoVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
		String str;
		if(this.type == INTEGER) 
			str = "int ";
		else if (this.type == DOUBLE) 
			str = "double ";
		else if(this.type == BOOLEAN)
			str = "boolean ";
		else 
			str = "String ";
		
		return str + this.name + ";\n";
		
	}
	
	public String generateJavaScriptCode() {

		return "var " + this.name + ";\n";
		
	}
}
