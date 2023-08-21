package fefolanguage.dataStructures;
import fefolanguage.exceptions.FefoExceptions;

public class FefoBinaryExpression {
	public static final int INTEGER = 0;
	public static final int DOUBLE = 1;
	public static final int TEXT = 2;
	public static final int BOOLEAN = 3;
	private int tipoEsquerda = -1;
	private int tipoDireita = -1;
	private String operador;
	public int getTipoEsquerda() {
		return tipoEsquerda;
	}


	public void setTipoEsquerda(int tipoEsquerda) {
		this.tipoEsquerda = tipoEsquerda;
	}


	public int getTipoDireita() {
		return tipoDireita;
	}


	public void setTipoDireita(int tipoDireita) {
		this.tipoDireita = tipoDireita;
	}


	public String getOperador() {
		return operador;
	}


	public void setOperador(String operador) {
		this.operador = operador;
	}



	
	
	public int eval() {
		//aqui vou determinar a corretude dos tipos.
		//vou  retornar o tipo da expressao
		
		//removendo primeiro o caso de duas strings sendo concatenadas
		if(tipoEsquerda == 2 && tipoDireita == 2 && operador.equals("+")) {
			return 2;
		}
		if(operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/")) {//trata-se de uma operação numérica
			if(tipoEsquerda == 0 && tipoDireita == 0) {
				return 0;
			}
			if(tipoEsquerda == 1 && tipoDireita == 1) {
				return 1;
			}
			if (tipoEsquerda == 0 && tipoDireita == 1 || tipoEsquerda == 1 && tipoDireita == 0) {
				throw new FefoExceptions("Erro ao processar operação matemática entre inteiros e decimais.");
			}
			if(tipoEsquerda == 2 || tipoDireita == 2) {
				throw new FefoExceptions("Erro ao utilizar um texto em uma operaçõa numérica!");
			}
			if(tipoEsquerda == 3 || tipoDireita == 3) {
				throw new FefoExceptions("Erro ao utilizar um booleano em uma operaçõa numérica!");
			}
		} else {//estamos em uma operação booleana
			if(operador.equals("==") || operador.equals("!=")) {
				if (tipoEsquerda == tipoDireita) {
					//podemos fazer essas operações com variaveis de mesmo tipo
					return 3;
				} else if (tipoEsquerda == 0 && tipoDireita == 1 || tipoEsquerda == 1 && tipoDireita == 0) {
					//operação entre double e inteiro são permitidas em java
					return 3;
				} else {
					throw new FefoExceptions("Erro ao comparar tipos diferentes!");
				}
			} else if(operador.equals(">") || operador.equals("<") || operador.equals(">=") || operador.equals("<=")) {
				if(tipoEsquerda < 2 && tipoDireita < 2) {
					return 3;
				} else {
					throw new FefoExceptions("Erro ao utilizar um valor não numérico numa comparação!");
				}
			}
		}
		return 0;
	}
	
	
}
