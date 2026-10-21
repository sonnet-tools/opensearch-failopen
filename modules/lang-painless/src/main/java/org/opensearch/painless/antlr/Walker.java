        } else {
            operation = Operation.EQ;
            operation = Operation.NE;
    }
        } else if (ctx.DECR() != null) {
    public ANode visitDynamic(DynamicContext ctx) {
 * GitHub history for details.
    public ANode visitNotaddsub(NotaddsubContext ctx) {
        return identifier++;
        }
                statements.add((AStatement) visit(statement));
        }
        return new SReturn(nextIdentifier(), location(ctx), expression);
            String name = declvar.ID().getText();
            operation = Operation.DIV;
            operation = Operation.SUB;
    }
            return visit(ctx.block());
 *
    @Override
    public ANode visitElvis(ElvisContext ctx) {
import org.opensearch.painless.node.SBreak;
 * Modifications Copyright OpenSearch Contributors. See
        functions.add(execute);
    public ANode visitArguments(ArgumentsContext ctx) {
        // Diagnostic listener invokes syntaxError on other listeners for ambiguity issues,
import org.opensearch.painless.antlr.PainlessParser.ReturnContext;
        } else if (ctx.HEX() != null) {
            paramNames.add(lamtype.ID().getText());
        parser.setErrorHandler(strategy);
            statements.add((AStatement) visit(ctx.block().dstatement()));
            statements.add((AStatement) visit(statement));
    @Override
/*
            List<AStatement> statements = new ArrayList<>();
import org.opensearch.painless.node.EComp;
import org.opensearch.painless.antlr.PainlessParser.BraceaccessContext;
        AExpression expression = (AExpression) visit(ctx.expression());
    }
            SBlock block = (SBlock) visit(ctx.trailer());
    }
            type.append("[]");
    @Override
            operation = Operation.XOR;
            operation
/*
        lexer.removeErrorListeners();
        for (StatementContext statement : ctx.statement()) {
    @Override
        for (DeclvarContext declvar : ctx.declvar()) {
        String type = ctx.type().getText();
        }
    @Override
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return visit(ctx.arrayinitializer());
    @Override
        return new Location(sourceName, ctx.getStart().getStartIndex());
    }
            AExpression expression = declvar.expression() == null ? null : (AExpression) visit(declvar.expression());
            operation = Operation.FIND;
        AExpression expression = ctx.expression() == null ? null : (AExpression) visit(ctx.expression());
    @Override
import org.opensearch.painless.antlr.PainlessParser.NotContext;
    }
            return visitFieldaccess(ctx.fieldaccess(), prefix);
    public ANode visitStatement(StatementContext ctx) {
    @Override
        } else {
        } else if (ctx.ARSH() != null) {
            char current = string.charAt(src);
                current = string.charAt(src);
import org.opensearch.painless.antlr.PainlessParser.LamtypeContext;
/**
        } else {
            "<internal>",
        if (ctx.BOOLNOT() != null) {
        String type = ctx.refcasttype().getText();
        );
        String type = ctx.decltype().getText();
        return new EListInit(nextIdentifier(), location(ctx), values);
    public ANode visitClassfuncref(ClassfuncrefContext ctx) {
        if (ctx.DECIMAL() != null) {
/*
        } else if (ctx.NE() != null) {
import org.opensearch.painless.antlr.PainlessParser.CastContext;
        if (postdot != null) {
    @Override
    }
        } else if (ctx.AMUL() != null) {
        }
import org.opensearch.painless.antlr.PainlessParser.ListinitializerContext;
    @Override
        this.settings = settings;
            operation = Operation.XOR;
    @Override
    }
        String name = ctx.ID().getText();
import org.opensearch.painless.node.ENewArrayFunctionRef;
            src++;
            prefix = visitPostdot(postdot, prefix);
            operation = Operation.BWOR;
    }
    }
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        List<SFunction> functions = new ArrayList<>();
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.node.ENewArray;
    }
    public static SClass buildPainlessTree(String sourceName, String sourceText, CompilerSettings settings) {
        SBlock block = (SBlock) visit(ctx.trailer());
    public ANode visitEmpty(EmptyContext ctx) {
        if (ctx.trailer() != null) {
import org.opensearch.painless.node.AExpression;
        }
import org.opensearch.painless.antlr.PainlessParser.PreContext;
        return new EBrace(nextIdentifier(), location(ctx), prefix, expression);
        } else {
            false
import org.opensearch.painless.antlr.PainlessParser.DeclvarContext;
    public ANode visitFor(ForContext ctx) {
 * not use this file except in compliance with the License.
    public ANode visitCallinvoke(CallinvokeContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.TrueContext;
        // a second listener to fail the test when the above happens.
    }
        } else if (ctx.DECR() != null) {
    public ANode visitLambda(LambdaContext ctx) {
            return null;
        AExpression expression = (AExpression) visit(ctx.expression());
        );
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));
            operation = Operation.LSH;
            return new SBlock(nextIdentifier(), location(ctx), statements);
    }
    public ANode visitTrailer(TrailerContext ctx) {
        return visit(ctx.declaration());
    public AExpression visitBraceaccess(BraceaccessContext ctx, AExpression prefix) {
        }
import org.opensearch.painless.node.SThrow;
package org.opensearch.painless.antlr;
    }
            new SBlock(nextIdentifier(), location(ctx), statements),
        } else if (ctx.XOR() != null) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            location(ctx),
            statements.add((AStatement) visit(statement));
    public ANode visitBinary(BinaryContext ctx) {
            operation = Operation.GT;
import org.opensearch.painless.antlr.PainlessParser.BinaryContext;
            SBlock elseblock = (SBlock) visit(ctx.trailer(1));
        assert string.charAt(end) == '"' || string.charAt(end) == '\'' : "expected string to end with a quote was [" + string + "]";
            operation
    @Override
        } else if (ctx.DOTINTEGER() != null) {
    }
import org.opensearch.painless.antlr.PainlessParser.PostfixContext;
import org.opensearch.painless.node.SFunction;
import org.opensearch.painless.antlr.PainlessParser.ExpressionContext;
import org.opensearch.painless.antlr.PainlessParser.TrailerContext;
            return new SIf(nextIdentifier(), location(ctx), expression, ifblock);
import org.opensearch.painless.antlr.PainlessParser.ConditionalContext;
            operation = Operation.REM;
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));
        this.source = (SClass) visit(buildAntlrTree(sourceText));
import org.antlr.v4.runtime.ANTLRInputStream;
import org.opensearch.painless.node.SContinue;
            paramNames.add(id.getText());
            keys.add((AExpression) visit(maptoken.expression(0)));
 * this work for additional information regarding copyright
 */
            return visit(ctx.dstatement());
    @Override
        } else {
            new ENewArray(nextIdentifier(), location(ctx), type.toString(), expressions, false),
        } else {
            operation = Operation.USH;
            expressions.add((AExpression) visit(expression));
    }
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.painless.antlr.PainlessParser.StringContext;
            new ENumeric(nextIdentifier(), location(ctx), "1", 10),
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));
            operation = Operation.OR;
