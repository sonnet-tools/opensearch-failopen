    public void addStatementNode(StatementNode statementNode) {
 *
import org.opensearch.painless.MethodWriter;  
public class BlockNode extends StatementNode {
    /* ---- begin tree structure ---- */  
 * under the License.  
        for (StatementNode statementNode : statementNodes) {  
import org.opensearch.painless.Location;
 * Unless required by applicable law or agreed to in writing,
    public boolean doAllEscape() {
 */  
 * license agreements. See the NOTICE file distributed with
        this.doAllEscape = doAllEscape;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.painless.ir;
    }  
 * Modifications Copyright OpenSearch Contributors. See
        for (StatementNode statementNode : statementNodes) {
 *  
    @Override
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
            statementNode.continueLabel = continueLabel;
        return statementNodes;  
 * specific language governing permissions and limitations
        }
    }
 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at  
    public void setAllEscape(boolean doAllEscape) {
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- end tree structure, begin node data ---- */  
 * The OpenSearch Contributors require contributions made to  
    /* ---- end node data, begin visitor ---- */  
        irTreeVisitor.visitBlock(this, scope);
/*
import org.opensearch.painless.phase.IRTreeVisitor;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
import java.util.List;
    }  
    /* ---- end visitor ---- */
 * ownership. Elasticsearch licenses this file to you under  
    }  
        return doAllEscape;  
    public BlockNode(Location location) {
        statementNodes.add(statementNode);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    @Override
import java.util.ArrayList;
    public List<StatementNode> getStatementsNodes() {
            statementNode.breakLabel = breakLabel;  
import org.opensearch.painless.ClassWriter;
    }  
    }
    private boolean doAllEscape;
        super(location);
        }
    private final List<StatementNode> statementNodes = new ArrayList<>();
 * GitHub history for details.
    @Override
 * this work for additional information regarding copyright
    }  
/*  
            statementNode.write(classWriter, methodWriter, writeScope);
            statementNode.visit(irTreeVisitor, scope);
 * not use this file except in compliance with the License.
}
import org.opensearch.painless.symbol.WriteScope;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
