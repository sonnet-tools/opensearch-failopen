    }
    }  
    @Override  
        userDoNode.visitChildren(this, scope);  
import org.opensearch.painless.node.EComp;
        userEachNode.visitChildren(this, scope);
        userExplicitNode.visitChildren(this, scope);
    @Override
    @Override  
import org.opensearch.painless.node.ERegex;  
    }
    @Override
        userBlockNode.visitChildren(this, scope);
        userStringNode.visitChildren(this, scope);
    }
    public void visitFunctionRef(EFunctionRef userFunctionRefNode, Scope scope) {
/*
    public void visitInstanceof(EInstanceof userInstanceofNode, Scope scope) {
    public void visitAssignment(EAssignment userAssignmentNode, Scope scope) {
        userUnaryNode.visitChildren(this, scope);
import org.opensearch.painless.node.EString;
        userInstanceofNode.visitChildren(this, scope);  
    }  
        userBreakNode.visitChildren(this, scope);
    }
import org.opensearch.painless.node.EListInit;
    }
    public void visitIf(SIf userIfNode, Scope scope) {
import org.opensearch.painless.node.SEach;  
    public void visitFunction(SFunction userClassNode, Scope scope) {
    @Override
import org.opensearch.painless.node.SDo;
    @Override
import org.opensearch.painless.node.EUnary;  
    @Override  
    public void visitElvis(EElvis userElvisNode, Scope scope) {  
 *
import org.opensearch.painless.node.SThrow;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
}  
import org.opensearch.painless.node.ENewObj;  
    @Override
    }  
    @Override
/*  
    public void visitCallLocal(ECallLocal userCallLocalNode, Scope scope) {
        userTryNode.visitChildren(this, scope);
    @Override
        userExpressionNode.visitChildren(this, scope);  
    }
    }
    public void visitEach(SEach userEachNode, Scope scope) {  
    public void visitDeclaration(SDeclaration userDeclarationNode, Scope scope) {
    @Override
    }
        userNullNode.visitChildren(this, scope);  
import org.opensearch.painless.node.SDeclaration;
    }  
    }  
    @Override
import org.opensearch.painless.node.EBinary;
    public void visitCatch(SCatch userCatchNode, Scope scope) {  
import org.opensearch.painless.node.EConditional;  
        userCompNode.visitChildren(this, scope);
    public void visitClass(SClass userClassNode, Scope scope) {
        userConditionalNode.visitChildren(this, scope);
import org.opensearch.painless.node.EFunctionRef;
    public void visitNumeric(ENumeric userNumericNode, Scope scope) {
    public void visitNewArray(ENewArray userNewArrayNode, Scope scope) {  
    }
        userReturnNode.visitChildren(this, scope);
        userNewArrayNode.visitChildren(this, scope);
    }
    }  
        userDotNode.visitChildren(this, scope);  
    public void visitRegex(ERegex userRegexNode, Scope scope) {
 * software distributed under the License is distributed on an
        userListInitNode.visitChildren(this, scope);  
        userCallNode.visitChildren(this, scope);
        userBraceNode.visitChildren(this, scope);
        userNewObjNode.visitChildren(this, scope);  
    @Override
    }
import org.opensearch.painless.node.EMapInit;  
import org.opensearch.painless.node.ESymbol;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
import org.opensearch.painless.node.SDeclBlock;  
    public void visitReturn(SReturn userReturnNode, Scope scope) {  
import org.opensearch.painless.node.SIfElse;
 * under the License.  
    }
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.painless.node.ECallLocal;
import org.opensearch.painless.node.SContinue;
import org.opensearch.painless.node.ELambda;
        userNewArrayFunctionRefNode.visitChildren(this, scope);
        userBooleanConstantNode.visitChildren(this, scope);
        userRegexNode.visitChildren(this, scope);
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
    @Override
    public void visitContinue(SContinue userContinueNode, Scope scope) {
        userBinaryNode.visitChildren(this, scope);
        userCatchNode.visitChildren(this, scope);
    @Override  
    public void visitNewArrayFunctionRef(ENewArrayFunctionRef userNewArrayFunctionRefNode, Scope scope) {
import org.opensearch.painless.node.SClass;
import org.opensearch.painless.node.ENumeric;
    @Override
    @Override  
    @Override
import org.opensearch.painless.node.SBlock;
        userNumericNode.visitChildren(this, scope);  
import org.opensearch.painless.node.EElvis;  
    public void visitBrace(EBrace userBraceNode, Scope scope) {
    }
import org.opensearch.painless.node.EDot;
 * GitHub history for details.
    public void visitComp(EComp userCompNode, Scope scope) {
    public void visitNull(ENull userNullNode, Scope scope) {
    @Override
    @Override
        userThrowNode.visitChildren(this, scope);  
    public void visitUnary(EUnary userUnaryNode, Scope scope) {
 *  
    }
        userDeclBlockNode.visitChildren(this, scope);  
        userMapInitNode.visitChildren(this, scope);
    }
    public void visitIfElse(SIfElse userIfElseNode, Scope scope) {
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.painless.node.EAssignment;
import org.opensearch.painless.node.SIf;
    }
package org.opensearch.painless.phase;
    @Override
        userClassNode.visitChildren(this, scope);  
        userBooleanCompNode.visitChildren(this, scope);  
    public void visitDo(SDo userDoNode, Scope scope) {
 *
    }
    public void visitCall(ECall userCallNode, Scope scope) {  
        userDeclarationNode.visitChildren(this, scope);
    public void visitDeclBlock(SDeclBlock userDeclBlockNode, Scope scope) {
        userFunctionRefNode.visitChildren(this, scope);  
    public void visitTry(STry userTryNode, Scope scope) {
        userElvisNode.visitChildren(this, scope);
    public void visitDot(EDot userDotNode, Scope scope) {
    public void visitBooleanConstant(EBooleanConstant userBooleanConstantNode, Scope scope) {  
import org.opensearch.painless.node.ENull;
    @Override  
 */  
    }  
        userDecimalNode.visitChildren(this, scope);
        userAssignmentNode.visitChildren(this, scope);  
    public void visitBooleanComp(EBooleanComp userBooleanCompNode, Scope scope) {
    }
    public void visitString(EString userStringNode, Scope scope) {  
 * specific language governing permissions and limitations
        userSymbolNode.visitChildren(this, scope);
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void visitListInit(EListInit userListInitNode, Scope scope) {
 * license agreements. See the NOTICE file distributed with
    @Override
import org.opensearch.painless.node.EInstanceof;  
import org.opensearch.painless.node.EBooleanComp;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.painless.node.ENewArray;
import org.opensearch.painless.node.EBrace;
import org.opensearch.painless.node.ECall;  
    }
    @Override
import org.opensearch.painless.node.EExplicit;
import org.opensearch.painless.node.STry;
    public void visitLambda(ELambda userLambdaNode, Scope scope) {  
    }  
    @Override  
        userContinueNode.visitChildren(this, scope);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.node.EDecimal;
    }  
    public void visitBlock(SBlock userBlockNode, Scope scope) {  
    }