import org.opensearch.painless.antlr.PainlessParser.EmptyContext;
        if (ctx.ADD() != null) {
    @Override
        }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            operation = Operation.AND;
        }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        } else if (ctx.dstatement() != null) {
        } else if (ctx.AAND() != null) {
        } else {
import org.opensearch.painless.antlr.PainlessParser.CalllocalContext;
    }
    }
        } else if (ctx.RSH() != null) {
        } else if (ctx.fieldaccess() != null) {
    public ANode visitContinue(ContinueContext ctx) {
        // because the statements come loose from the grammar as
    public ANode visitAssignment(AssignmentContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.LocalfuncrefContext;
 */
            operation = Operation.MUL;
    @Override
            operation = Operation.MATCH;
    }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitCalllocal(CalllocalContext ctx) {
            catches.add((SCatch) visit(trap));
import org.opensearch.painless.antlr.PainlessParser.DoContext;
            }
        List<AExpression> values = new ArrayList<>();
import org.opensearch.painless.antlr.PainlessParser.BoolContext;
        parser.removeErrorListeners();
        AExpression afterthought = ctx.afterthought() == null ? null : (AExpression) visit(ctx.afterthought());
        } else if (ctx.AREM() != null) {
    }
            dest++;
    public ANode visitInitializer(InitializerContext ctx) {
        return new SBreak(nextIdentifier(), location(ctx));
        PainlessLexer lexer = new EnhancedPainlessLexer(stream, sourceName);
        }
    @Override
    }
            functions.add((SFunction) visit(function));
