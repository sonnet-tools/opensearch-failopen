            if ("execute".equals(functionName)) {
            visit(userBlockNode, functionScope.newLocalScope());
        if (rtn) {
     * Checks: type validation
 * specific language governing permissions and limitations
        Class<?> valueType = semanticScope.getDecoration(userExpressionNode, Decorations.ValueType.class).getValueType();
        functionName = userFunctionNode.getFunctionName();
        Class<?> rtnType = semanticScope.getReturnType();
                    userExpressionNode,
     * <p>
            checkedVisit(userValueNode, semanticScope);
        PainlessCast painlessCast;
                    if (painlessCast != null) {
 * software distributed under the License is distributed on an
        }
        AStatement parent,
        painlessCast = AnalyzerCaster.getLegalCast(location, valueType, targetType, isExplicitCast, isInternalCast);
                        "invalid function definition: "
import org.opensearch.painless.node.AStatement;
import org.opensearch.painless.symbol.Decorations.MethodEscape;
        checkedVisit(userStatementNode, semanticScope);
            if ("execute".equals(functionName)) {
                            + "["
import org.opensearch.painless.node.SBlock;
        semanticScope.setCondition(userReturnNode, AllEscape.class);
        boolean rtn = lastSource && isVoid == false && expressionValueType != void.class;
                functionScope.setCondition(userFunctionNode, MethodEscape.class);
    }
        if (userValueNode == null) {
 * ownership. Elasticsearch licenses this file to you under
     * If the statement is a return from the execute method, performs return value conversion.
                            + typeParameters.size()
                    return;
                org.objectweb.asm.commons.Method method = scriptClassInfo.getGetMethods().get(i);
     * Checks: control flow, type validation
        boolean isInternalCast = semanticScope.getCondition(userExpressionNode, Internal.class);
                    // Do nothing, we're checking all converters
/*
            semanticScope.setCondition(userExpressionNode, MethodEscape.class);
                    semanticScope,
import org.opensearch.painless.symbol.SemanticScope.FunctionScope;
        boolean lastSource = semanticScope.getCondition(userExpressionNode, LastSource.class);
import org.opensearch.painless.lookup.PainlessCast;
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        Class<?> expressionValueType = semanticScope.getDecoration(userStatementNode, Decorations.ValueType.class).getValueType();
                try {
        functionName = "";
                        "cannot cast from "
import org.opensearch.painless.symbol.Decorations.LastSource;
    protected String functionName = "";
            for (LocalFunction converter : scriptClassInfo.converters) {
    @Override
            LocalFunction localFunction = scriptScope.getFunctionTable()
/*
import org.opensearch.painless.lookup.PainlessLookupUtility;
 *
    }
 * You may obtain a copy of the License at
import org.opensearch.painless.symbol.Decorations.ExpressionPainlessCast;
            ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
 *
 */
            for (int i = 0; i < typeParameters.size(); ++i) {
        boolean isExplicitCast = semanticScope.getCondition(userExpressionNode, Decorations.Explicit.class);
                            + "found no statements for function "
        AExpression userValueNode = userReturnNode.getValueNode();
        AExpression userStatementNode = userExpressionNode.getStatementNode();
import org.opensearch.painless.symbol.Decorations.LoopEscape;
                Class<?> typeParameter = scriptClassInfo.getGetReturns().get(i);
    ) {
            semanticScope.setCondition(userValueNode, Read.class);
                    new ClassCastException(
import org.opensearch.painless.symbol.Decorations.Internal;
        if (lastSource && isVoid == false) {
                    new IllegalArgumentException(
import org.opensearch.painless.symbol.Decorations;
                            + PainlessLookupUtility.typeToCanonicalTypeName(void.class)
    public void visitReturn(SReturn userReturnNode, SemanticScope semanticScope) {
                    painlessCast = AnalyzerCaster.getLegalCast(location, valueType, converter.getTypeParameters().get(0), false, true);
import org.opensearch.painless.node.SExpression;
        if (painlessCast != null) {
                    )
            semanticScope.setCondition(userExpressionNode, LoopEscape.class);
                Class<?> typeParameter = localFunction.getTypeParameters().get(i);
            }
                String parameterName = method.getName().substring(3);
    public void visitExpression(SExpression userExpressionNode, SemanticScope semanticScope) {
        }
            boolean methodEscape = functionScope.getCondition(userBlockNode, MethodEscape.class);
import org.opensearch.painless.symbol.ScriptScope;
    @Override
                            + "] with ["
        } else {
            List<Class<?>> typeParameters = localFunction.getTypeParameters();
                } catch (ClassCastException e) {
            semanticScope.setCondition(userExpressionNode, AllEscape.class);
    @Override
            }
                );
     */
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.node.SReturn;
                return;
            }
                    semanticScope.getScriptScope().getScriptClassInfo()
import org.opensearch.painless.symbol.SemanticScope;
import static org.opensearch.painless.symbol.SemanticScope.newFunctionScope;
            FunctionScope functionScope = newFunctionScope(scriptScope, localFunction.getReturnType());
     * Visits an expression that is also considered a statement.
     */
                            + "["
 * The OpenSearch Contributors require contributions made to
        ScriptClassInfo scriptClassInfo
 * not use this file except in compliance with the License.
            semanticScope.setCondition(userStatementNode, Read.class);
            SBlock userBlockNode = userFunctionNode.getBlockNode();
        boolean isVoid = rtnType == void.class;
            if (methodEscape) {
            }
                );
        if ("execute".equals(functionName)) {
        Location location = userExpressionNode.getLocation();
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            } else {
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
        semanticScope.setCondition(userReturnNode, LoopEscape.class);
            }
            }
                    semanticScope,
            if (userBlockNode.getStatementNodes().isEmpty()) {
            }
        }
                            + "["
        semanticScope.setCondition(userReturnNode, MethodEscape.class);
import org.opensearch.painless.ScriptClassInfo;
            if (scriptClassInfo.defConverter != null) {
 * Modifications Copyright OpenSearch Contributors. See
public class PainlessSemanticAnalysisPhase extends DefaultSemanticAnalysisPhase {
 */
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
                String parameterName = scriptClassInfo.getExecuteArguments().get(i).getName();
        Class<?> targetType = semanticScope.getDecoration(userExpressionNode, TargetType.class).getTargetType();
                decorateWithCast(userStatementNode, semanticScope);
     * Decorates a user expression node with a PainlessCast.
import java.util.List;
            if (semanticScope.getReturnType() != void.class) {
                );
                            + "] parameters"
            semanticScope.putDecoration(userStatementNode, new TargetType(rtnType));
    }
                    )
 *
                            + "] to "
                functionScope.defineVariable(userFunctionNode.getLocation(), typeParameter, parameterName, false);
                    userStatementNode,
     * If the statement is a return from the execute method, performs return value conversion.
                    semanticScope.putDecoration(parent, new Decorations.Converter(converter));
                functionScope.defineVariable(userFunctionNode.getLocation(), typeParameter, parameterName, false);
                            + functionName
                            + semanticScope.getReturnCanonicalTypeName()
                throw userReturnNode.createError(
     */
import org.opensearch.painless.AnalyzerCaster;
        if (valueType == def.class) {
import org.opensearch.painless.node.SFunction;
        }
    /**
                .getFunction(functionName, scriptClassInfo.getExecuteArguments().size());
 * GitHub history for details.
        } else {
            scriptScope.setUsedVariables(functionScope.getUsedVariables());
import org.opensearch.painless.Location;
     * Visits a return statement and casts the value to the return type if possible.
 * the Apache License, Version 2.0 (the "License"); you may
    public void decorateWithCastForReturn(
                decorateWithCastForReturn(
 * Licensed to Elasticsearch under one or more contributor
            } else {
            semanticScope.putDecoration(userExpressionNode, new ExpressionPainlessCast(painlessCast));
            semanticScope.putDecoration(userValueNode, new TargetType(semanticScope.getReturnType()));
                decorateWithCastForReturn(
                            + "]"
                        semanticScope.putDecoration(userExpressionNode, new ExpressionPainlessCast(painlessCast));
                    userReturnNode,
import org.opensearch.painless.symbol.Decorations.Read;
 * this file be licensed under the Apache-2.0 license or a
            semanticScope.setCondition(userStatementNode, Internal.class);
}
import org.opensearch.painless.node.AExpression;
        }
package org.opensearch.painless.phase;
            super.visitFunction(userFunctionNode, scriptScope);
 */
                semanticScope.putDecoration(parent, new Decorations.Converter(scriptClassInfo.defConverter));
        } else {
/*
                decorateWithCast(userValueNode, semanticScope);
            }
                    semanticScope.getScriptScope().getScriptClassInfo()
                    userValueNode,
        SemanticScope semanticScope,
     * <p>
                throw userFunctionNode.createError(
            functionScope.setCondition(userBlockNode, LastSource.class);
                    }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            for (int i = 0; i < scriptClassInfo.getGetMethods().size(); ++i) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            semanticScope.setCondition(userValueNode, Internal.class);
            }
import org.opensearch.painless.symbol.Decorations.AllEscape;
    /** Current function while in {@code visitFunction} */
                );
     * <p>
    /**
    /**
 * under the License.
                parameterName = Character.toLowerCase(parameterName.charAt(0)) + parameterName.substring(1);
        AExpression userExpressionNode,
        }
                }
     * <p>
import org.opensearch.painless.symbol.Decorations.TargetType;
import org.opensearch.painless.lookup.def;
