package fefolanguage.dataStructures;

public class FefoVariable extends FefoSymbol{
	
	public static final int INTEGER = 0;
	public static final int DOUBLE = 1;
	public static final int TEXT = 2;
	public static final int BOOLEAN = 3;
	
	private int type;
	private String value;
	private boolean usado = false;
	
	
	public FefoVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}

//
	


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


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "FefoVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
}
