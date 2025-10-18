// Generated from CRUD.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CRUDParser}.
 */
public interface CRUDListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CRUDParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(CRUDParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(CRUDParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#sentenciaLista}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaLista(CRUDParser.SentenciaListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#sentenciaLista}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaLista(CRUDParser.SentenciaListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(CRUDParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(CRUDParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#createTable}.
	 * @param ctx the parse tree
	 */
	void enterCreateTable(CRUDParser.CreateTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#createTable}.
	 * @param ctx the parse tree
	 */
	void exitCreateTable(CRUDParser.CreateTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#defCampoLista}.
	 * @param ctx the parse tree
	 */
	void enterDefCampoLista(CRUDParser.DefCampoListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#defCampoLista}.
	 * @param ctx the parse tree
	 */
	void exitDefCampoLista(CRUDParser.DefCampoListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#defCampo}.
	 * @param ctx the parse tree
	 */
	void enterDefCampo(CRUDParser.DefCampoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#defCampo}.
	 * @param ctx the parse tree
	 */
	void exitDefCampo(CRUDParser.DefCampoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(CRUDParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(CRUDParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#optPK}.
	 * @param ctx the parse tree
	 */
	void enterOptPK(CRUDParser.OptPKContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#optPK}.
	 * @param ctx the parse tree
	 */
	void exitOptPK(CRUDParser.OptPKContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void enterInsertStmt(CRUDParser.InsertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void exitInsertStmt(CRUDParser.InsertStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#optCols}.
	 * @param ctx the parse tree
	 */
	void enterOptCols(CRUDParser.OptColsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#optCols}.
	 * @param ctx the parse tree
	 */
	void exitOptCols(CRUDParser.OptColsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#idLista}.
	 * @param ctx the parse tree
	 */
	void enterIdLista(CRUDParser.IdListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#idLista}.
	 * @param ctx the parse tree
	 */
	void exitIdLista(CRUDParser.IdListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#valorLista}.
	 * @param ctx the parse tree
	 */
	void enterValorLista(CRUDParser.ValorListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#valorLista}.
	 * @param ctx the parse tree
	 */
	void exitValorLista(CRUDParser.ValorListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(CRUDParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(CRUDParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(CRUDParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(CRUDParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#seleccion}.
	 * @param ctx the parse tree
	 */
	void enterSeleccion(CRUDParser.SeleccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#seleccion}.
	 * @param ctx the parse tree
	 */
	void exitSeleccion(CRUDParser.SeleccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#optWhere}.
	 * @param ctx the parse tree
	 */
	void enterOptWhere(CRUDParser.OptWhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#optWhere}.
	 * @param ctx the parse tree
	 */
	void exitOptWhere(CRUDParser.OptWhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStmt(CRUDParser.UpdateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStmt(CRUDParser.UpdateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#asignLista}.
	 * @param ctx the parse tree
	 */
	void enterAsignLista(CRUDParser.AsignListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#asignLista}.
	 * @param ctx the parse tree
	 */
	void exitAsignLista(CRUDParser.AsignListaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(CRUDParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(CRUDParser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStmt(CRUDParser.DeleteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStmt(CRUDParser.DeleteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CRUDParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CRUDParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(CRUDParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(CRUDParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(CRUDParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(CRUDParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(CRUDParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(CRUDParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#opRel}.
	 * @param ctx the parse tree
	 */
	void enterOpRel(CRUDParser.OpRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#opRel}.
	 * @param ctx the parse tree
	 */
	void exitOpRel(CRUDParser.OpRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(CRUDParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(CRUDParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#boolT}.
	 * @param ctx the parse tree
	 */
	void enterBoolT(CRUDParser.BoolTContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#boolT}.
	 * @param ctx the parse tree
	 */
	void exitBoolT(CRUDParser.BoolTContext ctx);
	/**
	 * Enter a parse tree produced by {@link CRUDParser#boolF}.
	 * @param ctx the parse tree
	 */
	void enterBoolF(CRUDParser.BoolFContext ctx);
	/**
	 * Exit a parse tree produced by {@link CRUDParser#boolF}.
	 * @param ctx the parse tree
	 */
	void exitBoolF(CRUDParser.BoolFContext ctx);
}