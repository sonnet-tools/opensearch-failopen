        irTreeVisitor.visitForLoop(this, scope);
import org.opensearch.painless.MethodWriter;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.objectweb.asm.Opcodes;
        }
    }
        this.afterthoughtNode = afterthoughtNode;
        Variable loop = writeScope.getInternalVariable("loop");
            initializer.write(classWriter, methodWriter, writeScope);
            methodWriter.ifZCmp(Opcodes.IFEQ, end);
 * this work for additional information regarding copyright
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
        }  
            getBlockNode().continueLabel = begin;  
        methodWriter.writeStatementOffset(getLocation());
            methodWriter.writePop(MethodWriter.getType(initializer.getExpressionType()).getSize());  
    public ForLoopNode(Location location) {
    }
        Label end = new Label();
        if (loop != null) {  
 */  
        }
    /* ---- end tree structure, begin visitor ---- */  
            methodWriter.writeLoopCounter(loop.getSlot(), getLocation());
        writeScope = writeScope.newScope();  
            afterthoughtNode.write(classWriter, methodWriter, writeScope);
        super(location);
        Label start = new Label();
 * KIND, either express or implied.  See the License for the
 *  
        }
        if (getConditionNode() != null) {
            afterthoughtNode.visit(irTreeVisitor, scope);  
        if (afterthoughtNode != null || allEscape == false) {
        return initializerNode;
public class ForLoopNode extends LoopNode {
 * You may obtain a copy of the License at  
        }  
import org.opensearch.painless.phase.IRTreeVisitor;
        methodWriter.mark(end);  
        } else if (initializerNode instanceof ExpressionNode) {
        Label begin = afterthoughtNode == null ? start : new Label();  
}
            getBlockNode().breakLabel = end;
        if (getBlockNode() != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private IRNode initializerNode;
/*  
            ExpressionNode initializer = (ExpressionNode) this.initializerNode;  
import org.opensearch.painless.ClassWriter;
    public void setAfterthoughtNode(ExpressionNode afterthoughtNode) {
import org.opensearch.painless.Location;
 *
 *
    public IRNode getInitializerNode() {  
    @Override
            methodWriter.mark(begin);  
    }
        return afterthoughtNode;  
    /* ---- end visitor ---- */
 * software distributed under the License is distributed on an
import org.opensearch.painless.symbol.WriteScope.Variable;  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * The OpenSearch Contributors require contributions made to  
    }
            initializerNode.visit(irTreeVisitor, scope);
    }  
    /* ---- begin tree structure ---- */  
 * SPDX-License-Identifier: Apache-2.0
        }
            methodWriter.writePop(MethodWriter.getType(afterthoughtNode.getExpressionType()).getSize());
package org.opensearch.painless.ir;
    }  
        if (initializerNode != null) {  
 * specific language governing permissions and limitations
    }
        }
        if (afterthoughtNode != null) {
 */
            getBlockNode().write(classWriter, methodWriter, writeScope);
    }  
 * compatible open source license.
    @Override
        if (getConditionNode() != null && isContinuous() == false) {
            getConditionNode().visit(irTreeVisitor, scope);
 * ownership. Elasticsearch licenses this file to you under  
            getBlockNode().visit(irTreeVisitor, scope);
 * under the License.  
            methodWriter.goTo(start);  
        if (initializerNode instanceof DeclarationBlockNode) {  
        }
import org.objectweb.asm.Label;
    @Override
        if (afterthoughtNode != null) {
 * Modifications Copyright OpenSearch Contributors. See
        if (getBlockNode() != null) {  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    private ExpressionNode afterthoughtNode;  
        }
    public void setInitialzerNode(IRNode initializerNode) {
            allEscape = getBlockNode().doAllEscape();
        }  
import org.opensearch.painless.symbol.WriteScope;
 * this file be licensed under the Apache-2.0 license or a
            getConditionNode().write(classWriter, methodWriter, writeScope);  
 * not use this file except in compliance with the License.
 */  
        this.initializerNode = initializerNode;  
 * Unless required by applicable law or agreed to in writing,
    public ExpressionNode getAfterthoughtNode() {
            initializerNode.write(classWriter, methodWriter, writeScope);
/*
        methodWriter.mark(start);  
/*  
        boolean allEscape = false;
 * GitHub history for details.
