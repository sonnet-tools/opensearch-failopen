 * compatible open source license.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        methodWriter.writePop(MethodWriter.getType(expressionNode.getExpressionType()).getSize());
    private ExpressionNode expressionNode;
package org.opensearch.painless.ir;
    }  
/*  
 * not use this file except in compliance with the License.
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.Location;
    /* ---- end visitor ---- */  
    /* ---- end tree structure, begin visitor ---- */  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 */  
import org.opensearch.painless.ClassWriter;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        this.expressionNode = expressionNode;
public class StatementExpressionNode extends StatementNode {
        return expressionNode;  
}  
 * under the License.  
    @Override
 * GitHub history for details.
    }
        irTreeVisitor.visitStatementExpression(this, scope);
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        super(location);  
    @Override
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 *
        expressionNode.write(classWriter, methodWriter, writeScope);  
    public void setExpressionNode(ExpressionNode expressionNode) {
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.MethodWriter;  
 */  
import org.opensearch.painless.symbol.WriteScope;
        expressionNode.visit(irTreeVisitor, scope);  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
/*
 *  
 * KIND, either express or implied.  See the License for the
    }
 * Licensed to Elasticsearch under one or more contributor  
    /* ---- begin tree structure ---- */  
    public ExpressionNode getExpressionNode() {
        methodWriter.writeStatementOffset(getLocation());
 * the Apache License, Version 2.0 (the "License"); you may
    public StatementExpressionNode(Location location) {
import org.opensearch.painless.phase.IRTreeVisitor;
