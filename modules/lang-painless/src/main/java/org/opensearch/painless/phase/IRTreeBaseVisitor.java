    public void visitComparison(ComparisonNode irComparisonNode, Scope scope) {
        irForEachSubIterableNode.visitChildren(this, scope);  
        irLoadFieldMemberNode.visitChildren(this, scope);
    @Override
    public void visitStatic(StaticNode irStaticNode, Scope scope) {  
        irFlipArrayIndexNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadListShortcutNode;  
    }
import org.opensearch.painless.ir.ClassNode;
    @Override  
 * software distributed under the License is distributed on an
    @Override
 * The OpenSearch Contributors require contributions made to  
 *  
    public void visitUnaryMath(UnaryMathNode irUnaryMathNode, Scope scope) {  
    public void visitDefInterfaceReference(DefInterfaceReferenceNode irDefInterfaceReferenceNode, Scope scope) {  
    @Override
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    }
    @Override  
    @Override
    public void visitLoadDot(LoadDotNode irLoadDotNode, Scope scope) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
        irMapInitializationNode.visitChildren(this, scope);  
        irThrowNode.visitChildren(this, scope);
import org.opensearch.painless.ir.CastNode;  
    }
    }
    public void visitNullSafeSub(NullSafeSubNode irNullSafeSubNode, Scope scope) {
    }
    }
    @Override
    public void visitInvokeCall(InvokeCallNode irInvokeCallNode, Scope scope) {
    @Override
import org.opensearch.painless.ir.ThrowNode;  
    @Override
import org.opensearch.painless.ir.NullNode;  
import org.opensearch.painless.ir.LoadVariableNode;
import org.opensearch.painless.ir.DeclarationBlockNode;
        irComparisonNode.visitChildren(this, scope);  
    }  
import org.opensearch.painless.ir.BinaryMathNode;
import org.opensearch.painless.ir.CatchNode;
    }
    @Override
        irStoreFieldMemberNode.visitChildren(this, scope);
    public void visitLoadVariable(LoadVariableNode irLoadVariableNode, Scope scope) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
import org.opensearch.painless.ir.StoreDotNode;
import org.opensearch.painless.ir.StoreDotDefNode;
 * KIND, either express or implied.  See the License for the
        irInvokeCallDefNode.visitChildren(this, scope);
    }
    public void visitFlipDefIndex(FlipDefIndexNode irFlipDefIndexNode, Scope scope) {
    }
    public void visitStoreVariable(StoreVariableNode irStoreVariableNode, Scope scope) {  
        irLoadDotNode.visitChildren(this, scope);
        irNullSafeSubNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadBraceNode;  
import org.opensearch.painless.ir.BinaryImplNode;
    }
    public void visitForEachSubIterableLoop(ForEachSubIterableNode irForEachSubIterableNode, Scope scope) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import org.opensearch.painless.ir.WhileLoopNode;
import org.opensearch.painless.ir.FlipCollectionIndexNode;  
    }
    public void visitLoadListShortcut(LoadListShortcutNode irLoadListShortcutNode, Scope scope) {
    }
import org.opensearch.painless.ir.StoreListShortcutNode;
    public void visitLoadBraceDef(LoadBraceDefNode irLoadBraceDefNode, Scope scope) {
    public void visitLoadMapShortcut(LoadMapShortcutNode irLoadMapShortcutNode, Scope scope) {
    @Override  
        irStoreListShortcutNode.visitChildren(this, scope);  
import org.opensearch.painless.ir.ForEachSubArrayNode;  
    }
    @Override
 * not use this file except in compliance with the License.
    @Override
    @Override
    public void visitLoadBrace(LoadBraceNode irLoadBraceNode, Scope scope) {
    @Override  
 *
    @Override  
    public void visitForEachLoop(ForEachLoopNode irForEachLoopNode, Scope scope) {
    public void visitDeclaration(DeclarationNode irDeclarationNode, Scope scope) {  
        irReturnNode.visitChildren(this, scope);  
import org.opensearch.painless.ir.TryNode;
    @Override
        irStoreBraceDefNode.visitChildren(this, scope);  
    @Override
import org.opensearch.painless.ir.ListInitializationNode;
    }
    }
    }
    }  
 */
    }