import org.opensearch.painless.antlr.PainlessParser.EachContext;
                statements.add((AStatement) visit(ctx.dstatement()));
        String name = ctx.ID().getText();
        } else if (ctx.ADIV() != null) {
        String flags = text.substring(lastSlash + 1);
        ParserErrorStrategy strategy = new ParserErrorStrategy(sourceName);
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        }
        return new EUnary(nextIdentifier(), location(ctx), expression, operation);
            operation = Operation.NER;
    public ANode visitTry(TryContext ctx) {
        }
    @Override
    public ANode visitPrimordefcasttype(PainlessParser.PrimordefcasttypeContext ctx) {
        return visit(ctx.unarynotaddsub());
        PainlessParser parser = new PainlessParser(new CommonTokenStream(lexer));
        parser.addErrorListener(new BaseErrorListener() {
            return visitCallinvoke(ctx.callinvoke(), prefix);
    public ANode visitPost(PostContext ctx) {
            if (current == '\\') {
    }
import org.opensearch.painless.node.SDo;
            operation = Operation.USH;
    }
    }
    public ANode visitLocalfuncref(LocalfuncrefContext ctx) {
    public ANode visitThrow(ThrowContext ctx) {
    }
    public ANode visitNewinitializedarray(NewinitializedarrayContext ctx) {
            );
    @Override
        } else {
        } else if (ctx.BOOLOR() != null) {
        return new SEach(nextIdentifier(), location(ctx), "def", name, expression, block);
    public ANode visitSource(SourceContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.NumericContext;
        AExpression right = (AExpression) visit(ctx.noncondexpression(1));
    public ANode visitVariable(VariableContext ctx) {
import org.opensearch.painless.Location;
    }
            nextIdentifier(),
        return parser.source();
import org.opensearch.painless.antlr.PainlessParser.AfterthoughtContext;
        }
import org.opensearch.painless.node.EString;
            operation = Operation.ADD;
        List<AExpression> arguments = new ArrayList<>();
        String name = ctx.ID().getText();
            false
import org.opensearch.painless.node.SIfElse;
    @Override
            false,
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
 * under the License.
import org.opensearch.painless.antlr.PainlessParser.DeclarationContext;
        } else if (ctx.lambda() != null) {
        } else {
        String name = ctx.ID().getText();
    @Override
import org.opensearch.painless.node.STry;
    public ANode visitDeclvar(DeclvarContext ctx) {
    @Override
import org.opensearch.painless.antlr.PainlessParser.NonconditionalContext;
    }
import org.opensearch.painless.antlr.PainlessParser.ClassfuncrefContext;
            operation = Operation.LSH;
            false,
        }
        List<AExpression> arguments = collectArguments(ctx.arguments());
                final Recognizer<?, ?> recognizer,
import org.opensearch.painless.node.ENull;
    public ANode visitInstanceof(InstanceofContext ctx) {
        } else if (ctx.braceaccess() != null) {
    @Override
        assert string.charAt(0) == '"' || string.charAt(0) == '\'' : "expected string to start with a quote but was [" + string + "]";
        } else if (ctx.SUB() != null) {
            arguments.add((AExpression) visit(argument));
            block = new SBlock(
    @Override
            false,
    public AExpression visitCallinvoke(CallinvokeContext ctx, AExpression prefix) {
    @Override
        parser.addErrorListener(new DiagnosticErrorListener(true));
        } else if (ctx.LTE() != null) {
        // handle the code to generate the execute method here
    @Override
    public ANode visitDecl(DeclContext ctx) {
            operation = null;
import org.opensearch.painless.antlr.PainlessParser.PostContext;
        }
        }
    }
    }
        );
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.antlr.PainlessParser.SingleContext;
            nextIdentifier(),
import org.opensearch.painless.antlr.PainlessParser.BlockContext;
            return visit(ctx.expression());
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
    @Override
            return new EDecimal(nextIdentifier(), location(ctx), ctx.DECIMAL().getText());
import org.opensearch.painless.node.SFor;
import org.opensearch.painless.antlr.PainlessParser.DynamicContext;
            emptyList(),
        return new EFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText(), ctx.ID().getText());
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new SDo(nextIdentifier(), location(ctx), expression, block);
        String rtnType = ctx.decltype().getText();
    }
        if (ctx.trailer().size() > 1) {
        } else {
 * Licensed to Elasticsearch under one or more contributor
        // Enable exact ambiguity detection (costly). we enable exact since its the default for
    public ANode visitIf(IfContext ctx) {
 *
            }
import org.opensearch.painless.node.ENewObj;
import org.opensearch.painless.node.EConditional;
            operation = Operation.SUB;
                final int charPositionInLine,
            paramTypes.add(decltype.getText());
            operation = Operation.SUB;
    @Override
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitNewarray(NewarrayContext ctx) {
                final String msg,
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.painless.node.AStatement;
    }
        }
    public ANode visitComp(CompContext ctx) {
        return new EBooleanConstant(nextIdentifier(), location(ctx), true);
    public ANode visitBraceaccess(BraceaccessContext ctx) {
        } else if (ctx.BWAND() != null) {
 */
    public ANode visitNonconditional(NonconditionalContext ctx) {
 */
    @Override
            block = (SBlock) visit(ctx.block());
    }
 * compatible open source license.
    public ANode visitBool(BoolContext ctx) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        List<String> paramTypes = new ArrayList<>();
    @Override
    }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            expressions.add((AExpression) visit(expression));
        for (PostfixContext postfix : postfixes) {
        }
            return visit(ctx.lambda());
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.antlr.PainlessParser.BreakContext;
        if (ctx.expression() != null) {
import org.opensearch.painless.node.ERegex;
        AExpression rhs = (AExpression) visit(ctx.expression());
        return buildPostfixChain(primary, null, ctx.postfix());
            new SBlock(nextIdentifier(), location(ctx), statements),
        if (ctx.expression() != null) {
            return new ENumeric(nextIdentifier(), location(ctx), ctx.INTEGER().getText(), 10);
    }
        } else {
            return new SFor(nextIdentifier(), location(ctx), initializer, expression, afterthought, block);
 * specific language governing permissions and limitations
        String type = ctx.decltype().getText();
        List<AExpression> arguments = collectArguments(ctx.arguments());
    public ANode visitString(StringContext ctx) {
        } else if (ctx.INTEGER() != null) {
            SBlock block = (SBlock) visit(ctx.trailer());
        AExpression right = (AExpression) visit(ctx.expression(1));
    private final SClass source;
import org.antlr.v4.runtime.DiagnosticErrorListener;
        for (ExpressionContext expression : ctx.expression()) {
import org.opensearch.painless.antlr.PainlessParser.NotaddsubContext;
    @Override
        } else {
        return visit(ctx.castexpression());
    @Override
import org.opensearch.painless.antlr.PainlessParser.VariableContext;
import org.opensearch.painless.antlr.PainlessParser.FieldaccessContext;
            }
        } else if (ctx.ALSH() != null) {
        if (ctx.declaration() != null) {
        return prefix;
    }
    }
        return new ELambda(nextIdentifier(), location(ctx), paramTypes, paramNames, block);
            operation = Operation.NOT;
    public ANode visitDeclaration(DeclarationContext ctx) {
            operation = Operation.REM;
        } else if (ctx.ADD() != null) {
    }
import org.opensearch.painless.antlr.PainlessParser.IfContext;
 * SPDX-License-Identifier: Apache-2.0
        }
    public ANode visitListinitializer(ListinitializerContext ctx) {
 * software distributed under the License is distributed on an
import org.opensearch.painless.antlr.PainlessParser.DeclContext;
        return new EMapInit(nextIdentifier(), location(ctx), keys, values);
    }
        return new EExplicit(nextIdentifier(), location(ctx), type, child);
        } else {
            operation = Operation.SUB;
        if (ctx.ASSIGN() != null) {
            if (ctx.dstatement() != null) {
import org.opensearch.painless.antlr.PainlessParser.ExprContext;
    public ANode visitNumeric(NumericContext ctx) {
    }
import org.opensearch.painless.antlr.PainlessParser.ElvisContext;
        final Operation operation;
        return visit(ctx.chain());
import org.opensearch.painless.node.EBooleanConstant;
        List<AExpression> expressions = new ArrayList<>();
        SFunction execute = new SFunction(
import org.opensearch.painless.node.SReturn;
        } else if (ctx.ASUB() != null) {
        return new STry(nextIdentifier(), location(ctx), block, catches);
        }
    public ANode visitConditional(ConditionalContext ctx) {
        SBlock block = (SBlock) visit(ctx.block());
import org.opensearch.painless.antlr.PainlessParser.IneachContext;
import org.antlr.v4.runtime.CommonTokenStream;
        int lastSlash = text.lastIndexOf('/');
        }
        } else if (ctx.AXOR() != null) {
    }
import org.opensearch.painless.antlr.PainlessParser.ArgumentsContext;
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            operation = Operation.RSH;
        for (DecltypeContext decltype : ctx.parameters().decltype()) {
        int dest = 0;
        AExpression expression = null;
        AExpression expression = (AExpression) visit(ctx.unary());
        return new EFunctionRef(nextIdentifier(), location(ctx), ctx.THIS().getText(), ctx.ID().getText());
    @Override
    private List<AExpression> collectArguments(ArgumentsContext ctx) {
    @Override
    }
import org.opensearch.painless.antlr.PainlessParser.ContinueContext;
            return visitCallinvoke(ctx.callinvoke(), prefix);
        if (ctx.LT() != null) {
        }
    @Override
    public ANode visitRegex(RegexContext ctx) {
        } else {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import org.opensearch.painless.antlr.PainlessParser.PostdotContext;
 * You may obtain a copy of the License at
            operation = Operation.BWOR;
        return new EConditional(nextIdentifier(), location(ctx), condition, left, right);
        for (MaptokenContext maptoken : ctx.maptoken()) {
    public ANode visitPostfix(PostfixContext ctx) {
                final int line,
 * KIND, either express or implied.  See the License for the
    }
    @Override
import static java.util.Collections.emptyList;
    }
    }
        String type = ctx.type().getText() + "[]";
import org.opensearch.painless.node.SCatch;
    }
    }
        } else if (ctx.statement() != null) {
        }
        final Operation operation;
    public ANode visitNot(NotContext ctx) {
    public ANode visitDo(DoContext ctx) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ANode visitFalse(FalseContext ctx) {
        return new ENull(nextIdentifier(), location(ctx));
        List<AStatement> statements = new ArrayList<>();
        } else if (ctx.expression() != null) {
    public ANode visitEach(EachContext ctx) {
}
            false,
import org.opensearch.painless.node.ENumeric;
            value = ctx.DOTID().getText();
        AExpression primary = (AExpression) visit(ctx.primary());
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        }
import org.opensearch.painless.node.EBinary;
        for (ExpressionContext expression : ctx.expression()) {
        return new EBinary(nextIdentifier(), location(ctx), left, right, operation);
        return buildPostfixChain(new ENewArray(nextIdentifier(), location(ctx), type, expressions, true), null, ctx.postfix());
import java.util.List;
        return new EString(nextIdentifier(), location(ctx), string.toString());
        final Operation operation;
        } else if (ctx.LSH() != null) {
        AExpression prefix = primary;
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
        return new SFunction(
        if (settings.isPicky()) {
        }
        AExpression expression = (AExpression) visit(ctx.expression());
import org.opensearch.painless.node.SClass;
        } else if (ctx.MATCH() != null) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            operation = Operation.EQR;
    @Override
import org.opensearch.painless.node.ESymbol;
        for (TrapContext trap : ctx.trap()) {
        AExpression expression = (AExpression) visit(ctx.expression());
        String name = ctx.ID().getText();
            return new ENumeric(nextIdentifier(), location(ctx), ctx.OCTAL().getText().substring(1), 8);
import org.opensearch.painless.Operation;
        SBlock block = (SBlock) visit(ctx.trailer());
import org.opensearch.painless.node.EDot;
            string.setCharAt(dest, current);
import org.opensearch.painless.antlr.PainlessParser.MapinitContext;
            operation = Operation.SUB;
        } else if (ctx.empty() != null) {
    public ANode visitMapinitializer(MapinitializerContext ctx) {
                final Object offendingSymbol,
            "execute",
    }
            operation = Operation.GTE;
        return visit(ctx.expression());
    @Override
import org.opensearch.painless.antlr.PainlessParser.ReadContext;
import org.opensearch.painless.antlr.PainlessParser.NewinitializedarrayContext;
        AExpression expression = (AExpression) visit(ctx.expression());
import java.util.Collections;
    public ANode visitMaptoken(MaptokenContext ctx) {
    @Override
        } else if (ctx.NER() != null) {
    @Override
    }
        } else {
        } else if (ctx.BWOR() != null) {
            public void syntaxError(
    public ANode visitLamtype(LamtypeContext ctx) {
    private void setupPicky(PainlessParser parser) {
    @Override
        AExpression left = (AExpression) visit(ctx.expression(0));
import org.opensearch.painless.node.EInstanceof;
import org.opensearch.painless.node.EMapInit;
            false,
import org.antlr.v4.runtime.BaseErrorListener;
        for (LamtypeContext lamtype : ctx.lamtype()) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        AExpression expression = (AExpression) visit(ctx.chain());
        for (TerminalNode id : ctx.parameters().ID()) {
            return visit(ctx.funcref());
    public ANode visitSingle(SingleContext ctx) {
        AExpression expression = (AExpression) visit(ctx.expression());
    }
            for (StatementContext statement : ctx.statement()) {
        } else if (ctx.GT() != null) {
        final Operation operation;
import org.opensearch.painless.antlr.PainlessParser.FalseContext;
    public ANode visitNull(NullContext ctx) {
    private final String sourceName;
import org.antlr.v4.runtime.tree.TerminalNode;
        List<AExpression> arguments = collectArguments(ctx.arguments());
import org.opensearch.painless.antlr.PainlessParser.DecltypeContext;
    @Override
        AExpression child = (AExpression) visit(ctx.unary());
        } else if (ctx.USH() != null) {
        // generate the execute method from the collected statements and parameters
            operation = Operation.LTE;
    public ANode visitListinit(ListinitContext ctx) {
        }
    private AExpression buildPostfixChain(AExpression primary, PostdotContext postdot, List<PostfixContext> postfixes) {
import org.opensearch.painless.node.ECallLocal;
            List<AStatement> statements = new ArrayList<>();
    @Override
    @Override
        } else if (ctx.DIV() != null) {
        for (StatementContext statement : ctx.block().statement()) {
import org.opensearch.painless.antlr.PainlessParser.NewobjectContext;
    @Override
import org.opensearch.painless.node.EAssignment;
        String type = ctx.type().getText();
            operation = Operation.BWNOT;
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        }
    }
        }
        return new SCatch(nextIdentifier(), location(ctx), Exception.class, type, name, block);
        return visit(ctx.expression());
    @Override
        }
        AExpression expression = (AExpression) visit(ctx.expression());
        final Operation operation;
import org.opensearch.painless.antlr.PainlessParser.ListinitContext;
    }
 * Converts the ANTLR tree to a Painless tree.
import org.opensearch.painless.antlr.PainlessParser.ConstructorfuncrefContext;
        ANode initializer = ctx.initializer() == null ? null : visit(ctx.initializer());
        if (ctx.block() != null) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            nextIdentifier(),
    }
    }
    }
        if (ctx.expression() != null) {
        this.identifier = 0;
    @Override
import org.opensearch.painless.antlr.PainlessParser.AssignmentContext;
    @Override
        List<SCatch> catches = new ArrayList<>();
        AExpression expression = (AExpression) visit(ctx.expression());
import org.opensearch.painless.node.SDeclaration;
    private SourceContext buildAntlrTree(String source) {
import org.opensearch.painless.antlr.PainlessParser.ForContext;
        if (ctx.callinvoke() != null) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    }
    public ANode visitConstructorfuncref(ConstructorfuncrefContext ctx) {
    }
        String text = ctx.REGEX().getText();
    @Override
    }
        return new ECallLocal(nextIdentifier(), location(ctx), name, arguments);
                paramTypes.add(lamtype.decltype().getText());
    @Override
        List<String> paramNames = new ArrayList<>();
    @Override
import org.opensearch.painless.antlr.PainlessParser.ThrowContext;
        return new ENewObj(nextIdentifier(), location(ctx), type, arguments);
        } else if (ctx.funcref() != null) {
        }
import org.opensearch.painless.antlr.PainlessParser.MaptokenContext;
    public ANode visitIneach(IneachContext ctx) {
        return new EBooleanComp(nextIdentifier(), location(ctx), left, right, operation);
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            operation = Operation.ADD;
            prefix = visitPostfix(postfix, prefix);
    private Walker(String sourceName, String sourceText, CompilerSettings settings) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    public ANode visitRead(ReadContext ctx) {
            expression = (AExpression) visit(ctx.expression());
        if (ctx.BOOLAND() != null) {
            false,
    public ANode visitCast(CastContext ctx) {
            nextIdentifier(),
        AExpression condition = (AExpression) visit(ctx.noncondexpression());
        if (ctx.statement().isEmpty() && ctx.dstatement() == null) {
    }
        return new SContinue(nextIdentifier(), location(ctx));
import org.opensearch.painless.antlr.PainlessParser.StatementContext;
        return new SThrow(nextIdentifier(), location(ctx), expression);
        return new EElvis(nextIdentifier(), location(ctx), left, right);
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            emptyList(),
    @Override
            operation = Operation.ADD;
    public ANode visitBreak(BreakContext ctx) {
        List<SDeclaration> declarations = new ArrayList<>();
        }
    public ANode visitFieldaccess(FieldaccessContext ctx) {
import org.opensearch.painless.node.EFunctionRef;
    @Override
        return new EComp(nextIdentifier(), location(ctx), left, right, operation);
            statements.add((AStatement) visit(ctx.statement()));
import org.opensearch.painless.antlr.PainlessParser.MapinitializerContext;
            }
    @Override
            setupPicky(parser);
                final RecognitionException e
    public AExpression visitPostdot(PostdotContext ctx, AExpression prefix) {
        }
            return visit(ctx.rstatement());
        AExpression child = (AExpression) visit(ctx.unarynotaddsub());
            } else {
import org.opensearch.painless.node.EBooleanComp;
    public ANode visitWhile(WhileContext ctx) {
        List<String> paramTypes = new ArrayList<>();
        final Operation operation;
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    }
    @Override
            return new ENumeric(nextIdentifier(), location(ctx), ctx.HEX().getText().substring(2), 16);
        final String value;
        while (src < end) {
    private int nextIdentifier() {
            operation = Operation.LT;
        } else if (ctx.empty() != null) {
            operation = Operation.BWAND;
    public ANode visitDecltype(DecltypeContext ctx) {
            true,
    @Override
import org.opensearch.painless.node.SExpression;
        AExpression expr = (AExpression) visit(ctx.noncondexpression());
    public ANode visitRefcasttype(PainlessParser.RefcasttypeContext ctx) {
    public ANode visitTrap(TrapContext ctx) {
            return new SBlock(nextIdentifier(), location(ctx), statements);
    @Override
    @Override
        return visit(ctx.unary());
        // Strip the leading and trailing quotes and replace the escape sequences with their literal equivalents
    public ANode visitRefcast(PainlessParser.RefcastContext ctx) {
            operation = Operation.ADD;
    @Override
    @Override
        } else if (ctx.EQR() != null) {
    @Override
    }
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
    @Override
    @Override
    @Override
        }
    @Override
import org.opensearch.painless.node.EBrace;
        return buildPostfixChain(
        String name = ctx.ID().getText();
import org.antlr.v4.runtime.atn.PredictionMode;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.painless.antlr.PainlessParser.CompContext;
import org.opensearch.painless.antlr.PainlessParser.NewstandardarrayContext;
        });
import org.opensearch.painless.antlr.PainlessParser.ArgumentContext;
            expression,
        return new EInstanceof(nextIdentifier(), location(ctx), expr, type);
                nextIdentifier(),
        return new EUnary(nextIdentifier(), location(ctx), expression, operation);
        } else {
    }
        String type = ctx.decltype().getText();
            return new SWhile(nextIdentifier(), location(ctx), expression, null);
    }
            values.add((AExpression) visit(expression));
    @Override
import org.opensearch.painless.node.SBlock;
            operation = Operation.ADD;
    }
            new ENumeric(nextIdentifier(), location(ctx), "1", 10),
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        final Operation operation;
    public ANode visitPrecedence(PrecedenceContext ctx) {
            // single expression
            operation = Operation.DIV;
        // DiagnosticErrorListener, life is too short to think about what 'inexact ambiguity' might mean.
        } else if (ctx.SUB() != null) {
    public ANode visitPre(PreContext ctx) {
        } else if (ctx.EQ() != null) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        int src = 1;
            location(ctx),
import org.opensearch.painless.node.SIf;
    @Override
            ctx.postfix()
        return new EExplicit(nextIdentifier(), location(ctx), type, child);
        return new ESymbol(nextIdentifier(), location(ctx), name);
    }
import org.opensearch.painless.antlr.PainlessParser.InstanceofContext;
            return new SFor(nextIdentifier(), location(ctx), initializer, expression, afterthought, null);
        List<AExpression> expressions = new ArrayList<>();
    public ANode visitFunction(FunctionContext ctx) {
        // part of the overall class
import org.opensearch.painless.node.ANode;
        SBlock ifblock = (SBlock) visit(ctx.trailer(0));
        AExpression lhs = (AExpression) visit(ctx.noncondexpression());
    }
import org.antlr.v4.runtime.ParserRuleContext;
            return visitBraceaccess(ctx.braceaccess(), prefix);
        } else if (ctx.FIND() != null) {
        return new EAssignment(
import org.opensearch.painless.antlr.PainlessParser.CallinvokeContext;
        StringBuilder string = new StringBuilder(ctx.STRING().getText());
import org.opensearch.painless.node.EElvis;
    @Override
import org.opensearch.painless.antlr.PainlessParser.TryContext;
        );
        SBlock block = (SBlock) visit(ctx.block());
        List<AExpression> values = new ArrayList<>();
        return new ERegex(nextIdentifier(), location(ctx), pattern, flags);
    @Override
        return new Walker(sourceName, sourceText, settings).source;
            return new SIfElse(nextIdentifier(), location(ctx), expression, ifblock, elseblock);
                Collections.singletonList(new SReturn(nextIdentifier(), location(ctx), expression))
        return visit(ctx.noncondexpression());
    }
    public ANode visitNewobject(NewobjectContext ctx) {
    }
        AExpression expression = (AExpression) visit(ctx.unary());
        } else if (ctx.BWNOT() != null) {
        } else {
import org.opensearch.painless.antlr.PainlessParser.AddsubContext;
    @Override
        if (ctx.INCR() != null) {
    }
        );
import org.opensearch.painless.antlr.PainlessParser.InitializerContext;
        return new EDot(nextIdentifier(), location(ctx), prefix, value, ctx.NSDOT() != null);
            return new SWhile(nextIdentifier(), location(ctx), expression, block);
    }
        for (FunctionContext function : ctx.function()) {
        } else {
        return new EBooleanConstant(nextIdentifier(), location(ctx), false);
    public ANode visitBlock(BlockContext ctx) {
    private int identifier;
        SBlock block = (SBlock) visit(ctx.block());
        } else {
    @Override
    public ANode visitNewstandardarray(NewstandardarrayContext ctx) {
        return new SDeclBlock(nextIdentifier(), location(ctx), declarations);
            return visit(ctx.expression());
                location(ctx),
import org.opensearch.painless.node.EDecimal;
            rtnType,
    }
        AExpression left = (AExpression) visit(ctx.noncondexpression(0));
        return new SEach(nextIdentifier(), location(ctx), type, name, expression, block);
        List<String> paramNames = new ArrayList<>();
        List<AStatement> statements = new ArrayList<>();
import org.opensearch.painless.antlr.PainlessParser.LambdaContext;
            ? new EFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText(), ctx.NEW().getText())
            ) {
        if (ctx.INCR() != null) {
        List<AExpression> keys = new ArrayList<>();
        if (ctx.block().dstatement() != null) {
import org.opensearch.painless.antlr.PainlessParser.WhileContext;
 *
        return new ECall(nextIdentifier(), location(ctx), prefix, name, arguments, ctx.NSDOT() != null);
        return ctx.decltype().LBRACE().isEmpty()
import org.opensearch.painless.node.ELambda;
        } else if (ctx.fieldaccess() != null) {
            expression,
            location(ctx),
import org.opensearch.painless.antlr.PainlessParser.TypeContext;
    public ANode visitTrue(TrueContext ctx) {
            location(ctx),
            paramNames,
        return visit(ctx.mapinitializer());
    }
            values.add((AExpression) visit(maptoken.expression(1)));
        }
import org.opensearch.painless.node.EExplicit;
import org.opensearch.painless.antlr.PainlessParser.TrapContext;
    public AExpression visitPostfix(PostfixContext ctx, AExpression prefix) {
    public ANode visitAddsub(AddsubContext ctx) {
        if (ctx.rstatement() != null) {
        if (ctx.DOTID() != null) {
import org.opensearch.painless.node.SDeclBlock;
    @Override
    public AExpression visitFieldaccess(FieldaccessContext ctx, AExpression prefix) {
        } else if (ctx.GTE() != null) {
        } else if (ctx.AUSH() != null) {
        String type = ctx.primordefcasttype().getText();
 * Unless required by applicable law or agreed to in writing,
            if (lamtype.decltype() == null) {
    public ANode visitAfterthought(AfterthoughtContext ctx) {
        throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
        return new SClass(nextIdentifier(), location(ctx), functions);
import org.opensearch.painless.node.SWhile;
import org.opensearch.painless.node.ECall;
import org.opensearch.painless.antlr.PainlessParser.ParametersContext;
        }
    @Override
            @Override
    public ANode visitExpr(ExprContext ctx) {
        ANTLRInputStream stream = new ANTLRInputStream(source);
    }
import org.opensearch.painless.node.EListInit;
import org.opensearch.painless.antlr.PainlessParser.SourceContext;
        }
        this.sourceName = sourceName;
import org.opensearch.painless.antlr.PainlessParser.NewarrayContext;
    public ANode visitType(TypeContext ctx) {
import org.opensearch.painless.antlr.PainlessParser.NullContext;
            return visitFieldaccess(ctx.fieldaccess(), prefix);
        if (ctx.MUL() != null) {
import org.opensearch.painless.antlr.PainlessParser.RegexContext;
    }
        StringBuilder type = new StringBuilder(ctx.type().getText());
            true,
    private final CompilerSettings settings;
            paramTypes,
                src++;
            : new ENewArrayFunctionRef(nextIdentifier(), location(ctx), ctx.decltype().getText());
            }
    }
            return visit(ctx.declaration());
            value = ctx.DOTINTEGER().getText();
    @Override
    @Override
        } else {
            operation = Operation.MUL;
            operation = Operation.RSH;
        }
public final class Walker extends PainlessParserBaseVisitor<ANode> {
                paramTypes.add(null);
            declarations.add(new SDeclaration(nextIdentifier(), location(declvar), type, name, expression));
    }
        }
        return new SExpression(nextIdentifier(), location(ctx), expression);
        }
import org.antlr.v4.runtime.RecognitionException;
    public ANode visitArgument(ArgumentContext ctx) {
    public ANode visitMapinit(MapinitContext ctx) {
    }
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
import java.util.ArrayList;
    }
    }
    }
        string.setLength(dest);
        String name = ctx.DOTID().getText();
        SBlock block;
    @Override
        return new EAssignment(nextIdentifier(), location(ctx), lhs, rhs, false, operation);
    }
        int end = string.length() - 1;
        } else {
    }
    }
    }
        for (ExpressionContext expression : ctx.expression()) {
    public ANode visitPrimordefcast(PainlessParser.PrimordefcastContext ctx) {
    public ANode visitReturn(ReturnContext ctx) {
        } else if (ctx.REM() != null) {
import org.opensearch.painless.antlr.PainlessParser.PrecedenceContext;
    }
        if (ctx.callinvoke() != null) {
        if (ctx.trailer() != null) {
import org.opensearch.painless.antlr.PainlessParser.FunctionContext;
            name,
        return visit(ctx.listinitializer());
    public ANode visitParameters(ParametersContext ctx) {
        } else if (ctx.AOR() != null) {
    }
    private Location location(ParserRuleContext ctx) {
import org.opensearch.painless.node.EUnary;
            ctx.postdot(),
 * license agreements. See the NOTICE file distributed with
        return new EAssignment(
        String pattern = text.substring(1, lastSlash);
    public ANode visitPostdot(PostdotContext ctx) {
    @Override
                throw new AssertionError("line: " + line + ", offset: " + charPositionInLine + ", symbol:" + offendingSymbol + " " + msg);
        } else if (ctx.AADD() != null) {
    @Override
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
    }
        AExpression expression = (AExpression) visit(ctx.chain());
    }
import org.opensearch.painless.node.SEach;
        return arguments;
        } else if (ctx.OCTAL() != null) {
            throw location(ctx).createError(new IllegalStateException("illegal tree structure"));
            operation = Operation.BWAND;
    }
import org.opensearch.painless.CompilerSettings;
        for (ArgumentContext argument : ctx.argument()) {
            AExpression expression = (AExpression) visit(ctx.expression());
    }
import org.antlr.v4.runtime.Recognizer;
        final Operation operation;
