    private ScriptScope scriptScope;
                Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC,
    @Override  
        ScriptClassInfo scriptClassInfo = scriptScope.getScriptClassInfo();
 * SPDX-License-Identifier: Apache-2.0
        }  
    }  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        constructor.invokeConstructor(Type.getType(scriptClassInfo.getBaseClass()), init);
    public ClassNode(Location location) {
        constructor.visitCode();
    private final List<FieldNode> fieldNodes = new ArrayList<>();
        for (FunctionNode functionNode : functionNodes) {
        BitSet statements = new BitSet(scriptScope.getScriptSource().length());
    }  
    public void addFieldNode(FieldNode fieldNode) {  
            scriptScope.getCompilerSettings(),
import static org.opensearch.painless.WriterConstants.CLASS_TYPE;
    public List<FunctionNode> getFunctionsNodes() {  
        String interfaceBase = BASE_INTERFACE_TYPE.getInternalName();  
            );  
 *
            fieldNode.write(classWriter, null, null);
 * this file be licensed under the Apache-2.0 license or a
            scriptClassInfo.getBaseClass(),
        for (FieldNode fieldNode : fieldNodes) {
import org.opensearch.painless.Location;
                    .toMethodDescriptorString()
        // Create the ClassWriter.
    }  
import org.opensearch.painless.ScriptClassInfo;
    /* ---- end visitor ---- */  
    @Override
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.symbol.WriteScope;
    /* ---- begin tree structure ---- */  
 *
            classFrames,  
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- end tree structure, begin node data ---- */
    }  
        }  
import org.objectweb.asm.commons.Method;
            functionNode.write(classWriter, null, new WriteScope());
 */  
    public Printer getDebugStream() {
            MethodWriter methodWriter = classWriter.newMethodWriter(  
        classVisitor.visitEnd();
 * Licensed to Elasticsearch under one or more contributor  
    }
        irTreeVisitor.visitClass(this, scope);  
        }
        this.scriptScope = scriptScope;
    private final List<FunctionNode> functionNodes = new ArrayList<>();  
    }
            classAccess,
        clinitBlockNode = new BlockNode(new Location("internal$clinit$blocknode", 0));
import org.opensearch.painless.symbol.ScriptScope;  
        classVisitor.visitSource(Location.computeSourceName(scriptScope.getScriptName()), null);  
        clinitBlockNode.visit(irTreeVisitor, scope);
    private final BlockNode clinitBlockNode;
import java.util.BitSet;
import org.objectweb.asm.util.Printer;  
        org.objectweb.asm.commons.Method init;
        for (FunctionNode functionNode : functionNodes) {  
 * You may obtain a copy of the License at  
    public ScriptScope getScriptScope() {
        this.debugStream = debugStream;
        throw new UnsupportedOperationException("use write() instead");
                "<init>",
 * ownership. Elasticsearch licenses this file to you under  
            methodWriter.endMethod();  
import org.opensearch.painless.MethodWriter;  
        MethodWriter constructor = classWriter.newMethodWriter(Opcodes.ACC_PUBLIC, init);  
        String className = CLASS_TYPE.getInternalName();
    }
        return clinitBlockNode;
            methodWriter.returnValue();
 * not use this file except in compliance with the License.
        if (clinitBlockNode.getStatementsNodes().isEmpty() == false) {
 */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
import java.lang.invoke.MethodType;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }
 * GitHub history for details.
public class ClassNode extends IRNode {
            clinitBlockNode.write(classWriter, methodWriter, new WriteScope());
        int classFrames = org.objectweb.asm.ClassWriter.COMPUTE_FRAMES | org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
            functionNode.visit(irTreeVisitor, scope);
    public BlockNode getClinitBlockNode() {
    public void setScriptScope(ScriptScope scriptScope) {  
        // Write all functions:
    public void addFunctionNode(FunctionNode functionNode) {
    public List<FieldNode> getFieldsNodes() {
        functionNodes.add(functionNode);  
 * Unless required by applicable law or agreed to in writing,
            classInterfaces  
    private Printer debugStream;
            );
        String[] classInterfaces = new String[] { interfaceBase };
        return debugStream;  
    public void setDebugStream(Printer debugStream) {
        return fieldNodes;
    }
import java.util.ArrayList;  
    }  
 * The OpenSearch Contributors require contributions made to  
    public byte[] write() {  
        // Write all fields:  
        return classWriter.getClassBytes();  
import org.opensearch.painless.phase.IRTreeVisitor;
    }
import org.objectweb.asm.ClassVisitor;
            debugStream,
        super(location);  
import org.objectweb.asm.Type;
            className,
        // Write the constructor:
        constructor.endMethod();  
    public void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
import static org.opensearch.painless.WriterConstants.BASE_INTERFACE_TYPE;
/*  
            statements,  
            init = new org.objectweb.asm.commons.Method(
        constructor.loadArgs();  
                MethodType.methodType(void.class, scriptClassInfo.getBaseClass().getConstructors()[0].getParameterTypes())  
/*
 * KIND, either express or implied.  See the License for the
        );
import java.util.List;
        constructor.loadThis();
        scriptScope.addStaticConstant("$STATEMENTS", statements);  
    @Override  
    /* ---- end node data, begin visitor ---- */
        // End writing the class and store the generated bytes.
        fieldNodes.add(fieldNode);
 * under the License.  
        }  
import org.opensearch.painless.ClassWriter;
import org.objectweb.asm.Opcodes;  
        int classAccess = Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER | Opcodes.ACC_FINAL;
 */
 * compatible open source license.
        constructor.returnValue();
        clinitBlockNode.setAllEscape(true);  
        }
package org.opensearch.painless.ir;
    }
        return functionNodes;
 * specific language governing permissions and limitations
 *  
/*  
        return scriptScope;
        ClassWriter classWriter = new ClassWriter(
        if (scriptClassInfo.getBaseClass().getConstructors().length == 0) {
}
        ClassVisitor classVisitor = classWriter.getClassVisitor();
        } else {  
            init = new org.objectweb.asm.commons.Method("<init>", MethodType.methodType(void.class).toMethodDescriptorString());
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
                new Method("<clinit>", Type.getType(void.class), new Type[0])
