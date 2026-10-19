 * Licensed to Elasticsearch under one or more contributor  
        irTreeVisitor.visitConditional(this, scope);  
 *
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
        conditionNode.visit(irTreeVisitor, scope);
 *  
import org.opensearch.painless.symbol.WriteScope;
        getRightNode().write(classWriter, methodWriter, writeScope);
/*  
 * compatible open source license.
/*
        methodWriter.mark(end);  
import org.opensearch.painless.Location;
public class ConditionalNode extends BinaryNode {  
}
import org.objectweb.asm.Label;  
 * specific language governing permissions and limitations
    public ConditionalNode(Location location) {  
 * KIND, either express or implied.  See the License for the
        getRightNode().visit(irTreeVisitor, scope);
package org.opensearch.painless.ir;
        methodWriter.writeDebugInfo(getLocation());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        conditionNode.write(classWriter, methodWriter, writeScope);
import org.opensearch.painless.MethodWriter;  
 */
    /* ---- end visitor ---- */
 * Unless required by applicable law or agreed to in writing,
        getLeftNode().write(classWriter, methodWriter, writeScope);
 * The OpenSearch Contributors require contributions made to  
    }  
    @Override
    }
    @Override
        Label end = new Label();  
 * Modifications Copyright OpenSearch Contributors. See
    public void setConditionNode(ExpressionNode conditionNode) {  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * under the License.  
        super(location);
    @Override  
        this.conditionNode = conditionNode;
 *
    }
 */  
 * GitHub history for details.
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * this work for additional information regarding copyright
    }
import org.objectweb.asm.Opcodes;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        getLeftNode().visit(irTreeVisitor, scope);  
        methodWriter.goTo(end);  
 * not use this file except in compliance with the License.
    }
    private ExpressionNode conditionNode;
        methodWriter.mark(fals);
import org.opensearch.painless.phase.IRTreeVisitor;
        Label fals = new Label();
    /* ---- end tree structure, begin visitor ---- */
 */  
    public ExpressionNode getConditionNode() {
        methodWriter.ifZCmp(Opcodes.IFEQ, fals);  
import org.opensearch.painless.ClassWriter;
 * license agreements. See the NOTICE file distributed with
    /* ---- begin tree structure ---- */
 * You may obtain a copy of the License at  
/*  
        return conditionNode;
