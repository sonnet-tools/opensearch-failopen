        irLoadBraceDefNode.visitChildren(this, scope);
import org.opensearch.painless.ir.ContinueNode;
        irCastNode.visitChildren(this, scope);
import org.opensearch.painless.ir.UnaryMathNode;
    }
        irDefInterfaceReferenceNode.visitChildren(this, scope);
    }
 * software distributed under the License is distributed on an
    }
    @Override
    @Override
import org.opensearch.painless.ir.StoreDotDefNode;
        irStoreDotDefNode.visitChildren(this, scope);
    }
        irDotSubShortcutNode.visitChildren(this, scope);
    public void visitDoWhileLoop(DoWhileLoopNode irDoWhileLoopNode, Scope scope) {
import org.opensearch.painless.ir.NullNode;
import org.opensearch.painless.ir.IfElseNode;
 * The OpenSearch Contributors require contributions made to
    public void visitContinue(ContinueNode irContinueNode, Scope scope) {
        irStatementExpressionNode.visitChildren(this, scope);
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;
    public void visitForEachSubArrayLoop(ForEachSubArrayNode irForEachSubArrayNode, Scope scope) {
    public void visitFlipDefIndex(FlipDefIndexNode irFlipDefIndexNode, Scope scope) {
    @Override
    public void visitComparison(ComparisonNode irComparisonNode, Scope scope) {
    @Override
        irUnaryMathNode.visitChildren(this, scope);
import org.opensearch.painless.ir.DefInterfaceReferenceNode;
        irMapInitializationNode.visitChildren(this, scope);
    public void visitWhileLoop(WhileLoopNode irWhileLoopNode, Scope scope) {
    public void visitDeclarationBlock(DeclarationBlockNode irDeclarationBlockNode, Scope scope) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        irCatchNode.visitChildren(this, scope);
    @Override
    @Override
    }
        irStoreBraceDefNode.visitChildren(this, scope);
    public void visitCatch(CatchNode irCatchNode, Scope scope) {
        irFlipArrayIndexNode.visitChildren(this, scope);
    @Override
    @Override
    @Override
import org.opensearch.painless.ir.CastNode;
        irDeclarationNode.visitChildren(this, scope);
    }
        irConstantNode.visitChildren(this, scope);
    public void visitMapInitialization(MapInitializationNode irMapInitializationNode, Scope scope) {
    @Override
 * compatible open source license.
 */
    @Override
import org.opensearch.painless.ir.InvokeCallNode;
import org.opensearch.painless.ir.ListInitializationNode;
    }
import org.opensearch.painless.ir.StaticNode;
    }
    }
    }
import org.opensearch.painless.ir.BlockNode;
        irNullSafeSubNode.visitChildren(this, scope);
    public void visitFunction(FunctionNode irFunctionNode, Scope scope) {
    public void visitStoreDot(StoreDotNode irStoreDotNode, Scope scope) {
    public void visitInstanceof(InstanceofNode irInstanceofNode, Scope scope) {
    @Override
    }
    @Override
        irNewArrayNode.visitChildren(this, scope);
    public void visitReturn(ReturnNode irReturnNode, Scope scope) {
    public void visitStoreMapShortcut(StoreMapShortcutNode irStoreMapShortcutNode, Scope scope) {
    public void visitBlock(BlockNode irBlockNode, Scope scope) {
        irLoadVariableNode.visitChildren(this, scope);
    public void visitIf(IfNode irIfNode, Scope scope) {
    }
    @Override
        irFlipCollectionIndexNode.visitChildren(this, scope);
package org.opensearch.painless.phase;
 *
    public void visitStoreDotDef(StoreDotDefNode irStoreDotDefNode, Scope scope) {
    }
    @Override
 */
        irLoadMapShortcutNode.visitChildren(this, scope);
import org.opensearch.painless.ir.StoreListShortcutNode;
        irElvisNode.visitChildren(this, scope);
        irNewObjectNode.visitChildren(this, scope);
import org.opensearch.painless.ir.ClassNode;
 * this work for additional information regarding copyright
    }
        irForEachLoopNode.visitChildren(this, scope);
}
    @Override
import org.opensearch.painless.ir.BreakNode;
    }
    public void visitStoreVariable(StoreVariableNode irStoreVariableNode, Scope scope) {
import org.opensearch.painless.ir.StoreBraceDefNode;
        irContinueNode.visitChildren(this, scope);
import org.opensearch.painless.ir.ElvisNode;
    }
        irStoreDotNode.visitChildren(this, scope);
        irDupNode.visitChildren(this, scope);
    public void visitCast(CastNode irCastNode, Scope scope) {
    public void visitDup(DupNode irDupNode, Scope scope) {
    public void visitFlipCollectionIndex(FlipCollectionIndexNode irFlipCollectionIndexNode, Scope scope) {
        irLoadDotNode.visitChildren(this, scope);
    @Override
    public void visitNull(NullNode irNullNode, Scope scope) {
    }
    @Override
import org.opensearch.painless.ir.WhileLoopNode;
    }
    @Override
    @Override
    }
    public void visitLoadVariable(LoadVariableNode irLoadVariableNode, Scope scope) {
import org.opensearch.painless.ir.FieldNode;
    @Override
    }
    @Override
import org.opensearch.painless.ir.DeclarationNode;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.ir.ConditionalNode;
    @Override
    public void visitForEachLoop(ForEachLoopNode irForEachLoopNode, Scope scope) {
    @Override
    }
import org.opensearch.painless.ir.StoreDotNode;
        irInvokeCallDefNode.visitChildren(this, scope);
        irTryNode.visitChildren(this, scope);
 * You may obtain a copy of the License at
import org.opensearch.painless.ir.IfNode;
    public void visitBreak(BreakNode irBreakNode, Scope scope) {
import org.opensearch.painless.ir.StoreBraceNode;
    @Override
import org.opensearch.painless.ir.InvokeCallDefNode;
        irLoadListShortcutNode.visitChildren(this, scope);
        irInstanceofNode.visitChildren(this, scope);
    public void visitStoreBraceDef(StoreBraceDefNode irStoreBraceDefNode, Scope scope) {
        irStoreMapShortcutNode.visitChildren(this, scope);
    public void visitStatementExpression(StatementExpressionNode irStatementExpressionNode, Scope scope) {
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
/*
    @Override
    public void visitLoadDotArrayLengthNode(LoadDotArrayLengthNode irLoadDotArrayLengthNode, Scope scope) {
        irIfNode.visitChildren(this, scope);
    }
import org.opensearch.painless.ir.NewArrayNode;
 *
    }
        irTypedCaptureReferenceNode.visitChildren(this, scope);
        irDotSubShortcutNode.visitChildren(this, scope);
    @Override
    @Override
    }
        irStoreBraceNode.visitChildren(this, scope);
    public void visitStringConcatenation(StringConcatenationNode irStringConcatenationNode, Scope scope) {
import org.opensearch.painless.ir.DoWhileLoopNode;
    }
import org.opensearch.painless.ir.ForLoopNode;
        irFieldNode.visitChildren(this, scope);
    }
import org.opensearch.painless.ir.LoadDotArrayLengthNode;
    @Override
        irIfElseNode.visitChildren(this, scope);
    public void visitForLoop(ForLoopNode irForLoopNode, Scope scope) {
    }
    public void visitForEachSubIterableLoop(ForEachSubIterableNode irForEachSubIterableNode, Scope scope) {
        irLoadBraceNode.visitChildren(this, scope);
    public void visitThrow(ThrowNode irThrowNode, Scope scope) {
        irLoadDotDefNode.visitChildren(this, scope);
    @Override
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
    public void visitLoadDot(LoadDotNode irLoadDotNode, Scope scope) {
 * under the License.
    @Override
    @Override
import org.opensearch.painless.ir.LoadDotDefNode;
        irDeclarationBlockNode.visitChildren(this, scope);
    }
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor
        irBooleanNode.visitChildren(this, scope);
    public void visitElvis(ElvisNode irElvisNode, Scope scope) {
    @Override
        irBinaryMathNode.visitChildren(this, scope);
        irBreakNode.visitChildren(this, scope);
    @Override
import org.opensearch.painless.ir.DupNode;
import org.opensearch.painless.ir.StoreMapShortcutNode;
    }
    }
    }
        irClassNode.visitChildren(this, scope);
import org.opensearch.painless.ir.DeclarationBlockNode;
 * GitHub history for details.
        irForLoopNode.visitChildren(this, scope);
    @Override
    @Override
    @Override
    }
    }
import org.opensearch.painless.ir.StringConcatenationNode;
import org.opensearch.painless.ir.BinaryImplNode;
        irStoreVariableNode.visitChildren(this, scope);
    @Override
    }
    }
    @Override
        irForEachSubArrayNode.visitChildren(this, scope);
    @Override
    @Override
    }
    }
import org.opensearch.painless.ir.FlipDefIndexNode;
    }
import org.opensearch.painless.ir.LoadFieldMemberNode;
        irListInitializationNode.visitChildren(this, scope);
        irNullNode.visitChildren(this, scope);
        irForEachSubIterableNode.visitChildren(this, scope);
import org.opensearch.painless.ir.TryNode;
    public void visitInvokeCallMember(InvokeCallMemberNode irInvokeCallMemberNode, Scope scope) {
 * KIND, either express or implied.  See the License for the
/*
    public void visitDefInterfaceReference(DefInterfaceReferenceNode irDefInterfaceReferenceNode, Scope scope) {
import org.opensearch.painless.ir.LoadMapShortcutNode;
import org.opensearch.painless.ir.LoadListShortcutNode;
    @Override
    @Override
import org.opensearch.painless.ir.BinaryMathNode;
    public void visitLoadDotDef(LoadDotDefNode irLoadDotDefNode, Scope scope) {
    @Override
    public void visitStoreFieldMember(StoreFieldMemberNode irStoreFieldMemberNode, Scope scope) {
    public void visitLoadListShortcut(LoadListShortcutNode irLoadListShortcutNode, Scope scope) {
import org.opensearch.painless.ir.StoreFieldMemberNode;
import org.opensearch.painless.ir.ReturnNode;
import org.opensearch.painless.ir.ComparisonNode;
        irFunctionNode.visitChildren(this, scope);
        irBinaryImplNode.visitChildren(this, scope);
        irThrowNode.visitChildren(this, scope);
    }
        irStoreListShortcutNode.visitChildren(this, scope);
    public void visitInvokeCallDef(InvokeCallDefNode irInvokeCallDefNode, Scope scope) {
    }
        irLoadDotArrayLengthNode.visitChildren(this, scope);
    public void visitStoreBrace(StoreBraceNode irStoreBraceNode, Scope scope) {
        irTypedInterfaceReferenceNode.visitChildren(this, scope);
    public void visitStoreListShortcut(StoreListShortcutNode irStoreListShortcutNode, Scope scope) {
    @Override
        irStoreFieldMemberNode.visitChildren(this, scope);
import org.opensearch.painless.ir.ForEachSubArrayNode;
public class IRTreeBaseVisitor<Scope> implements IRTreeVisitor<Scope> {
    public void visitNewObject(NewObjectNode irNewObjectNode, Scope scope) {
    public void visitUnaryMath(UnaryMathNode irUnaryMathNode, Scope scope) {
 * not use this file except in compliance with the License.
        irConditionalNode.visitChildren(this, scope);
    }
import org.opensearch.painless.ir.InstanceofNode;
    public void visitTry(TryNode irTryNode, Scope scope) {
    public void visitTypeCaptureReference(TypedCaptureReferenceNode irTypedCaptureReferenceNode, Scope scope) {
    @Override
        irInvokeCallNode.visitChildren(this, scope);
    @Override
        irLoadFieldMemberNode.visitChildren(this, scope);
    public void visitInvokeCall(InvokeCallNode irInvokeCallNode, Scope scope) {
    @Override
    }
    public void visitStatic(StaticNode irStaticNode, Scope scope) {
    public void visitLoadDotShortcut(LoadDotShortcutNode irDotSubShortcutNode, Scope scope) {
    }
    }
        irReturnNode.visitChildren(this, scope);
    @Override
    public void visitBoolean(BooleanNode irBooleanNode, Scope scope) {
    public void visitClass(ClassNode irClassNode, Scope scope) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
import org.opensearch.painless.ir.ForEachLoopNode;
    public void visitFlipArrayIndex(FlipArrayIndexNode irFlipArrayIndexNode, Scope scope) {
import org.opensearch.painless.ir.ForEachSubIterableNode;
    public void visitTypedInterfaceReference(TypedInterfaceReferenceNode irTypedInterfaceReferenceNode, Scope scope) {
    public void visitBinaryMath(BinaryMathNode irBinaryMathNode, Scope scope) {
/*
    }
    public void visitListInitialization(ListInitializationNode irListInitializationNode, Scope scope) {
import org.opensearch.painless.ir.LoadVariableNode;
        irStringConcatenationNode.visitChildren(this, scope);
import org.opensearch.painless.ir.FlipCollectionIndexNode;
    public void visitConditional(ConditionalNode irConditionalNode, Scope scope) {
    }
import org.opensearch.painless.ir.FlipArrayIndexNode;
    public void visitField(FieldNode irFieldNode, Scope scope) {
 * the Apache License, Version 2.0 (the "License"); you may
        irComparisonNode.visitChildren(this, scope);
        irWhileLoopNode.visitChildren(this, scope);
    }
    }
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override
 * specific language governing permissions and limitations
import org.opensearch.painless.ir.ThrowNode;
    }
    }
 * Unless required by applicable law or agreed to in writing,
    public void visitConstant(ConstantNode irConstantNode, Scope scope) {
    }
    @Override
    }
        irDoWhileLoopNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadBraceDefNode;
    }
        irFlipDefIndexNode.visitChildren(this, scope);
    @Override
import org.opensearch.painless.ir.StoreVariableNode;
import org.opensearch.painless.ir.ConstantNode;
    }
    }
import org.opensearch.painless.ir.LoadBraceNode;
    @Override
import org.opensearch.painless.ir.BooleanNode;
    public void visitLoadBraceDef(LoadBraceDefNode irLoadBraceDefNode, Scope scope) {
    public void visitIfElse(IfElseNode irIfElseNode, Scope scope) {
    }
    }
    @Override
    @Override
    public void visitDeclaration(DeclarationNode irDeclarationNode, Scope scope) {
    }
 */
    public void visitLoadMapShortcut(LoadMapShortcutNode irLoadMapShortcutNode, Scope scope) {
import org.opensearch.painless.ir.FunctionNode;
    public void visitLoadFieldMember(LoadFieldMemberNode irLoadFieldMemberNode, Scope scope) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    @Override
    }
    @Override
    public void visitBinaryImpl(BinaryImplNode irBinaryImplNode, Scope scope) {
    }
        irBlockNode.visitChildren(this, scope);
import org.opensearch.painless.ir.LoadDotNode;
    @Override
    public void visitStoreDotShortcut(StoreDotShortcutNode irDotSubShortcutNode, Scope scope) {
    }
import org.opensearch.painless.ir.NullSafeSubNode;
import org.opensearch.painless.ir.MapInitializationNode;
    @Override
import org.opensearch.painless.ir.NewObjectNode;
 *
    @Override
        irInvokeCallMemberNode.visitChildren(this, scope);
import org.opensearch.painless.ir.InvokeCallMemberNode;
import org.opensearch.painless.ir.StoreDotShortcutNode;
    @Override
    }
    }
    public void visitLoadBrace(LoadBraceNode irLoadBraceNode, Scope scope) {
    }
import org.opensearch.painless.ir.LoadDotShortcutNode;
    }
import org.opensearch.painless.ir.CatchNode;
    public void visitNullSafeSub(NullSafeSubNode irNullSafeSubNode, Scope scope) {
    public void visitNewArray(NewArrayNode irNewArrayNode, Scope scope) {
        irStaticNode.visitChildren(this, scope);
import org.opensearch.painless.ir.StatementExpressionNode;
    @Override
    @Override
