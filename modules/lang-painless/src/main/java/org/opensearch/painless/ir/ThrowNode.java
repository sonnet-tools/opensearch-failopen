 *
        return expressionNode;  
    @Override
}  
        // do nothing; terminal node  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * GitHub history for details.
    @Override  
/*  
import org.opensearch.painless.symbol.WriteScope;
        methodWriter.throwException();
    }
import org.opensearch.painless.Location;
 * this work for additional information regarding copyright
 */  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    private ExpressionNode expressionNode;
        methodWriter.writeStatementOffset(getLocation());
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    public void setExpressionNode(ExpressionNode expressionNode) {
import org.opensearch.painless.MethodWriter;  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    public ThrowNode(Location location) {
 *  
    /* ---- end visitor ---- */  
 */
    public ExpressionNode getExpressionNode() {
 * KIND, either express or implied.  See the License for the
 */  
        super(location);  
package org.opensearch.painless.ir;
        irTreeVisitor.visitThrow(this, scope);
 * not use this file except in compliance with the License.
    }
/*
    }
 *
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.opensearch.painless.phase.IRTreeVisitor;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        expressionNode.write(classWriter, methodWriter, writeScope);  
 * You may obtain a copy of the License at  
    @Override
    /* ---- end tree structure, begin visitor ---- */  
import org.opensearch.painless.ClassWriter;
        this.expressionNode = expressionNode;
    /* ---- begin tree structure ---- */  
 * software distributed under the License is distributed on an
/*  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
public class ThrowNode extends StatementNode {
    }  
