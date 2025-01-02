// Generated from D:/sf/team-project-24spring-29/antrlee/src/main/spl.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link splParser}.
 */
public interface splListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link splParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(splParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(splParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#extDefList}.
	 * @param ctx the parse tree
	 */
	void enterExtDefList(splParser.ExtDefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#extDefList}.
	 * @param ctx the parse tree
	 */
	void exitExtDefList(splParser.ExtDefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#extDef}.
	 * @param ctx the parse tree
	 */
	void enterExtDef(splParser.ExtDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#extDef}.
	 * @param ctx the parse tree
	 */
	void exitExtDef(splParser.ExtDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#extDecList}.
	 * @param ctx the parse tree
	 */
	void enterExtDecList(splParser.ExtDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#extDecList}.
	 * @param ctx the parse tree
	 */
	void exitExtDecList(splParser.ExtDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#specifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecifier(splParser.SpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#specifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecifier(splParser.SpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStructSpecifier(splParser.StructSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStructSpecifier(splParser.StructSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#varDec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(splParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#varDec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(splParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#funDec}.
	 * @param ctx the parse tree
	 */
	void enterFunDec(splParser.FunDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#funDec}.
	 * @param ctx the parse tree
	 */
	void exitFunDec(splParser.FunDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(splParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(splParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#paramDec}.
	 * @param ctx the parse tree
	 */
	void enterParamDec(splParser.ParamDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#paramDec}.
	 * @param ctx the parse tree
	 */
	void exitParamDec(splParser.ParamDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#compSt}.
	 * @param ctx the parse tree
	 */
	void enterCompSt(splParser.CompStContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#compSt}.
	 * @param ctx the parse tree
	 */
	void exitCompSt(splParser.CompStContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(splParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(splParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(splParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(splParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#defList}.
	 * @param ctx the parse tree
	 */
	void enterDefList(splParser.DefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#defList}.
	 * @param ctx the parse tree
	 */
	void exitDefList(splParser.DefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#def}.
	 * @param ctx the parse tree
	 */
	void enterDef(splParser.DefContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#def}.
	 * @param ctx the parse tree
	 */
	void exitDef(splParser.DefContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#decList}.
	 * @param ctx the parse tree
	 */
	void enterDecList(splParser.DecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#decList}.
	 * @param ctx the parse tree
	 */
	void exitDecList(splParser.DecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(splParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(splParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(splParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(splParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link splParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(splParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link splParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(splParser.ArgsContext ctx);
}