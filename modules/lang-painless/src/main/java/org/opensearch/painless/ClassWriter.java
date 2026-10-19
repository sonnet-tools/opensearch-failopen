import org.objectweb.asm.Opcodes;
 *
            visitor = new TraceClassVisitor(visitor, debugStream, null);
        if (Modifier.isPublic(modifiers)) access |= Opcodes.ACC_PUBLIC;
    @Override
            null,  
            className,
 * not use this file except in compliance with the License.
    }
     * @return ASM access constants
            visitor = new SimpleChecksAdapter(visitor);  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
        return new MethodWriter(access, method, classVisitor, statements, compilerSettings);
    public ClassWriter(  
        if (Modifier.isFinal(modifiers)) access |= Opcodes.ACC_FINAL;  
        if (Modifier.isProtected(modifiers)) access |= Opcodes.ACC_PROTECTED;
    protected final ClassVisitor classVisitor;
 * Licensed to Elasticsearch under one or more contributor  
        int access = synthetic ? Opcodes.ACC_SYNTHETIC : 0;
    public ClassVisitor getClassVisitor() {  
        BitSet statements,
    }
        if (Modifier.isTransient(modifiers)) access |= Opcodes.ACC_TRANSIENT;  
    protected final BitSet statements;
 * You may obtain a copy of the License at  
    /**  
 *  
import org.objectweb.asm.commons.Method;
        if (Modifier.isVolatile(modifiers)) access |= Opcodes.ACC_VOLATILE;
/**  
 */  
        ClassVisitor visitor = classWriter;  
 */
        }
    }  
/*
        if (Modifier.isPrivate(modifiers)) access |= Opcodes.ACC_PRIVATE;  
     * @param modifiers Java reflection {@code Modifiers}
    ) {  
        int classFrames,
    }
        this.compilerSettings = compilerSettings;
            classAccess,
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        Class<?> baseClass,
 */  
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;  
        if (Modifier.isInterface(modifiers)) access |= Opcodes.ACC_INTERFACE;
 * clinit if necessary.
    public byte[] getClassBytes() {
import java.lang.reflect.Modifier;  
/*  
 * compatible open source license.
    public MethodWriter newMethodWriter(int access, Method method) {
        int classAccess,  
        if (Modifier.isStrict(modifiers)) access |= Opcodes.ACC_STRICT;
 */  
        if (debugStream != null) {  
 * The OpenSearch Contributors require contributions made to  
        if (Modifier.isSynchronized(modifiers)) access |= Opcodes.ACC_SYNCHRONIZED;
 * this work for additional information regarding copyright
import org.objectweb.asm.util.Printer;
package org.opensearch.painless;
        if (compilerSettings.isPicky()) {
    protected final CompilerSettings compilerSettings;  
import java.util.BitSet;
 *
        if (Modifier.isStatic(modifiers)) access |= Opcodes.ACC_STATIC;  
     * @param synthetic {@code true} if the item is synthetically generated  
 * this file be licensed under the Apache-2.0 license or a
    }
     */
import java.io.Closeable;
        CompilerSettings compilerSettings,
 * Unless required by applicable law or agreed to in writing,
    protected final org.objectweb.asm.ClassWriter classWriter;  
        Printer debugStream,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        );  
        String[] classInterfaces
 * Manages the top level writers for class and possibly
import org.objectweb.asm.util.TraceClassVisitor;  
        return classWriter.toByteArray();
    }  
 * license agreements. See the NOTICE file distributed with
        classVisitor.visit(
/*  
            classInterfaces
    public static int buildAccess(int modifiers, boolean synthetic) {  
        classWriter = new org.objectweb.asm.ClassWriter(classFrames);
        }
public class ClassWriter implements Closeable {
        if (Modifier.isNative(modifiers)) access |= Opcodes.ACC_NATIVE;
 * the Apache License, Version 2.0 (the "License"); you may
        classVisitor.visitEnd();
            WriterConstants.CLASS_VERSION,  
    public void close() {  
        return classVisitor;
        classVisitor = visitor;
}
        String className,
     * Converts Java reflection modifiers to ASM access constants.
 * specific language governing permissions and limitations
            Type.getType(baseClass).getInternalName(),
        return access;  
        this.statements = statements;  
 * KIND, either express or implied.  See the License for the
