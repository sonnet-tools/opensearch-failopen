                    )  
            irCatchNode.setSymbol("#painlessExplainError");  
        irInvokeCallMemberNode.setLocalFunction(converter.getConverter());
import org.opensearch.painless.PainlessError;
        returnNode.setExpressionNode(irInvokeCallMemberNode);
                )
            ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
                                irConstantNode.setConstant(0d);
        // that are used and adds additional sandboxing by wrapping
        FunctionNode irFunctionNode = new FunctionNode(internalLocation);
        irBlockNode.setAllEscape(true);
import org.opensearch.painless.Location;
import org.opensearch.painless.ir.InvokeCallNode;
                StackOverflowError.class,  
            irBinaryImplNode.setExpressionType(Map.class);
    }
    }  
                                throw userFunctionNode.createError(new IllegalStateException("illegal tree structure"));  
                    null,  
                    new PainlessMethod(
    // if a get method variable isn't used it's declaration node is removed from
import org.opensearch.painless.ScriptClassInfo;
                        null,
        irFunctionNode.setReturnType(String.class);
            irBlockNode.setAllEscape(true);
import java.util.BitSet;
 *  
            irTryNode.setBlockNode(irBlockNode);
        irBlockNode.addStatementNode(irReturnNode);
 */  
    protected void injectNeedsMethods(ScriptScope scriptScope) {  
        irFieldNode.setFieldType(String.class);
import org.opensearch.painless.lookup.PainlessMethod;
        irFunctionNode.setName("getName");
            irFunctionNode.setName(needsMethod.getName());  
                        irExpressionNode = new NullNode(userFunctionNode.getLocation());
                new PainlessMethod(  
                name = "#" + Character.toLowerCase(name.charAt(0)) + name.substring(1);
                irBinaryImplNode.setLeftNode(irStaticNode);
import java.util.Collections;  
        irBlockNode.setAllEscape(true);
            List<String> parameterNames = new ArrayList<>(scriptClassInfo.getExecuteArguments().size());
import org.opensearch.painless.symbol.Decorations.MethodEscape;
                            } else if (returnType == float.class) {
import org.opensearch.painless.ir.FieldNode;  
            injectGetsDeclarations(irBlockNode, scriptScope);
        irFieldNode = new FieldNode(internalLocation);
    }  
            irInvokeCallMemberNode.setLocalFunction(  
        // to convert get methods into local variables for those  
                    Collections.emptyList(),
        }
                irInvokeCallNode.setMethod(  
import org.opensearch.painless.ir.BlockNode;
 *
 * specific language governing permissions and limitations
            ReturnNode irReturnNode = new ReturnNode(internalLocation);
            irCatchBlockNode.setAllEscape(true);
        IRNodeDecoration irNodeDecoration = scriptScope.getDecoration(userStatementNode, IRNodeDecoration.class);
                irLoadVariableNode = new LoadVariableNode(internalLocation);
        irFunctionNode.setMaxLoopCounter(0);
import org.objectweb.asm.Opcodes;  
    }  
    public void visitExpression(SExpression userExpressionNode, ScriptScope scriptScope) {
        LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
        irFieldNode.setModifiers(modifiers);
            LoadVariableNode irLoadVariableNode = new LoadVariableNode(internalLocation);  
import org.opensearch.script.ScriptException;
            irFunctionNode.setMaxLoopCounter(scriptScope.getCompilerSettings().getMaxLoopCounter());
                            || returnType == int.class) {  
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);
                if (returnType == void.class) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    new LocalFunction(  
        } catch (Exception exception) {
}
import org.opensearch.painless.ir.IRNode;
            irTryNode.addCatchNode(irCatchNode);
        FieldNode irFieldNode = new FieldNode(internalLocation);
                irBinaryImplNode = new BinaryImplNode(internalLocation);
            return;
/*  
    public void injectConverter(AStatement userStatementNode, ScriptScope scriptScope) {
            );
            String name = needsMethod.getName();
import org.opensearch.painless.ir.ExpressionNode;
 * You may obtain a copy of the License at  
                String name = throwable.getSimpleName();  
        super.visitReturn(userReturnNode, scriptScope);
        if ((irNode instanceof ReturnNode) == false) {
        InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(userStatementNode.getLocation());
        irLoadFieldMemberNode.setExpressionType(String.class);  
                        ScriptException.class,
            irFunctionNode.setBlockNode(irBlockNode);
        irLoadFieldMemberNode.setExpressionType(BitSet.class);
        irFunctionNode.setSynthetic(true);
        irLoadFieldMemberNode.setName("$NAME");
            for (MethodArgument methodArgument : scriptClassInfo.getExecuteArguments()) {  
            ConstantNode irConstantNode = new ConstantNode(internalLocation);  
            irBlockNode = new BlockNode(internalLocation);  
            InvokeCallNode irInvokeCallNode = new InvokeCallNode(internalLocation);
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;  
                irReturnNode.setExpressionNode(irExpressionNode);
import org.opensearch.painless.ir.BinaryImplNode;  
            BlockNode irCatchBlockNode = new BlockNode(internalLocation);
    protected void injectGetsDeclarations(BlockNode irBlockNode, ScriptScope scriptScope) {  
        // inject converter  
                irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);  
        ReturnNode irReturnNode = new ReturnNode(internalLocation);
                        Arrays.asList(Throwable.class, Map.class),  
 * this work for additional information regarding copyright
                    new LocalFunction(getMethod.getName(), returnType, Collections.emptyList(), true, false)
                                irConstantNode.setConstant(0L);  
import org.opensearch.painless.ir.InvokeCallMemberNode;  
        ReturnNode returnNode = (ReturnNode) irNode;
                        irExpressionNode = irConstantNode;  
import org.opensearch.painless.symbol.Decorations.Converter;  
        irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);  
        BlockNode irBlockNode = new BlockNode(internalLocation);
 * not use this file except in compliance with the License.
import org.objectweb.asm.commons.Method;
import org.opensearch.painless.ir.ConstantNode;  
                irCatchBlockNode.addStatementNode(irThrowNode);
        IRNode irNode = irNodeDecoration.getIRNode();  
                irDeclarationNode.setName(name);  
    protected void injectStaticFieldsAndGetters() {  
            CatchNode irCatchNode = new CatchNode(internalLocation);
 * this file be licensed under the Apache-2.0 license or a
        irClassNode.addFunctionNode(irFunctionNode);  
                irCatchNode.setBlockNode(irCatchBlockNode);  
import org.opensearch.painless.ir.CatchNode;
    @Override  
public class PainlessUserTreeToIRTreePhase extends DefaultUserTreeToIRTreePhase {
            irBinaryImplNode.setLeftNode(irLoadVariableNode);  
        irFieldNode.setModifiers(modifiers);
    // the sandboxed errors as follows:  
            irFunctionNode.getTypeParameters().addAll(localFunction.getTypeParameters());
        injectConverter(userReturnNode, scriptScope);
            irFunctionNode.setBlockNode(irBlockNode);  
            irInvokeCallMemberNode.setExpressionType(ScriptException.class);
        irFunctionNode.setVarArgs(false);
                            } else {
            TryNode irTryNode = new TryNode(internalLocation);
                parameterNames.add(methodArgument.getName());
            irBlockNode.addStatementNode(irTryNode);
 */  
        // sets IRNodeDecoration with ReturnNode or StatementExpressionNode  
            irBlockNode.addStatementNode(irReturnNode);
            throw new RuntimeException(exception);  
        irFunctionNode.setSynthetic(true);  
 * ownership. Elasticsearch licenses this file to you under  
        irReturnNode = new ReturnNode(internalLocation);
        irInvokeCallMemberNode.addArgumentNode(returnExpression);
            boolean methodEscape = scriptScope.getCondition(userFunctionNode, MethodEscape.class);  
        irReturnNode = new ReturnNode(internalLocation);  
                        ConstantNode irConstantNode = new ConstantNode(userFunctionNode.getLocation());
import org.opensearch.painless.symbol.ScriptScope;
import org.opensearch.painless.ir.StaticNode;  
                        Collections.class,  
            irFunctionNode.setStatic(false);
            if (scriptScope.getUsedVariables().contains(name)) {
            irCatchBlockNode.addStatementNode(irThrowNode);
        irFunctionNode.setBlockNode(irBlockNode);
        }  
            irLoadVariableNode.setName("#painlessExplainError");
            irInvokeCallNode.setBox(PainlessExplainError.class);
                );
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectGetsDeclarations", 0);
                    )  
                        irConstantNode.setExpressionType(returnType);
            irThrowNode.setExpressionNode(irInvokeCallMemberNode);
    // injects needs methods as defined by ScriptClassInfo
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
        Converter converter = scriptScope.getDecoration(userStatementNode, Converter.class);  
        irBlockNode.addStatementNode(irReturnNode);  
        irFieldNode.setName("$STATEMENTS");  
        ExpressionNode returnExpression = returnNode.getExpressionNode();  
                irBinaryImplNode.setExpressionType(Map.class);  
            scriptScope.putDecoration(userFunctionNode, new IRNodeDecoration(irFunctionNode));
        irClassNode.addFieldNode(irFieldNode);
        // the "execute" method. This includes injection of ir nodes
        irFieldNode.setFieldType(BitSet.class);
                        true,
            irFunctionNode.setSynthetic(true);
            irInvokeCallMemberNode.addArgumentNode(irBinaryImplNode);  
                irCatchNode = new CatchNode(internalLocation);  
            name = name.substring(5);
            irLoadVariableNode.setExpressionType(ScriptException.class);
                            } else if (returnType == double.class) {  
        irFunctionNode.setMaxLoopCounter(0);  
            String name = getMethod.getName().substring(3);
                            irConstantNode.setConstant(false);
                    } else {
        // the main "execute" block with several exceptions.
                irBinaryImplNode.setRightNode(irInvokeCallNode);  
            LoadFieldMemberNode irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
            // Shouldn't have a Converter decoration if StatementExpressionNode, should be ReturnNode if explicit return  
            irFunctionNode.setReturnType(boolean.class);
        irLoadFieldMemberNode.setStatic(true);
    public void visitReturn(SReturn userReturnNode, ScriptScope scriptScope) {  
                        Collections.class.getMethod("emptyMap"),
                            }
            irInvokeCallNode.setMethod(
import org.opensearch.painless.ir.DeclarationNode;
            }
        irFieldNode.setModifiers(modifiers);  
    }  
                } else {
        irClassNode.addFieldNode(irFieldNode);  
                ExpressionNode irExpressionNode;
            irBlockNode.setAllEscape(true);
            injectNeedsMethods(scriptScope);
        irBlockNode.addStatementNode(irReturnNode);
    // adds static fields and getter methods required by PainlessScript for exception handling
                irInvokeCallMemberNode.addArgumentNode(irBinaryImplNode);
        }
 * Modifications Copyright OpenSearch Contributors. See
                                irConstantNode.setConstant(0f);
                StaticNode irStaticNode = new StaticNode(internalLocation);
                    if (returnType.isPrimitive()) {  
            super.visitFunction(userFunctionNode, scriptScope);
                                irConstantNode.setConstant(0);
    // } catch (PainlessExplainError e) {
import java.util.Arrays;
            Class<?> returnType = localFunction.getReturnType();
 * the Apache License, Version 2.0 (the "License"); you may
                            || returnType == char.class
import org.opensearch.painless.ir.ReturnNode;
        irFunctionNode.setStatic(false);
            irLoadVariableNode.setName("#painlessExplainError");
                        irExpressionNode.setExpressionType(returnType);  
        irFunctionNode = new FunctionNode(internalLocation);  
                    null
                Class<?> returnType = scriptScope.getScriptClassInfo().getGetReturns().get(i);  
        } else {  
 * software distributed under the License is distributed on an
                ReturnNode irReturnNode = new ReturnNode(userFunctionNode.getLocation());
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);  
                .getFunction(functionName, scriptClassInfo.getExecuteArguments().size());  
            name = Character.toLowerCase(name.charAt(0)) + name.substring(1);  
    // requires the gets method name be modified from "getExample" to "example"  
            irInvokeCallNode.addArgumentNode(irLoadFieldMemberNode);  
            FunctionNode irFunctionNode = new FunctionNode(userFunctionNode.getLocation());
        irFunctionNode = new FunctionNode(internalLocation);
            if (methodEscape == false) {  
        }
        irLoadFieldMemberNode.setName("$STATEMENTS");
        irFunctionNode.setReturnType(String.class);  
