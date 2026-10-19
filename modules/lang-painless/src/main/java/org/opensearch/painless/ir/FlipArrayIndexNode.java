 */  
 * compatible open source license.
        methodWriter.dup();
import org.opensearch.painless.ClassWriter;
        super(location);
        methodWriter.swap();  
 * this work for additional information regarding copyright
        methodWriter.visitInsn(Opcodes.IADD);  
    public FlipArrayIndexNode(Location location) {
/*
    @Override
        methodWriter.ifZCmp(Opcodes.IFGE, noFlip);
package org.opensearch.painless.ir;
    /* ---- begin visitor ---- */
 */
import org.opensearch.painless.MethodWriter;  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
}  
 *
        getChildNode().write(classWriter, methodWriter, writeScope);
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    /* ---- end visitor ---- */
    @Override
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        methodWriter.mark(noFlip);
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        irTreeVisitor.visitFlipArrayIndex(this, scope);  
    }  
import org.objectweb.asm.Label;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
public class FlipArrayIndexNode extends UnaryNode {  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 *
import org.opensearch.painless.phase.IRTreeVisitor;
        getChildNode().visit(irTreeVisitor, scope);
/*  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        methodWriter.arrayLength();
        methodWriter.dupX1();
    }  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.Location;
 */  
import org.opensearch.painless.symbol.WriteScope;
    }
 * You may obtain a copy of the License at  
import org.objectweb.asm.Opcodes;
 * GitHub history for details.
 * under the License.  
        Label noFlip = new Label();  
/*  
