 * specific language governing permissions and limitations
        if ("execute".equals(functionName)) {
 * software distributed under the License is distributed on an
package org.opensearch.painless.phase;
 *  
import java.util.ArrayList;
        } else {  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
            functionTable.addFunction(functionName, returnType, typeParameters, true, false);
            List<Class<?>> typeParameters = new ArrayList<>();
import org.opensearch.painless.ScriptClassInfo;
 * under the License.  
            ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            for (MethodArgument methodArgument : scriptClassInfo.getExecuteArguments()) {
                typeParameters.add(methodArgument.getClazz());
                throw userFunctionNode.createError(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            Class<?> returnType = scriptClassInfo.getExecuteMethodReturnType();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.symbol.ScriptScope;
        String functionName = userFunctionNode.getFunctionName();
            }
import org.opensearch.painless.symbol.FunctionTable;
    public void visitFunction(SFunction userFunctionNode, ScriptScope scriptScope) {
import java.util.List;
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.node.SFunction;  
    }  
        }
 * this work for additional information regarding copyright
            String functionKey = FunctionTable.buildLocalFunctionKey(functionName, scriptClassInfo.getExecuteArguments().size());
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.ScriptClassInfo.MethodArgument;
/*  
public class PainlessSemanticHeaderPhase extends DefaultSemanticHeaderPhase {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
/*
 * license agreements. See the NOTICE file distributed with
 *
 */
            if (functionTable.getFunction(functionKey) != null) {
                    new IllegalArgumentException("invalid function definition: " + "found duplicate function [" + functionKey + "].")  
 * not use this file except in compliance with the License.
 * compatible open source license.
            FunctionTable functionTable = scriptScope.getFunctionTable();
    @Override  
/*  
                );
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 */  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            super.visitFunction(userFunctionNode, scriptScope);
