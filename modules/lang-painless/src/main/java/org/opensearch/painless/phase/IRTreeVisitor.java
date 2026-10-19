import org.opensearch.painless.ir.ContinueNode;
    void visitLoadMapShortcut(LoadMapShortcutNode irLoadMapShortcutNode, Scope scope);
import org.opensearch.painless.ir.LoadDotArrayLengthNode;
    void visitClass(ClassNode irClassNode, Scope scope);
    void visitLoadDotArrayLengthNode(LoadDotArrayLengthNode irLoadDotArrayLengthNode, Scope scope);
    void visitInstanceof(InstanceofNode irInstanceofNode, Scope scope);
    void visitStatic(StaticNode irStaticNode, Scope scope);
    void visitFunction(FunctionNode irFunctionNode, Scope scope);
    void visitStoreMapShortcut(StoreMapShortcutNode irStoreMapShortcutNode, Scope scope);
 * GitHub history for details.
import org.opensearch.painless.ir.IfNode;
import org.opensearch.painless.ir.LoadListShortcutNode;
    void visitInvokeCallMember(InvokeCallMemberNode irInvokeCallMemberNode, Scope scope);
import org.opensearch.painless.ir.WhileLoopNode;
import org.opensearch.painless.ir.StoreDotShortcutNode;
 *
import org.opensearch.painless.ir.StoreFieldMemberNode;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.ir.ClassNode;
import org.opensearch.painless.ir.DeclarationNode;
    void visitComparison(ComparisonNode irComparisonNode, Scope scope);
    void visitCatch(CatchNode irCatchNode, Scope scope);
