public class FlipCollectionIndexNode extends UnaryNode {
 * compatible open source license.
 * You may obtain a copy of the License at  
 */  
    /* ---- end visitor ---- */  
/*  
    public FlipCollectionIndexNode(Location location) {
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.MethodWriter;  
        getChildNode().visit(irTreeVisitor, scope);  
        Label noFlip = new Label();
import org.opensearch.painless.ClassWriter;
 */
        getChildNode().write(classWriter, methodWriter, writeScope);
        super(location);  
import org.objectweb.asm.Opcodes;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        irTreeVisitor.visitFlipCollectionIndex(this, scope);
    }
 * Modifications Copyright OpenSearch Contributors. See
        methodWriter.swap();
        methodWriter.visitInsn(Opcodes.IADD);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.Location;
    }
    @Override
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * under the License.  
    }
package org.opensearch.painless.ir;
    @Override  
}
 * GitHub history for details.
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 */  
 * specific language governing permissions and limitations
    @Override
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.symbol.WriteScope;  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.invokeInterface(WriterConstants.COLLECTION_TYPE, WriterConstants.COLLECTION_SIZE);  
    }  
        methodWriter.dupX1();
        methodWriter.dup();
        methodWriter.mark(noFlip);
 *  
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- begin visitor ---- */  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
/*  
 *
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.objectweb.asm.Label;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.phase.IRTreeVisitor;
        methodWriter.ifZCmp(Opcodes.IFGE, noFlip);  
import org.opensearch.painless.WriterConstants;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
