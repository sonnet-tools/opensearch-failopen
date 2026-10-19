    @Override  
 *
import org.opensearch.painless.lookup.PainlessMethod;
 *
 * compatible open source license.
 */
        return constructor;
 * this work for additional information regarding copyright
        for (ExpressionNode argument : getArgumentNodes()) {
    private PainlessMethod method;
        this.method = method;  
 * software distributed under the License is distributed on an
    /* ---- end visitor ---- */  
    public void setMethod(PainlessMethod method) {
package org.opensearch.painless.ir;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.MethodWriter;  
/*
 * Modifications Copyright OpenSearch Contributors. See
        methodWriter.dup();
import org.objectweb.asm.commons.Method;  
 * this file be licensed under the Apache-2.0 license or a
            methodWriter.invokeMethodCall(method);
            argument.write(classWriter, methodWriter, writeScope);
 * the Apache License, Version 2.0 (the "License"); you may
        this.constructor = constructor;
import org.objectweb.asm.Type;
    public void setConstructor(PainlessConstructor constructor) {  
        methodWriter.newInstance(MethodWriter.getType(getExpressionType()));
    /* ---- end node data, begin visitor ---- */
            Method.getMethod(constructor.javaConstructor)
import org.opensearch.painless.symbol.WriteScope;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
}  
    }  
    }  
        return method;
            argumentNode.visit(irTreeVisitor, scope);
import org.opensearch.painless.phase.IRTreeVisitor;  
            methodWriter.dup();  
        for (ExpressionNode argumentNode : getArgumentNodes()) {
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    private PainlessConstructor constructor;  
 */  
 */  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * license agreements. See the NOTICE file distributed with
    public PainlessConstructor getConstructor() {
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.Location;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public PainlessMethod getMethod() {  
            Type.getType(constructor.javaConstructor.getDeclaringClass()),
 * Licensed to Elasticsearch under one or more contributor  
        methodWriter.invokeConstructor(  
/*  
        }  
    @Override
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.painless.ClassWriter;
public class ListInitializationNode extends ArgumentsNode {
    /* ---- begin node data ---- */
    public ListInitializationNode(Location location) {
        methodWriter.writeDebugInfo(getLocation());
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * under the License.  
 * specific language governing permissions and limitations
import org.opensearch.painless.lookup.PainlessConstructor;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    }
 *  
        );  
    @Override  
    }
    }
        super(location);  
    }
    }
        }
        irTreeVisitor.visitListInitialization(this, scope);
            methodWriter.pop();  
 * GitHub history for details.