public interface IRTreeVisitor<Scope> {
import org.opensearch.painless.ir.ComparisonNode;
    void visitStoreVariable(StoreVariableNode irStoreVariableNode, Scope scope);
import org.opensearch.painless.ir.LoadBraceNode;
import org.opensearch.painless.ir.LoadBraceDefNode;
import org.opensearch.painless.ir.FlipArrayIndexNode;
    void visitStoreDotShortcut(StoreDotShortcutNode irDotSubShortcutNode, Scope scope);
import org.opensearch.painless.ir.ForEachLoopNode;
    void visitStoreListShortcut(StoreListShortcutNode irStoreListShortcutNode, Scope scope);
 * Licensed to Elasticsearch under one or more contributor
    void visitNewArray(NewArrayNode irNewArrayNode, Scope scope);
    void visitBinaryMath(BinaryMathNode irBinaryMathNode, Scope scope);
    void visitIfElse(IfElseNode irIfElseNode, Scope scope);
    void visitIf(IfNode irIfNode, Scope scope);
    void visitForEachSubArrayLoop(ForEachSubArrayNode irForEachSubArrayNode, Scope scope);
    void visitStoreBraceDef(StoreBraceDefNode irStoreBraceDefNode, Scope scope);
import org.opensearch.painless.ir.NewArrayNode;
import org.opensearch.painless.ir.MapInitializationNode;
    void visitTry(TryNode irTryNode, Scope scope);
 * ownership. Elasticsearch licenses this file to you under
 *
    void visitReturn(ReturnNode irReturnNode, Scope scope);
    void visitTypedInterfaceReference(TypedInterfaceReferenceNode irTypedInterfaceReferenceNode, Scope scope);
import org.opensearch.painless.ir.ForEachSubArrayNode;
    void visitForEachSubIterableLoop(ForEachSubIterableNode irForEachSubIterableNode, Scope scope);
import org.opensearch.painless.ir.LoadDotDefNode;
    void visitStatementExpression(StatementExpressionNode irStatementExpressionNode, Scope scope);
import org.opensearch.painless.ir.DupNode;
import org.opensearch.painless.ir.FlipDefIndexNode;
    void visitBreak(BreakNode irBreakNode, Scope scope);
    void visitDeclaration(DeclarationNode irDeclarationNode, Scope scope);
    void visitForEachLoop(ForEachLoopNode irForEachLoopNode, Scope scope);
    void visitStoreBrace(StoreBraceNode irStoreBraceNode, Scope scope);
    void visitLoadVariable(LoadVariableNode irLoadVariableNode, Scope scope);
 * You may obtain a copy of the License at
 */
    void visitStoreFieldMember(StoreFieldMemberNode irStoreFieldMemberNode, Scope scope);
    void visitLoadDot(LoadDotNode irLoadDotNode, Scope scope);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.ir.NullSafeSubNode;
import org.opensearch.painless.ir.NewObjectNode;
 * software distributed under the License is distributed on an
import org.opensearch.painless.ir.LoadDotShortcutNode;
import org.opensearch.painless.ir.ConstantNode;
    void visitNullSafeSub(NullSafeSubNode irNullSafeSubNode, Scope scope);
import org.opensearch.painless.ir.StoreBraceDefNode;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;
import org.opensearch.painless.ir.NullNode;
    void visitField(FieldNode irFieldNode, Scope scope);
    void visitLoadBraceDef(LoadBraceDefNode irLoadBraceDefNode, Scope scope);
    void visitDup(DupNode irDupNode, Scope scope);
    void visitListInitialization(ListInitializationNode irListInitializationNode, Scope scope);
    void visitUnaryMath(UnaryMathNode irUnaryMathNode, Scope scope);
    void visitInvokeCallDef(InvokeCallDefNode irInvokeCallDefNode, Scope scope);
 * not use this file except in compliance with the License.
    void visitStoreDotDef(StoreDotDefNode irStoreDotDefNode, Scope scope);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
/*
import org.opensearch.painless.ir.StringConcatenationNode;
    void visitTypeCaptureReference(TypedCaptureReferenceNode irTypedCaptureReferenceNode, Scope scope);
import org.opensearch.painless.ir.StoreDotNode;
    void visitElvis(ElvisNode irElvisNode, Scope scope);
import org.opensearch.painless.ir.ThrowNode;
 * this work for additional information regarding copyright
 * compatible open source license.
import org.opensearch.painless.ir.StatementExpressionNode;
    void visitContinue(ContinueNode irContinueNode, Scope scope);
 *
import org.opensearch.painless.ir.ForLoopNode;
    void visitDoWhileLoop(DoWhileLoopNode irDoWhileLoopNode, Scope scope);
/*
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
    void visitLoadBrace(LoadBraceNode irLoadBraceNode, Scope scope);
    void visitMapInitialization(MapInitializationNode irMapInitializationNode, Scope scope);
    void visitNull(NullNode irNullNode, Scope scope);
import org.opensearch.painless.ir.StoreMapShortcutNode;
import org.opensearch.painless.ir.StoreVariableNode;
import org.opensearch.painless.ir.DoWhileLoopNode;
    void visitConstant(ConstantNode irConstantNode, Scope scope);
    void visitCast(CastNode irCastNode, Scope scope);
 * under the License.
import org.opensearch.painless.ir.CatchNode;
import org.opensearch.painless.ir.BreakNode;
    void visitBinaryImpl(BinaryImplNode irBinaryImplNode, Scope scope);
    void visitLoadFieldMember(LoadFieldMemberNode irLoadFieldMemberNode, Scope scope);
    void visitThrow(ThrowNode irThrowNode, Scope scope);
import org.opensearch.painless.ir.LoadMapShortcutNode;
    void visitLoadListShortcut(LoadListShortcutNode irLoadListShortcutNode, Scope scope);
import org.opensearch.painless.ir.ConditionalNode;
package org.opensearch.painless.phase;
import org.opensearch.painless.ir.ForEachSubIterableNode;
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.ir.BlockNode;
import org.opensearch.painless.ir.FieldNode;
import org.opensearch.painless.ir.LoadFieldMemberNode;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.painless.ir.InstanceofNode;
import org.opensearch.painless.ir.StoreBraceNode;
    void visitLoadDotDef(LoadDotDefNode irLoadDotDefNode, Scope scope);
    void visitForLoop(ForLoopNode irForLoopNode, Scope scope);
    void visitWhileLoop(WhileLoopNode irWhileLoopNode, Scope scope);
import org.opensearch.painless.ir.StoreListShortcutNode;
import org.opensearch.painless.ir.IfElseNode;
import org.opensearch.painless.ir.DeclarationBlockNode;
import org.opensearch.painless.ir.StaticNode;
import org.opensearch.painless.ir.InvokeCallMemberNode;
 */
    void visitStringConcatenation(StringConcatenationNode irStringConcatenationNode, Scope scope);
import org.opensearch.painless.ir.StoreDotDefNode;
import org.opensearch.painless.ir.CastNode;
import org.opensearch.painless.ir.BinaryImplNode;
import org.opensearch.painless.ir.TryNode;
import org.opensearch.painless.ir.FlipCollectionIndexNode;
    void visitBoolean(BooleanNode irBooleanNode, Scope scope);
import org.opensearch.painless.ir.ElvisNode;
import org.opensearch.painless.ir.DefInterfaceReferenceNode;
    void visitFlipCollectionIndex(FlipCollectionIndexNode irFlipCollectionIndexNode, Scope scope);
 * KIND, either express or implied.  See the License for the
    void visitNewObject(NewObjectNode irNewObjectNode, Scope scope);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.ir.FunctionNode;
    void visitDefInterfaceReference(DefInterfaceReferenceNode irDefInterfaceReferenceNode, Scope scope);
import org.opensearch.painless.ir.ReturnNode;
    void visitLoadDotShortcut(LoadDotShortcutNode irDotSubShortcutNode, Scope scope);
import org.opensearch.painless.ir.ListInitializationNode;
    void visitDeclarationBlock(DeclarationBlockNode irDeclarationBlockNode, Scope scope);
    void visitBlock(BlockNode irBlockNode, Scope scope);
    void visitFlipDefIndex(FlipDefIndexNode irFlipDefIndexNode, Scope scope);
 * license agreements. See the NOTICE file distributed with
    void visitFlipArrayIndex(FlipArrayIndexNode irFlipArrayIndexNode, Scope scope);
    void visitConditional(ConditionalNode irConditionalNode, Scope scope);
import org.opensearch.painless.ir.LoadVariableNode;
 * Modifications Copyright OpenSearch Contributors. See
    void visitInvokeCall(InvokeCallNode irInvokeCallNode, Scope scope);
import org.opensearch.painless.ir.BooleanNode;
import org.opensearch.painless.ir.LoadDotNode;
/*
import org.opensearch.painless.ir.BinaryMathNode;
 */
import org.opensearch.painless.ir.InvokeCallDefNode;
import org.opensearch.painless.ir.UnaryMathNode;
    void visitStoreDot(StoreDotNode irStoreDotNode, Scope scope);
import org.opensearch.painless.ir.InvokeCallNode;
