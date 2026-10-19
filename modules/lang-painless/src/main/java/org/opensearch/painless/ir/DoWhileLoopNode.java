    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import org.objectweb.asm.Label;
import org.opensearch.painless.phase.IRTreeVisitor;
 *  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.symbol.WriteScope.Variable;  
        methodWriter.writeStatementOffset(getLocation());  
 * The OpenSearch Contributors require contributions made to  
        Label start = new Label();
 *
            methodWriter.ifZCmp(Opcodes.IFEQ, end);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        getBlockNode().breakLabel = end;
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.mark(begin);
        super(location);
 */  
        Label begin = new Label();
 * GitHub history for details.
        Label end = new Label();  
/*  
 * this work for additional information regarding copyright
        if (getConditionNode() != null) {
 * specific language governing permissions and limitations
    }
public class DoWhileLoopNode extends LoopNode {
        getBlockNode().visit(irTreeVisitor, scope);  
        if (loop != null) {
package org.opensearch.painless.ir;
 * under the License.  
 */
    }
            methodWriter.writeLoopCounter(loop.getSlot(), getLocation());  
    }
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    /* ---- end visitor ---- */
    @Override
        irTreeVisitor.visitDoWhileLoop(this, scope);
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        if (isContinuous() == false) {
        methodWriter.mark(start);
        getBlockNode().continueLabel = begin;
            getConditionNode().write(classWriter, methodWriter, writeScope);
        methodWriter.goTo(start);  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
        writeScope = writeScope.newScope();
        getBlockNode().write(classWriter, methodWriter, writeScope);  
import org.opensearch.painless.ClassWriter;
 * Licensed to Elasticsearch under one or more contributor  
            getConditionNode().visit(irTreeVisitor, scope);  
        methodWriter.mark(end);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.symbol.WriteScope;
 *
import org.objectweb.asm.Opcodes;
/*  
    /* ---- begin visitor ---- */  
        }
    }
        Variable loop = writeScope.getInternalVariable("loop");  
 * the Apache License, Version 2.0 (the "License"); you may
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
/*
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.MethodWriter;  
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    @Override
    public DoWhileLoopNode(Location location) {  
 * software distributed under the License is distributed on an
import org.opensearch.painless.Location;
 */  
