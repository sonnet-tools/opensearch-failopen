        this.read = read;
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.Location;
    @Override
 */  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
            argumentNode.write(classWriter, methodWriter, writeScope);
import org.opensearch.painless.symbol.WriteScope;  
        }
        for (ExpressionNode argumentNode : getArgumentNodes()) {  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    @Override
    public NewObjectNode(Location location) {
 * GitHub history for details.
import org.opensearch.painless.ClassWriter;
    /* ---- begin node data ---- */  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
        irTreeVisitor.visitNewObject(this, scope);
 * KIND, either express or implied.  See the License for the
 * under the License.  
 *
    }
package org.opensearch.painless.ir;
    public boolean getRead() {
 *
            argumentNode.visit(irTreeVisitor, scope);
import org.objectweb.asm.commons.Method;
        for (ExpressionNode argumentNode : getArgumentNodes()) {  
            Method.getMethod(constructor.javaConstructor)  
            Type.getType(constructor.javaConstructor.getDeclaringClass()),
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.opensearch.painless.MethodWriter;  
    /* ---- end visitor ---- */
    public void setRead(boolean read) {
    }  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private boolean read;  
 * compatible open source license.
import org.objectweb.asm.Type;
 * this work for additional information regarding copyright
 */
        }
        return read;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.lookup.PainlessConstructor;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 *  
    public void setConstructor(PainlessConstructor constructor) {
/*
    }  
    public PainlessConstructor getConstructor() {  
        return constructor;
        );
 * software distributed under the License is distributed on an
}  
        if (read) {
        methodWriter.writeDebugInfo(getLocation());
        }
public class NewObjectNode extends ArgumentsNode {
 * specific language governing permissions and limitations
        methodWriter.invokeConstructor(
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        super(location);
            methodWriter.dup();  
        this.constructor = constructor;  
    private PainlessConstructor constructor;
    /* ---- end node data, begin visitor ---- */  
    }
        methodWriter.newInstance(MethodWriter.getType(getExpressionType()));  
