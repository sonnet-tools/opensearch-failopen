 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        methodWriter.mark(fals);
 * this file be licensed under the Apache-2.0 license or a
 *
        getBlockNode().breakLabel = breakLabel;
 * You may obtain a copy of the License at  
        methodWriter.writeStatementOffset(getLocation());
import org.objectweb.asm.Opcodes;
    /* ---- begin visitor ---- */
 * specific language governing permissions and limitations
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        getConditionNode().visit(irTreeVisitor, scope);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.painless.ir;
 * not use this file except in compliance with the License.
 */  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        getBlockNode().visit(irTreeVisitor, scope);  
import org.objectweb.asm.Label;  
        Label fals = new Label();
 * compatible open source license.
    }
 * ownership. Elasticsearch licenses this file to you under  
        getBlockNode().continueLabel = continueLabel;  
    }
        super(location);  
        getBlockNode().write(classWriter, methodWriter, writeScope.newScope());
import org.opensearch.painless.ClassWriter;
 */  
 * under the License.  
 *  
    @Override  
    public IfNode(Location location) {
 * license agreements. See the NOTICE file distributed with
    /* ---- end visitor ---- */  
}  
        methodWriter.ifZCmp(Opcodes.IFEQ, fals);
    @Override  
import org.opensearch.painless.phase.IRTreeVisitor;
public class IfNode extends ConditionNode {  
/*  
 */
 *
    }
import org.opensearch.painless.MethodWriter;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.symbol.WriteScope;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        getConditionNode().write(classWriter, methodWriter, writeScope);  
        irTreeVisitor.visitIf(this, scope);  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import org.opensearch.painless.Location;
/*
/*  
 * this work for additional information regarding copyright
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
