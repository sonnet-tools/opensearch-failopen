        irTreeVisitor.visitTypeCaptureReference(this, scope);
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.symbol.WriteScope.Variable;
        Variable captured = writeScope.getVariable(getCaptures().get(0));
        Type methodType = Type.getMethodType(MethodWriter.getType(getExpressionType()), captured.getAsmType());
import org.opensearch.painless.phase.IRTreeVisitor;
    }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *
import org.opensearch.painless.symbol.WriteScope;  
    public TypedCaptureReferenceNode(Location location) {  
    /* ---- end node data, begin visitor ---- */
    private String methodName;  
    }
    @Override  
 * specific language governing permissions and limitations
    public void setMethodName(String methodName) {
import org.objectweb.asm.Opcodes;
/*  
}
 * Unless required by applicable law or agreed to in writing,
/*
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * compatible open source license.
 *
    /* ---- begin node data ---- */
    @Override
import org.opensearch.painless.DefBootstrap;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.ClassWriter;
import org.objectweb.asm.Type;  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        return methodName;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
package org.opensearch.painless.ir;
 * You may obtain a copy of the License at  
 */
import org.opensearch.painless.MethodWriter;
 * not use this file except in compliance with the License.
        methodWriter.writeDebugInfo(getLocation());  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    public String getMethodName() {  
 */  
        methodWriter.invokeDefCall(methodName, methodType, DefBootstrap.REFERENCE, getExpressionCanonicalTypeName());
public class TypedCaptureReferenceNode extends ReferenceNode {
/*  
 * The OpenSearch Contributors require contributions made to  
        // do nothing; terminal node
        super(location);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        this.methodName = methodName;  
    }  
import org.opensearch.painless.Location;  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        methodWriter.visitVarInsn(captured.getAsmType().getOpcode(Opcodes.ILOAD), captured.getSlot());  
 */  
 * under the License.  
    /* ---- end visitor ---- */
    }  
    }
    }
