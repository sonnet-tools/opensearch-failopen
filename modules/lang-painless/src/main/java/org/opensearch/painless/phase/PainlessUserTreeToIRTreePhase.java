            irBlockNode.setAllEscape(true);
        irFunctionNode.setMaxLoopCounter(0);
    // } catch (PainlessError | BootstrapMethodError | OutOfMemoryError | StackOverflowError | Exception e) {
/*
            irBinaryImplNode.setExpressionType(Map.class);
        IRNode irNode = irNodeDecoration.getIRNode();
                DeclarationNode irDeclarationNode = new DeclarationNode(internalLocation);
import org.opensearch.painless.lookup.PainlessMethod;
        irBlockNode.setAllEscape(true);
            irLoadVariableNode.setExpressionType(ScriptException.class);
                String name = throwable.getSimpleName();
                irReturnNode.setExpressionNode(irExpressionNode);
                        Collections.class,
            LoadVariableNode irLoadVariableNode = new LoadVariableNode(internalLocation);
            scriptScope.putDecoration(userFunctionNode, new IRNodeDecoration(irFunctionNode));
            LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
    }
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
            ThrowNode irThrowNode = new ThrowNode(internalLocation);
 */
        injectConverter(userReturnNode, scriptScope);
        } else {
                    } else {
            irFunctionNode.setSynthetic(true);
                        null,
 * The OpenSearch Contributors require contributions made to
                irInvokeCallMemberNode.addArgumentNode(irBinaryImplNode);
                irInvokeCallNode.setExpressionType(Map.class);
                irInvokeCallNode = new InvokeCallNode(internalLocation);
                new LocalFunction("convertToScriptException", ScriptException.class, Arrays.asList(Throwable.class, Map.class), true, false)
                irInvokeCallMemberNode.setExpressionType(irDeclarationNode.getDeclarationType());
                irDeclarationNode.setExpressionNode(irInvokeCallMemberNode);
            FunctionNode irFunctionNode = new FunctionNode(internalLocation);
                } else {
    }
import org.opensearch.painless.ir.StaticNode;
                                irConstantNode.setConstant(0L);
            String name = needsMethod.getName();
                Class<?> returnType = scriptScope.getScriptClassInfo().getGetReturns().get(i);
                    irExpressionNode = null;
 * license agreements. See the NOTICE file distributed with
                            } else if (returnType == float.class) {
 * GitHub history for details.
import org.opensearch.painless.ir.InvokeCallNode;
    @Override
 *
            irFunctionNode.setName(needsMethod.getName());
        injectConverter(userExpressionNode, scriptScope);
                        irExpressionNode.setExpressionType(returnType);
    }