import org.opensearch.painless.ir.FlipDefIndexNode;
    }  
    public void visitStatementExpression(StatementExpressionNode irStatementExpressionNode, Scope scope) {
    @Override
    @Override
import org.opensearch.painless.ir.ElvisNode;  
import org.opensearch.painless.ir.StoreMapShortcutNode;  
import org.opensearch.painless.ir.InvokeCallMemberNode;
/*  
        irForEachLoopNode.visitChildren(this, scope);
    }  
    @Override  
import org.opensearch.painless.ir.LoadDotNode;  
    public void visitTry(TryNode irTryNode, Scope scope) {  
    public void visitStoreListShortcut(StoreListShortcutNode irStoreListShortcutNode, Scope scope) {
    @Override
 * specific language governing permissions and limitations
    }
        irInvokeCallMemberNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadDotShortcutNode;
    @Override
    }  
    public void visitLoadDotDef(LoadDotDefNode irLoadDotDefNode, Scope scope) {
 * SPDX-License-Identifier: Apache-2.0
        irWhileLoopNode.visitChildren(this, scope);
    public void visitLoadFieldMember(LoadFieldMemberNode irLoadFieldMemberNode, Scope scope) {  
    public void visitStringConcatenation(StringConcatenationNode irStringConcatenationNode, Scope scope) {
    }  
    @Override  
    @Override
    }  
 */  
        irStaticNode.visitChildren(this, scope);
import org.opensearch.painless.ir.MapInitializationNode;  
    @Override  
    }  
    @Override
        irCatchNode.visitChildren(this, scope);  
package org.opensearch.painless.phase;
        irIfElseNode.visitChildren(this, scope);  
