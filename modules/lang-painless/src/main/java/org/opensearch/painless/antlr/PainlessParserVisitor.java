     */
     * Visit a parse tree produced by the {@code pre}
     * @param ctx the parse tree
     * @param ctx the parse tree  
    /**
 * not use this file except in compliance with the License.
    /**  
     * Visit a parse tree produced by {@link PainlessParser#function}.
    /**
     * @return the visitor result
     * Visit a parse tree produced by the {@code string}  
     * @param ctx the parse tree
     */
    /**  
    T visitEmpty(PainlessParser.EmptyContext ctx);
     * @return the visitor result
     * Visit a parse tree produced by {@link PainlessParser#empty}.  
     */
     * @param ctx the parse tree
     */  
     * Visit a parse tree produced by the {@code while}
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#primary}.  
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
     * labeled alternative in {@link PainlessParser#noncondexpression}.
     * @param ctx the parse tree
     * @return the visitor result  
     */
     * Visit a parse tree produced by the {@code not}  
     * Visit a parse tree produced by the {@code addsub}
     */
     * labeled alternative in {@link PainlessParser#unary}.
     * Visit a parse tree produced by the {@code do}
    /**
 */
    T visitComp(PainlessParser.CompContext ctx);  
     */
     * Visit a parse tree produced by the {@code elvis}
     * @param ctx the parse tree  
     * Visit a parse tree produced by {@link PainlessParser#fieldaccess}.
    /**  
     * Visit a parse tree produced by the {@code numeric}
     * Visit a parse tree produced by the {@code conditional}
     * Visit a parse tree produced by the {@code break}
     * @param ctx the parse tree
     * @return the visitor result
     * @param ctx the parse tree
     */
    /**  
     */
     * @return the visitor result
    /**
     * labeled alternative in {@link PainlessParser#castexpression}.
     * Visit a parse tree produced by {@link PainlessParser#trap}.
     * Visit a parse tree produced by {@link PainlessParser#decltype}.
/*
    T visitPrimordefcast(PainlessParser.PrimordefcastContext ctx);  
 * specific language governing permissions and limitations
    T visitMaptoken(PainlessParser.MaptokenContext ctx);
     * labeled alternative in {@link PainlessParser#primary}.
    /**  
     * Visit a parse tree produced by {@link PainlessParser#callinvoke}.
 * The OpenSearch Contributors require contributions made to  
     * Visit a parse tree produced by the {@code null}
     * Visit a parse tree produced by {@link PainlessParser#postfix}.
     * @return the visitor result  
    T visitNewarray(PainlessParser.NewarrayContext ctx);
     * @param ctx the parse tree
     */
     * @param ctx the parse tree
    T visitTrailer(PainlessParser.TrailerContext ctx);
    T visitFunction(PainlessParser.FunctionContext ctx);  
     * labeled alternative in {@link PainlessParser#dstatement}.
     * labeled alternative in {@link PainlessParser#primary}.  
     * labeled alternative in {@link PainlessParser#rstatement}.
    /**  
     * @return the visitor result
    T visitListinit(PainlessParser.ListinitContext ctx);  
    T visitExpr(PainlessParser.ExprContext ctx);
    T visitElvis(PainlessParser.ElvisContext ctx);  
     */  
     */  
     * labeled alternative in {@link PainlessParser#unarynotaddsub}.
    T visitCallinvoke(PainlessParser.CallinvokeContext ctx);
     * @param ctx the parse tree
    /**
     * @param ctx the parse tree
 * Modifications Copyright OpenSearch Contributors. See
    T visitTrap(PainlessParser.TrapContext ctx);
package org.opensearch.painless.antlr;  
     * @param ctx the parse tree
    T visitVariable(PainlessParser.VariableContext ctx);
    T visitType(PainlessParser.TypeContext ctx);  
     * labeled alternative in {@link PainlessParser#dstatement}.
     * @param ctx the parse tree  
    T visitFor(PainlessParser.ForContext ctx);
    /**  
     * @return the visitor result  
    /**
     */
     * labeled alternative in {@link PainlessParser#rstatement}.
    T visitBool(PainlessParser.BoolContext ctx);
    T visitNot(PainlessParser.NotContext ctx);
     * @return the visitor result
    T visitFalse(PainlessParser.FalseContext ctx);
     * @param ctx the parse tree
     */
     * Visit a parse tree produced by {@link PainlessParser#arguments}.
    /**
    T visitRefcasttype(PainlessParser.RefcasttypeContext ctx);
    /**  
    T visitBraceaccess(PainlessParser.BraceaccessContext ctx);
     * @param ctx the parse tree
    /**
    /**
     */
     */
    /**
     * @return the visitor result
    T visitDo(PainlessParser.DoContext ctx);
     * @param ctx the parse tree
    T visitArguments(PainlessParser.ArgumentsContext ctx);  
     * @return the visitor result
     * Visit a parse tree produced by the {@code mapinit}  
    T visitNewinitializedarray(PainlessParser.NewinitializedarrayContext ctx);
     * labeled alternative in {@link PainlessParser#rstatement}.
     * @param ctx the parse tree
 * by {@link PainlessParser}.  
     * @return the visitor result  
    T visitArgument(PainlessParser.ArgumentContext ctx);
    /**
    T visitAfterthought(PainlessParser.AfterthoughtContext ctx);  
     */  
     * @param ctx the parse tree  
 */  
     */  
    T visitNewstandardarray(PainlessParser.NewstandardarrayContext ctx);  
     * @param ctx the parse tree
    /**  
     * labeled alternative in {@link PainlessParser#castexpression}.
     * labeled alternative in {@link PainlessParser#dstatement}.  
 * @param <T> The return type of the visit operation. Use {@link Void} for
     */  
    T visitConstructorfuncref(PainlessParser.ConstructorfuncrefContext ctx);
     */  
     * @return the visitor result
     * @return the visitor result
    T visitClassfuncref(PainlessParser.ClassfuncrefContext ctx);
 * operations with no return type.  
 *  
     * @param ctx the parse tree  
     * Visit a parse tree produced by the {@code newobject}  
    /**
     */  
     * labeled alternative in {@link PainlessParser#primary}.
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#funcref}.
     */
     */
    T visitBinary(PainlessParser.BinaryContext ctx);
    T visitCast(PainlessParser.CastContext ctx);
     * @return the visitor result
     * @return the visitor result
     * @return the visitor result  
     */  
     */
     * Visit a parse tree produced by {@link PainlessParser#postdot}.  
     * Visit a parse tree produced by the {@code calllocal}
    /**
    /**
    /**  
     * Visit a parse tree produced by {@link PainlessParser#source}.
 *
    T visitListinitializer(PainlessParser.ListinitializerContext ctx);  
     * Visit a parse tree produced by the {@code assignment}  
 * software distributed under the License is distributed on an
    T visitPre(PainlessParser.PreContext ctx);
 * Licensed to Elasticsearch under one or more contributor  
 *
     * @return the visitor result
     * @return the visitor result
     * @return the visitor result
     * Visit a parse tree produced by the {@code post}
    T visitRegex(PainlessParser.RegexContext ctx);
    /**
 * This interface defines a complete generic visitor for a parse tree produced
    T visitString(PainlessParser.StringContext ctx);
    /**
    /**  
     * Visit a parse tree produced by the {@code throw}  
 * this work for additional information regarding copyright
     */
     * @param ctx the parse tree
     * Visit a parse tree produced by the {@code ineach}
     */
     * Visit a parse tree produced by {@link PainlessParser#lamtype}.
     * @param ctx the parse tree  
     * @param ctx the parse tree
     * @return the visitor result
     * @param ctx the parse tree
    T visitInitializer(PainlessParser.InitializerContext ctx);
     * @return the visitor result  
     * Visit a parse tree produced by {@link PainlessParser#lambda}.
     */  
    /**
    T visitIf(PainlessParser.IfContext ctx);
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#primary}.
     */  
     */
    T visitDecltype(PainlessParser.DecltypeContext ctx);
    /**
     */
    T visitConditional(PainlessParser.ConditionalContext ctx);  
     * labeled alternative in {@link PainlessParser#primary}.
    T visitSource(PainlessParser.SourceContext ctx);
     * @return the visitor result  
     * labeled alternative in {@link PainlessParser#noncondexpression}.  
     * @return the visitor result  
    /**  
     */
     * @param ctx the parse tree  
     * Visit a parse tree produced by the {@code single}
     * @param ctx the parse tree
    /**
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#primary}.
     */
     * labeled alternative in {@link PainlessParser#unary}.  
     * labeled alternative in {@link PainlessParser#primary}.  
    /**
    T visitLocalfuncref(PainlessParser.LocalfuncrefContext ctx);  
     */
     * Visit a parse tree produced by the {@code true}  
     * labeled alternative in {@link PainlessParser#primary}.
     * labeled alternative in {@link PainlessParser#primary}.
     * @return the visitor result
    T visitMapinit(PainlessParser.MapinitContext ctx);
     * @return the visitor result  
     * labeled alternative in {@link PainlessParser#rstatement}.
    /**  
     * @return the visitor result
     * @return the visitor result  
    /**  
     * @param ctx the parse tree  
     * labeled alternative in {@link PainlessParser#dstatement}.  
    /**
    /**
    T visitBlock(PainlessParser.BlockContext ctx);  
     */  
     * @return the visitor result
     * @return the visitor result
     */
    /**
     */  
 * ownership. Elasticsearch licenses this file to you under  
     * @param ctx the parse tree  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
     * @param ctx the parse tree  
    T visitDynamic(PainlessParser.DynamicContext ctx);  
     */
     * @param ctx the parse tree
 * compatible open source license.
     * @param ctx the parse tree
     */
     * @return the visitor result
     */
     */
    /**  
     */
     * labeled alternative in {@link PainlessParser#primary}.
    T visitNotaddsub(PainlessParser.NotaddsubContext ctx);
     * labeled alternative in {@link PainlessParser#unarynotaddsub}.
    /**
     * Visit a parse tree produced by the {@code bool}  
     * @param ctx the parse tree
    /**  
     * labeled alternative in {@link PainlessParser#unary}.
     * @return the visitor result
     * @param ctx the parse tree  
     * @return the visitor result
     * @return the visitor result
     * Visit a parse tree produced by {@link PainlessParser#declaration}.  
     * labeled alternative in {@link PainlessParser#expression}.
    /**  
     * @param ctx the parse tree
 *     http://www.apache.org/licenses/LICENSE-2.0
    T visitThrow(PainlessParser.ThrowContext ctx);
    T visitNonconditional(PainlessParser.NonconditionalContext ctx);
     * @param ctx the parse tree
     * @param ctx the parse tree
     */
     * Visit a parse tree produced by the {@code newstandardarray}
     * @return the visitor result
     * labeled alternative in {@link PainlessParser#rstatement}.  
     * @return the visitor result
     */  
     * Visit a parse tree produced by the {@code for}  
     * @param ctx the parse tree  
    T visitCalllocal(PainlessParser.CalllocalContext ctx);  
     * @return the visitor result  
 * GitHub history for details.  
     * @return the visitor result
     * @return the visitor result
     * @param ctx the parse tree  
    /**  
     * Visit a parse tree produced by {@link PainlessParser#listinitializer}.
    /**
    /**
    T visitAssignment(PainlessParser.AssignmentContext ctx);
     */
     * labeled alternative in {@link PainlessParser#noncondexpression}.
     * @param ctx the parse tree
     */
     */
     * @return the visitor result
     * Visit a parse tree produced by {@link PainlessParser#trailer}.
     * labeled alternative in {@link PainlessParser#noncondexpression}.  
    T visitReturn(PainlessParser.ReturnContext ctx);  
     * Visit a parse tree produced by the {@code each}
 * this file be licensed under the Apache-2.0 license or a
    T visitPost(PainlessParser.PostContext ctx);  
     * @return the visitor result  
     */
     * Visit a parse tree produced by the {@code false}
     */
     */
     * Visit a parse tree produced by the {@code refcast}  
     * @return the visitor result
    T visitEach(PainlessParser.EachContext ctx);
     * @param ctx the parse tree  
     * labeled alternative in {@link PainlessParser#chain}.
     * @param ctx the parse tree
     * Visit a parse tree produced by the {@code primordefcast}
     * @return the visitor result  
     * Visit a parse tree produced by {@link PainlessParser#braceaccess}.  
     * @param ctx the parse tree
     * @return the visitor result
}
    /**
     * @return the visitor result  
     * Visit a parse tree produced by {@link PainlessParser#statement}.
     */  
    /**
     * @param ctx the parse tree  
    /**
     */
    /**
     * @param ctx the parse tree  
     * @return the visitor result
     * @param ctx the parse tree
    T visitMapinitializer(PainlessParser.MapinitializerContext ctx);
     * @return the visitor result
/*  
     * @return the visitor result  
     * @return the visitor result  
interface PainlessParserVisitor<T> extends ParseTreeVisitor<T> {
     * Visit a parse tree produced by the {@code nonconditional}
    T visitRead(PainlessParser.ReadContext ctx);
     * @param ctx the parse tree
     * Visit a parse tree produced by the {@code classfuncref}  
     * @param ctx the parse tree  
    /**
     * Visit a parse tree produced by {@link PainlessParser#block}.
     * labeled alternative in {@link PainlessParser#arrayinitializer}.
     * Visit a parse tree produced by the {@code return}
     * @return the visitor result  
    /**
     * Visit a parse tree produced by the {@code newinitializedarray}  
    T visitLamtype(PainlessParser.LamtypeContext ctx);  
     * Visit a parse tree produced by the {@code localfuncref}
    /**
     * @param ctx the parse tree  
    /**
     * Visit a parse tree produced by the {@code regex}
     */
    /**
     * labeled alternative in {@link PainlessParser#noncondexpression}.
     * Visit a parse tree produced by {@link PainlessParser#declvar}.  
     * @param ctx the parse tree
    T visitPrimordefcasttype(PainlessParser.PrimordefcasttypeContext ctx);  
    T visitTry(PainlessParser.TryContext ctx);
     */  
    /**
     * labeled alternative in {@link PainlessParser#chain}.
     * @return the visitor result
    T visitTrue(PainlessParser.TrueContext ctx);
    /**
     */
/**
     * @param ctx the parse tree
    T visitIneach(PainlessParser.IneachContext ctx);  
     * @param ctx the parse tree
 *
     * Visit a parse tree produced by the {@code constructorfuncref}
     * @return the visitor result
     * @return the visitor result
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#primary}.  
     * labeled alternative in {@link PainlessParser#unarynotaddsub}.  
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#dstatement}.
     * @param ctx the parse tree
     */
     * @param ctx the parse tree
    /**
     * @param ctx the parse tree  
     */
     * Visit a parse tree produced by the {@code if}
    /**  
     */
    T visitFieldaccess(PainlessParser.FieldaccessContext ctx);  
    T visitStatement(PainlessParser.StatementContext ctx);
     * Visit a parse tree produced by {@link PainlessParser#type}.
     * @return the visitor result  
     * @param ctx the parse tree  
     * @param ctx the parse tree  
     * @return the visitor result
     * @param ctx the parse tree  
     */
     */
// ANTLR GENERATED CODE: DO NOT EDIT  
     * Visit a parse tree produced by the {@code dynamic}
    T visitAddsub(PainlessParser.AddsubContext ctx);  
     */
     * labeled alternative in {@link PainlessParser#dstatement}.
     * @param ctx the parse tree  
    T visitNewobject(PainlessParser.NewobjectContext ctx);
     * labeled alternative in {@link PainlessParser#funcref}.  
     */  
     * @return the visitor result
     * Visit a parse tree produced by the {@code continue}  
     * Visit a parse tree produced by {@link PainlessParser#parameters}.  
 * KIND, either express or implied.  See the License for the
    T visitBreak(PainlessParser.BreakContext ctx);
     * @param ctx the parse tree
     */  
     * @return the visitor result
    T visitInstanceof(PainlessParser.InstanceofContext ctx);
    T visitPostdot(PainlessParser.PostdotContext ctx);
     * @return the visitor result
 * license agreements. See the NOTICE file distributed with
    /**
     * @return the visitor result  
     */
     * Visit a parse tree produced by {@link PainlessParser#argument}.  
     * Visit a parse tree produced by the {@code newarray}  
     * @return the visitor result  
     * labeled alternative in {@link PainlessParser#expression}.
     * Visit a parse tree produced by the {@code comp}
 * You may obtain a copy of the License at  
     */
    T visitWhile(PainlessParser.WhileContext ctx);  
     * @return the visitor result
     * @param ctx the parse tree  
     */  
     * @param ctx the parse tree
    /**  
     */
    /**
     * Visit a parse tree produced by the {@code cast}
    /**
     * Visit a parse tree produced by the {@code decl}
     * @return the visitor result
    /**
     * @return the visitor result
     * Visit a parse tree produced by the {@code binary}
    T visitContinue(PainlessParser.ContinueContext ctx);
    /**
     */
    /**
     * Visit a parse tree produced by the {@code instanceof}  
     * @return the visitor result
     * @return the visitor result  
     * @param ctx the parse tree
     * @param ctx the parse tree  
    /**  
 * SPDX-License-Identifier: Apache-2.0
     */
     * Visit a parse tree produced by {@link PainlessParser#initializer}.
     * @param ctx the parse tree  
    T visitDecl(PainlessParser.DeclContext ctx);  
     */  
     * labeled alternative in {@link PainlessParser#expression}.  
    /**  
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#arrayinitializer}.
    /**
    T visitPrecedence(PainlessParser.PrecedenceContext ctx);
     * @param ctx the parse tree
     * @param ctx the parse tree  
    T visitNumeric(PainlessParser.NumericContext ctx);  
     * Visit a parse tree produced by {@link PainlessParser#mapinitializer}.  
    /**
     * Visit a parse tree produced by {@link PainlessParser#maptoken}.
     * Visit a parse tree produced by {@link PainlessParser#refcasttype}.  
     * @return the visitor result
     * @return the visitor result  
    /**
    /**
     * @return the visitor result  
     * @return the visitor result
     * Visit a parse tree produced by the {@code notaddsub}  
    T visitParameters(PainlessParser.ParametersContext ctx);
 * under the License.  
     * Visit a parse tree produced by the {@code listinit}
     */  
     * Visit a parse tree produced by the {@code precedence}
     * labeled alternative in {@link PainlessParser#dstatement}.  
     * Visit a parse tree produced by the {@code variable}
     * @return the visitor result
     * @param ctx the parse tree
    T visitSingle(PainlessParser.SingleContext ctx);
     */
     * @param ctx the parse tree
     * labeled alternative in {@link PainlessParser#unarynotaddsub}.  
/*
     * Visit a parse tree produced by {@link PainlessParser#afterthought}.
    /**  
    T visitRefcast(PainlessParser.RefcastContext ctx);
     * Visit a parse tree produced by {@link PainlessParser#primordefcasttype}.
     * @return the visitor result
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the visitor result
     */  
 */
    /**  
     * @param ctx the parse tree
     */  
    /**
    T visitLambda(PainlessParser.LambdaContext ctx);
 */
    T visitNull(PainlessParser.NullContext ctx);  
    /**
     * @return the visitor result
     * @return the visitor result  
 * Unless required by applicable law or agreed to in writing,
    /**
     * Visit a parse tree produced by the {@code expr}
     * @return the visitor result  
     * @return the visitor result
    /**  
    T visitDeclaration(PainlessParser.DeclarationContext ctx);
     * Visit a parse tree produced by the {@code try}  
     * Visit a parse tree produced by the {@code read}
     * @param ctx the parse tree
     * @return the visitor result  
     */  
    /**
     */  
     * labeled alternative in {@link PainlessParser#rstatement}.  
     * labeled alternative in {@link PainlessParser#noncondexpression}.
     * @return the visitor result
    T visitPostfix(PainlessParser.PostfixContext ctx);  
    T visitDeclvar(PainlessParser.DeclvarContext ctx);
    /**  
     * labeled alternative in {@link PainlessParser#funcref}.
