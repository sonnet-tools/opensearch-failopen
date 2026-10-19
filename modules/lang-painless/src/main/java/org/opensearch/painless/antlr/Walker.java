            rtnType,
            } else {
    public ANode visitIf(IfContext ctx) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
    private void setupPicky(PainlessParser parser) {
    public ANode visitArguments(ArgumentsContext ctx) {
        List<SCatch> catches = new ArrayList<>();  
        }
    @Override
    public ANode visitAssignment(AssignmentContext ctx) {
import org.opensearch.painless.node.ELambda;
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
 */
        } else if (ctx.ASUB() != null) {  
    @Override
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        AExpression condition = (AExpression) visit(ctx.noncondexpression());  
import org.opensearch.painless.antlr.PainlessParser.DeclarationContext;  
        } else if (ctx.GTE() != null) {  
        List<AStatement> statements = new ArrayList<>();
    @Override  
    @Override  
        } else if (ctx.LSH() != null) {
            return visit(ctx.block());
        return visit(ctx.mapinitializer());
        } else if (ctx.dstatement() != null) {
    }  
        for (TerminalNode id : ctx.parameters().ID()) {
        assert string.charAt(end) == '"' || string.charAt(end) == '\'' : "expected string to end with a quote was [" + string + "]";
import org.opensearch.painless.antlr.PainlessParser.FieldaccessContext;
        }
import org.opensearch.painless.antlr.PainlessParser.CompContext;
            paramTypes,
    }
    @Override
        return visit(ctx.chain());  
    @Override
            return visit(ctx.lambda());
            expressions.add((AExpression) visit(expression));
    public ANode visitDecl(DeclContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.MapinitializerContext;  
        return buildPostfixChain(new ENewArray(nextIdentifier(), location(ctx), type, expressions, true), null, ctx.postfix());
    public ANode visitLambda(LambdaContext ctx) {
            operation = Operation.GTE;
            operation = Operation.RSH;
            : new ENewArrayFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText());
        } else if (ctx.fieldaccess() != null) {
    public ANode visitInitializer(InitializerContext ctx) {
        } else {
            operation = Operation.SUB;  
    }  
                current = string.charAt(src);
    @Override
        String type = ctx.decltype().getText();
import org.opensearch.painless.node.EComp;  
    public ANode visitEmpty(EmptyContext ctx) {  
        } else if (ctx.AUSH() != null) {  
    private final String sourceName;
import org.antlr.v4.runtime.CommonTokenStream;  
        }
    private final SClass source;
    }  
    }
    }
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        AExpression child = (AExpression) visit(ctx.unarynotaddsub());  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
        } else if (ctx.AXOR() != null) {
        if (ctx.INCR() != null) {  
    @Override  
    }  
    @Override
    }  
    }
        SBlock block = (SBlock) visit(ctx.block());
    @Override  
        }
        AExpression expression = (AExpression) visit(ctx.expression());
            return new SWhile(nextIdentifier(), location(ctx), expression, block);  
            false,  
    public ANode visitMapinit(MapinitContext ctx) {
            operation = Operation.OR;
            operation = Operation.AND;
 * specific language governing permissions and limitations
    public AExpression visitPostfix(PostfixContext ctx, AExpression prefix) {
    }  
import org.antlr.v4.runtime.RecognitionException;  
        return new EAssignment(
            return new SBlock(nextIdentifier(), location(ctx), statements);
    public ANode visitLamtype(LamtypeContext ctx) {  
import org.opensearch.painless.node.EConditional;
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    }
            statements.add((AStatement) visit(ctx.statement()));
        }  
        String name = ctx.ID().getText();
    @Override  
import org.opensearch.painless.node.SDo;  
        } else if (ctx.expression() != null) {
    @Override
        int lastSlash = text.lastIndexOf('/');  
    public ANode visitAfterthought(AfterthoughtContext ctx) {
    public ANode visitArgument(ArgumentContext ctx) {
            for (StatementContext statement : ctx.statement()) {
        List<AExpression> keys = new ArrayList<>();
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new EBinary(nextIdentifier(), location(ctx), left, right, operation);  
    private int identifier;  
        return new EConditional(nextIdentifier(), location(ctx), condition, left, right);
import org.opensearch.painless.antlr.PainlessParser.TrueContext;  
        for (ExpressionContext expression : ctx.expression()) {
        SBlock block = (SBlock) visit(ctx.block());
    public ANode visitNewobject(NewobjectContext ctx) {  
            setupPicky(parser);  
    @Override  
import org.opensearch.painless.node.AExpression;
        } else if (ctx.SUB() != null) {
            }
    public ANode visitRead(ReadContext ctx) {
    }  
        return new Walker(sourceName, sourceText, settings).source;  
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
        return new SBreak(nextIdentifier(), location(ctx));
    }  
        List<String> paramNames = new ArrayList<>();
        // Strip the leading and trailing quotes and replace the escape sequences with their literal equivalents  
    public ANode visitConstructorfuncref(ConstructorfuncrefContext ctx) {
        String text = ctx.REGEX().getText();
            operation = Operation.REM;  
        if (ctx.LT() != null) {  
                final Recognizer<?, ?> recognizer,  
    @Override
        for (StatementContext statement : ctx.block().statement()) {  
        SBlock block = (SBlock) visit(ctx.block());
    }
        PainlessLexer lexer = new EnhancedPainlessLexer(stream, sourceName);
 * Modifications Copyright OpenSearch Contributors. See
            src++;
                Collections.singletonList(new SReturn(nextIdentifier(), location(ctx), expression))
import org.opensearch.painless.node.SContinue;  
        return identifier++;
    }
 * GitHub history for details.
            SBlock block = (SBlock) visit(ctx.trailer());
 *
        }
        // part of the overall class  
            return new SIfElse(nextIdentifier(), location(ctx), expression, ifblock, elseblock);
        List<AExpression> values = new ArrayList<>();  
        List<AExpression> arguments = collectArguments(ctx.arguments());
            operation = Operation.ADD;
import org.opensearch.painless.antlr.PainlessParser.InstanceofContext;
            expression,
        return new EBrace(nextIdentifier(), location(ctx), prefix, expression);
    @Override  
    }
    @Override
    }  
    }
        if (ctx.BOOLAND() != null) {
        while (src < end) {  
            true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
import org.opensearch.painless.antlr.PainlessParser.ListinitContext;
        );
        return new ESymbol(nextIdentifier(), location(ctx), name);  
    public ANode visitPostdot(PostdotContext ctx) {  
        return new EExplicit(nextIdentifier(), location(ctx), type, child);
        if (ctx.trailer() != null) {
import org.opensearch.painless.antlr.PainlessParser.ParametersContext;
    }
            operation = Operation.LSH;  
    public ANode visitBreak(BreakContext ctx) {  
        return visit(ctx.castexpression());
        return buildPostfixChain(primary, null, ctx.postfix());
import org.opensearch.painless.antlr.PainlessParser.TypeContext;
        List<String> paramNames = new ArrayList<>();
import org.opensearch.painless.antlr.PainlessParser.DecltypeContext;
        for (TrapContext trap : ctx.trap()) {
        } else {  
    public ANode visitMapinitializer(MapinitializerContext ctx) {
    @Override  
            new ENumeric(nextIdentifier(), location(ctx), "1", 10),  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new Location(sourceName, ctx.getStart().getStartIndex());
    }  
import org.opensearch.painless.antlr.PainlessParser.ContinueContext;
import org.opensearch.painless.node.EUnary;
            operation = Operation.DIV;
import org.opensearch.painless.antlr.PainlessParser.ExprContext;
                src++;  
            expression = (AExpression) visit(ctx.expression());  
import org.antlr.v4.runtime.BaseErrorListener;
                final RecognitionException e
import java.util.ArrayList;  
    }
import org.opensearch.painless.node.EMapInit;
import org.opensearch.painless.antlr.PainlessParser.FunctionContext;
    }
        final Operation operation;
        String flags = text.substring(lastSlash + 1);
 *
        SBlock block = (SBlock) visit(ctx.trailer());
            location(ctx),
    public ANode visitTrap(TrapContext ctx) {
    @Override
            values.add((AExpression) visit(maptoken.expression(1)));
    public ANode visitBraceaccess(BraceaccessContext ctx) {
            return visitFieldaccess(ctx.fieldaccess(), prefix);  
        String name = ctx.ID().getText();
    }  
        List<String> paramTypes = new ArrayList<>();  
import org.antlr.v4.runtime.DiagnosticErrorListener;
        } else {
        // Enable exact ambiguity detection (costly). we enable exact since its the default for
            operation = Operation.EQR;
    public ANode visitLocalfuncref(LocalfuncrefContext ctx) {
        } else if (ctx.BOOLOR() != null) {  
            operation = Operation.ADD;
        for (ArgumentContext argument : ctx.argument()) {
        parser.addErrorListener(new BaseErrorListener() {  
        } else {
        if (postdot != null) {
    @Override  
import org.opensearch.painless.antlr.PainlessParser.AddsubContext;
        }  
            }  
        for (StatementContext statement : ctx.statement()) {  
            name,  
import org.opensearch.painless.node.ENewObj;
import org.opensearch.painless.node.ECallLocal;
        } else if (ctx.AADD() != null) {
        } else if (ctx.empty() != null) {
import org.opensearch.painless.node.EAssignment;
                final String msg,
import org.opensearch.painless.antlr.PainlessParser.ClassfuncrefContext;  
            operation = Operation.SUB;  
    }
    }
        if (ctx.block() != null) {
        String type = ctx.type().getText();  
            location(ctx),
    public ANode visitListinit(ListinitContext ctx) {
import org.opensearch.painless.node.EDecimal;
 * not use this file except in compliance with the License.
import org.opensearch.painless.node.EElvis;
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (DeclvarContext declvar : ctx.declvar()) {
    }
import org.opensearch.painless.node.EExplicit;
        parser.setErrorHandler(strategy);  
    private int nextIdentifier() {
        } else {
        }
        final Operation operation;
import org.antlr.v4.runtime.ANTLRInputStream;
    }
        } else {  
            new ENewArray(nextIdentifier(), location(ctx), type.toString(), expressions, false),
            operation = Operation.LSH;  
            return visitBraceaccess(ctx.braceaccess(), prefix);
 */  
        final Operation operation;
    }  
            ctx.postfix()  
        final Operation operation;
import org.opensearch.painless.antlr.PainlessParser.NotContext;
    }
    @Override
            value = ctx.DOTID().getText();
import org.opensearch.painless.node.EBinary;  
import org.opensearch.painless.antlr.PainlessParser.TrapContext;
    public ANode visitClassfuncref(ClassfuncrefContext ctx) {
            new ENumeric(nextIdentifier(), location(ctx), "1", 10),  
                statements.add((AStatement) visit(statement));  
    public ANode visitVariable(VariableContext ctx) {  
        }
        );  
        return new ELambda(nextIdentifier(), location(ctx), paramTypes, paramNames, block);
    public ANode visitBool(BoolContext ctx) {
        StringBuilder string = new StringBuilder(ctx.STRING().getText());
    }
    public AExpression visitFieldaccess(FieldaccessContext ctx, AExpression prefix) {
 * under the License.  
    @Override
    public ANode visitPre(PreContext ctx) {
    @Override
        } else {
            paramNames.add(lamtype.ID().getText());
        String rtnType = ctx.decltype().getText();
        SBlock block = (SBlock) visit(ctx.trailer());
import org.opensearch.painless.node.ANode;  
            catches.add((SCatch) visit(trap));  
        AExpression primary = (AExpression) visit(ctx.primary());
    @Override
    @Override
        AExpression expression = (AExpression) visit(ctx.expression());
import java.util.List;
    }
            operation = Operation.BWOR;
        List<AStatement> statements = new ArrayList<>();
    public ANode visitStatement(StatementContext ctx) {
    public ANode visitTrailer(TrailerContext ctx) {  
        // a second listener to fail the test when the above happens.
    public ANode visitBinary(BinaryContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.ForContext;  
        return new SDo(nextIdentifier(), location(ctx), expression, block);
    public ANode visitFunction(FunctionContext ctx) {  
import org.opensearch.painless.antlr.PainlessParser.DeclContext;
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
    public static SClass buildPainlessTree(String sourceName, String sourceText, CompilerSettings settings) {
        // generate the execute method from the collected statements and parameters
            values.add((AExpression) visit(expression));  
import org.opensearch.painless.node.ESymbol;  
 * this file be licensed under the Apache-2.0 license or a
        if (ctx.BOOLNOT() != null) {  
import org.opensearch.painless.node.SWhile;
    public ANode visitInstanceof(InstanceofContext ctx) {  
            SBlock elseblock = (SBlock) visit(ctx.trailer(1));  
            declarations.add(new SDeclaration(nextIdentifier(), location(declvar), type, name, expression));
    public ANode visitComp(CompContext ctx) {
            operation = Operation.NER;  
        }  
        AExpression rhs = (AExpression) visit(ctx.expression());
import org.opensearch.painless.antlr.PainlessParser.FalseContext;
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.antlr.PainlessParser.StringContext;
    @Override
import org.antlr.v4.runtime.Recognizer;
    }  
            paramNames,
        final Operation operation;
import org.opensearch.painless.node.SIfElse;  
import org.opensearch.painless.antlr.PainlessParser.SingleContext;
        if (settings.isPicky()) {
    }
        }
    }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
    public ANode visitAddsub(AddsubContext ctx) {
        int end = string.length() - 1;  
import org.opensearch.painless.node.ENewArrayFunctionRef;  
    @Override  
            operation
    @Override
                nextIdentifier(),  
    }
    @Override  
    @Override  
    @Override  
        } else if (ctx.DIV() != null) {
        List<SFunction> functions = new ArrayList<>();
                paramTypes.add(lamtype.decltype().getText());
    @Override  
            operation = Operation.USH;
import org.opensearch.painless.antlr.PainlessParser.ConditionalContext;
    }
        return prefix;  
    public ANode visitNumeric(NumericContext ctx) {  
        this.settings = settings;
            operation = Operation.NOT;
    public ANode visitPrecedence(PrecedenceContext ctx) {
        if (ctx.DOTID() != null) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
import org.opensearch.painless.antlr.PainlessParser.TryContext;
            public void syntaxError(
import org.opensearch.painless.antlr.PainlessParser.PreContext;  
    @Override
    public ANode visitNotaddsub(NotaddsubContext ctx) {  
/**  
        return arguments;  
        }  
    @Override
    public ANode visitWhile(WhileContext ctx) {  
            operation = Operation.ADD;
        } else if (ctx.AREM() != null) {
        }  
        } else {
        this.identifier = 0;
        if (ctx.trailer() != null) {  
import org.opensearch.painless.antlr.PainlessParser.BraceaccessContext;
import org.opensearch.painless.node.EBooleanComp;
            if (lamtype.decltype() == null) {
    }
    @Override  
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
    @Override
        final String value;
            @Override
                final Object offendingSymbol,
        } else if (ctx.EQ() != null) {
import org.opensearch.painless.node.SThrow;
import org.opensearch.painless.node.EBrace;  
        } else {
    private SourceContext buildAntlrTree(String source) {
import org.opensearch.painless.antlr.PainlessParser.LamtypeContext;
import org.opensearch.painless.antlr.PainlessParser.MaptokenContext;
    }
    }
        if (ctx.statement().isEmpty() && ctx.dstatement() == null) {  
    @Override
            return visit(ctx.funcref());
            operation = Operation.LT;
        } else if (ctx.AAND() != null) {
        return ctx.decltype().LBRACE().isEmpty()
        parser.removeErrorListeners();  
    }  
    public ANode visitEach(EachContext ctx) {
        }
        return new ENewObj(nextIdentifier(), location(ctx), type, arguments);
        } else if (ctx.SUB() != null) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public AExpression visitBraceaccess(BraceaccessContext ctx, AExpression prefix) {
    @Override
            }
    }
    @Override  
        return new EAssignment(nextIdentifier(), location(ctx), lhs, rhs, false, operation);  
    }
            keys.add((AExpression) visit(maptoken.expression(0)));  
            "execute",  
    }
    @Override
        return new STry(nextIdentifier(), location(ctx), block, catches);  
package org.opensearch.painless.antlr;
    }  
        String name = ctx.ID().getText();
    }
    @Override  
        return new EInstanceof(nextIdentifier(), location(ctx), expr, type);
        } else if (ctx.DECR() != null) {
    public ANode visitThrow(ThrowContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.SourceContext;  
        } else if (ctx.DOTINTEGER() != null) {  
            return visitCallinvoke(ctx.callinvoke(), prefix);
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));  
            AExpression expression = declvar.expression() == null ? null : (AExpression) visit(declvar.expression());  
 * The OpenSearch Contributors require contributions made to  
    public ANode visitTry(TryContext ctx) {
        } else if (ctx.empty() != null) {
        AExpression expression = (AExpression) visit(ctx.expression());
            operation = Operation.RSH;
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));  
import org.opensearch.painless.antlr.PainlessParser.ElvisContext;  
        final Operation operation;
    public ANode visitNonconditional(NonconditionalContext ctx) {  
            operation = Operation.BWAND;  
    public ANode visitNewinitializedarray(NewinitializedarrayContext ctx) {
        return new EDot(nextIdentifier(), location(ctx), prefix, value, ctx.NSDOT() != null);  
import org.opensearch.painless.antlr.PainlessParser.NewarrayContext;
        }
            type.append("[]");
    public ANode visitRefcasttype(PainlessParser.RefcasttypeContext ctx) {
            operation = Operation.SUB;
        }  
            operation = null;  
        } else if (ctx.ARSH() != null) {
        AExpression left = (AExpression) visit(ctx.expression(0));
            return new EDecimal(nextIdentifier(), location(ctx), ctx.DECIMAL().getText());
        // DiagnosticErrorListener, life is too short to think about what 'inexact ambiguity' might mean.  
        if (ctx.DECIMAL() != null) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            nextIdentifier(),  
            }
    }  
        } else {
    public ANode visitDynamic(DynamicContext ctx) {
    private AExpression buildPostfixChain(AExpression primary, PostdotContext postdot, List<PostfixContext> postfixes) {
        String name = ctx.ID().getText();
        return new EComp(nextIdentifier(), location(ctx), left, right, operation);
        AExpression expression = ctx.expression() == null ? null : (AExpression) visit(ctx.expression());
        functions.add(execute);  
            return visit(ctx.rstatement());
        return new ECallLocal(nextIdentifier(), location(ctx), name, arguments);
    @Override  
import org.opensearch.painless.antlr.PainlessParser.EachContext;
import org.opensearch.painless.antlr.PainlessParser.CastContext;
        for (ExpressionContext expression : ctx.expression()) {
            return visitFieldaccess(ctx.fieldaccess(), prefix);
        AExpression expression = (AExpression) visit(ctx.unary());
        string.setLength(dest);
import java.util.Collections;
        } else {
    public ANode visitPostfix(PostfixContext ctx) {
        } else if (ctx.BWOR() != null) {  
        String name = ctx.ID().getText();  
        AExpression expr = (AExpression) visit(ctx.noncondexpression());
            false,
            emptyList(),
            SBlock block = (SBlock) visit(ctx.trailer());
import org.opensearch.painless.antlr.PainlessParser.DoContext;  
    private final CompilerSettings settings;  
            if (ctx.dstatement() != null) {  
import org.opensearch.painless.node.SCatch;
            operation = Operation.ADD;
        } else if (ctx.XOR() != null) {
    public ANode visitFor(ForContext ctx) {
        if (ctx.trailer().size() > 1) {
            return visit(ctx.declaration());
import org.opensearch.painless.node.EBooleanConstant;
    @Override
    @Override  
import org.opensearch.painless.node.EString;
    @Override  
            ctx.postdot(),
            statements.add((AStatement) visit(statement));
        return new EFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText(), ctx.ID().getText());  
    public ANode visitDeclvar(DeclvarContext ctx) {  
    private Location location(ParserRuleContext ctx) {
 * this work for additional information regarding copyright
        } else {
 * software distributed under the License is distributed on an
    public ANode visitFalse(FalseContext ctx) {
        }
        } else if (ctx.AOR() != null) {  
        String type = ctx.decltype().getText();
        } else if (ctx.FIND() != null) {
    public ANode visitDecltype(DecltypeContext ctx) {
            operation = Operation.LTE;  
    public ANode visitSingle(SingleContext ctx) {
        } else if (ctx.BWNOT() != null) {
            operation = Operation.BWOR;
        if (ctx.declaration() != null) {  
        if (ctx.expression() != null) {
    @Override  
 * compatible open source license.
    }
        AExpression expression = (AExpression) visit(ctx.chain());
    public ANode visitCalllocal(CalllocalContext ctx) {
import org.opensearch.painless.node.EInstanceof;
import org.opensearch.painless.antlr.PainlessParser.ListinitializerContext;  
        return new EMapInit(nextIdentifier(), location(ctx), keys, values);
    }
import org.opensearch.painless.antlr.PainlessParser.PostContext;  
import org.opensearch.painless.antlr.PainlessParser.PostdotContext;
import org.opensearch.painless.antlr.PainlessParser.AfterthoughtContext;  
        }
    @Override
        AExpression lhs = (AExpression) visit(ctx.noncondexpression());  
    @Override
    }
    @Override
        return new ENull(nextIdentifier(), location(ctx));
import org.opensearch.painless.antlr.PainlessParser.StatementContext;
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
import org.opensearch.painless.antlr.PainlessParser.LambdaContext;  
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        String name = ctx.ID().getText();  
    }
    }
    public ANode visitParameters(ParametersContext ctx) {  
            false,
        if (ctx.expression() != null) {
import static java.util.Collections.emptyList;
        for (DecltypeContext decltype : ctx.parameters().decltype()) {
            ? new EFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText(), ctx.NEW().getText())  
    }
        }
        List<AExpression> arguments = collectArguments(ctx.arguments());  
import org.opensearch.painless.antlr.PainlessParser.ArgumentContext;
import org.opensearch.painless.antlr.PainlessParser.NewinitializedarrayContext;  
        ANTLRInputStream stream = new ANTLRInputStream(source);  
    public ANode visitCallinvoke(CallinvokeContext ctx) {  
            operation = Operation.NE;
    @Override  
        } else {  
        ANode initializer = ctx.initializer() == null ? null : visit(ctx.initializer());  
        } else if (ctx.MATCH() != null) {  
    public ANode visitListinitializer(ListinitializerContext ctx) {
        SFunction execute = new SFunction(
import org.opensearch.painless.antlr.PainlessParser.VariableContext;  
        }
        SBlock ifblock = (SBlock) visit(ctx.trailer(0));  
        if (ctx.MUL() != null) {  
        );
import org.opensearch.painless.node.SIf;
        for (PostfixContext postfix : postfixes) {
        if (ctx.INCR() != null) {  
        return new ERegex(nextIdentifier(), location(ctx), pattern, flags);
    }  
        String type = ctx.type().getText();
import org.opensearch.painless.antlr.PainlessParser.PostfixContext;
    public AExpression visitPostdot(PostdotContext ctx, AExpression prefix) {
        AExpression expression = (AExpression) visit(ctx.expression());
    @Override
 */  
        return new EElvis(nextIdentifier(), location(ctx), left, right);
        } else {
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.node.SClass;
    }  
    public ANode visitTrue(TrueContext ctx) {  
        } else if (ctx.NE() != null) {  
        return new SThrow(nextIdentifier(), location(ctx), expression);
        AExpression expression = (AExpression) visit(ctx.chain());
    @Override
import org.opensearch.painless.CompilerSettings;
        return parser.source();
import org.opensearch.painless.node.ERegex;
        return visit(ctx.expression());
import org.opensearch.painless.antlr.PainlessParser.AssignmentContext;  
        return new EFunctionRef(nextIdentifier(), location(ctx), ctx.THIS().getText(), ctx.ID().getText());  
        final Operation operation;
    public ANode visitRegex(RegexContext ctx) {
    @Override  
import org.opensearch.painless.node.SBlock;
    public ANode visitNewstandardarray(NewstandardarrayContext ctx) {  
import org.opensearch.painless.antlr.PainlessParser.NotaddsubContext;
import org.opensearch.painless.antlr.PainlessParser.BinaryContext;
        AExpression expression = (AExpression) visit(ctx.expression());  
        return visit(ctx.arrayinitializer());  
        if (ctx.ASSIGN() != null) {
/*  
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new SDeclBlock(nextIdentifier(), location(ctx), declarations);
import org.opensearch.painless.antlr.PainlessParser.BlockContext;
 * license agreements. See the NOTICE file distributed with
            location(ctx),
    public ANode visitReturn(ReturnContext ctx) {
    }  
            operation = Operation.USH;
        return new SExpression(nextIdentifier(), location(ctx), expression);
        String type = ctx.type().getText() + "[]";  
            location(ctx),
        });  
        AExpression afterthought = ctx.afterthought() == null ? null : (AExpression) visit(ctx.afterthought());
import org.opensearch.painless.node.SReturn;
    }  
        } else if (ctx.braceaccess() != null) {
    }
    public ANode visitSource(SourceContext ctx) {  
        } else if (ctx.USH() != null) {  
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
        final Operation operation;  
        return visit(ctx.unary());  
    }  
        for (LamtypeContext lamtype : ctx.lamtype()) {
    public ANode visitDeclaration(DeclarationContext ctx) {  
        }  
    }
            value = ctx.DOTINTEGER().getText();
    @Override
            "<internal>",
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
        } else if (ctx.fieldaccess() != null) {
            return new SFor(nextIdentifier(), location(ctx), initializer, expression, afterthought, null);  
        if (ctx.callinvoke() != null) {  
            operation = Operation.EQ;  
    @Override
    public ANode visitElvis(ElvisContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.WhileContext;
        return new EExplicit(nextIdentifier(), location(ctx), type, child);  
    private Walker(String sourceName, String sourceText, CompilerSettings settings) {
 * KIND, either express or implied.  See the License for the
        } else if (ctx.ADIV() != null) {  
    public ANode visitBlock(BlockContext ctx) {
        String pattern = text.substring(1, lastSlash);
import org.opensearch.painless.antlr.PainlessParser.InitializerContext;
        return buildPostfixChain(  
import org.antlr.v4.runtime.atn.PredictionMode;
        return new SContinue(nextIdentifier(), location(ctx));
        } else {  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));  
        }  
    public ANode visitPrimordefcasttype(PainlessParser.PrimordefcasttypeContext ctx) {  
        }
            operation = Operation.GT;
    @Override  
            return visit(ctx.dstatement());  
        } else if (ctx.EQR() != null) {
    @Override  
    public ANode visitExpr(ExprContext ctx) {
        AExpression expression = (AExpression) visit(ctx.expression());  
            String name = declvar.ID().getText();
    }
    }
        return new EUnary(nextIdentifier(), location(ctx), expression, operation);
        } else {
        } else if (ctx.INTEGER() != null) {
            paramTypes.add(decltype.getText());
    }
import org.opensearch.painless.antlr.PainlessParser.CallinvokeContext;  
        } else if (ctx.DECR() != null) {
            ) {  
        }  
    @Override
    @Override
    }
    @Override  
    }  
            expressions.add((AExpression) visit(expression));  
        } else if (ctx.RSH() != null) {
        } else {
    }  
    @Override
        if (ctx.rstatement() != null) {  
            false,
import org.opensearch.painless.node.SBreak;  
        return new SEach(nextIdentifier(), location(ctx), type, name, expression, block);
            new SBlock(nextIdentifier(), location(ctx), statements),  
        return visit(ctx.unarynotaddsub());
    }  
            dest++;
            nextIdentifier(),  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitMaptoken(MaptokenContext ctx) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitIneach(IneachContext ctx) {
    }
            block = (SBlock) visit(ctx.block());
            true,
        }  
        } else if (ctx.lambda() != null) {
            );  
        return new EBooleanConstant(nextIdentifier(), location(ctx), false);  
                final int charPositionInLine,  
            return new ENumeric(nextIdentifier(), location(ctx), ctx.OCTAL().getText().substring(1), 8);
 * SPDX-License-Identifier: Apache-2.0
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));
                paramTypes.add(null);  
        }  
import org.opensearch.painless.antlr.PainlessParser.CalllocalContext;
        parser.addErrorListener(new DiagnosticErrorListener(true));
            List<AStatement> statements = new ArrayList<>();
            string.setCharAt(dest, current);  
    }  
            operation = Operation.SUB;  
            emptyList(),
        return visit(ctx.declaration());  
        List<String> paramTypes = new ArrayList<>();  
import org.opensearch.painless.antlr.PainlessParser.ExpressionContext;  
        return new SReturn(nextIdentifier(), location(ctx), expression);  
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));  
        }
    @Override
        AExpression expression = null;  
        this.source = (SClass) visit(buildAntlrTree(sourceText));
        String type = ctx.decltype().getText();
            false
import org.opensearch.painless.antlr.PainlessParser.RegexContext;  
    public ANode visitType(TypeContext ctx) {
        }
            // single expression  
import org.opensearch.painless.node.ENull;
        } else if (ctx.HEX() != null) {  
        AExpression right = (AExpression) visit(ctx.expression(1));
            return new SBlock(nextIdentifier(), location(ctx), statements);
    @Override
    }
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        } else if (ctx.AMUL() != null) {
        return new EListInit(nextIdentifier(), location(ctx), values);  
    }  
    public ANode visitNot(NotContext ctx) {
    }
            statements.add((AStatement) visit(ctx.block().dstatement()));
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.node.SFunction;
        }  
        String type = ctx.refcasttype().getText();
        String type = ctx.primordefcasttype().getText();  
            nextIdentifier(),  
            return new ENumeric(nextIdentifier(), location(ctx), ctx.HEX().getText().substring(2), 16);
            return new SFor(nextIdentifier(), location(ctx), initializer, expression, afterthought, block);
        } else if (ctx.NER() != null) {
        }
import org.opensearch.painless.antlr.PainlessParser.TrailerContext;
        }
            if (current == '\\') {
            false,
            nextIdentifier(),  
    @Override  
        List<SDeclaration> declarations = new ArrayList<>();
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        SBlock block;
        List<AExpression> arguments = new ArrayList<>();  
            operation = Operation.SUB;  
        } else if (ctx.GT() != null) {
        assert string.charAt(0) == '"' || string.charAt(0) == '\'' : "expected string to start with a quote but was [" + string + "]";
        List<AExpression> arguments = collectArguments(ctx.arguments());  
    }
    @Override
        }
        } else if (ctx.funcref() != null) {  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    @Override
            new SBlock(nextIdentifier(), location(ctx), statements),  
        if (ctx.expression() != null) {
        PainlessParser parser = new PainlessParser(new CommonTokenStream(lexer));
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.antlr.v4.runtime.tree.TerminalNode;  
import org.opensearch.painless.antlr.PainlessParser.NewobjectContext;
        }
    }  
        return new SCatch(nextIdentifier(), location(ctx), Exception.class, type, name, block);
    }
        AExpression prefix = primary;
            AExpression expression = (AExpression) visit(ctx.expression());
        List<AExpression> expressions = new ArrayList<>();
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitNewarray(NewarrayContext ctx) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        }
        return new ECall(nextIdentifier(), location(ctx), prefix, name, arguments, ctx.NSDOT() != null);
    }
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));  
            operation = Operation.FIND;
        this.sourceName = sourceName;  
                final int line,
            operation = Operation.DIV;  
        } else {
        } else if (ctx.REM() != null) {
import org.opensearch.painless.antlr.PainlessParser.NonconditionalContext;  
/*  
        AExpression expression = (AExpression) visit(ctx.expression());
    @Override
        return visit(ctx.listinitializer());  
        AExpression expression = (AExpression) visit(ctx.unary());
        for (FunctionContext function : ctx.function()) {  
import org.opensearch.painless.node.ENumeric;  
        List<AExpression> expressions = new ArrayList<>();
        }
        return new SClass(nextIdentifier(), location(ctx), functions);
            block = new SBlock(
 * Converts the ANTLR tree to a Painless tree.
            false,  
import org.opensearch.painless.antlr.PainlessParser.ArgumentsContext;
import org.opensearch.painless.antlr.PainlessParser.NewstandardarrayContext;
 * Unless required by applicable law or agreed to in writing,
        // Diagnostic listener invokes syntaxError on other listeners for ambiguity issues,  
                location(ctx),
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.node.SEach;
        StringBuilder type = new StringBuilder(ctx.type().getText());
import org.opensearch.painless.antlr.PainlessParser.LocalfuncrefContext;
            expression,
import org.opensearch.painless.node.STry;  
import org.opensearch.painless.node.EDot;  
    }
        // because the statements come loose from the grammar as
                throw new AssertionError("line: " + line + ", offset: " + charPositionInLine + ", symbol:" + offendingSymbol + " " + msg);
import org.opensearch.painless.antlr.PainlessParser.EmptyContext;
    @Override
            operation = Operation.MATCH;
        } else {
    }
 * You may obtain a copy of the License at  
        } else if (ctx.LTE() != null) {
            paramNames.add(id.getText());  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    }  
        } else if (ctx.ALSH() != null) {
            return visit(ctx.expression());  
    }
        int dest = 0;
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new EString(nextIdentifier(), location(ctx), string.toString());  
/*
}
import org.opensearch.painless.antlr.PainlessParser.ConstructorfuncrefContext;  
    public ANode visitDo(DoContext ctx) {  
import org.opensearch.painless.antlr.PainlessParser.DeclvarContext;
import org.opensearch.painless.Operation;
import org.opensearch.painless.antlr.PainlessParser.IfContext;
import org.opensearch.painless.antlr.PainlessParser.BreakContext;
        }
        }  
public final class Walker extends PainlessParserBaseVisitor<ANode> {  
        return visit(ctx.noncondexpression());
import org.opensearch.painless.node.EFunctionRef;  
            return new ENumeric(nextIdentifier(), location(ctx), ctx.INTEGER().getText(), 10);  
        );
        } else if (ctx.statement() != null) {  
        if (ctx.block().dstatement() != null) {
        return visit(ctx.expression());
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    private List<AExpression> collectArguments(ArgumentsContext ctx) {
        return new EBooleanConstant(nextIdentifier(), location(ctx), true);
        }  
    public ANode visitPost(PostContext ctx) {
    }
        AExpression expression = (AExpression) visit(ctx.expression());
    }  
    @Override
        if (ctx.ADD() != null) {  
    @Override
        } else if (ctx.BWAND() != null) {
    @Override
import org.opensearch.painless.antlr.PainlessParser.IneachContext;  
            operation = Operation.ADD;
            prefix = visitPostdot(postdot, prefix);
    public ANode visitPrimordefcast(PainlessParser.PrimordefcastContext ctx) {
import org.opensearch.painless.node.SDeclaration;
    public ANode visitRefcast(PainlessParser.RefcastContext ctx) {
            return null;
import org.opensearch.painless.node.ENewArray;
import org.opensearch.painless.antlr.PainlessParser.NullContext;  
            operation = Operation.MUL;
    @Override
import org.opensearch.painless.node.SExpression;
import org.opensearch.painless.antlr.PainlessParser.BoolContext;  
            operation = Operation.REM;
            operation = Operation.XOR;
        ParserErrorStrategy strategy = new ParserErrorStrategy(sourceName);  
    public ANode visitString(StringContext ctx) {  
            operation = Operation.XOR;
        }
    @Override
        if (ctx.callinvoke() != null) {
 * the Apache License, Version 2.0 (the "License"); you may
            prefix = visitPostfix(postfix, prefix);  
            functions.add((SFunction) visit(function));
    }
    }  
            statements.add((AStatement) visit(statement));
import org.opensearch.painless.node.EListInit;  
            List<AStatement> statements = new ArrayList<>();  
            arguments.add((AExpression) visit(argument));  
        AExpression child = (AExpression) visit(ctx.unary());
            false
    }
import org.opensearch.painless.antlr.PainlessParser.ReadContext;
        List<AExpression> values = new ArrayList<>();  
        }
        return new SEach(nextIdentifier(), location(ctx), "def", name, expression, block);
    @Override
        // handle the code to generate the execute method here
    }
import org.opensearch.painless.antlr.PainlessParser.DynamicContext;
    @Override
import org.opensearch.painless.node.SDeclBlock;
        } else if (ctx.OCTAL() != null) {
        String name = ctx.DOTID().getText();
    }
    public ANode visitNull(NullContext ctx) {
    public ANode visitCast(CastContext ctx) {  
        for (ExpressionContext expression : ctx.expression()) {  
        return new EBooleanComp(nextIdentifier(), location(ctx), left, right, operation);  
    }
            operation
    }
        );  
import org.opensearch.painless.node.AStatement;
            operation = Operation.BWAND;  
            return visit(ctx.expression());  
    }
        } else {
        return new EAssignment(
    public ANode visitConditional(ConditionalContext ctx) {
    public ANode visitContinue(ContinueContext ctx) {
        for (MaptokenContext maptoken : ctx.maptoken()) {
            return visitCallinvoke(ctx.callinvoke(), prefix);  
import org.opensearch.painless.antlr.PainlessParser.ThrowContext;  
import org.opensearch.painless.antlr.PainlessParser.MapinitContext;
import org.opensearch.painless.antlr.PainlessParser.NumericContext;
            return new SIf(nextIdentifier(), location(ctx), expression, ifblock);
            char current = string.charAt(src);
        } else if (ctx.ADD() != null) {  
    @Override
import org.opensearch.painless.Location;  
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        lexer.removeErrorListeners();
import org.opensearch.painless.node.SFor;  
        return new EUnary(nextIdentifier(), location(ctx), expression, operation);
            operation = Operation.MUL;
 *  
        int src = 1;
    }
        return new SFunction(
    public AExpression visitCallinvoke(CallinvokeContext ctx, AExpression prefix) {
            operation = Operation.BWNOT;  
            }
import org.antlr.v4.runtime.ParserRuleContext;
            return new SWhile(nextIdentifier(), location(ctx), expression, null);
import org.opensearch.painless.node.ECall;
    @Override
        } else {  
 */
                statements.add((AStatement) visit(ctx.dstatement()));
import org.opensearch.painless.antlr.PainlessParser.ReturnContext;
import org.opensearch.painless.antlr.PainlessParser.PrecedenceContext;
    public ANode visitFieldaccess(FieldaccessContext ctx) {  