/*
import org.opensearch.painless.ir.DeclarationNode;
            irInvokeCallNode.setMethod(
            irInvokeCallMemberNode.setLocalFunction(
    // and
                    )
        irClassNode.addFieldNode(irFieldNode);
    // } catch (PainlessExplainError e) {
            irFunctionNode.setName("execute");
                        null
import org.opensearch.script.ScriptException;
    }
    protected void injectNeedsMethods(ScriptScope scriptScope) {
import org.objectweb.asm.commons.Method;
                    if (returnType.isPrimitive()) {
import org.opensearch.painless.node.SExpression;
                name = "#" + Character.toLowerCase(name.charAt(0)) + name.substring(1);
        irBlockNode = new BlockNode(internalLocation);
        }
        // that are used and adds additional sandboxing by wrapping
    protected void injectGetsDeclarations(BlockNode irBlockNode, ScriptScope scriptScope) {
            if (methodEscape == false) {
            irLoadVariableNode.setExpressionType(PainlessExplainError.class);
                OutOfMemoryError.class,
            List<String> parameterNames = new ArrayList<>(scriptClassInfo.getExecuteArguments().size());
        irFunctionNode.setBlockNode(irBlockNode);
                irTryNode.addCatchNode(irCatchNode);
        irFunctionNode.setStatic(false);
            );
        FieldNode irFieldNode = new FieldNode(internalLocation);
            irBlockNode.addStatementNode(irReturnNode);
                            } else if (returnType == long.class) {
            Method getMethod = scriptScope.getScriptClassInfo().getGetMethods().get(i);
    }
            injectSandboxExceptions(irFunctionNode);
            irInvokeCallMemberNode.addArgumentNode(irBinaryImplNode);
            ConstantNode irConstantNode = new ConstantNode(internalLocation);
import org.opensearch.painless.node.AStatement;
            }
import org.opensearch.painless.ScriptClassInfo;
import org.opensearch.painless.PainlessError;
        irFunctionNode.setSynthetic(true);
import org.opensearch.painless.ir.ThrowNode;
        }
        LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
        irClassNode.addFieldNode(irFieldNode);
        ReturnNode returnNode = (ReturnNode) irNode;
import org.opensearch.painless.lookup.PainlessLookup;
            irFunctionNode.setBlockNode(irBlockNode);
            TryNode irTryNode = new TryNode(internalLocation);
            if (scriptScope.getUsedVariables().contains(name)) {
    protected void injectStaticFieldsAndGetters() {
import org.opensearch.painless.ir.CatchNode;
            for (MethodArgument methodArgument : scriptClassInfo.getExecuteArguments()) {
                irCatchBlockNode.addStatementNode(irThrowNode);
        }
            irFunctionNode.setVarArgs(false);
            irLoadVariableNode.setName("#painlessExplainError");
            irBlockNode.setAllEscape(true);
    // adds static fields and getter methods required by PainlessScript for exception handling
            ReturnNode irReturnNode = new ReturnNode(internalLocation);
        irFunctionNode.setStatic(false);
            irFunctionNode.setBlockNode(irBlockNode);
            InvokeCallNode irInvokeCallNode = new InvokeCallNode(internalLocation);
            irCatchBlockNode.addStatementNode(irThrowNode);
        irFieldNode.setName("$STATEMENTS");
import org.opensearch.painless.symbol.Decorations.Converter;
            injectGetsDeclarations(irBlockNode, scriptScope);
                }
                irCatchBlockNode.setAllEscape(true);
            irCatchBlockNode.setAllEscape(true);
            irInvokeCallMemberNode.setExpressionType(ScriptException.class);
 * this work for additional information regarding copyright
            irLoadFieldMemberNode.setStatic(true);
        irFieldNode.setModifiers(modifiers);
                        if (returnType == boolean.class) {
                irCatchBlockNode = new BlockNode(internalLocation);
                irDeclarationNode.setName(name);
        irLoadFieldMemberNode.setStatic(true);
import org.opensearch.painless.Location;
                new PainlessMethod(
import java.util.BitSet;
        irClassNode.addFunctionNode(irFunctionNode);
            irFunctionNode.setReturnType(returnType);
                        Collections.class.getMethod("emptyMap"),
                irBinaryImplNode.setExpressionType(Map.class);
                        irConstantNode.setExpressionType(returnType);
            irBlockNode.addStatementNode(irTryNode);
import java.util.Map;
        irLoadFieldMemberNode.setStatic(true);
                irInvokeCallMemberNode.setExpressionType(ScriptException.class);
    }
            irFunctionNode.setMaxLoopCounter(0);
            irFunctionNode.setReturnType(boolean.class);
                    Collections.emptyList(),
                        } else if (returnType == byte.class
        irLoadFieldMemberNode.setStatic(true);
        irFunctionNode = new FunctionNode(internalLocation);
                irCatchNode.setExceptionType(throwable);
        irBlockNode.setAllEscape(true);
            for (Class<?> throwable : new Class<?>[] {
        irFunctionNode.setReturnType(String.class);
                            || returnType == int.class) {
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);
import org.opensearch.painless.ir.FieldNode;
                    null,
            BlockNode irBlockNode = (BlockNode) visit(userFunctionNode.getBlockNode(), scriptScope);
        InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(userStatementNode.getLocation());
                irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);
        try {
            irLoadFieldMemberNode.setExpressionType(PainlessLookup.class);
                        true,
        // This injects additional ir nodes required for
            Class<?> returnType = localFunction.getReturnType();
            irTryNode.addCatchNode(irCatchNode);
                irCatchNode.setBlockNode(irCatchBlockNode);
        irFunctionNode = new FunctionNode(internalLocation);
                StackOverflowError.class,
                        Arrays.asList(Throwable.class, Map.class),
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectNeedsMethods", 0);
            irCatchNode.setBlockNode(irCatchBlockNode);
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);
            BlockNode irBlockNode = new BlockNode(internalLocation);
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);
        ExpressionNode returnExpression = returnNode.getExpressionNode();
                            } else if (returnType == double.class) {
        irFunctionNode.setVarArgs(false);
import org.opensearch.painless.ir.LoadVariableNode;
        irFieldNode.setName("$SOURCE");
    }
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(internalLocation);
public class PainlessUserTreeToIRTreePhase extends DefaultUserTreeToIRTreePhase {
        if ("execute".equals(functionName)) {
        // to convert get methods into local variables for those
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } catch (Exception exception) {
    public void injectConverter(AStatement userStatementNode, ScriptScope scriptScope) {
                irThrowNode.setExpressionNode(irInvokeCallMemberNode);
import org.opensearch.painless.node.SFunction;
                if (returnType == void.class) {
 * KIND, either express or implied.  See the License for the
                    null,
        // inject converter
            irInvokeCallNode.addArgumentNode(irLoadFieldMemberNode);
        irBlockNode = new BlockNode(internalLocation);
            CatchNode irCatchNode = new CatchNode(internalLocation);
            irInvokeCallMemberNode.addArgumentNode(irLoadVariableNode);
            LocalFunction localFunction = scriptScope.getFunctionTable()
        irFieldNode.setFieldType(BitSet.class);
import org.opensearch.painless.ir.BlockNode;
            irLoadFieldMemberNode.setName("$DEFINITION");
 * software distributed under the License is distributed on an
        irLoadFieldMemberNode.setName("$NAME");
            irConstantNode.setExpressionType(boolean.class);
                irBinaryImplNode.setLeftNode(irStaticNode);
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
            irThrowNode.setExpressionNode(irInvokeCallMemberNode);
import org.opensearch.painless.ir.ExpressionNode;
        irFunctionNode.setBlockNode(irBlockNode);
            irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
import org.opensearch.painless.ir.TryNode;
                                throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));
                            irConstantNode.setConstant(false);
            irFunctionNode.getParameterNames().addAll(parameterNames);
            injectNeedsMethods(scriptScope);
            irFunctionNode.setBlockNode(irBlockNode);
                );
                ExpressionNode irExpressionNode;
                            } else {
 */
                                irConstantNode.setConstant(0d);
