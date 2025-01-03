// Generated from /Users/Leslie/Desktop/SUSTECH-CS323/antrlee/src/main/spl.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link splParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface splVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link splParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(splParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#extDefList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDefList(splParser.ExtDefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#extDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDef(splParser.ExtDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#extDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtDecList(splParser.ExtDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifier(splParser.SpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#structSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructSpecifier(splParser.StructSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(splParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#funDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDec(splParser.FunDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(splParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#paramDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDec(splParser.ParamDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#compSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompSt(splParser.CompStContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(splParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(splParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#defList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefList(splParser.DefListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef(splParser.DefContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#decList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecList(splParser.DecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(splParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(splParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link splParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(splParser.ArgsContext ctx);
}