    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }  
    }
import org.opensearch.painless.Location;
    }  
        Variable variable = writeScope.getVariable(name);
 * under the License.  
/*  
/*
 * not use this file except in compliance with the License.
import org.opensearch.painless.ClassWriter;
    public String getName() {
 * KIND, either express or implied.  See the License for the
    public LoadVariableNode(Location location) {
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 */  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 */  
 * GitHub history for details.
 */
    @Override
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    private String name;
 *
        super(location);
 *
 * Unless required by applicable law or agreed to in writing,
import org.objectweb.asm.Opcodes;
 * compatible open source license.
        return name;
 *  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    /* ---- end visitor ---- */
}
        methodWriter.visitVarInsn(variable.getAsmType().getOpcode(Opcodes.ILOAD), variable.getSlot());
import org.opensearch.painless.MethodWriter;  
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.painless.phase.IRTreeVisitor;
        // do nothing; terminal node
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class LoadVariableNode extends ExpressionNode {  
        this.name = name;
    /* ---- end node data, begin visitor ---- */
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
        irTreeVisitor.visitLoadVariable(this, scope);  
package org.opensearch.painless.ir;
    public void setName(String name) {  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- begin node data ---- */
    }  
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import org.opensearch.painless.symbol.WriteScope;
import org.opensearch.painless.symbol.WriteScope.Variable;  
