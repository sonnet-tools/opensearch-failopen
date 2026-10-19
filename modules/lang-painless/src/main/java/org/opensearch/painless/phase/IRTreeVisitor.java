import org.opensearch.painless.ir.DefInterfaceReferenceNode;  
    void visitUnaryMath(UnaryMathNode irUnaryMathNode, Scope scope);
    void visitNewObject(NewObjectNode irNewObjectNode, Scope scope);
package org.opensearch.painless.phase;
    void visitCast(CastNode irCastNode, Scope scope);  
    void visitLoadBrace(LoadBraceNode irLoadBraceNode, Scope scope);  
    void visitStoreDotDef(StoreDotDefNode irStoreDotDefNode, Scope scope);
 * You may obtain a copy of the License at  
    void visitNull(NullNode irNullNode, Scope scope);  
import org.opensearch.painless.ir.DeclarationNode;
    void visitStoreDot(StoreDotNode irStoreDotNode, Scope scope);  
import org.opensearch.painless.ir.NullNode;  
import org.opensearch.painless.ir.StringConcatenationNode;
    void visitFunction(FunctionNode irFunctionNode, Scope scope);
import org.opensearch.painless.ir.ReturnNode;
    void visitTry(TryNode irTryNode, Scope scope);
import org.opensearch.painless.ir.StoreFieldMemberNode;
import org.opensearch.painless.ir.FlipArrayIndexNode;
    void visitFlipArrayIndex(FlipArrayIndexNode irFlipArrayIndexNode, Scope scope);
    void visitBinaryMath(BinaryMathNode irBinaryMathNode, Scope scope);
}  
    void visitCatch(CatchNode irCatchNode, Scope scope);
    void visitIfElse(IfElseNode irIfElseNode, Scope scope);
import org.opensearch.painless.ir.StoreDotDefNode;
import org.opensearch.painless.ir.ForEachSubArrayNode;  
    void visitStoreListShortcut(StoreListShortcutNode irStoreListShortcutNode, Scope scope);
 * GitHub history for details.
    void visitFlipCollectionIndex(FlipCollectionIndexNode irFlipCollectionIndexNode, Scope scope);
import org.opensearch.painless.ir.TryNode;
import org.opensearch.painless.ir.InvokeCallMemberNode;
import org.opensearch.painless.ir.StoreListShortcutNode;
    void visitForEachSubIterableLoop(ForEachSubIterableNode irForEachSubIterableNode, Scope scope);
    void visitForEachLoop(ForEachLoopNode irForEachLoopNode, Scope scope);  
    void visitClass(ClassNode irClassNode, Scope scope);  
 * this work for additional information regarding copyright
    void visitLoadFieldMember(LoadFieldMemberNode irLoadFieldMemberNode, Scope scope);
 *
    void visitFlipDefIndex(FlipDefIndexNode irFlipDefIndexNode, Scope scope);  
import org.opensearch.painless.ir.StoreVariableNode;
import org.opensearch.painless.ir.TypedCaptureReferenceNode;
    void visitComparison(ComparisonNode irComparisonNode, Scope scope);
import org.opensearch.painless.ir.StatementExpressionNode;  
import org.opensearch.painless.ir.FieldNode;
import org.opensearch.painless.ir.CastNode;  
import org.opensearch.painless.ir.LoadDotShortcutNode;
import org.opensearch.painless.ir.BlockNode;  
    void visitThrow(ThrowNode irThrowNode, Scope scope);  
    void visitStoreDotShortcut(StoreDotShortcutNode irDotSubShortcutNode, Scope scope);
    void visitDefInterfaceReference(DefInterfaceReferenceNode irDefInterfaceReferenceNode, Scope scope);
import org.opensearch.painless.ir.InvokeCallNode;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.ir.InstanceofNode;  
    void visitStoreBrace(StoreBraceNode irStoreBraceNode, Scope scope);  
    void visitMapInitialization(MapInitializationNode irMapInitializationNode, Scope scope);
import org.opensearch.painless.ir.StaticNode;
    void visitNewArray(NewArrayNode irNewArrayNode, Scope scope);  
    void visitForLoop(ForLoopNode irForLoopNode, Scope scope);
    void visitStringConcatenation(StringConcatenationNode irStringConcatenationNode, Scope scope);  
 *     http://www.apache.org/licenses/LICENSE-2.0
    void visitLoadDotDef(LoadDotDefNode irLoadDotDefNode, Scope scope);
    void visitBlock(BlockNode irBlockNode, Scope scope);  
import org.opensearch.painless.ir.ComparisonNode;  
/*
import org.opensearch.painless.ir.ClassNode;
import org.opensearch.painless.ir.LoadListShortcutNode;  
 */  
    void visitNullSafeSub(NullSafeSubNode irNullSafeSubNode, Scope scope);  
    void visitLoadVariable(LoadVariableNode irLoadVariableNode, Scope scope);
 * license agreements. See the NOTICE file distributed with
    void visitDeclarationBlock(DeclarationBlockNode irDeclarationBlockNode, Scope scope);  
    void visitTypeCaptureReference(TypedCaptureReferenceNode irTypedCaptureReferenceNode, Scope scope);  
import org.opensearch.painless.ir.IfNode;
    void visitConstant(ConstantNode irConstantNode, Scope scope);
import org.opensearch.painless.ir.ListInitializationNode;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.ir.TypedInterfaceReferenceNode;  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    void visitStoreVariable(StoreVariableNode irStoreVariableNode, Scope scope);
import org.opensearch.painless.ir.ForEachLoopNode;
 * software distributed under the License is distributed on an
