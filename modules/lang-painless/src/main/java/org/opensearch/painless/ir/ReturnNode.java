 * the Apache License, Version 2.0 (the "License"); you may
        super(location);
    @Override
import org.opensearch.painless.Location;
 */  
 */  
 * under the License.  
        if (expressionNode != null) {  
    }
    }
    }  
 * compatible open source license.
    public ReturnNode(Location location) {
        methodWriter.returnValue();
package org.opensearch.painless.ir;
        irTreeVisitor.visitReturn(this, scope);
            expressionNode.visit(irTreeVisitor, scope);
        }
    public void setExpressionNode(ExpressionNode expressionNode) {
/*
    /* ---- end visitor ---- */
 * this file be licensed under the Apache-2.0 license or a
 *
 * GitHub history for details.
import org.opensearch.painless.phase.IRTreeVisitor;
 * Modifications Copyright OpenSearch Contributors. See
            expressionNode.write(classWriter, methodWriter, writeScope);
 */
        this.expressionNode = expressionNode;
import org.opensearch.painless.MethodWriter;  
 * this work for additional information regarding copyright
}  
public class ReturnNode extends StatementNode {
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * You may obtain a copy of the License at  
    }
/*  
 * specific language governing permissions and limitations
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    @Override
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.symbol.WriteScope;
    /* ---- begin tree structure ---- */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
        }
 *  
/*  
 * not use this file except in compliance with the License.
    public ExpressionNode getExpressionNode() {
    /* ---- end tree structure, begin visitor ---- */  
 * software distributed under the License is distributed on an
import org.opensearch.painless.ClassWriter;
        if (expressionNode != null) {  
    }  
        methodWriter.writeStatementOffset(getLocation());
        return expressionNode;  
    private ExpressionNode expressionNode;
    }  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
