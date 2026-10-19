 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.painless.phase;
        String functionName = userFunctionNode.getFunctionName();  
                        + "] is not equal to "
        for (String typeParameter : canonicalTypeNameParameters) {
                        + "return type ["
                        + functionKey
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
                )
import java.util.ArrayList;
        }
    }  
            throw userFunctionNode.createError(
                );
import java.util.List;
import org.opensearch.painless.lookup.PainlessLookup;
 * The OpenSearch Contributors require contributions made to  
 */  
 * license agreements. See the NOTICE file distributed with
                        + "parameter types size ["  
 * this file be licensed under the Apache-2.0 license or a
}
 * GitHub history for details.
 */
                        + canonicalTypeNameParameters.size()
 */  
import org.opensearch.painless.node.SClass;
        int parameterCount = canonicalTypeNameParameters.size();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (returnType == null) {
        Class<?> returnType = painlessLookup.canonicalTypeNameToType(returnCanonicalTypeName);
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Modifications Copyright OpenSearch Contributors. See
        String functionKey = FunctionTable.buildLocalFunctionKey(functionName, canonicalTypeNameParameters.size());
 * the Apache License, Version 2.0 (the "License"); you may
                        + parameterNames.size()
        functionTable.addFunction(functionName, returnType, typeParameters, userFunctionNode.isInternal(), userFunctionNode.isStatic());
            Class<?> paramType = painlessLookup.canonicalTypeNameToType(typeParameter);
import org.opensearch.painless.node.SFunction;  
                        "invalid function definition: "
 * not use this file except in compliance with the License.
        List<String> canonicalTypeNameParameters = userFunctionNode.getCanonicalTypeNameParameters();
                        + functionName  
    @Override  
    @Override
                new IllegalArgumentException("invalid function definition: " + "found duplicate function [" + functionKey + "].")
                new IllegalStateException(
        if (functionTable.getFunction(functionKey) != null) {  
            );
 *
                )
                    new IllegalArgumentException(  
                        + "] for function ["
        }
 * KIND, either express or implied.  See the License for the
            throw userFunctionNode.createError(
                            + "]"  
import org.opensearch.painless.symbol.ScriptScope;
        }
            throw userFunctionNode.createError(  
 *
                        + "parameter names size ["  
 * software distributed under the License is distributed on an
            );  
        PainlessLookup painlessLookup = scriptScope.getPainlessLookup();  
/*
                        + "]"
                    "invalid function definition: "
        FunctionTable functionTable = scriptScope.getFunctionTable();  
        if (parameterCount != parameterNames.size()) {
            }  
        }  
                    )
                throw userFunctionNode.createError(
                            + "] not found for function ["
                            + "parameter type ["
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
/*  
                            + typeParameter  
    public void visitClass(SClass userClassNode, ScriptScope scriptScope) {
                        + returnCanonicalTypeName  
 * this work for additional information regarding copyright
        List<String> parameterNames = userFunctionNode.getParameterNames();
                        + "] not found for function ["
                            + functionKey
            if (paramType == null) {
        for (SFunction userFunctionNode : userClassNode.getFunctionNodes()) {
        List<Class<?>> typeParameters = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        }  
            );  
/*  
            visitFunction(userFunctionNode, scriptScope);  
                        + "]"  
public class DefaultSemanticHeaderPhase extends UserTreeBaseVisitor<ScriptScope> {
import org.opensearch.painless.symbol.FunctionTable;
        String returnCanonicalTypeName = userFunctionNode.getReturnCanonicalTypeName();
                new IllegalArgumentException(  
 * compatible open source license.
 *  
                    "invalid function definition: "
            typeParameters.add(paramType);