import org.opensearch.painless.ir.LoadDotNode;  
import org.opensearch.painless.ir.DupNode;
    void visitInvokeCallMember(InvokeCallMemberNode irInvokeCallMemberNode, Scope scope);  
import org.opensearch.painless.ir.NewObjectNode;
 */  
import org.opensearch.painless.ir.StoreMapShortcutNode;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.ir.LoadBraceDefNode;
 *  
import org.opensearch.painless.ir.DoWhileLoopNode;
import org.opensearch.painless.ir.LoadBraceNode;  
import org.opensearch.painless.ir.StoreBraceNode;  
import org.opensearch.painless.ir.FlipDefIndexNode;
import org.opensearch.painless.ir.ThrowNode;  
    void visitInvokeCall(InvokeCallNode irInvokeCallNode, Scope scope);
 *
    void visitLoadDotShortcut(LoadDotShortcutNode irDotSubShortcutNode, Scope scope);
    void visitElvis(ElvisNode irElvisNode, Scope scope);  
import org.opensearch.painless.ir.StoreBraceDefNode;
import org.opensearch.painless.ir.BooleanNode;
    void visitIf(IfNode irIfNode, Scope scope);
import org.opensearch.painless.ir.LoadMapShortcutNode;
import org.opensearch.painless.ir.LoadVariableNode;
public interface IRTreeVisitor<Scope> {
import org.opensearch.painless.ir.StoreDotNode;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.ir.StoreDotShortcutNode;  
import org.opensearch.painless.ir.UnaryMathNode;
import org.opensearch.painless.ir.LoadFieldMemberNode;
    void visitField(FieldNode irFieldNode, Scope scope);
import org.opensearch.painless.ir.FlipCollectionIndexNode;  
import org.opensearch.painless.ir.NewArrayNode;
import org.opensearch.painless.ir.ElvisNode;  
    void visitStoreFieldMember(StoreFieldMemberNode irStoreFieldMemberNode, Scope scope);
 * Modifications Copyright OpenSearch Contributors. See
    void visitReturn(ReturnNode irReturnNode, Scope scope);
 * KIND, either express or implied.  See the License for the
    void visitInstanceof(InstanceofNode irInstanceofNode, Scope scope);
    void visitTypedInterfaceReference(TypedInterfaceReferenceNode irTypedInterfaceReferenceNode, Scope scope);
    void visitDoWhileLoop(DoWhileLoopNode irDoWhileLoopNode, Scope scope);
    void visitDup(DupNode irDupNode, Scope scope);
import org.opensearch.painless.ir.DeclarationBlockNode;
    void visitConditional(ConditionalNode irConditionalNode, Scope scope);
import org.opensearch.painless.ir.ForLoopNode;
import org.opensearch.painless.ir.InvokeCallDefNode;
import org.opensearch.painless.ir.ConstantNode;
    void visitLoadBraceDef(LoadBraceDefNode irLoadBraceDefNode, Scope scope);
import org.opensearch.painless.ir.FunctionNode;  
    void visitStatic(StaticNode irStaticNode, Scope scope);
import org.opensearch.painless.ir.BinaryMathNode;
 */
    void visitLoadDot(LoadDotNode irLoadDotNode, Scope scope);  
 * compatible open source license.
    void visitForEachSubArrayLoop(ForEachSubArrayNode irForEachSubArrayNode, Scope scope);
import org.opensearch.painless.ir.ContinueNode;  
 * not use this file except in compliance with the License.
import org.opensearch.painless.ir.BinaryImplNode;
    void visitWhileLoop(WhileLoopNode irWhileLoopNode, Scope scope);  
/*  
    void visitBoolean(BooleanNode irBooleanNode, Scope scope);
import org.opensearch.painless.ir.LoadDotArrayLengthNode;
    void visitStoreMapShortcut(StoreMapShortcutNode irStoreMapShortcutNode, Scope scope);  
import org.opensearch.painless.ir.NullSafeSubNode;
 * SPDX-License-Identifier: Apache-2.0
    void visitContinue(ContinueNode irContinueNode, Scope scope);
import org.opensearch.painless.ir.CatchNode;
 * specific language governing permissions and limitations
import org.opensearch.painless.ir.IfElseNode;
    void visitBinaryImpl(BinaryImplNode irBinaryImplNode, Scope scope);  
    void visitDeclaration(DeclarationNode irDeclarationNode, Scope scope);
    void visitListInitialization(ListInitializationNode irListInitializationNode, Scope scope);
    void visitBreak(BreakNode irBreakNode, Scope scope);
import org.opensearch.painless.ir.LoadDotDefNode;
/*  
import org.opensearch.painless.ir.ConditionalNode;
import org.opensearch.painless.ir.MapInitializationNode;  
    void visitLoadDotArrayLengthNode(LoadDotArrayLengthNode irLoadDotArrayLengthNode, Scope scope);
    void visitStatementExpression(StatementExpressionNode irStatementExpressionNode, Scope scope);  
import org.opensearch.painless.ir.WhileLoopNode;
    void visitStoreBraceDef(StoreBraceDefNode irStoreBraceDefNode, Scope scope);
import org.opensearch.painless.ir.BreakNode;
    void visitInvokeCallDef(InvokeCallDefNode irInvokeCallDefNode, Scope scope);
    void visitLoadMapShortcut(LoadMapShortcutNode irLoadMapShortcutNode, Scope scope);  
 * under the License.  
    void visitLoadListShortcut(LoadListShortcutNode irLoadListShortcutNode, Scope scope);
import org.opensearch.painless.ir.ForEachSubIterableNode;
