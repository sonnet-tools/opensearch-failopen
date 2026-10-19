 * ownership. Elasticsearch licenses this file to you under  
                Class<?> typeParameter = scriptClassInfo.getGetReturns().get(i);  
        if (rtn) {
import org.opensearch.painless.ScriptClassInfo;  
 * software distributed under the License is distributed on an
     * <p>
import org.opensearch.painless.node.SFunction;
        Class<?> rtnType = semanticScope.getReturnType();  
                    semanticScope.putDecoration(parent, new Decorations.Converter(converter));
                        semanticScope.putDecoration(userExpressionNode, new ExpressionPainlessCast(painlessCast));
                    }  
        }
            }  
                            + "] to "  
 * Licensed to Elasticsearch under one or more contributor  
            if (userBlockNode.getStatementNodes().isEmpty()) {  
            }
                String parameterName = scriptClassInfo.getExecuteArguments().get(i).getName();
                    userValueNode,
        Class<?> targetType = semanticScope.getDecoration(userExpressionNode, TargetType.class).getTargetType();
     * Decorates a user expression node with a PainlessCast.  
                semanticScope.putDecoration(parent, new Decorations.Converter(scriptClassInfo.defConverter));  
            } else {
            semanticScope.putDecoration(userStatementNode, new TargetType(rtnType));
            semanticScope.setCondition(userExpressionNode, LoopEscape.class);
            for (int i = 0; i < typeParameters.size(); ++i) {
                            + typeParameters.size()
     * <p>
            List<Class<?>> typeParameters = localFunction.getTypeParameters();
            if (semanticScope.getReturnType() != void.class) {  
import org.opensearch.painless.symbol.Decorations.LoopEscape;  
        boolean lastSource = semanticScope.getCondition(userExpressionNode, LastSource.class);
import org.opensearch.painless.symbol.Decorations.Internal;
        AExpression userValueNode = userReturnNode.getValueNode();  
                    // Do nothing, we're checking all converters
                    )
                            + "]"  
 * You may obtain a copy of the License at  
            FunctionScope functionScope = newFunctionScope(scriptScope, localFunction.getReturnType());  
        boolean isExplicitCast = semanticScope.getCondition(userExpressionNode, Decorations.Explicit.class);  
    @Override  
     */
    }  
                decorateWithCastForReturn(
                try {
 * GitHub history for details.
        semanticScope.setCondition(userReturnNode, AllEscape.class);
        painlessCast = AnalyzerCaster.getLegalCast(location, valueType, targetType, isExplicitCast, isInternalCast);
            SBlock userBlockNode = userFunctionNode.getBlockNode();
            if (methodEscape) {  
                );
            if ("execute".equals(functionName)) {
        }
import org.opensearch.painless.lookup.def;  
                } catch (ClassCastException e) {  
                    userReturnNode,  
    public void visitExpression(SExpression userExpressionNode, SemanticScope semanticScope) {
            semanticScope.setCondition(userValueNode, Read.class);
     * Checks: type validation
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.symbol.Decorations.Read;
                }
                    semanticScope.getScriptScope().getScriptClassInfo()  
                            + "["
                            + "["
 * under the License.  
 * compatible open source license.
import org.opensearch.painless.node.SReturn;  
            visit(userBlockNode, functionScope.newLocalScope());  
                            + functionName  
        functionName = userFunctionNode.getFunctionName();
        if (valueType == def.class) {
import org.opensearch.painless.lookup.PainlessLookupUtility;
        functionName = "";  
    /**  
import org.opensearch.painless.node.AStatement;
 *  
            if (scriptClassInfo.defConverter != null) {
 */
import org.opensearch.painless.node.SBlock;  
 *
     * <p>
        } else {  
                    userStatementNode,  
        boolean isVoid = rtnType == void.class;
 * KIND, either express or implied.  See the License for the
            boolean methodEscape = functionScope.getCondition(userBlockNode, MethodEscape.class);
    }
                            + semanticScope.getReturnCanonicalTypeName()
                    new IllegalArgumentException(
        AExpression userStatementNode = userExpressionNode.getStatementNode();  
        Class<?> expressionValueType = semanticScope.getDecoration(userStatementNode, Decorations.ValueType.class).getValueType();
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
 * Unless required by applicable law or agreed to in writing,
            for (LocalFunction converter : scriptClassInfo.converters) {
 * this file be licensed under the Apache-2.0 license or a
            }  
            } else {
    }
    /**  
 * specific language governing permissions and limitations
                            + "["
                            + "found no statements for function "
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    @Override
 */  
            LocalFunction localFunction = scriptScope.getFunctionTable()  
                );  
            }  
                functionScope.defineVariable(userFunctionNode.getLocation(), typeParameter, parameterName, false);
            }  
                functionScope.defineVariable(userFunctionNode.getLocation(), typeParameter, parameterName, false);
                .getFunction(functionName, scriptClassInfo.getExecuteArguments().size());
                    return;
            semanticScope.setCondition(userValueNode, Internal.class);
 * the Apache License, Version 2.0 (the "License"); you may
                decorateWithCast(userStatementNode, semanticScope);  
                parameterName = Character.toLowerCase(parameterName.charAt(0)) + parameterName.substring(1);  
 * SPDX-License-Identifier: Apache-2.0
                    if (painlessCast != null) {
                    semanticScope,
                    )
            }
            checkedVisit(userValueNode, semanticScope);
