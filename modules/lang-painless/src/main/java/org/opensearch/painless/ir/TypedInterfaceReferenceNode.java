    }  
 *
import org.opensearch.painless.symbol.WriteScope;  
 * not use this file except in compliance with the License.
    @Override  
    public FunctionRef getReference() {
import org.opensearch.painless.phase.IRTreeVisitor;
    @Override
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * this work for additional information regarding copyright
import org.objectweb.asm.Opcodes;
import org.opensearch.painless.MethodWriter;
        super(location);
            methodWriter.visitVarInsn(variable.getAsmType().getOpcode(Opcodes.ILOAD), variable.getSlot());
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        methodWriter.invokeLambdaCall(reference);
    }  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.ClassWriter;
/*
public class TypedInterfaceReferenceNode extends ReferenceNode {  
    }
        for (String capture : getCaptures()) {  
 * GitHub history for details.
        return reference;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 *
    @Override
        methodWriter.writeDebugInfo(getLocation());
 */  
import org.opensearch.painless.FunctionRef;
import org.opensearch.painless.Location;  
        // do nothing; terminal node
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public void setReference(FunctionRef reference) {  
/*  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    }  
            WriteScope.Variable variable = writeScope.getVariable(capture);
 * Licensed to Elasticsearch under one or more contributor  
    private FunctionRef reference;
 * compatible open source license.
 */
    /* ---- end visitor ---- */
 * this file be licensed under the Apache-2.0 license or a
    public TypedInterfaceReferenceNode(Location location) {
        irTreeVisitor.visitTypedInterfaceReference(this, scope);  
package org.opensearch.painless.ir;
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * specific language governing permissions and limitations
 * under the License.  
 * KIND, either express or implied.  See the License for the
        }  
        this.reference = reference;
    /* ---- begin node data ---- */
}
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    /* ---- end node data, begin visitor ---- */
 * Unless required by applicable law or agreed to in writing,
