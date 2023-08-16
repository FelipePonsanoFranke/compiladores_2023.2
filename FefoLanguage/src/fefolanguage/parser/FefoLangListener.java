// Generated from FefoLang.g4 by ANTLR 4.13.0
package fefolanguage.parser;

	import java.util.ArrayList;
	import fefolanguage.dataStructures.*;
	import fefolanguage.exceptions.FefoExceptions;
	import fefolanguage.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FefoLangParser}.
 */
public interface FefoLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(FefoLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(FefoLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(FefoLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(FefoLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(FefoLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(FefoLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmdDeclaracao}.
	 * @param ctx the parse tree
	 */
	void enterCmdDeclaracao(FefoLangParser.CmdDeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmdDeclaracao}.
	 * @param ctx the parse tree
	 */
	void exitCmdDeclaracao(FefoLangParser.CmdDeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(FefoLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(FefoLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(FefoLangParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(FefoLangParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(FefoLangParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(FefoLangParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmdCondicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdCondicao(FefoLangParser.CmdCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmdCondicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdCondicao(FefoLangParser.CmdCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(FefoLangParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(FefoLangParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#opAtr}.
	 * @param ctx the parse tree
	 */
	void enterOpAtr(FefoLangParser.OpAtrContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#opAtr}.
	 * @param ctx the parse tree
	 */
	void exitOpAtr(FefoLangParser.OpAtrContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#opRel}.
	 * @param ctx the parse tree
	 */
	void enterOpRel(FefoLangParser.OpRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#opRel}.
	 * @param ctx the parse tree
	 */
	void exitOpRel(FefoLangParser.OpRelContext ctx);
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
	 * Enter a parse tree produced by {@link FefoLangParser#exprLinha}.
	 * @param ctx the parse tree
	 */
	void enterExprLinha(FefoLangParser.ExprLinhaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#exprLinha}.
	 * @param ctx the parse tree
	 */
	void exitExprLinha(FefoLangParser.ExprLinhaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FefoLangParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(FefoLangParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FefoLangParser#opExpr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(FefoLangParser.OpExprContext ctx);
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