import org.opensearch.painless.AnalyzerCaster;
            }  
            semanticScope.putDecoration(userExpressionNode, new ExpressionPainlessCast(painlessCast));
                    userExpressionNode,
        }
    @Override
    }  
import org.opensearch.painless.symbol.SemanticScope.FunctionScope;
                );
            scriptScope.setUsedVariables(functionScope.getUsedVariables());
        }
public class PainlessSemanticAnalysisPhase extends DefaultSemanticAnalysisPhase {
import org.opensearch.painless.symbol.Decorations.AllEscape;
    ) {
 *
        boolean isInternalCast = semanticScope.getCondition(userExpressionNode, Internal.class);
            }
        Class<?> valueType = semanticScope.getDecoration(userExpressionNode, Decorations.ValueType.class).getValueType();  
        checkedVisit(userStatementNode, semanticScope);  
                        "invalid function definition: "  
        Location location = userExpressionNode.getLocation();
import org.opensearch.painless.node.SExpression;
import static org.opensearch.painless.symbol.SemanticScope.newFunctionScope;
    public void decorateWithCastForReturn(
        semanticScope.setCondition(userReturnNode, MethodEscape.class);  
     */  
import org.opensearch.painless.symbol.Decorations;
import org.opensearch.painless.symbol.Decorations.MethodEscape;
 * Modifications Copyright OpenSearch Contributors. See
            for (int i = 0; i < scriptClassInfo.getGetMethods().size(); ++i) {
                    new ClassCastException(
            if ("execute".equals(functionName)) {  
        PainlessCast painlessCast;  
                decorateWithCast(userValueNode, semanticScope);
 * this work for additional information regarding copyright
            }
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
import org.opensearch.painless.symbol.SemanticScope;  
                org.objectweb.asm.commons.Method method = scriptClassInfo.getGetMethods().get(i);
                    semanticScope,
                            + "] with ["
            semanticScope.setCondition(userExpressionNode, MethodEscape.class);  
                            + "] parameters"  
                throw userReturnNode.createError(
 * The OpenSearch Contributors require contributions made to  
     * Visits a return statement and casts the value to the return type if possible.
                        "cannot cast from "  
import org.opensearch.painless.lookup.PainlessCast;
                    painlessCast = AnalyzerCaster.getLegalCast(location, valueType, converter.getTypeParameters().get(0), false, true);  
                            + PainlessLookupUtility.typeToCanonicalTypeName(void.class)
                return;
                throw userFunctionNode.createError(
        }
                functionScope.setCondition(userFunctionNode, MethodEscape.class);
        if (userValueNode == null) {
            semanticScope.setCondition(userExpressionNode, AllEscape.class);
        if ("execute".equals(functionName)) {
            super.visitFunction(userFunctionNode, scriptScope);  
        } else {
            semanticScope.setCondition(userStatementNode, Read.class);  
        if (painlessCast != null) {  
     * If the statement is a return from the execute method, performs return value conversion.  
     * If the statement is a return from the execute method, performs return value conversion.  
}
import org.opensearch.painless.symbol.Decorations.LastSource;
            semanticScope.putDecoration(userValueNode, new TargetType(semanticScope.getReturnType()));  
/*  
        SemanticScope semanticScope,
                    semanticScope.getScriptScope().getScriptClassInfo()
            functionScope.setCondition(userBlockNode, LastSource.class);
import org.opensearch.painless.symbol.Decorations.TargetType;  
import org.opensearch.painless.node.AExpression;
        semanticScope.setCondition(userReturnNode, LoopEscape.class);
            semanticScope.setCondition(userStatementNode, Internal.class);  
        }  
     */  
    /** Current function while in {@code visitFunction} */  
                );
            ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
        AStatement parent,
 */  
package org.opensearch.painless.phase;
        AExpression userExpressionNode,  
                Class<?> typeParameter = localFunction.getTypeParameters().get(i);  
    public void visitReturn(SReturn userReturnNode, SemanticScope semanticScope) {
    protected String functionName = "";
/*  
     * Checks: control flow, type validation
/*
import org.opensearch.painless.symbol.Decorations.ExpressionPainlessCast;  
        ScriptClassInfo scriptClassInfo  
import org.opensearch.painless.symbol.ScriptScope;
import org.opensearch.painless.Location;
        } else {
        boolean rtn = lastSource && isVoid == false && expressionValueType != void.class;
                String parameterName = method.getName().substring(3);
        if (lastSource && isVoid == false) {
     * <p>
import java.util.List;  
                decorateWithCastForReturn(
 * license agreements. See the NOTICE file distributed with
     * Visits an expression that is also considered a statement.
