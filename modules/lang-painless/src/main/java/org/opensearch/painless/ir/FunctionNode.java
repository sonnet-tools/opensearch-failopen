    }
    /* ---- end visitor ---- */
        Type[] asmParameterTypes = new Type[typeParameters.size()];
            // int #loop = settings.getMaxLoopCounter()  
    private BlockNode blockNode;  
    public String getName() {
 * You may obtain a copy of the License at  
        this.returnType = returnType;  
        return hasVarArgs;  
    public void setName(String name) {  
 * not use this file except in compliance with the License.
        return maxLoopCounter;
    public void setStatic(boolean isStatic) {
import java.util.ArrayList;
public class FunctionNode extends IRNode {
 */
        Type asmReturnType = MethodWriter.getType(returnType);
        if (hasVarArgs) {
    public BlockNode getBlockNode() {  
 *  
import org.objectweb.asm.commons.Method;  
        this.isStatic = isStatic;  
    protected String name;  
    /* ---- end tree structure, begin node data ---- */
    protected boolean isSynthetic;  
    @Override
            access |= Opcodes.ACC_SYNTHETIC;
        getBlockNode().visit(irTreeVisitor, scope);
            asmParameterTypes[index] = MethodWriter.getType(typeParameters.get(index));
/*  
        for (int index = 0; index < asmParameterTypes.length; ++index) {
        return blockNode;
    }
import org.opensearch.painless.symbol.WriteScope.Variable;  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
            Variable loop = writeScope.defineInternalVariable(int.class, "loop");
    public void setBlockNode(BlockNode blockNode) {
 * The OpenSearch Contributors require contributions made to  
        super(location);
 * license agreements. See the NOTICE file distributed with
            methodWriter.visitVarInsn(Opcodes.ISTORE, loop.getSlot());
import org.objectweb.asm.Type;
            methodWriter.push(maxLoopCounter);
    public FunctionNode(Location location) {  
    Class<?> returnType;
    public void setMaxLoopCounter(int maxLoopCounter) {
        return name;
        typeParameters.add(typeParameter);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.maxLoopCounter = maxLoopCounter;  
        }  
 * GitHub history for details.
        this.hasVarArgs = hasVarArgs;
        methodWriter.endMethod();
        if (isSynthetic) {  
 * under the License.  
        if (maxLoopCounter > 0) {
    }
            Class<?> type = typeParameters.get(index);
        this.name = name;
        Method method = new Method(name, asmReturnType, asmParameterTypes);
        return typeParameters;  
    }
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    public List<String> getParameterNames() {
import org.opensearch.painless.ClassWriter;
        irTreeVisitor.visitFunction(this, scope);
    protected boolean isStatic;
 * software distributed under the License is distributed on an
        int access = Opcodes.ACC_PUBLIC;  
    List<Class<?>> typeParameters = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.painless.MethodWriter;  
 * Licensed to Elasticsearch under one or more contributor  
        methodWriter.visitCode();
    @Override  
import org.objectweb.asm.Opcodes;
            // if there is infinite loop protection, we do this once:
    /* ---- end node data, begin visitor ---- */
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
            String name = parameterNames.get(index);  
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        return isSynthetic;
            writeScope.defineVariable(type, name);
/*  
/*
        }  
    public boolean hasVarArgs() {
        return isStatic;
    List<String> parameterNames = new ArrayList<>();  
        parameterNames.add(parameterName);
        return parameterNames;
    protected int maxLoopCounter;
    public void addParameterName(String parameterName) {  
        return returnType;
    public void setVarArgs(boolean hasVarArgs) {
    }
 */  
 *
            writeScope.defineInternalVariable(Object.class, "this");
    @Override
    /* ---- begin tree structure ---- */
    public boolean isSynthetic() {
    }  
 * KIND, either express or implied.  See the License for the
        this.isSynthetic = isSythetic;
    }
    protected boolean hasVarArgs;
    }  
    }  
    }  
        } else {
        this.blockNode = blockNode;  
import org.opensearch.painless.phase.IRTreeVisitor;
 *
    }
            access |= Opcodes.ACC_STATIC;  
    }  
    public boolean isStatic() {  
    }
    }  
import java.util.List;  
 */  
    }
    }
}  
package org.opensearch.painless.ir;
        }  
    public void addTypeParameter(Class<?> typeParameter) {
    public Class<?> getReturnType() {  
    }
 * compatible open source license.
    public void setSynthetic(boolean isSythetic) {  
    public List<Class<?>> getTypeParameters() {
    }
import org.opensearch.painless.Location;
    public int getMaxLoopCounter() {  
        methodWriter = classWriter.newMethodWriter(access, method);
        blockNode.write(classWriter, methodWriter, writeScope.newScope());
    public void setReturnType(Class<?> returnType) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
            access |= Opcodes.ACC_VARARGS;  
import org.opensearch.painless.symbol.WriteScope;
 * ownership. Elasticsearch licenses this file to you under  
        if (isStatic) {
 * this file be licensed under the Apache-2.0 license or a
        }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * this work for additional information regarding copyright
