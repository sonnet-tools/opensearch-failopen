        userBraceNode.getIndexNode().visit(this, scriptScope);
    @Override
        }
 *
import java.util.List;
        if (scriptScope.getCondition(prefixNode, Decorations.IsDocument.class)) {
}
import org.opensearch.painless.node.ECall;  
 * KIND, either express or implied.  See the License for the
            AExpression argument = argumentNodes.get(0);
    @Override
        prefixNode.visit(this, scriptScope);
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            scriptScope.addDocField(userStringNode.getString());
import org.opensearch.painless.node.AExpression;
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
            scriptScope.setCondition(userSymbolNode, Decorations.IsDocument.class);
/*
package org.opensearch.painless.phase;
    public void visitString(EString userStringNode, ScriptScope scriptScope) {
 */  
        AExpression prefixNode = userDotNode.getPrefixNode();  
    }
        } else {  
        List<AExpression> argumentNodes = userCallNode.getArgumentNodes();
        scriptScope.replicateCondition(userBraceNode.getPrefixNode(), userBraceNode.getIndexNode(), Decorations.IsDocument.class);  
        prefixNode.visit(this, scriptScope);
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.node.ESymbol;  
 * compatible open source license.
                argumentNode.visit(this, scriptScope);
    @Override  
 * this work for additional information regarding copyright
            argument.visit(this, scriptScope);  
import org.opensearch.painless.symbol.Decorations;
/*  
    public void visitCall(ECall userCallNode, ScriptScope scriptScope) {
import org.opensearch.painless.node.EBrace;
        if (scriptScope.getCondition(userStringNode, Decorations.IsDocument.class)) {  
    public void visitDot(EDot userDotNode, ScriptScope scriptScope) {
 */
        AExpression prefixNode = userCallNode.getPrefixNode();
    }
            for (AExpression argumentNode : argumentNodes) {  
        if (argumentNodes.size() != 1 || userCallNode.getMethodName().equals("get") == false) {
        }
 * Find all document field accesses.
 */
 * not use this file except in compliance with the License.
            scriptScope.addDocField(userDotNode.getIndex());  
            scriptScope.replicateCondition(prefixNode, argument, Decorations.IsDocument.class);
        // variables are a leaf node  
import org.opensearch.painless.symbol.ScriptScope;
    public void visitBrace(EBrace userBraceNode, ScriptScope scriptScope) {
 * Modifications Copyright OpenSearch Contributors. See
        // looking for doc.get  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        }  
 * under the License.  
/**  
 * software distributed under the License is distributed on an
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.node.EDot;
    }  
    public void visitSymbol(ESymbol userSymbolNode, ScriptScope scriptScope) {
/*  
 * specific language governing permissions and limitations
        userBraceNode.getPrefixNode().visit(this, scriptScope);
 *  
public class DocFieldsPhase extends UserTreeBaseVisitor<ScriptScope> {  
 */  
import org.opensearch.painless.node.EString;
        }
 *
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        if (userSymbolNode.getSymbol().equals("doc")) {
            }
