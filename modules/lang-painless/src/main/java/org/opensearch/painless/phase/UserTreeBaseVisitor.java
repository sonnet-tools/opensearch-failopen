    public void visitExpression(SExpression userExpressionNode, Scope scope) {
        userNumericNode.visitChildren(this, scope);
 * specific language governing permissions and limitations
    }
    public void visitNull(ENull userNullNode, Scope scope) {
 * You may obtain a copy of the License at
    @Override
        userExpressionNode.visitChildren(this, scope);
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.node.SIfElse;
import org.opensearch.painless.node.SBlock;
import org.opensearch.painless.node.ENewArrayFunctionRef;
        userDotNode.visitChildren(this, scope);
/*
    public void visitTry(STry userTryNode, Scope scope) {
    public void visitDecimal(EDecimal userDecimalNode, Scope scope) {
    @Override
    @Override
        userContinueNode.visitChildren(this, scope);
    @Override
import org.opensearch.painless.node.EExplicit;
    }
import org.opensearch.painless.node.EMapInit;
import org.opensearch.painless.node.EString;
import org.opensearch.painless.node.SContinue;
    public void visitAssignment(EAssignment userAssignmentNode, Scope scope) {
        userFunctionRefNode.visitChildren(this, scope);
    public void visitThrow(SThrow userThrowNode, Scope scope) {
    }
    }
    public void visitClass(SClass userClassNode, Scope scope) {
    public void visitInstanceof(EInstanceof userInstanceofNode, Scope scope) {
    public void visitBlock(SBlock userBlockNode, Scope scope) {
    public void visitDo(SDo userDoNode, Scope scope) {
    @Override
    @Override
    }
    @Override
    @Override
    @Override
    }
    }
    public void visitBrace(EBrace userBraceNode, Scope scope) {
    public void visitComp(EComp userCompNode, Scope scope) {
import org.opensearch.painless.node.SDeclBlock;
import org.opensearch.painless.node.EFunctionRef;
    @Override
    }
    }
    @Override
    public void visitSymbol(ESymbol userSymbolNode, Scope scope) {
        userListInitNode.visitChildren(this, scope);
import org.opensearch.painless.node.ENewArray;
import org.opensearch.painless.node.SReturn;
        userCompNode.visitChildren(this, scope);
    }
    public void visitCatch(SCatch userCatchNode, Scope scope) {
import org.opensearch.painless.node.ELambda;
 * compatible open source license.
        userBlockNode.visitChildren(this, scope);
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    }
    public void visitFunctionRef(EFunctionRef userFunctionRefNode, Scope scope) {
    public void visitDeclaration(SDeclaration userDeclarationNode, Scope scope) {
    public void visitEach(SEach userEachNode, Scope scope) {
    @Override
        userDecimalNode.visitChildren(this, scope);
    }
    @Override
    public void visitBreak(SBreak userBreakNode, Scope scope) {
 * not use this file except in compliance with the License.
    public void visitElvis(EElvis userElvisNode, Scope scope) {
/*
 * GitHub history for details.
    public void visitIfElse(SIfElse userIfElseNode, Scope scope) {
}
        userWhileNode.visitChildren(this, scope);
import org.opensearch.painless.node.ENewObj;
        userTryNode.visitChildren(this, scope);
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
    @Override
    public void visitMapInit(EMapInit userMapInitNode, Scope scope) {
    }
        userCatchNode.visitChildren(this, scope);
        userReturnNode.visitChildren(this, scope);
        userClassNode.visitChildren(this, scope);
    }
        userConditionalNode.visitChildren(this, scope);
    @Override
import org.opensearch.painless.node.EAssignment;
    @Override
import org.opensearch.painless.node.EBooleanComp;
        userNewArrayNode.visitChildren(this, scope);
import org.opensearch.painless.node.EElvis;
    public void visitIf(SIf userIfNode, Scope scope) {
    @Override
import org.opensearch.painless.node.STry;
import org.opensearch.painless.node.ECall;
/*
        userAssignmentNode.visitChildren(this, scope);
import org.opensearch.painless.node.EBrace;
    }
    public void visitWhile(SWhile userWhileNode, Scope scope) {
    public void visitDot(EDot userDotNode, Scope scope) {
    @Override
    @Override
        userCallNode.visitChildren(this, scope);
        userBinaryNode.visitChildren(this, scope);
    public void visitCall(ECall userCallNode, Scope scope) {
    }
import org.opensearch.painless.node.SDeclaration;
        userInstanceofNode.visitChildren(this, scope);
        userStringNode.visitChildren(this, scope);
    }
        userIfElseNode.visitChildren(this, scope);
import org.opensearch.painless.node.EBooleanConstant;
import org.opensearch.painless.node.ESymbol;
    @Override
    @Override
    @Override
    @Override
        userCallLocalNode.visitChildren(this, scope);
    }
import org.opensearch.painless.node.SExpression;
        userForNode.visitChildren(this, scope);
import org.opensearch.painless.node.EInstanceof;
 * Licensed to Elasticsearch under one or more contributor
    public void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, Scope scope) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.painless.node.SIf;
import org.opensearch.painless.node.SFunction;
    }
    }
 *
    @Override
    }
    public void visitString(EString userStringNode, Scope scope) {
    public void visitExplicit(EExplicit userExplicitNode, Scope scope) {
    public void visitContinue(SContinue userContinueNode, Scope scope) {
    }
import org.opensearch.painless.node.EListInit;
        userMapInitNode.visitChildren(this, scope);
        userClassNode.visitChildren(this, scope);
    public void visitReturn(SReturn userReturnNode, Scope scope) {
        userNewObjNode.visitChildren(this, scope);
        userEachNode.visitChildren(this, scope);
import org.opensearch.painless.node.EUnary;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.node.SFor;
    @Override
 * The OpenSearch Contributors require contributions made to
        userDoNode.visitChildren(this, scope);
    }
    }
    }
 *
package org.opensearch.painless.phase;
        userBooleanCompNode.visitChildren(this, scope);
import org.opensearch.painless.node.SBreak;
    @Override
    @Override
 */
    public void visitCallLocal(ECallLocal userCallLocalNode, Scope scope) {
 * this work for additional information regarding copyright
        userBooleanConstantNode.visitChildren(this, scope);
 * ownership. Elasticsearch licenses this file to you under
        userExplicitNode.visitChildren(this, scope);
    public void visitConditional(EConditional userConditionalNode, Scope scope) {
    public void visitNumeric(ENumeric userNumericNode, Scope scope) {
    }
 * software distributed under the License is distributed on an
import org.opensearch.painless.node.SDo;
import org.opensearch.painless.node.ECallLocal;
    @Override
import org.opensearch.painless.node.ENumeric;
    }
        userIfNode.visitChildren(this, scope);
    public void visitUnary(EUnary userUnaryNode, Scope scope) {
    }
    }
import org.opensearch.painless.node.EDot;
    }
    }
