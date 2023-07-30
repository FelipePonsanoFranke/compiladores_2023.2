// Generated from FefoLang.g4 by ANTLR 4.7.1
package fefolanguage.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FefoLangParser}.
 */
public interface FefoLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(FefoLangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(FefoLangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(FefoLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(FefoLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(FefoLangParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(FefoLangParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(FefoLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(FefoLangParser.TermoContext ctx);
}