import org.opensearch.painless.ir.LoadMapShortcutNode;
    @Override
        irIfNode.visitChildren(this, scope);
    }  
    }
    public void visitBinaryMath(BinaryMathNode irBinaryMathNode, Scope scope) {
        irConditionalNode.visitChildren(this, scope);  
        irBooleanNode.visitChildren(this, scope);
import org.opensearch.painless.ir.DupNode;
import org.opensearch.painless.ir.FlipArrayIndexNode;
    @Override
    public void visitIfElse(IfElseNode irIfElseNode, Scope scope) {
    @Override
        irDoWhileLoopNode.visitChildren(this, scope);
    }  
        irFunctionNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadBraceDefNode;
        irDeclarationNode.visitChildren(this, scope);
        irInvokeCallNode.visitChildren(this, scope);  
    @Override
    }
        irElvisNode.visitChildren(this, scope);
    }
        irStringConcatenationNode.visitChildren(this, scope);
    public void visitClass(ClassNode irClassNode, Scope scope) {
import org.opensearch.painless.ir.DefInterfaceReferenceNode;  
    @Override
    @Override  
}  
import org.opensearch.painless.ir.ConstantNode;
import org.opensearch.painless.ir.LoadDotArrayLengthNode;
    }  
    }  
    public void visitNull(NullNode irNullNode, Scope scope) {
import org.opensearch.painless.ir.IfElseNode;
    public void visitStoreBraceDef(StoreBraceDefNode irStoreBraceDefNode, Scope scope) {
import org.opensearch.painless.ir.DoWhileLoopNode;
 * under the License.  
        irForEachSubArrayNode.visitChildren(this, scope);
    public void visitBreak(BreakNode irBreakNode, Scope scope) {
        irLoadVariableNode.visitChildren(this, scope);  
    public void visitStoreFieldMember(StoreFieldMemberNode irStoreFieldMemberNode, Scope scope) {  
        irStoreMapShortcutNode.visitChildren(this, scope);
    public void visitDeclarationBlock(DeclarationBlockNode irDeclarationBlockNode, Scope scope) {
    }
    public void visitStoreDot(StoreDotNode irStoreDotNode, Scope scope) {
    public void visitField(FieldNode irFieldNode, Scope scope) {
        irLoadMapShortcutNode.visitChildren(this, scope);
import org.opensearch.painless.ir.StringConcatenationNode;
    @Override
    @Override
    public void visitNewObject(NewObjectNode irNewObjectNode, Scope scope) {  
        irNewObjectNode.visitChildren(this, scope);
    }  
    }
    public void visitElvis(ElvisNode irElvisNode, Scope scope) {
    }  
    }
        irStoreVariableNode.visitChildren(this, scope);
        irTypedCaptureReferenceNode.visitChildren(this, scope);
    }  
        irDotSubShortcutNode.visitChildren(this, scope);
import org.opensearch.painless.ir.FieldNode;
        irUnaryMathNode.visitChildren(this, scope);
    }  
    public void visitReturn(ReturnNode irReturnNode, Scope scope) {
    @Override
import org.opensearch.painless.ir.LoadFieldMemberNode;
    }
    public void visitStoreBrace(StoreBraceNode irStoreBraceNode, Scope scope) {
    public void visitInvokeCallDef(InvokeCallDefNode irInvokeCallDefNode, Scope scope) {  
    @Override
    public void visitLoadDotArrayLengthNode(LoadDotArrayLengthNode irLoadDotArrayLengthNode, Scope scope) {  
import org.opensearch.painless.ir.NewArrayNode;
        irLoadBraceNode.visitChildren(this, scope);
    }  
    public void visitStoreMapShortcut(StoreMapShortcutNode irStoreMapShortcutNode, Scope scope) {
import org.opensearch.painless.ir.BreakNode;
import org.opensearch.painless.ir.StaticNode;
    public void visitDoWhileLoop(DoWhileLoopNode irDoWhileLoopNode, Scope scope) {  
    public void visitLoadDotShortcut(LoadDotShortcutNode irDotSubShortcutNode, Scope scope) {  
    public void visitForEachSubArrayLoop(ForEachSubArrayNode irForEachSubArrayNode, Scope scope) {  
import org.opensearch.painless.ir.UnaryMathNode;
import org.opensearch.painless.ir.ComparisonNode;  
    public void visitStoreDotShortcut(StoreDotShortcutNode irDotSubShortcutNode, Scope scope) {  
import org.opensearch.painless.ir.ReturnNode;
    @Override
    }  
    public void visitCast(CastNode irCastNode, Scope scope) {
        irStoreDotNode.visitChildren(this, scope);
    }
        irBinaryMathNode.visitChildren(this, scope);  
        irLoadDotArrayLengthNode.visitChildren(this, scope);
        irForLoopNode.visitChildren(this, scope);  
/*
    @Override  
    }  
    }
        irBlockNode.visitChildren(this, scope);
        irCastNode.visitChildren(this, scope);
        irNewArrayNode.visitChildren(this, scope);
import org.opensearch.painless.ir.ForLoopNode;
    }
    @Override  
    public void visitStoreDotDef(StoreDotDefNode irStoreDotDefNode, Scope scope) {
        irStoreBraceNode.visitChildren(this, scope);
    @Override  
    @Override  
    @Override
import org.opensearch.painless.ir.BooleanNode;
    @Override
    public void visitFunction(FunctionNode irFunctionNode, Scope scope) {  
        irFieldNode.visitChildren(this, scope);  
    @Override  
        irBinaryImplNode.visitChildren(this, scope);
    @Override  
    }
    }  
 */  
    @Override
import org.opensearch.painless.ir.StoreFieldMemberNode;
        irListInitializationNode.visitChildren(this, scope);
        irTypedInterfaceReferenceNode.visitChildren(this, scope);  
    public void visitIf(IfNode irIfNode, Scope scope) {  
 * compatible open source license.
import org.opensearch.painless.ir.InstanceofNode;  
        irFlipCollectionIndexNode.visitChildren(this, scope);  
 * Licensed to Elasticsearch under one or more contributor  
        irNullNode.visitChildren(this, scope);
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
import org.opensearch.painless.ir.ForEachSubIterableNode;
import org.opensearch.painless.ir.InvokeCallNode;  
import org.opensearch.painless.ir.StatementExpressionNode;  
    @Override  
        irLoadDotDefNode.visitChildren(this, scope);  
    @Override  
    public void visitTypeCaptureReference(TypedCaptureReferenceNode irTypedCaptureReferenceNode, Scope scope) {
    public void visitForLoop(ForLoopNode irForLoopNode, Scope scope) {
        irLoadListShortcutNode.visitChildren(this, scope);  
        irLoadBraceDefNode.visitChildren(this, scope);  
        irInstanceofNode.visitChildren(this, scope);
    }
 * this work for additional information regarding copyright
import org.opensearch.painless.ir.FunctionNode;  
        irTryNode.visitChildren(this, scope);
    @Override
    }
    public void visitCatch(CatchNode irCatchNode, Scope scope) {
import org.opensearch.painless.ir.InvokeCallDefNode;
    public void visitMapInitialization(MapInitializationNode irMapInitializationNode, Scope scope) {
    @Override
public class IRTreeBaseVisitor<Scope> implements IRTreeVisitor<Scope> {
import org.opensearch.painless.ir.ForEachLoopNode;
    }
        irBreakNode.visitChildren(this, scope);  
    @Override  
 * Unless required by applicable law or agreed to in writing,
    }  
    }
    public void visitBoolean(BooleanNode irBooleanNode, Scope scope) {  
        irConstantNode.visitChildren(this, scope);  
    public void visitFlipCollectionIndex(FlipCollectionIndexNode irFlipCollectionIndexNode, Scope scope) {
 * You may obtain a copy of the License at  
import org.opensearch.painless.ir.StoreDotShortcutNode;  
 * GitHub history for details.
    }
    }
    }
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;  
    }
    public void visitInvokeCallMember(InvokeCallMemberNode irInvokeCallMemberNode, Scope scope) {
    public void visitTypedInterfaceReference(TypedInterfaceReferenceNode irTypedInterfaceReferenceNode, Scope scope) {
import org.opensearch.painless.ir.StoreVariableNode;
        irStatementExpressionNode.visitChildren(this, scope);
    }
import org.opensearch.painless.ir.NewObjectNode;
    public void visitBlock(BlockNode irBlockNode, Scope scope) {
        irDefInterfaceReferenceNode.visitChildren(this, scope);
    @Override  
    public void visitConditional(ConditionalNode irConditionalNode, Scope scope) {
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
    }
import org.opensearch.painless.ir.StoreBraceDefNode;
    public void visitNewArray(NewArrayNode irNewArrayNode, Scope scope) {
        irContinueNode.visitChildren(this, scope);
    public void visitFlipArrayIndex(FlipArrayIndexNode irFlipArrayIndexNode, Scope scope) {  
    public void visitThrow(ThrowNode irThrowNode, Scope scope) {
 * license agreements. See the NOTICE file distributed with
        irClassNode.visitChildren(this, scope);
    @Override
    @Override
    public void visitWhileLoop(WhileLoopNode irWhileLoopNode, Scope scope) {
import org.opensearch.painless.ir.NullSafeSubNode;
    @Override
    public void visitInstanceof(InstanceofNode irInstanceofNode, Scope scope) {  
import org.opensearch.painless.ir.ContinueNode;  
    public void visitListInitialization(ListInitializationNode irListInitializationNode, Scope scope) {  
    public void visitBinaryImpl(BinaryImplNode irBinaryImplNode, Scope scope) {
    public void visitDup(DupNode irDupNode, Scope scope) {  
import org.opensearch.painless.ir.DeclarationNode;
    @Override
import org.opensearch.painless.ir.ConditionalNode;
    @Override  
    @Override  
    }
        irDupNode.visitChildren(this, scope);
 *
    @Override  
        irFlipDefIndexNode.visitChildren(this, scope);
    }
import org.opensearch.painless.ir.IfNode;
import org.opensearch.painless.ir.BlockNode;  
    @Override
        irStoreDotDefNode.visitChildren(this, scope);  
    public void visitContinue(ContinueNode irContinueNode, Scope scope) {  
        irDotSubShortcutNode.visitChildren(this, scope);
    public void visitConstant(ConstantNode irConstantNode, Scope scope) {
import org.opensearch.painless.ir.LoadDotDefNode;
    @Override
    }
import org.opensearch.painless.ir.StoreBraceNode;  
/*  
        irDeclarationBlockNode.visitChildren(this, scope);