import org.opensearch.painless.node.SClass;
import org.opensearch.painless.node.EBinary;
import org.opensearch.painless.node.SWhile;
    }
    @Override
    @Override
import org.opensearch.painless.node.ENull;
        userSymbolNode.visitChildren(this, scope);
        userRegexNode.visitChildren(this, scope);
    public void visitNewArray(ENewArray userNewArrayNode, Scope scope) {
import org.opensearch.painless.node.SEach;
    @Override
    @Override
    @Override
    }
    public void visitFor(SFor userForNode, Scope scope) {
    }
    public void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, Scope scope) {
    }
    @Override
import org.opensearch.painless.node.ERegex;
    }
    @Override
        userNewArrayFunctionRefNode.visitChildren(this, scope);
    @Override
    }
        userUnaryNode.visitChildren(this, scope);
    public void visitFunction(SFunction userClassNode, Scope scope) {
    }
import org.opensearch.painless.node.EComp;
    @Override
    @Override
    @Override
    @Override
        userThrowNode.visitChildren(this, scope);
    public void visitNewObj(ENewObj userNewObjNode, Scope scope) {
import org.opensearch.painless.node.EConditional;
public class UserTreeBaseVisitor<Scope> implements UserTreeVisitor<Scope> {
    @Override
    public void visitBooleanComp(EBooleanComp userBooleanCompNode, Scope scope) {
        userBraceNode.visitChildren(this, scope);
    public void visitRegex(ERegex userRegexNode, Scope scope) {
 */
        userBreakNode.visitChildren(this, scope);
        userNullNode.visitChildren(this, scope);
    }
    }
    }
        userElvisNode.visitChildren(this, scope);
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
import org.opensearch.painless.node.SCatch;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.node.SThrow;
    public void visitBinary(EBinary userBinaryNode, Scope scope) {
        userLambdaNode.visitChildren(this, scope);
    public void visitDeclBlock(SDeclBlock userDeclBlockNode, Scope scope) {
 * license agreements. See the NOTICE file distributed with
 */
    public void visitLambda(ELambda userLambdaNode, Scope scope) {
    @Override
        userDeclarationNode.visitChildren(this, scope);
import org.opensearch.painless.node.EDecimal;
    }
    @Override
    }
        userDeclBlockNode.visitChildren(this, scope);
    public void visitListInit(EListInit userListInitNode, Scope scope) {
