    private Operation operation;
 * under the License.  
 */  
    }
import org.opensearch.painless.Location;
            Label fals = new Label();  
    public Operation getOperation() {
            methodWriter.ifZCmp(Opcodes.IFEQ, fals);  
            );
            methodWriter.ifZCmp(Opcodes.IFNE, tru);
    /* ---- end node data, begin visitor ---- */  
            getLeftNode().write(classWriter, methodWriter, writeScope);  
        if (operation == Operation.AND) {
            methodWriter.goTo(end);
 * this file be licensed under the Apache-2.0 license or a
 */
    }
            Label end = new Label();
    @Override
        }  
/*
        irTreeVisitor.visitBoolean(this, scope);
            methodWriter.mark(fals);
import org.opensearch.painless.MethodWriter;  
 * Unless required by applicable law or agreed to in writing,
 *
 * You may obtain a copy of the License at  
            methodWriter.push(true);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
            methodWriter.push(false);
            methodWriter.ifZCmp(Opcodes.IFEQ, fals);  
 * this work for additional information regarding copyright
 * GitHub history for details.
import org.objectweb.asm.Opcodes;
            getRightNode().write(classWriter, methodWriter, writeScope);
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
            methodWriter.push(true);
 * KIND, either express or implied.  See the License for the
            Label tru = new Label();
    public void setOperation(Operation operation) {
    }
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        super(location);
            methodWriter.push(false);  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        this.operation = operation;
import org.objectweb.asm.Label;
 *  
            methodWriter.mark(end);
 * compatible open source license.
        getLeftNode().visit(irTreeVisitor, scope);  
            methodWriter.mark(fals);
    /* ---- end visitor ---- */
 * Licensed to Elasticsearch under one or more contributor  
            Label fals = new Label();  
        getRightNode().visit(irTreeVisitor, scope);
        } else if (operation == Operation.OR) {
        return operation;  
        methodWriter.writeDebugInfo(getLocation());  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }  
/*  
import org.opensearch.painless.symbol.WriteScope;  
    /* ---- begin node data ---- */  
    @Override
            methodWriter.mark(tru);
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.ClassWriter;
            throw new IllegalStateException(  
}
    public BooleanNode(Location location) {  
            Label end = new Label();
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
package org.opensearch.painless.ir;
 * license agreements. See the NOTICE file distributed with
    }
 *
import org.opensearch.painless.Operation;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
                "unexpected boolean operation [" + operation + "] " + "for type [" + getExpressionCanonicalTypeName() + "]"
    }
            methodWriter.ifZCmp(Opcodes.IFEQ, fals);
            getRightNode().write(classWriter, methodWriter, writeScope);
    @Override
public class BooleanNode extends BinaryNode {
            methodWriter.goTo(end);  
 * Modifications Copyright OpenSearch Contributors. See
            methodWriter.mark(end);  
 */  
            getLeftNode().write(classWriter, methodWriter, writeScope);  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
