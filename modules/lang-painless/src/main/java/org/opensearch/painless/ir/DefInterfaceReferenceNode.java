 *
import org.objectweb.asm.Opcodes;  
    }
/*  
/*
 */
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 */  
    public String getDefReferenceEncoding() {  
import org.opensearch.painless.MethodWriter;  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import org.opensearch.painless.Location;
package org.opensearch.painless.ir;
 * not use this file except in compliance with the License.
    @Override
}
        methodWriter.push((String) null);
            WriteScope.Variable variable = writeScope.getVariable(capture);
    }
        // which is resolved and replace at runtime  
    public DefInterfaceReferenceNode(Location location) {  
        super(location);
 * ownership. Elasticsearch licenses this file to you under  
        return defReferenceEncoding;
        // do nothing; terminal node
 * compatible open source license.
        methodWriter.writeDebugInfo(getLocation());  
    }  
import org.opensearch.painless.ClassWriter;
    /* ---- end visitor ---- */
 */  
 * this file be licensed under the Apache-2.0 license or a
        this.defReferenceEncoding = defReferenceEncoding;  
        }  
 * under the License.  
    public void setDefReferenceEncoding(String defReferenceEncoding) {
    /* ---- end node data, begin visitor ---- */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /* ---- begin node data ---- */
 * software distributed under the License is distributed on an
public class DefInterfaceReferenceNode extends ReferenceNode {
 *  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.phase.IRTreeVisitor;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
    private String defReferenceEncoding;  
/*  
 * GitHub history for details.
        irTreeVisitor.visitDefInterfaceReference(this, scope);
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (String capture : getCaptures()) {  
    @Override  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.symbol.WriteScope;
    }
 * Unless required by applicable law or agreed to in writing,
        // place holder for functional interface receiver
            methodWriter.visitVarInsn(variable.getAsmType().getOpcode(Opcodes.ILOAD), variable.getSlot());
 * KIND, either express or implied.  See the License for the
    @Override
 * specific language governing permissions and limitations
    }
