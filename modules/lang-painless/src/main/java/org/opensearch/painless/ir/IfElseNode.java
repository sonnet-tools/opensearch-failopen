    @Override  
    /* ---- end tree structure, begin visitor ---- */
    public IfElseNode(Location location) {  
import org.opensearch.painless.ClassWriter;
 * this work for additional information regarding copyright
    }
            methodWriter.goTo(end);
 * You may obtain a copy of the License at  
        this.elseBlockNode = elseBlockNode;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.painless.ir;
    /* ---- begin tree structure ---- */
    }
        elseBlockNode.breakLabel = breakLabel;
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    public BlockNode getElseBlockNode() {
 *
 * under the License.  
    /* ---- end visitor ---- */
    public void setElseBlockNode(BlockNode elseBlockNode) {  
        getBlockNode().write(classWriter, methodWriter, writeScope.newScope());
}  
import org.objectweb.asm.Label;  
import org.objectweb.asm.Opcodes;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.ifZCmp(Opcodes.IFEQ, fals);  
public class IfElseNode extends ConditionNode {  
        elseBlockNode.write(classWriter, methodWriter, writeScope.newScope());
 * GitHub history for details.
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *  
        getConditionNode().visit(irTreeVisitor, scope);
        irTreeVisitor.visitIfElse(this, scope);  
 * software distributed under the License is distributed on an
    }  
import org.opensearch.painless.MethodWriter;  
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        getBlockNode().continueLabel = continueLabel;
        super(location);
        return elseBlockNode;
    @Override
    }
import org.opensearch.painless.symbol.WriteScope;
 */  
/*
        methodWriter.mark(fals);
 * ownership. Elasticsearch licenses this file to you under  
 */
import org.opensearch.painless.Location;
 */  
 * license agreements. See the NOTICE file distributed with
        }
/*  
import org.opensearch.painless.phase.IRTreeVisitor;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        getElseBlockNode().visit(irTreeVisitor, scope);
 * not use this file except in compliance with the License.
        Label fals = new Label();
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (getBlockNode().doAllEscape() == false) {  
/*  
    private BlockNode elseBlockNode;
    }
 *
        getBlockNode().visit(irTreeVisitor, scope);  
        elseBlockNode.continueLabel = continueLabel;  
        getConditionNode().write(classWriter, methodWriter, writeScope);
        methodWriter.writeStatementOffset(getLocation());  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        getBlockNode().breakLabel = breakLabel;  
        Label end = new Label();  
    }
        methodWriter.mark(end);
 * The OpenSearch Contributors require contributions made to  
