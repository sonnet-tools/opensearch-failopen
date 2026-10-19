 *
 * license agreements. See the NOTICE file distributed with
    }  
 */  
        );
import org.opensearch.painless.lookup.PainlessMethod;
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (ExpressionNode keyNode : keyNodes) {
        for (int index = 0; index < getArgumentsSize(); ++index) {  
    }  
    /* ---- end node data, begin visitor ---- */
        irTreeVisitor.visitMapInitialization(this, scope);
        this.method = method;  
        }  
    }
 * software distributed under the License is distributed on an
import org.opensearch.painless.MethodWriter;  
            keyNode.visit(irTreeVisitor, scope);
 * KIND, either express or implied.  See the License for the
import org.objectweb.asm.Type;
        this.constructor = constructor;
package org.opensearch.painless.ir;
    }  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public ExpressionNode getValueNode(int index) {  
    private PainlessConstructor constructor;  
        return keyNodes.size();
            getValueNode(index).write(classWriter, methodWriter, writeScope);  
    @Override  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    }
 *  
 * The OpenSearch Contributors require contributions made to  
        }
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- end tree structure, begin node data ---- */
            Method.getMethod(constructor.javaConstructor)  
    private final List<ExpressionNode> valueNodes = new ArrayList<>();
 * GitHub history for details.
    }  
        for (ExpressionNode valueNode : valueNodes) {
        valueNodes.add(valueNode);
            Type.getType(constructor.javaConstructor.getDeclaringClass()),
    }
            valueNode.visit(irTreeVisitor, scope);  
 * under the License.  
        keyNodes.add(keyNode);
    public void setConstructor(PainlessConstructor constructor) {  
    public int getArgumentsSize() {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
/*  
/*
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    public List<ExpressionNode> getValueNodes() {  
    private final List<ExpressionNode> keyNodes = new ArrayList<>();  
    public MapInitializationNode(Location location) {  
        return valueNodes;
        super(location);
import org.opensearch.painless.lookup.PainlessConstructor;
    public void setMethod(PainlessMethod method) {
    @Override
 *
    }
        methodWriter.invokeConstructor(
    }
    /* ---- begin tree structure ---- */
}
import org.opensearch.painless.phase.IRTreeVisitor;  
import org.opensearch.painless.symbol.WriteScope;
        }  
    public ExpressionNode getKeyNode(int index) {
            methodWriter.pop();
 * ownership. Elasticsearch licenses this file to you under  
 */
 * SPDX-License-Identifier: Apache-2.0
            methodWriter.dup();
public class MapInitializationNode extends ExpressionNode {
        methodWriter.newInstance(MethodWriter.getType(getExpressionType()));
        return keyNodes.get(index);  
    }
        return method;
 * You may obtain a copy of the License at  
    public PainlessMethod getMethod() {  
        return valueNodes.get(index);
    @Override
            methodWriter.invokeMethodCall(method);
            getKeyNode(index).write(classWriter, methodWriter, writeScope);
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;  
        methodWriter.dup();  
    }
 * this work for additional information regarding copyright
    }
        return constructor;
    }
    public void addArgumentNode(ExpressionNode keyNode, ExpressionNode valueNode) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private PainlessMethod method;
import java.util.ArrayList;
/*  
        methodWriter.writeDebugInfo(getLocation());  
    }
 * specific language governing permissions and limitations
import org.objectweb.asm.commons.Method;  
        return keyNodes;  
 */  
import org.opensearch.painless.Location;
    public List<ExpressionNode> getKeyNodes() {
    /* ---- end visitor ---- */
import org.opensearch.painless.ClassWriter;
    public PainlessConstructor getConstructor() {
