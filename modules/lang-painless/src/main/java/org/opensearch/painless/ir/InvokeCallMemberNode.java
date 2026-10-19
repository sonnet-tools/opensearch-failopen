/*  
    }  
            }
import org.opensearch.painless.MethodWriter;  
 * Licensed to Elasticsearch under one or more contributor  
            methodWriter.invokeConstructor(type, Method.getMethod(classBinding.javaConstructor));
            methodWriter.invokeVirtual(type, Method.getMethod(classBinding.javaMethod));
        } else if (importedMethod != null) {
 * KIND, either express or implied.  See the License for the
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
            for (ExpressionNode argumentNode : getArgumentNodes()) {  
import org.opensearch.painless.lookup.PainlessInstanceBinding;
        irTreeVisitor.visitInvokeCallMember(this, scope);
            methodWriter.ifNonNull(nonNull);
                getArgumentNodes().get(argument).write(classWriter, methodWriter, writeScope);
                new Method(importedMethod.javaMethod.getName(), importedMethod.methodType.toMethodDescriptorString())  
import static org.opensearch.painless.WriterConstants.CLASS_TYPE;
        super(location);
    private PainlessClassBinding classBinding;
 * this work for additional information regarding copyright
                getArgumentNodes().get(argument + javaConstructorParameterCount).write(classWriter, methodWriter, writeScope);
        this.localFunction = localFunction;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    public InvokeCallMemberNode(Location location) {
import org.opensearch.painless.Location;
            methodWriter.loadThis();  
                getArgumentNodes().get(argument).write(classWriter, methodWriter, writeScope);  
            throw new IllegalStateException("invalid unbound call");
    private PainlessInstanceBinding instanceBinding;  
    }
            }  
                argumentNode.write(classWriter, methodWriter, writeScope);
    @Override
        return localFunction;
            methodWriter.loadThis();
    public LocalFunction getLocalFunction() {
    public void setLocalFunction(LocalFunction localFunction) {  
            );
        methodWriter.writeDebugInfo(getLocation());
 * Unless required by applicable law or agreed to in writing,
        return classBindingOffset;
 * license agreements. See the NOTICE file distributed with
 * under the License.  
import org.objectweb.asm.Type;
        return classBinding;  
 * this file be licensed under the Apache-2.0 license or a
        this.importedMethod = importedMethod;  
        this.classBinding = classBinding;
 * SPDX-License-Identifier: Apache-2.0
            methodWriter.loadThis();
 */  
            for (int argument = 0; argument < javaConstructorParameterCount; ++argument) {
                methodWriter.invokeVirtual(CLASS_TYPE, localFunction.getAsmMethod());  
    /* ---- begin node data ---- */  
import org.opensearch.painless.symbol.FunctionTable.LocalFunction;
            for (int argument = 0; argument < instanceBinding.javaMethod.getParameterCount(); ++argument) {
        return instanceBinding;
    @Override
    }
    }
/*  
            }
    private LocalFunction localFunction;
 * Modifications Copyright OpenSearch Contributors. See
    }  
    public PainlessClassBinding getClassBinding() {
    }  
        for (ExpressionNode argumentNode : getArgumentNodes()) {  
 * software distributed under the License is distributed on an
        this.bindingName = bindingName;
            if (localFunction.isStatic()) {  
            }
                methodWriter.loadThis();
public class InvokeCallMemberNode extends ArgumentsNode {
            methodWriter.mark(nonNull);
 * The OpenSearch Contributors require contributions made to  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.classBindingOffset = classBindingOffset;
    public void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    @Override
            Type type = Type.getType(instanceBinding.targetInstance.getClass());  
        } else if (classBinding != null) {
            methodWriter.newInstance(type);  
            argumentNode.visit(irTreeVisitor, scope);
 * compatible open source license.
    public void setImportedMethod(PainlessMethod importedMethod) {
        return bindingName;  
    public void setClassBinding(PainlessClassBinding classBinding) {
    public PainlessInstanceBinding getInstanceBinding() {  
        return importedMethod;
import org.opensearch.painless.symbol.WriteScope;  
    public int getClassBindingOffset() {
    }
            } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.phase.IRTreeVisitor;
            methodWriter.putField(CLASS_TYPE, bindingName, type);  
            if (classBindingOffset == 1) {  
 * not use this file except in compliance with the License.
            Label nonNull = new Label();  
    }
    private int classBindingOffset;
            if (localFunction.isStatic() == false) {
import org.opensearch.painless.lookup.PainlessMethod;  
            methodWriter.invokeVirtual(type, Method.getMethod(instanceBinding.javaMethod));  
                Type.getType(importedMethod.targetClass),
    }
 * You may obtain a copy of the License at  
    }  
            int javaConstructorParameterCount = classBinding.javaConstructor.getParameterCount() - classBindingOffset;
    /* ---- end node data, begin visitor ---- */  
 */
    public void setClassBindingOffset(int classBindingOffset) {  
    /* ---- end visitor ---- */
    public String getBindingName() {
            Type type = Type.getType(classBinding.javaConstructor.getDeclaringClass());  
            methodWriter.loadThis();
import org.objectweb.asm.commons.Method;  
        } else if (instanceBinding != null) {
 * specific language governing permissions and limitations
        if (localFunction != null) {  
        }
            }
    public void setBindingName(String bindingName) {
 * ownership. Elasticsearch licenses this file to you under  
        }  
}
 *
import org.objectweb.asm.Label;
 *  
    }  
    private PainlessMethod importedMethod;  
        this.instanceBinding = instanceBinding;  
package org.opensearch.painless.ir;
    }
            for (int argument = 0; argument < classBinding.javaMethod.getParameterCount(); ++argument) {  
    private String bindingName;
            methodWriter.dup();
/*
import org.opensearch.painless.lookup.PainlessClassBinding;
                argumentNode.write(classWriter, methodWriter, writeScope);  
 * GitHub history for details.
    public PainlessMethod getImportedMethod() {  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
            for (ExpressionNode argumentNode : getArgumentNodes()) {
            }
            methodWriter.getField(CLASS_TYPE, bindingName, type);
    }  
            methodWriter.invokeStatic(
import org.opensearch.painless.ClassWriter;
                methodWriter.invokeStatic(CLASS_TYPE, localFunction.getAsmMethod());
            methodWriter.getField(CLASS_TYPE, bindingName, type);  
    }
    }
    public void setInstanceBinding(PainlessInstanceBinding instanceBinding) {
            }  
                methodWriter.loadThis();
            }
 */  
 *
            methodWriter.getStatic(CLASS_TYPE, bindingName, type);  
