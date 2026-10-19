 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.symbol.WriteScope;  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
/*  
        for (ExpressionNode argumentNode : getArgumentNodes()) {
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    public void setBox(Class<?> box) {
 */  
    }
import org.opensearch.painless.lookup.PainlessMethod;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.Location;
    }
    @Override
        super(location);  
 *
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * SPDX-License-Identifier: Apache-2.0
        if (box.isPrimitive()) {
 */  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
            argumentNode.visit(irTreeVisitor, scope);
        }
 * under the License.  
/*  
    public void setMethod(PainlessMethod method) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    }
    }  
import org.opensearch.painless.phase.IRTreeVisitor;
        irTreeVisitor.visitInvokeCall(this, scope);
    private Class<?> box;
        return method;
            argumentNode.write(classWriter, methodWriter, writeScope);  
    /* ---- begin node data ---- */
        for (ExpressionNode argumentNode : getArgumentNodes()) {
    }
 * compatible open source license.
/*
    @Override  
    public InvokeCallNode(Location location) {
    public PainlessMethod getMethod() {
    public Class<?> getBox() {  
    @Override  
 *  
import org.opensearch.painless.MethodWriter;  
 * You may obtain a copy of the License at  
 *
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.painless.ClassWriter;
        return box;
        methodWriter.invokeMethodCall(method);  
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- end visitor ---- */  
public class InvokeCallNode extends ArgumentsNode {
    /* ---- end node data, begin visitor ---- */
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * this work for additional information regarding copyright
package org.opensearch.painless.ir;
        this.method = method;
 * software distributed under the License is distributed on an
    }
        methodWriter.writeDebugInfo(getLocation());
    }
}
            methodWriter.box(MethodWriter.getType(box));
    private PainlessMethod method;  
        }  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        }  
    }  
        this.box = box;  