import org.opensearch.painless.symbol.Decorations.IRNodeDecoration;
                BootstrapMethodError.class,
import org.opensearch.painless.ir.LoadFieldMemberNode;
            BlockNode irCatchBlockNode = new BlockNode(internalLocation);
 * SPDX-License-Identifier: Apache-2.0
                    new LocalFunction(getMethod.getName(), returnType, Collections.emptyList(), true, false)
import org.opensearch.painless.ir.ReturnNode;
        irFunctionNode.setVarArgs(false);
        }
            BlockNode irBlockNode = irFunctionNode.getBlockNode();
                .getFunction(functionName, scriptClassInfo.getExecuteArguments().size());
        if ((irNode instanceof ReturnNode) == false) {
import org.opensearch.painless.ir.IRNode;
                irLoadVariableNode.setExpressionType(ScriptException.class);
        irFunctionNode.setStatic(false);
                    new LocalFunction(
        irReturnNode = new ReturnNode(internalLocation);
        // the main "execute" block with several exceptions.
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
            String name = getMethod.getName().substring(3);
import org.objectweb.asm.Opcodes;
                irStaticNode.setExpressionType(Collections.class);
        irBlockNode.addStatementNode(irReturnNode);
        irInvokeCallMemberNode.setLocalFunction(converter.getConverter());
                irCatchNode.setSymbol(name);
            irFunctionNode.getTypeParameters().addAll(localFunction.getTypeParameters());
        irFunctionNode.setSynthetic(true);
                irInvokeCallMemberNode.setLocalFunction(
import java.util.Collections;
        irFunctionNode.setName("getStatements");
            irReturnNode.setExpressionNode(irConstantNode);
        irFunctionNode.setReturnType(String.class);
                irInvokeCallNode.setBox(Collections.class);
                irBinaryImplNode.setRightNode(irInvokeCallNode);
    // }
                irBinaryImplNode = new BinaryImplNode(internalLocation);
                parameterNames.add(methodArgument.getName());
                        irExpressionNode = irConstantNode;
        Converter converter = scriptScope.getDecoration(userStatementNode, Converter.class);
                    }
package org.opensearch.painless.phase;
        irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
        irFieldNode = new FieldNode(internalLocation);
import org.opensearch.painless.ScriptClassInfo.MethodArgument;
        irFieldNode.setModifiers(modifiers);
        irClassNode.addFunctionNode(irFunctionNode);
import org.opensearch.painless.ir.ConstantNode;
 * specific language governing permissions and limitations
            irBinaryImplNode.setLeftNode(irLoadVariableNode);
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);
        returnNode.setExpressionNode(irInvokeCallMemberNode);
        irFunctionNode.setMaxLoopCounter(0);
        for (int i = 0; i < scriptScope.getScriptClassInfo().getGetMethods().size(); ++i) {
        irFunctionNode.setSynthetic(true);
            irBinaryImplNode.setRightNode(irInvokeCallNode);
    // convert gets methods to a new set of inserted ir nodes as necessary -
            }
        FunctionNode irFunctionNode = new FunctionNode(internalLocation);
            irCatchNode.setExceptionType(PainlessExplainError.class);
    // requires the gets method name be modified from "getExample" to "example"
            irTryNode.setBlockNode(irBlockNode);
            irConstantNode.setConstant(scriptScope.getUsedVariables().contains(name));
import org.opensearch.painless.PainlessExplainError;
        irReturnNode = new ReturnNode(internalLocation);
            irInvokeCallNode.setExpressionType(Map.class);
        // sets IRNodeDecoration with ReturnNode or StatementExpressionNode
        for (org.objectweb.asm.commons.Method needsMethod : scriptScope.getScriptClassInfo().getNeedsMethods()) {
    @Override
import org.opensearch.painless.symbol.Decorations.MethodEscape;
        IRNodeDecoration irNodeDecoration = scriptScope.getDecoration(userStatementNode, IRNodeDecoration.class);
import java.util.ArrayList;
    // injects needs methods as defined by ScriptClassInfo
 */
                InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);
 *
        irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
import org.opensearch.painless.ir.NullNode;
import org.opensearch.painless.ir.InvokeCallMemberNode;
                irLoadVariableNode = new LoadVariableNode(internalLocation);
    @Override
                ReturnNode irReturnNode = new ReturnNode(userFunctionNode.getLocation());
                irLoadVariableNode.setName(name);
    // if a get method variable isn't used it's declaration node is removed from
                    null
        String functionName = userFunctionNode.getFunctionName();
                    PainlessExplainError.class,
            injectStaticFieldsAndGetters();
        irFieldNode = new FieldNode(internalLocation);
                irThrowNode = new ThrowNode(internalLocation);
        irClassNode.addFunctionNode(irFunctionNode);
                        null,
                irDeclarationNode.setDeclarationType(returnType);
            // Shouldn't have a Converter decoration if StatementExpressionNode, should be ReturnNode if explicit return
                    PainlessExplainError.class.getMethod("getHeaders", PainlessLookup.class),
            FunctionNode irFunctionNode = new FunctionNode(userFunctionNode.getLocation());
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectStaticFieldsAndGetters", 0);
                );
        irFunctionNode.setName("getName");
        BlockNode irBlockNode = new BlockNode(internalLocation);
                        irExpressionNode = new NullNode(userFunctionNode.getLocation());
                                irConstantNode.setConstant(0f);
 * You may obtain a copy of the License at
        irFunctionNode.setMaxLoopCounter(0);
        irFunctionNode.setBlockNode(irBlockNode);
                PainlessError.class,
    public void visitReturn(SReturn userReturnNode, ScriptScope scriptScope) {
            }
                        "convertToScriptException",
                irBlockNode.getStatementsNodes().add(0, irDeclarationNode);
 * ownership. Elasticsearch licenses this file to you under
            irLoadVariableNode.setName("#painlessExplainError");
            irFunctionNode.setVarArgs(false);
                irInvokeCallMemberNode.setLocalFunction(
                        ScriptException.class,
 * Licensed to Elasticsearch under one or more contributor
    // decorate the execute method with nodes to wrap the user statements with
            name = name.substring(5);
    // }
                irInvokeCallMemberNode.addArgumentNode(irLoadVariableNode);
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectGetsDeclarations", 0);
import org.opensearch.painless.node.SReturn;
            irFunctionNode.setSynthetic(false);
            ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
                            || returnType == short.class
    // the ir tree permanently so there is no frivolous variable slotting
import org.opensearch.painless.ir.FunctionNode;
            }
                                irConstantNode.setConstant(0);
 * under the License.
        irLoadFieldMemberNode.setName("$STATEMENTS");
    // throw this.convertToScriptException(e, e.getHeaders())
        if (converter == null) {
        irFieldNode.setName("$NAME");
            irFunctionNode.setStatic(false);
        irClassNode.addFieldNode(irFieldNode);
        irFieldNode.setFieldType(String.class);
                        Collections.emptyList(),
            irClassNode.addFunctionNode(irFunctionNode);
        irBlockNode.addStatementNode(irReturnNode);
        irBlockNode.addStatementNode(irReturnNode);
                            || returnType == char.class
                    null,
        irFunctionNode.setName("getSource");
import org.opensearch.painless.ir.BinaryImplNode;
            irBlockNode = new BlockNode(internalLocation);
            super.visitFunction(userFunctionNode, scriptScope);
import java.util.Arrays;
            irCatchNode.setSymbol("#painlessExplainError");
        irInvokeCallMemberNode.addArgumentNode(returnExpression);
            irInvokeCallNode.setBox(PainlessExplainError.class);
        super.visitExpression(userExpressionNode, scriptScope);
        }
                Exception.class }) {
 * this file be licensed under the Apache-2.0 license or a
/*
    }
 * Modifications Copyright OpenSearch Contributors. See
                        null,
    // throw this.convertToScriptException(e, e.getHeaders($DEFINITION))
import org.opensearch.painless.symbol.ScriptScope;
                        false
                        ConstantNode irConstantNode = new ConstantNode(userFunctionNode.getLocation());
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        ReturnNode irReturnNode = new ReturnNode(internalLocation);
        irLoadFieldMemberNode.setExpressionType(BitSet.class);
                irCatchNode = new CatchNode(internalLocation);
            Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectSandboxExceptions", 0);
            throw new RuntimeException(exception);
                StaticNode irStaticNode = new StaticNode(internalLocation);
                            }
            irFunctionNode.setStatic(false);
                irBlockNode.addStatementNode(irReturnNode);
        irBlockNode.setAllEscape(true);
            throw userStatementNode.createError(new IllegalStateException("illegal tree structure"));
        irFunctionNode.setReturnType(BitSet.class);
        irFieldNode.setFieldType(String.class);
 * not use this file except in compliance with the License.
    // the sandboxed errors as follows:
}
            InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);
        irLoadFieldMemberNode.setName("$SOURCE");
        irFunctionNode.setVarArgs(false);
    public void visitExpression(SExpression userExpressionNode, ScriptScope scriptScope) {
        }
                )
                irInvokeCallNode.setMethod(
        super.visitReturn(userReturnNode, scriptScope);
        int modifiers = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;
            );
    protected void injectSandboxExceptions(FunctionNode irFunctionNode) {
        // the "execute" method. This includes injection of ir nodes
        irLoadFieldMemberNode.setExpressionType(String.class);
                );
        irFieldNode.setModifiers(modifiers);
                    new PainlessMethod(
        irLoadFieldMemberNode.setExpressionType(String.class);
            irLoadVariableNode = new LoadVariableNode(internalLocation);
                    )
            boolean methodEscape = scriptScope.getCondition(userFunctionNode, MethodEscape.class);
            return;
