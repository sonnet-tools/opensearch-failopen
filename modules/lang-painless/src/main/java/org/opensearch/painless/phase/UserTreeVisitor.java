    void visitInstanceof(EInstanceof userInstanceofNode, Scope scope);
import org.opensearch.painless.node.ENull;
/*  
    void visitConditional(EConditional userConditionalNode, Scope scope);  
import org.opensearch.painless.node.EDot;
    void visitNumeric(ENumeric userNumericNode, Scope scope);
 * compatible open source license.
    void visitIfElse(SIfElse userIfElseNode, Scope scope);  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
public interface UserTreeVisitor<Scope> {
 */  
    void visitDeclaration(SDeclaration userDeclarationNode, Scope scope);  
    void visitThrow(SThrow userThrowNode, Scope scope);
import org.opensearch.painless.node.EAssignment;
import org.opensearch.painless.node.SReturn;  
    void visitListInit(EListInit userListInitNode, Scope scope);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.node.ERegex;  
    void visitRegex(ERegex userRegexNode, Scope scope);  
    void visitWhile(SWhile userWhileNode, Scope scope);
 *
    void visitContinue(SContinue userContinueNode, Scope scope);  
 * specific language governing permissions and limitations
}  
 *
    void visitFor(SFor userForNode, Scope scope);  
import org.opensearch.painless.node.SCatch;  
    void visitFunction(SFunction userFunctionNode, Scope scope);  
    void visitNewArray(ENewArray userNewArrayNode, Scope scope);
import org.opensearch.painless.node.EInstanceof;  
    void visitUnary(EUnary userUnaryNode, Scope scope);  
import org.opensearch.painless.node.SDeclaration;
import org.opensearch.painless.node.ELambda;
import org.opensearch.painless.node.ECallLocal;
    void visitDecimal(EDecimal userDecimalNode, Scope scope);  
import org.opensearch.painless.node.SDo;
import org.opensearch.painless.node.EElvis;  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.node.EMapInit;  
import org.opensearch.painless.node.EUnary;  
import org.opensearch.painless.node.EListInit;
import org.opensearch.painless.node.SBreak;
import org.opensearch.painless.node.SEach;  
 * license agreements. See the NOTICE file distributed with
    void visitElvis(EElvis userElvisNode, Scope scope);
    void visitExpression(SExpression userExpressionNode, Scope scope);
    void visitIf(SIf userIfNode, Scope scope);
import org.opensearch.painless.node.EDecimal;
    void visitExplicit(EExplicit userExplicitNode, Scope scope);
    void visitEach(SEach userEachNode, Scope scope);
    void visitLambda(ELambda userLambdaNode, Scope scope);
import org.opensearch.painless.node.EComp;
import org.opensearch.painless.node.SExpression;
import org.opensearch.painless.node.SWhile;  
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.node.EBinary;
import org.opensearch.painless.node.EExplicit;
import org.opensearch.painless.node.EConditional;  
    void visitAssignment(EAssignment userAssignmentNode, Scope scope);
    void visitBlock(SBlock userBlockNode, Scope scope);
import org.opensearch.painless.node.SFunction;  
import org.opensearch.painless.node.EBooleanComp;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    void visitClass(SClass userClassNode, Scope scope);
 * Modifications Copyright OpenSearch Contributors. See
    void visitTry(STry userTryNode, Scope scope);  
    void visitCallLocal(ECallLocal userCallLocalNode, Scope scope);  
 */
    void visitCatch(SCatch userCatchNode, Scope scope);
 * GitHub history for details.
import org.opensearch.painless.node.STry;
    void visitDeclBlock(SDeclBlock userDeclBlockNode, Scope scope);
import org.opensearch.painless.node.EString;
import org.opensearch.painless.node.ENewObj;  
import org.opensearch.painless.node.SThrow;
    void visitDo(SDo userDoNode, Scope scope);
/*
package org.opensearch.painless.phase;
import org.opensearch.painless.node.ENewArrayFunctionRef;
import org.opensearch.painless.node.SIfElse;
 * SPDX-License-Identifier: Apache-2.0
/*  
    void visitMapInit(EMapInit userMapInitNode, Scope scope);  
    void visitCall(ECall userCallNode, Scope scope);
 * under the License.  
    void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, Scope scope);
import org.opensearch.painless.node.SContinue;
import org.opensearch.painless.node.SDeclBlock;  
import org.opensearch.painless.node.SFor;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
    void visitReturn(SReturn userReturnNode, Scope scope);
    void visitNull(ENull userNullNode, Scope scope);
import org.opensearch.painless.node.EBooleanConstant;
    void visitComp(EComp userCompNode, Scope scope);  
import org.opensearch.painless.node.EFunctionRef;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.node.ENumeric;
import org.opensearch.painless.node.ECall;  
    void visitBrace(EBrace userBraceNode, Scope scope);  
 * Unless required by applicable law or agreed to in writing,
    void visitBinary(EBinary userBinaryNode, Scope scope);
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.node.ESymbol;
    void visitFunctionRef(EFunctionRef userFunctionRefNode, Scope scope);
 * not use this file except in compliance with the License.
import org.opensearch.painless.node.SClass;
    void visitBreak(SBreak userBreakNode, Scope scope);
import org.opensearch.painless.node.ENewArray;
import org.opensearch.painless.node.SBlock;
    void visitDot(EDot userDotNode, Scope scope);
    void visitSymbol(ESymbol userSymbolNode, Scope scope);
    void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, Scope scope);  
    void visitString(EString userStringNode, Scope scope);
    void visitBooleanComp(EBooleanComp userBooleanCompNode, Scope scope);
import org.opensearch.painless.node.EBrace;
import org.opensearch.painless.node.SIf;
    void visitNewObj(ENewObj userNewObjectNode, Scope scope);
