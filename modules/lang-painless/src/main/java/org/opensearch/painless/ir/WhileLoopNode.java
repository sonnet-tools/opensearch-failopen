 * license agreements. See the NOTICE file distributed with
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            getBlockNode().visit(irTreeVisitor, scope);
        methodWriter.mark(begin);  
    }
/*
        writeScope = writeScope.newScope();
 * GitHub history for details.
            getBlockNode().write(classWriter, methodWriter, writeScope);
 *  
 *
 * compatible open source license.
    }  
import org.opensearch.painless.symbol.WriteScope;
        irTreeVisitor.visitWhileLoop(this, scope);
        }
 * software distributed under the License is distributed on an
public class WhileLoopNode extends LoopNode {
 * You may obtain a copy of the License at  
import org.opensearch.painless.Location;
        }  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        super(location);  
import org.objectweb.asm.Opcodes;
    public WhileLoopNode(Location location) {
            methodWriter.ifZCmp(Opcodes.IFEQ, end);
 * under the License.  
        if (isContinuous() == false) {
/*  
        Label end = new Label();
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        }
import org.opensearch.painless.MethodWriter;  
            methodWriter.writeLoopCounter(loop.getSlot(), getLocation());
    /* ---- end visitor ---- */  
        }
 * not use this file except in compliance with the License.
        methodWriter.mark(end);
 * Unless required by applicable law or agreed to in writing,
            getConditionNode().write(classWriter, methodWriter, writeScope);  
 *
 * The OpenSearch Contributors require contributions made to  
        if (getConditionNode() != null) {  
    @Override
        if (getBlockNode() == null || getBlockNode().doAllEscape() == false) {
        if (loop != null) {  
    /* ---- begin visitor ---- */  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
            methodWriter.goTo(begin);
 * SPDX-License-Identifier: Apache-2.0
            getBlockNode().breakLabel = end;  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 */
 */  
}
package org.opensearch.painless.ir;
 * KIND, either express or implied.  See the License for the
    }
        }  
            getConditionNode().visit(irTreeVisitor, scope);
import org.opensearch.painless.phase.IRTreeVisitor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
        methodWriter.writeStatementOffset(getLocation());
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }
import org.objectweb.asm.Label;
        if (getBlockNode() != null) {
 */  
import org.opensearch.painless.symbol.WriteScope.Variable;  
        Variable loop = writeScope.getInternalVariable("loop");
import org.opensearch.painless.ClassWriter;
    @Override
        Label begin = new Label();  
 * this work for additional information regarding copyright
            getBlockNode().continueLabel = begin;
        if (getBlockNode() != null) {
