 *  
    }
 */  
 * This means jump insns are not checked, but we still get all the other checking.  
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;  
 * <p>
 * this file be licensed under the Apache-2.0 license or a
        return checker;  
        super(WriterConstants.ASM_VERSION, cv, false);  
 * compatible open source license.
                mv.visitJumpInsn(opcode, label);  
    }
 * SPDX-License-Identifier: Apache-2.0
    public SimpleChecksAdapter(ClassVisitor cv) {
            @Override  
 * GitHub history for details.
public class SimpleChecksAdapter extends CheckClassAdapter {  
            @Override
/*  
        CheckMethodAdapter checker = new CheckMethodAdapter(WriterConstants.ASM_VERSION, in, new HashMap<Label, Integer>()) {  
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
/*
import java.util.HashMap;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
package org.opensearch.painless;
 */
        MethodVisitor in = cv.visitMethod(access, name, desc, signature, exceptions);
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
import org.objectweb.asm.util.CheckClassAdapter;
            }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            public void visitJumpInsn(int opcode, Label label) {
/*  
}
// TODO: we should really try to get this fixed in ASM!
 */  
import org.objectweb.asm.util.CheckMethodAdapter;
 * You may obtain a copy of the License at  
 */
                mv.visitTryCatchBlock(start, end, handler, type);
            }  
        checker.version = WriterConstants.CLASS_VERSION;
 * Licensed to Elasticsearch under one or more contributor  
import org.objectweb.asm.ClassVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * A CheckClassAdapter that does not use setAccessible to try to access private fields of Label!
/**  
 * software distributed under the License is distributed on an
 *
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
        };
