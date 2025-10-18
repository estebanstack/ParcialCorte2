// Generated from CRUD.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CRUDParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CREATE=8, TABLE=9, 
		INSERT=10, INTO=11, VALUES=12, SELECT=13, FROM=14, WHERE=15, UPDATE=16, 
		SET=17, DELETE=18, AND=19, OR=20, NOT=21, TRUE=22, FALSE=23, INT=24, FLOAT=25, 
		TEXT=26, PRIMARY=27, KEY=28, EQ=29, NEQ=30, LE=31, LT=32, GE=33, GT=34, 
		STAR=35, ID=36, NUM=37, STR=38, WS=39, LINE_CMT=40, BLOCK_CMT=41;
	public static final int
		RULE_programa = 0, RULE_sentenciaLista = 1, RULE_sentencia = 2, RULE_createTable = 3, 
		RULE_defCampoLista = 4, RULE_defCampo = 5, RULE_tipo = 6, RULE_optPK = 7, 
		RULE_insertStmt = 8, RULE_optCols = 9, RULE_idLista = 10, RULE_valorLista = 11, 
		RULE_valor = 12, RULE_selectStmt = 13, RULE_seleccion = 14, RULE_optWhere = 15, 
		RULE_updateStmt = 16, RULE_asignLista = 17, RULE_asign = 18, RULE_deleteStmt = 19, 
		RULE_expr = 20, RULE_term = 21, RULE_fact = 22, RULE_rel = 23, RULE_opRel = 24, 
		RULE_boolExpr = 25, RULE_boolT = 26, RULE_boolF = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "sentenciaLista", "sentencia", "createTable", "defCampoLista", 
			"defCampo", "tipo", "optPK", "insertStmt", "optCols", "idLista", "valorLista", 
			"valor", "selectStmt", "seleccion", "optWhere", "updateStmt", "asignLista", 
			"asign", "deleteStmt", "expr", "term", "fact", "rel", "opRel", "boolExpr", 
			"boolT", "boolF"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "','", "'+'", "'-'", "'/'", "'CREATE'", "'TABLE'", 
			"'INSERT'", "'INTO'", "'VALUES'", "'SELECT'", "'FROM'", "'WHERE'", "'UPDATE'", 
			"'SET'", "'DELETE'", "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", "'INT'", 
			"'FLOAT'", "'TEXT'", "'PRIMARY'", "'KEY'", "'='", "'<>'", "'<='", "'<'", 
			"'>='", "'>'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "CREATE", "TABLE", "INSERT", 
			"INTO", "VALUES", "SELECT", "FROM", "WHERE", "UPDATE", "SET", "DELETE", 
			"AND", "OR", "NOT", "TRUE", "FALSE", "INT", "FLOAT", "TEXT", "PRIMARY", 
			"KEY", "EQ", "NEQ", "LE", "LT", "GE", "GT", "STAR", "ID", "NUM", "STR", 
			"WS", "LINE_CMT", "BLOCK_CMT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CRUD.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CRUDParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public SentenciaListaContext sentenciaLista() {
			return getRuleContext(SentenciaListaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CRUDParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			sentenciaLista();
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaListaContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public SentenciaListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaLista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitSentenciaLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaListaContext sentenciaLista() throws RecognitionException {
		SentenciaListaContext _localctx = new SentenciaListaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentenciaLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 337152L) != 0)) {
				{
				{
				setState(59);
				sentencia();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContext extends ParserRuleContext {
		public CreateTableContext createTable() {
			return getRuleContext(CreateTableContext.class,0);
		}
		public InsertStmtContext insertStmt() {
			return getRuleContext(InsertStmtContext.class,0);
		}
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public UpdateStmtContext updateStmt() {
			return getRuleContext(UpdateStmtContext.class,0);
		}
		public DeleteStmtContext deleteStmt() {
			return getRuleContext(DeleteStmtContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitSentencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentencia);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				createTable();
				setState(66);
				match(T__0);
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				insertStmt();
				setState(69);
				match(T__0);
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				selectStmt();
				setState(72);
				match(T__0);
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				updateStmt();
				setState(75);
				match(T__0);
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				deleteStmt();
				setState(78);
				match(T__0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(CRUDParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(CRUDParser.TABLE, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public DefCampoListaContext defCampoLista() {
			return getRuleContext(DefCampoListaContext.class,0);
		}
		public OptPKContext optPK() {
			return getRuleContext(OptPKContext.class,0);
		}
		public CreateTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableContext createTable() throws RecognitionException {
		CreateTableContext _localctx = new CreateTableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_createTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(CREATE);
			setState(83);
			match(TABLE);
			setState(84);
			match(ID);
			setState(85);
			match(T__1);
			setState(86);
			defCampoLista();
			setState(87);
			optPK();
			setState(88);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefCampoListaContext extends ParserRuleContext {
		public List<DefCampoContext> defCampo() {
			return getRuleContexts(DefCampoContext.class);
		}
		public DefCampoContext defCampo(int i) {
			return getRuleContext(DefCampoContext.class,i);
		}
		public DefCampoListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defCampoLista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitDefCampoLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefCampoListaContext defCampoLista() throws RecognitionException {
		DefCampoListaContext _localctx = new DefCampoListaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defCampoLista);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			defCampo();
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					match(T__3);
					setState(92);
					defCampo();
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefCampoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DefCampoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defCampo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitDefCampo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefCampoContext defCampo() throws RecognitionException {
		DefCampoContext _localctx = new DefCampoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defCampo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ID);
			setState(99);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CRUDParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(CRUDParser.FLOAT, 0); }
		public TerminalNode TEXT() { return getToken(CRUDParser.TEXT, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117440512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptPKContext extends ParserRuleContext {
		public TerminalNode PRIMARY() { return getToken(CRUDParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(CRUDParser.KEY, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public OptPKContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optPK; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitOptPK(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptPKContext optPK() throws RecognitionException {
		OptPKContext _localctx = new OptPKContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_optPK);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(103);
				match(T__3);
				setState(104);
				match(PRIMARY);
				setState(105);
				match(KEY);
				setState(106);
				match(T__1);
				setState(107);
				match(ID);
				setState(108);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InsertStmtContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(CRUDParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(CRUDParser.INTO, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public OptColsContext optCols() {
			return getRuleContext(OptColsContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(CRUDParser.VALUES, 0); }
		public ValorListaContext valorLista() {
			return getRuleContext(ValorListaContext.class,0);
		}
		public InsertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitInsertStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStmtContext insertStmt() throws RecognitionException {
		InsertStmtContext _localctx = new InsertStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_insertStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(INSERT);
			setState(112);
			match(INTO);
			setState(113);
			match(ID);
			setState(114);
			optCols();
			setState(115);
			match(VALUES);
			setState(116);
			match(T__1);
			setState(117);
			valorLista();
			setState(118);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptColsContext extends ParserRuleContext {
		public IdListaContext idLista() {
			return getRuleContext(IdListaContext.class,0);
		}
		public OptColsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optCols; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitOptCols(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptColsContext optCols() throws RecognitionException {
		OptColsContext _localctx = new OptColsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_optCols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(120);
				match(T__1);
				setState(121);
				idLista();
				setState(122);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdListaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CRUDParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CRUDParser.ID, i);
		}
		public IdListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idLista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitIdLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListaContext idLista() throws RecognitionException {
		IdListaContext _localctx = new IdListaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_idLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ID);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(127);
				match(T__3);
				setState(128);
				match(ID);
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorListaContext extends ParserRuleContext {
		public List<ValorContext> valor() {
			return getRuleContexts(ValorContext.class);
		}
		public ValorContext valor(int i) {
			return getRuleContext(ValorContext.class,i);
		}
		public ValorListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valorLista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitValorLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorListaContext valorLista() throws RecognitionException {
		ValorListaContext _localctx = new ValorListaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_valorLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			valor();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(135);
				match(T__3);
				setState(136);
				valor();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(CRUDParser.NUM, 0); }
		public TerminalNode STR() { return getToken(CRUDParser.STR, 0); }
		public TerminalNode TRUE() { return getToken(CRUDParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CRUDParser.FALSE, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 412329443328L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectStmtContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(CRUDParser.SELECT, 0); }
		public SeleccionContext seleccion() {
			return getRuleContext(SeleccionContext.class,0);
		}
		public TerminalNode FROM() { return getToken(CRUDParser.FROM, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public OptWhereContext optWhere() {
			return getRuleContext(OptWhereContext.class,0);
		}
		public SelectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitSelectStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_selectStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SELECT);
			setState(145);
			seleccion();
			setState(146);
			match(FROM);
			setState(147);
			match(ID);
			setState(148);
			optWhere();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeleccionContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(CRUDParser.STAR, 0); }
		public IdListaContext idLista() {
			return getRuleContext(IdListaContext.class,0);
		}
		public SeleccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seleccion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitSeleccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeleccionContext seleccion() throws RecognitionException {
		SeleccionContext _localctx = new SeleccionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_seleccion);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(STAR);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				idLista();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptWhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(CRUDParser.WHERE, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public OptWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optWhere; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitOptWhere(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptWhereContext optWhere() throws RecognitionException {
		OptWhereContext _localctx = new OptWhereContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_optWhere);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(154);
				match(WHERE);
				setState(155);
				boolExpr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateStmtContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(CRUDParser.UPDATE, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public TerminalNode SET() { return getToken(CRUDParser.SET, 0); }
		public AsignListaContext asignLista() {
			return getRuleContext(AsignListaContext.class,0);
		}
		public OptWhereContext optWhere() {
			return getRuleContext(OptWhereContext.class,0);
		}
		public UpdateStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitUpdateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateStmtContext updateStmt() throws RecognitionException {
		UpdateStmtContext _localctx = new UpdateStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_updateStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(UPDATE);
			setState(159);
			match(ID);
			setState(160);
			match(SET);
			setState(161);
			asignLista();
			setState(162);
			optWhere();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignListaContext extends ParserRuleContext {
		public List<AsignContext> asign() {
			return getRuleContexts(AsignContext.class);
		}
		public AsignContext asign(int i) {
			return getRuleContext(AsignContext.class,i);
		}
		public AsignListaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignLista; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitAsignLista(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignListaContext asignLista() throws RecognitionException {
		AsignListaContext _localctx = new AsignListaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_asignLista);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			asign();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(165);
				match(T__3);
				setState(166);
				asign();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public TerminalNode EQ() { return getToken(CRUDParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitAsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsignContext asign() throws RecognitionException {
		AsignContext _localctx = new AsignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_asign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(ID);
			setState(173);
			match(EQ);
			setState(174);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteStmtContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(CRUDParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(CRUDParser.FROM, 0); }
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public OptWhereContext optWhere() {
			return getRuleContext(OptWhereContext.class,0);
		}
		public DeleteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitDeleteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStmtContext deleteStmt() throws RecognitionException {
		DeleteStmtContext _localctx = new DeleteStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_deleteStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(DELETE);
			setState(177);
			match(FROM);
			setState(178);
			match(ID);
			setState(179);
			optWhere();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			term();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4 || _la==T__5) {
				{
				{
				setState(182);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				term();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactContext> fact() {
			return getRuleContexts(FactContext.class);
		}
		public FactContext fact(int i) {
			return getRuleContext(FactContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(CRUDParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(CRUDParser.STAR, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			fact();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==STAR) {
				{
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==STAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				fact();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public TerminalNode NUM() { return getToken(CRUDParser.NUM, 0); }
		public TerminalNode STR() { return getToken(CRUDParser.STR, 0); }
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fact);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(T__1);
				setState(198);
				expr();
				setState(199);
				match(T__2);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(ID);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(NUM);
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				match(STR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OpRelContext opRel() {
			return getRuleContext(OpRelContext.class,0);
		}
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_rel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			expr();
			setState(207);
			opRel();
			setState(208);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpRelContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(CRUDParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(CRUDParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(CRUDParser.LT, 0); }
		public TerminalNode LE() { return getToken(CRUDParser.LE, 0); }
		public TerminalNode GT() { return getToken(CRUDParser.GT, 0); }
		public TerminalNode GE() { return getToken(CRUDParser.GE, 0); }
		public OpRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opRel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitOpRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpRelContext opRel() throws RecognitionException {
		OpRelContext _localctx = new OpRelContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_opRel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33822867456L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ParserRuleContext {
		public List<BoolTContext> boolT() {
			return getRuleContexts(BoolTContext.class);
		}
		public BoolTContext boolT(int i) {
			return getRuleContext(BoolTContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CRUDParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CRUDParser.OR, i);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_boolExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			boolT();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(213);
				match(OR);
				setState(214);
				boolT();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolTContext extends ParserRuleContext {
		public List<BoolFContext> boolF() {
			return getRuleContexts(BoolFContext.class);
		}
		public BoolFContext boolF(int i) {
			return getRuleContext(BoolFContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(CRUDParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CRUDParser.AND, i);
		}
		public BoolTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolT; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitBoolT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolTContext boolT() throws RecognitionException {
		BoolTContext _localctx = new BoolTContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_boolT);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			boolF();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(221);
				match(AND);
				setState(222);
				boolF();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolFContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(CRUDParser.NOT, 0); }
		public BoolFContext boolF() {
			return getRuleContext(BoolFContext.class,0);
		}
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public TerminalNode ID() { return getToken(CRUDParser.ID, 0); }
		public TerminalNode TRUE() { return getToken(CRUDParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CRUDParser.FALSE, 0); }
		public BoolFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolF; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CRUDVisitor ) return ((CRUDVisitor<? extends T>)visitor).visitBoolF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolFContext boolF() throws RecognitionException {
		BoolFContext _localctx = new BoolFContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_boolF);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				match(NOT);
				setState(229);
				boolF();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(T__1);
				setState(231);
				boolExpr();
				setState(232);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				rel();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(236);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
				match(FALSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001)\u00f1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001=\b\u0001"+
		"\n\u0001\f\u0001@\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"Q\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004^\b\u0004\n\u0004\f\u0004a\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t}\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u0082"+
		"\b\n\n\n\f\n\u0085\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u008a\b\u000b\n\u000b\f\u000b\u008d\t\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0099\b\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u009d\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00a8\b\u0011\n\u0011\f\u0011"+
		"\u00ab\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u00b9\b\u0014\n\u0014\f\u0014\u00bc\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00c1\b\u0015\n\u0015\f\u0015"+
		"\u00c4\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u00cd\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u00d8\b\u0019\n\u0019\f\u0019\u00db\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u00e0\b\u001a\n\u001a\f\u001a"+
		"\u00e3\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u00ef\b\u001b\u0001\u001b\u0000\u0000\u001c\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"46\u0000\u0005\u0001\u0000\u0018\u001a\u0002\u0000\u0016\u0017%&\u0001"+
		"\u0000\u0005\u0006\u0002\u0000\u0007\u0007##\u0001\u0000\u001d\"\u00ed"+
		"\u00008\u0001\u0000\u0000\u0000\u0002>\u0001\u0000\u0000\u0000\u0004P"+
		"\u0001\u0000\u0000\u0000\u0006R\u0001\u0000\u0000\u0000\bZ\u0001\u0000"+
		"\u0000\u0000\nb\u0001\u0000\u0000\u0000\fe\u0001\u0000\u0000\u0000\u000e"+
		"m\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000\u0012|\u0001"+
		"\u0000\u0000\u0000\u0014~\u0001\u0000\u0000\u0000\u0016\u0086\u0001\u0000"+
		"\u0000\u0000\u0018\u008e\u0001\u0000\u0000\u0000\u001a\u0090\u0001\u0000"+
		"\u0000\u0000\u001c\u0098\u0001\u0000\u0000\u0000\u001e\u009c\u0001\u0000"+
		"\u0000\u0000 \u009e\u0001\u0000\u0000\u0000\"\u00a4\u0001\u0000\u0000"+
		"\u0000$\u00ac\u0001\u0000\u0000\u0000&\u00b0\u0001\u0000\u0000\u0000("+
		"\u00b5\u0001\u0000\u0000\u0000*\u00bd\u0001\u0000\u0000\u0000,\u00cc\u0001"+
		"\u0000\u0000\u0000.\u00ce\u0001\u0000\u0000\u00000\u00d2\u0001\u0000\u0000"+
		"\u00002\u00d4\u0001\u0000\u0000\u00004\u00dc\u0001\u0000\u0000\u00006"+
		"\u00ee\u0001\u0000\u0000\u000089\u0003\u0002\u0001\u00009:\u0005\u0000"+
		"\u0000\u0001:\u0001\u0001\u0000\u0000\u0000;=\u0003\u0004\u0002\u0000"+
		"<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000AB\u0003\u0006\u0003\u0000BC\u0005\u0001\u0000\u0000"+
		"CQ\u0001\u0000\u0000\u0000DE\u0003\u0010\b\u0000EF\u0005\u0001\u0000\u0000"+
		"FQ\u0001\u0000\u0000\u0000GH\u0003\u001a\r\u0000HI\u0005\u0001\u0000\u0000"+
		"IQ\u0001\u0000\u0000\u0000JK\u0003 \u0010\u0000KL\u0005\u0001\u0000\u0000"+
		"LQ\u0001\u0000\u0000\u0000MN\u0003&\u0013\u0000NO\u0005\u0001\u0000\u0000"+
		"OQ\u0001\u0000\u0000\u0000PA\u0001\u0000\u0000\u0000PD\u0001\u0000\u0000"+
		"\u0000PG\u0001\u0000\u0000\u0000PJ\u0001\u0000\u0000\u0000PM\u0001\u0000"+
		"\u0000\u0000Q\u0005\u0001\u0000\u0000\u0000RS\u0005\b\u0000\u0000ST\u0005"+
		"\t\u0000\u0000TU\u0005$\u0000\u0000UV\u0005\u0002\u0000\u0000VW\u0003"+
		"\b\u0004\u0000WX\u0003\u000e\u0007\u0000XY\u0005\u0003\u0000\u0000Y\u0007"+
		"\u0001\u0000\u0000\u0000Z_\u0003\n\u0005\u0000[\\\u0005\u0004\u0000\u0000"+
		"\\^\u0003\n\u0005\u0000][\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\t\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000bc\u0005$\u0000\u0000cd\u0003\f"+
		"\u0006\u0000d\u000b\u0001\u0000\u0000\u0000ef\u0007\u0000\u0000\u0000"+
		"f\r\u0001\u0000\u0000\u0000gh\u0005\u0004\u0000\u0000hi\u0005\u001b\u0000"+
		"\u0000ij\u0005\u001c\u0000\u0000jk\u0005\u0002\u0000\u0000kl\u0005$\u0000"+
		"\u0000ln\u0005\u0003\u0000\u0000mg\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000n\u000f\u0001\u0000\u0000\u0000op\u0005\n\u0000\u0000pq\u0005"+
		"\u000b\u0000\u0000qr\u0005$\u0000\u0000rs\u0003\u0012\t\u0000st\u0005"+
		"\f\u0000\u0000tu\u0005\u0002\u0000\u0000uv\u0003\u0016\u000b\u0000vw\u0005"+
		"\u0003\u0000\u0000w\u0011\u0001\u0000\u0000\u0000xy\u0005\u0002\u0000"+
		"\u0000yz\u0003\u0014\n\u0000z{\u0005\u0003\u0000\u0000{}\u0001\u0000\u0000"+
		"\u0000|x\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0013\u0001"+
		"\u0000\u0000\u0000~\u0083\u0005$\u0000\u0000\u007f\u0080\u0005\u0004\u0000"+
		"\u0000\u0080\u0082\u0005$\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000"+
		"\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0015\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u008b\u0003\u0018\f\u0000\u0087"+
		"\u0088\u0005\u0004\u0000\u0000\u0088\u008a\u0003\u0018\f\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0017"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0007\u0001\u0000\u0000\u008f\u0019\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\r\u0000\u0000\u0091\u0092\u0003\u001c\u000e\u0000\u0092\u0093\u0005"+
		"\u000e\u0000\u0000\u0093\u0094\u0005$\u0000\u0000\u0094\u0095\u0003\u001e"+
		"\u000f\u0000\u0095\u001b\u0001\u0000\u0000\u0000\u0096\u0099\u0005#\u0000"+
		"\u0000\u0097\u0099\u0003\u0014\n\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u001d\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005\u000f\u0000\u0000\u009b\u009d\u00032\u0019\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u001f\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u0010\u0000\u0000\u009f"+
		"\u00a0\u0005$\u0000\u0000\u00a0\u00a1\u0005\u0011\u0000\u0000\u00a1\u00a2"+
		"\u0003\"\u0011\u0000\u00a2\u00a3\u0003\u001e\u000f\u0000\u00a3!\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a9\u0003$\u0012\u0000\u00a5\u00a6\u0005\u0004"+
		"\u0000\u0000\u00a6\u00a8\u0003$\u0012\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa#\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005$\u0000\u0000\u00ad"+
		"\u00ae\u0005\u001d\u0000\u0000\u00ae\u00af\u0003(\u0014\u0000\u00af%\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\u0012\u0000\u0000\u00b1\u00b2\u0005"+
		"\u000e\u0000\u0000\u00b2\u00b3\u0005$\u0000\u0000\u00b3\u00b4\u0003\u001e"+
		"\u000f\u0000\u00b4\'\u0001\u0000\u0000\u0000\u00b5\u00ba\u0003*\u0015"+
		"\u0000\u00b6\u00b7\u0007\u0002\u0000\u0000\u00b7\u00b9\u0003*\u0015\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb)\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd"+
		"\u00c2\u0003,\u0016\u0000\u00be\u00bf\u0007\u0003\u0000\u0000\u00bf\u00c1"+
		"\u0003,\u0016\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3+\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0002\u0000\u0000\u00c6\u00c7\u0003(\u0014"+
		"\u0000\u00c7\u00c8\u0005\u0003\u0000\u0000\u00c8\u00cd\u0001\u0000\u0000"+
		"\u0000\u00c9\u00cd\u0005$\u0000\u0000\u00ca\u00cd\u0005%\u0000\u0000\u00cb"+
		"\u00cd\u0005&\u0000\u0000\u00cc\u00c5\u0001\u0000\u0000\u0000\u00cc\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd-\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003"+
		"(\u0014\u0000\u00cf\u00d0\u00030\u0018\u0000\u00d0\u00d1\u0003(\u0014"+
		"\u0000\u00d1/\u0001\u0000\u0000\u0000\u00d2\u00d3\u0007\u0004\u0000\u0000"+
		"\u00d31\u0001\u0000\u0000\u0000\u00d4\u00d9\u00034\u001a\u0000\u00d5\u00d6"+
		"\u0005\u0014\u0000\u0000\u00d6\u00d8\u00034\u001a\u0000\u00d7\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da3\u0001\u0000"+
		"\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e1\u00036\u001b"+
		"\u0000\u00dd\u00de\u0005\u0013\u0000\u0000\u00de\u00e0\u00036\u001b\u0000"+
		"\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e25\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0015\u0000\u0000\u00e5\u00ef\u00036\u001b\u0000\u00e6\u00e7"+
		"\u0005\u0002\u0000\u0000\u00e7\u00e8\u00032\u0019\u0000\u00e8\u00e9\u0005"+
		"\u0003\u0000\u0000\u00e9\u00ef\u0001\u0000\u0000\u0000\u00ea\u00ef\u0003"+
		".\u0017\u0000\u00eb\u00ef\u0005$\u0000\u0000\u00ec\u00ef\u0005\u0016\u0000"+
		"\u0000\u00ed\u00ef\u0005\u0017\u0000\u0000\u00ee\u00e4\u0001\u0000\u0000"+
		"\u0000\u00ee\u00e6\u0001\u0000\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ee\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ef7\u0001\u0000\u0000\u0000"+
		"\u0010>P_m|\u0083\u008b\u0098\u009c\u00a9\u00ba\u00c2\u00cc\u00d9\u00e1"+
		"\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}