import org.opensearch.painless.node.EBooleanConstant;
import org.opensearch.painless.node.SFunction;  
    public void visitSymbol(ESymbol userSymbolNode, Scope scope) {  
    }
        userIfElseNode.visitChildren(this, scope);
 */
    }  
    }
    @Override  
    @Override  
    public void visitFor(SFor userForNode, Scope scope) {
    public void visitExpression(SExpression userExpressionNode, Scope scope) {
    @Override
    @Override
    @Override  
    public void visitNewObj(ENewObj userNewObjNode, Scope scope) {
    }
import org.opensearch.painless.node.SExpression;
    public void visitDecimal(EDecimal userDecimalNode, Scope scope) {
    }
        userIfNode.visitChildren(this, scope);  
    public void visitBreak(SBreak userBreakNode, Scope scope) {  
    }  
    public void visitBinary(EBinary userBinaryNode, Scope scope) {  
    public void visitExplicit(EExplicit userExplicitNode, Scope scope) {  
    @Override  
/*  
    @Override  
    }  
        userWhileNode.visitChildren(this, scope);
    }
    public void visitThrow(SThrow userThrowNode, Scope scope) {
    public void visitMapInit(EMapInit userMapInitNode, Scope scope) {
import org.opensearch.painless.node.SBreak;
public class UserTreeBaseVisitor<Scope> implements UserTreeVisitor<Scope> {
    @Override
    }  
    @Override  
        userLambdaNode.visitChildren(this, scope);
 */  
    @Override  
import org.opensearch.painless.node.SReturn;  
    @Override
    @Override
    @Override  
    }  
    @Override
    public void visitConditional(EConditional userConditionalNode, Scope scope) {
        userClassNode.visitChildren(this, scope);
    @Override
    }
    public void visitWhile(SWhile userWhileNode, Scope scope) {  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.node.SFor;
    @Override
import org.opensearch.painless.node.SCatch;  
    }
import org.opensearch.painless.node.SWhile;  
 * this file be licensed under the Apache-2.0 license or a
        userCallLocalNode.visitChildren(this, scope);
        userForNode.visitChildren(this, scope);
import org.opensearch.painless.node.ENewArrayFunctionRef;
    @Override
 * KIND, either express or implied.  See the License for the
