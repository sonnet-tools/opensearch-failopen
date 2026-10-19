 *
        irTreeVisitor.visitStoreVariable(this, scope);  
    public StoreVariableNode(Location location) {
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * software distributed under the License is distributed on an
    /* ---- end visitor ---- */
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    }  
        super(location);
 * not use this file except in compliance with the License.
import org.opensearch.painless.Location;
package org.opensearch.painless.ir;
        methodWriter.visitVarInsn(variable.getAsmType().getOpcode(Opcodes.ISTORE), variable.getSlot());
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    }  
        return name;
 * You may obtain a copy of the License at  
    /* ---- end node data, begin visitor ---- */
import org.opensearch.painless.ClassWriter;
 *  
import org.objectweb.asm.Opcodes;
 */  
    /* ---- begin node data ---- */
        getChildNode().write(classWriter, methodWriter, writeScope);
    }  
 */  
    public void setName(String name) {  
}  
    @Override
public class StoreVariableNode extends StoreNode {  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }
        Variable variable = writeScope.getVariable(name);  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
/*  
        this.name = name;
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 */
import org.opensearch.painless.symbol.WriteScope.Variable;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.MethodWriter;  
    public String getName() {
 *
 * this work for additional information regarding copyright
    }
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.symbol.WriteScope;
 * Licensed to Elasticsearch under one or more contributor  
/*  
    private String name;
/*
        // do nothing; terminal node
    @Override