import org.opensearch.painless.node.SFunction;
            ThrowNode irThrowNode = new ThrowNode(internalLocation);  
            throw userStatementNode.createError(new IllegalStateException("illegal tree structure"));
 *
    // and
                irCatchBlockNode = new BlockNode(internalLocation);  
        irLoadFieldMemberNode.setExpressionType(String.class);
                irInvokeCallNode = new InvokeCallNode(internalLocation);  
import org.opensearch.painless.ir.NullNode;
    // throw this.convertToScriptException(e, e.getHeaders())  
        for (org.objectweb.asm.commons.Method needsMethod : scriptScope.getScriptClassInfo().getNeedsMethods()) {  
import org.opensearch.painless.node.SReturn;
package org.opensearch.painless.phase;
        irClassNode.addFunctionNode(irFunctionNode);
            irLoadVariableNode.setExpressionType(PainlessExplainError.class);  
        irFunctionNode.setMaxLoopCounter(0);
            }
            irFunctionNode.setVarArgs(false);
        irFunctionNode.setSynthetic(true);
        String functionName = userFunctionNode.getFunctionName();
        }
        if ("execute".equals(functionName)) {  
                );
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectStaticFieldsAndGetters", 0);
            irConstantNode.setConstant(scriptScope.getUsedVariables().contains(name));
                Exception.class }) {
        irLoadFieldMemberNode.setName("$SOURCE");  
                    null,
                    PainlessExplainError.class.getMethod("getHeaders", PainlessLookup.class),
    // } catch (PainlessError | BootstrapMethodError | OutOfMemoryError | StackOverflowError | Exception e) {
                irLoadVariableNode.setExpressionType(ScriptException.class);  
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);
                        null
        irClassNode.addFieldNode(irFieldNode);
                new LocalFunction("convertToScriptException", ScriptException.class, Arrays.asList(Throwable.class, Map.class), true, false)
                        "convertToScriptException",
                        if (returnType == boolean.class) {
            irReturnNode.setExpressionNode(irConstantNode);
            irFunctionNode.setVarArgs(false);  
                irDeclarationNode.setExpressionNode(irInvokeCallMemberNode);  
 * compatible open source license.
        irLoadFieldMemberNode = new LoadFieldMemberNode(internalLocation);
                        null,
        irFunctionNode.setVarArgs(false);  
                        null,  
        super.visitExpression(userExpressionNode, scriptScope);
 * GitHub history for details.
                DeclarationNode irDeclarationNode = new DeclarationNode(internalLocation);
            for (Class<?> throwable : new Class<?>[] {
            irCatchNode.setExceptionType(PainlessExplainError.class);
                    PainlessExplainError.class,
                irThrowNode.setExpressionNode(irInvokeCallMemberNode);  
            irLoadFieldMemberNode.setStatic(true);
                irBlockNode.addStatementNode(irReturnNode);
    // decorate the execute method with nodes to wrap the user statements with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            irFunctionNode.setBlockNode(irBlockNode);
                irTryNode.addCatchNode(irCatchNode);
                irCatchNode.setExceptionType(throwable);
                    irExpressionNode = null;
                irBlockNode.getStatementsNodes().add(0, irDeclarationNode);
                        Collections.emptyList(),
                InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);
            Method getMethod = scriptScope.getScriptClassInfo().getGetMethods().get(i);
                irInvokeCallMemberNode.setLocalFunction(  
                irDeclarationNode.setDeclarationType(returnType);
        irFieldNode = new FieldNode(internalLocation);  
import org.opensearch.painless.ir.LoadVariableNode;  
            irCatchNode.setBlockNode(irCatchBlockNode);
        irFieldNode.setName("$SOURCE");
            );  
        injectConverter(userExpressionNode, scriptScope);
        irFunctionNode.setBlockNode(irBlockNode);
            BlockNode irBlockNode = irFunctionNode.getBlockNode();
        int modifiers = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;
            irFunctionNode.setName("execute");  
        irClassNode.addFunctionNode(irFunctionNode);
/*  
            LocalFunction localFunction = scriptScope.getFunctionTable()
            irLoadFieldMemberNode.setExpressionType(PainlessLookup.class);
                irInvokeCallNode.setExpressionType(Map.class);
 * SPDX-License-Identifier: Apache-2.0
        irBlockNode = new BlockNode(internalLocation);
import org.opensearch.painless.ir.ThrowNode;
        if (converter == null) {
            irLoadVariableNode = new LoadVariableNode(internalLocation);
import org.opensearch.painless.ir.FunctionNode;
            InvokeCallMemberNode irInvokeCallMemberNode = new InvokeCallMemberNode(internalLocation);
        irFieldNode.setName("$NAME");
            injectStaticFieldsAndGetters();  
                irInvokeCallMemberNode.setExpressionType(irDeclarationNode.getDeclarationType());
        irFunctionNode.setVarArgs(false);
            Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectSandboxExceptions", 0);
        Location internalLocation = new Location("$internal$ScriptInjectionPhase$injectNeedsMethods", 0);
import org.opensearch.painless.lookup.PainlessLookup;  
                        } else if (returnType == byte.class  
    // throw this.convertToScriptException(e, e.getHeaders($DEFINITION))
        irReturnNode.setExpressionNode(irLoadFieldMemberNode);  
import java.util.List;
        try {  
    }  
                    }
import org.opensearch.painless.ir.LoadFieldMemberNode;
                    null,  
                irThrowNode = new ThrowNode(internalLocation);
                OutOfMemoryError.class,
        irFunctionNode.setBlockNode(irBlockNode);  
import org.opensearch.painless.node.AStatement;
    @Override
import java.util.Map;
import org.opensearch.painless.node.SExpression;  
import org.opensearch.painless.ScriptClassInfo.MethodArgument;
            irInvokeCallNode.setExpressionType(Map.class);  
            irFunctionNode.setReturnType(returnType);
        irBlockNode = new BlockNode(internalLocation);  
                irCatchBlockNode.setAllEscape(true);
                );
                BootstrapMethodError.class,
/*
    // the ir tree permanently so there is no frivolous variable slotting
    protected void injectSandboxExceptions(FunctionNode irFunctionNode) {
        irBlockNode.setAllEscape(true);  
            BinaryImplNode irBinaryImplNode = new BinaryImplNode(internalLocation);  
    }  
                irInvokeCallMemberNode.setLocalFunction(
        for (int i = 0; i < scriptScope.getScriptClassInfo().getGetMethods().size(); ++i) {  
    @Override
import org.opensearch.painless.PainlessExplainError;  
 */
 * KIND, either express or implied.  See the License for the
 * under the License.  
        // This injects additional ir nodes required for
            irFunctionNode.setMaxLoopCounter(0);
 * The OpenSearch Contributors require contributions made to  
                }
import org.opensearch.painless.ir.TryNode;
        irFieldNode.setFieldType(String.class);  
        irFunctionNode.setReturnType(BitSet.class);
        irFunctionNode.setName("getSource");
        irFunctionNode.setName("getStatements");  
            irInvokeCallMemberNode.addArgumentNode(irLoadVariableNode);
                PainlessError.class,  
            irLoadFieldMemberNode.setName("$DEFINITION");  
    // }
            }
            irFunctionNode.getParameterNames().addAll(parameterNames);  
                irInvokeCallMemberNode.addArgumentNode(irLoadVariableNode);  
    // convert gets methods to a new set of inserted ir nodes as necessary -
        irLoadFieldMemberNode.setStatic(true);  
            irBinaryImplNode.setRightNode(irInvokeCallNode);
            BlockNode irBlockNode = (BlockNode) visit(userFunctionNode.getBlockNode(), scriptScope);
    // }  
                irLoadVariableNode.setName(name);
                irCatchNode.setSymbol(name);
            injectSandboxExceptions(irFunctionNode);  
                            || returnType == short.class
                irInvokeCallMemberNode.setExpressionType(ScriptException.class);
                            } else if (returnType == long.class) {
        irLoadFieldMemberNode.setStatic(true);
            FunctionNode irFunctionNode = new FunctionNode(internalLocation);
                irStaticNode.setExpressionType(Collections.class);
        irFunctionNode.setStatic(false);  
import java.util.ArrayList;  
import org.opensearch.painless.symbol.Decorations.IRNodeDecoration;
 * Licensed to Elasticsearch under one or more contributor  
            }
    }
                irInvokeCallNode.setBox(Collections.class);
            irFunctionNode.setSynthetic(false);  
        irFunctionNode.setStatic(false);
            irFunctionNode.setStatic(false);
            irClassNode.addFunctionNode(irFunctionNode);
 * Unless required by applicable law or agreed to in writing,
            irConstantNode.setExpressionType(boolean.class);
 * license agreements. See the NOTICE file distributed with
        }
            BlockNode irBlockNode = new BlockNode(internalLocation);  
                        false
